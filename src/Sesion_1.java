import java.util.Scanner;

/**
 * MINI SIMULADOR DE MATRÍCULA — VERSIÓN MUY COMENTADA (OPERADORES)
 * ---------------------------------------------------------------
 * Objetivo didáctico:
 *  - Practicar Java básico SIN bucles (para centrarnos en operadores e if).
 *
 * Contenidos que aparecen:
 *  1) Estructura de un programa Java: clase + main() + métodos
 *  2) Tipos primitivos: int, double, boolean
 *  3) Tipos de referencia: String, Scanner
 *  4) Constantes: static final (evitar números mágicos)
 *  5) Operadores:
 *     - Aritméticos: +, -, *, /, +=
 *     - Relacionales: <, >, <=, >=, ==, !=
 *     - Lógicos: &&, ||, !
 *  6) Condicionales:
 *     - if
 *     - if-else
 *     - if-else if
 *  7) Strings:
 *     - Comparación correcta con equals / equalsIgnoreCase (NO con ==)
 *  8) Conversión de tipos:
 *     - Conversión implícita
 *     - Conversión explícita (casting)
 *
 * Nota de diseño:
 *  - Usamos 'static' para poder llamar a métodos desde main() sin crear objetos.
 *  - Este programa está pensado para practicar fundamentos, por eso hay muchos
 *    comentarios explicativos.
 */
public class Sesion_1 {

    /* =========================================================
       1) CONSTANTES (static final)
       ---------------------------------------------------------
       ¿Por qué usar constantes?
       - Porque hay valores que representan "reglas del sistema".
       - Si mañana cambia la regla, cambias el valor en un solo sitio.
       - Evita "números mágicos": poner 0.10 por ahí sin explicar qué significa.
       - Mejora legibilidad: IVA se entiende, 0.10 suelto no.
       ========================================================= */

    // Nota mínima para aprobar
    static final double NOTA_APROBADO = 5.0;

    // Impuesto (IVA) aplicado al precio final (10% = 0.10)
    static final double IVA = 0.10;

    // Precio base de matrícula antes de aplicar descuentos e impuestos
    static final double PRECIO_BASE = 500.0;

    // Descuento fijo por familia numerosa (10%)
    static final double DESC_FAMILIA_NUM = 0.10;

    // Descuento máximo permitido total (15%)
    static final double DESC_MAX = 0.15;

    // Umbral de media para obtener beca
    static final double BECA_POR_MEDIA = 8.5;

    // Descuento adicional por beca (5%)
    static final double DESC_BECA = 0.05;

    // A partir de cuántos hijos consideramos "familia numerosa"
    static final int HIJOS_FAMILIA_NUMEROSA = 3;

    // Descuento por ser menor de edad
    static final double DESC_MENOR_EDAD = 0.05;

    // Descuento por ser mayor de 65
    static final double DESC_MAYOR_65 = 0.07;

    // Recargo por pago fraccionado si la base es alta
    static final double RECARGO_FRACCIONADO_ALTO = 25.0;

    // Recargo por pago fraccionado si la base es menor
    static final double RECARGO_FRACCIONADO_BAJO = 15.0;

    /* =========================================================
       2) ATRIBUTOS (estado compartido del programa)
       ---------------------------------------------------------
       Tipos:
       - String y Scanner: TIPOS DE REFERENCIA
       - int, double, boolean: TIPOS PRIMITIVOS
       ========================================================= */

    // Nombre del alumno
    static String nombre;

    // Edad en años
    static int edad;

    // Notas
    static double nota1;
    static double nota2;

    // Número de hijos
    static boolean familiaNumerosa;

    // Pago fraccionado
    static boolean pagoFraccionado;

    // Scanner para leer desde teclado
    static Scanner sc = new Scanner(System.in);

    /* =========================================================
       main(): punto de entrada del programa
       ========================================================= */
    public static void main(String[] args) {

        // 1) ENTRADA
        leerDatos();

        // 2) PROCESAMIENTO: cálculo de media
        double media = calcularMedia(nota1, nota2);


    }

    /* =====================================================
       leerDatos(): lee información del usuario
       ===================================================== */
    static void leerDatos() {

        System.out.print("Nombre: ");
        nombre = sc.nextLine();

        // Validación básica del nombre
        if (nombre.equals("") || nombre.trim().equals("")) {
            System.out.println("Nombre vacío. Se asigna 'Alumno'.");
            nombre = "Alumno";
        }

        System.out.print("Edad: ");
        edad = sc.nextInt();

        if (edad >= 18) {
            System.out.println("Es mayor de edad.");
        } else {
            System.out.println("Es menor de edad.");
        }

        System.out.print("Nota 1: ");
        nota1 = sc.nextDouble();

        System.out.print("Nota 2: ");
        nota2 = sc.nextDouble();

        System.out.print("Número de hijos: ");
        int numeroHijos = sc.nextInt();

        /* -------------------------------------------------
           PARTE 11) EJEMPLOS DIDÁCTICOS DE CONVERSIÓN DE TIPOS
           -------------------------------------------------
           IMPORTANTE:
           Estas variables son solo educativas para explicar
           casting y conversiones. No son necesarias para el
           cálculo real del precio.

           1) CONVERSIÓN IMPLÍCITA
              numeroHijos es int.
              Al asignarlo a double, Java convierte solo:
                 int -> double

              Esto es seguro porque un double puede representar
              números enteros sin problema en este rango.
           ------------------------------------------------- */
        double hijosComoDouble = numeroHijos; // conversión implícita int -> double

        if (numeroHijos < 0) {
            System.out.println("Número de hijos no puede ser negativo. Se ajusta a 0.");
            numeroHijos = 0;
        }

        if (numeroHijos >= HIJOS_FAMILIA_NUMEROSA) {
            familiaNumerosa = true;
        }

        sc.nextLine(); // limpiar buffer

        System.out.print("¿Pago fraccionado? (sí/no): ");
        String respuesta = sc.nextLine();

        if (respuesta.equalsIgnoreCase("sí") || respuesta.equalsIgnoreCase("si")) {
            pagoFraccionado = true;
        } else {
            pagoFraccionado = false;
        }

        /* =====================================================
           PRUEBAS DE CASTING IMPLÍCITO
           -----------------------------------------------------
           A partir de aquí hacemos demostraciones prácticas
           siguiendo el orden del manual.
           -----------------------------------------------------
           Recordatorio de la jerarquía de conversión automática:

           byte -> short -> int -> long -> float -> double
                            ^
                           char

           Java puede convertir automáticamente "hacia la derecha",
           es decir, desde un tipo con menos capacidad a otro con
           más capacidad o compatible.
           ===================================================== */

        System.out.println("\n==============================================");
        System.out.println("PRUEBAS DE CASTING IMPLÍCITO");
        System.out.println("==============================================");

        /* -------------------------------------------------
           2.1.2 Ejemplo básico
           -------------------------------------------------
           int -> double

           numero es int
           resultadoBasico es double

           Java hace automáticamente:
           int -> double
           ------------------------------------------------- */
        int numero = 10;
        double resultadoBasico = numero;

        System.out.println("\n2.1.2 Ejemplo básico");
        System.out.println("int numero = 10;");
        System.out.println("double resultadoBasico = numero;");
        System.out.println("Salida: " + resultadoBasico); // 10.0

        /* -------------------------------------------------
           2.1.3 Ejemplo con varios tipos
           -------------------------------------------------
           byte -> int -> long -> double

           Todas estas conversiones son implícitas porque
           vamos hacia la derecha en la jerarquía.
           ------------------------------------------------- */
        byte a = 10;
        int b = a;      // byte -> int
        long c = b;     // int -> long
        double d = c;   // long -> double

        System.out.println("\n2.1.3 Ejemplo con varios tipos");
        System.out.println("byte a = " + a);
        System.out.println("int b = a;      -> " + b);
        System.out.println("long c = b;     -> " + c);
        System.out.println("double d = c;   -> " + d);

        /* -------------------------------------------------
           2.1.4 Conversión en operaciones matemáticas
           -------------------------------------------------
           Cuando mezclamos int y double en una operación,
           Java promociona automáticamente el int a double.

           int + double -> double
           ------------------------------------------------- */
        int enteroOperacion = 5;
        double decimalOperacion = 2.5;
        double resultadoOperacion = enteroOperacion + decimalOperacion;

        System.out.println("\n2.1.4 Conversión en operaciones matemáticas");
        System.out.println("int enteroOperacion = " + enteroOperacion);
        System.out.println("double decimalOperacion = " + decimalOperacion);
        System.out.println("double resultadoOperacion = enteroOperacion + decimalOperacion;");
        System.out.println("Salida: " + resultadoOperacion); // 7.5

        /* -------------------------------------------------
           2.1.5 Promoción automática en expresiones
           -------------------------------------------------
           Aunque los dos operandos sean byte, al hacer
           una operación aritmética Java los promociona a int.

           byte + byte -> int

           Esto se llama Numeric Promotion.
           ------------------------------------------------- */
        byte byte1 = 10;
        byte byte2 = 20;
        int resultadoPromocion = byte1 + byte2;

        System.out.println("\n2.1.5 Promoción automática en expresiones");
        System.out.println("byte byte1 = " + byte1);
        System.out.println("byte byte2 = " + byte2);
        System.out.println("int resultadoPromocion = byte1 + byte2;");
        System.out.println("Salida: " + resultadoPromocion); // 30

        /* -------------------------------------------------
           2.1.6 Ejemplo con char
           -------------------------------------------------
           char almacena códigos Unicode.
           Por eso se puede convertir implícitamente a int.
           ------------------------------------------------- */
        char letra = 'A';
        int codigo = letra;

        System.out.println("\n2.1.6 Ejemplo con char");
        System.out.println("char letra = 'A';");
        System.out.println("int codigo = letra;");
        System.out.println("Salida: " + codigo); // 65

        // También en operaciones:
        int resultadoChar = letra + 1;

        System.out.println("char letra = 'A';");
        System.out.println("int resultadoChar = letra + 1;");
        System.out.println("Salida: " + resultadoChar); // 66

        /* -------------------------------------------------
           2.1.7 Conversión implícita en métodos
           -------------------------------------------------
           Si un método espera un double y le pasamos un int,
           Java convierte automáticamente el int a double.
           ------------------------------------------------- */
        int valorMetodo = 10;

        System.out.println("\n2.1.7 Conversión implícita en métodos");
        System.out.println("int valorMetodo = 10;");
        System.out.println("Llamada: imprimirNumero(valorMetodo);");


        /* -------------------------------------------------
           2.1.8 Caso especial con float
           -------------------------------------------------
           float -> double es automático

           Pero double -> float NO es implícito, porque
           puede haber pérdida de precisión.
           ------------------------------------------------- */
        float numeroFloat = 3.5f;
        double resultadoFloatADouble = numeroFloat;

        System.out.println("\n2.1.8 Caso especial con float");
        System.out.println("float numeroFloat = 3.5f;");
        System.out.println("double resultadoFloatADouble = numeroFloat;");
        System.out.println("Salida: " + resultadoFloatADouble);

        // Este ejemplo se deja comentado porque daría error de compilación:
        // double numeroDouble = 3.5;
        // float resultadoError = numeroDouble; // ERROR: posible pérdida de información

        System.out.println("Ejemplo no válido (comentado en código):");
        System.out.println("double numeroDouble = 3.5;");
        System.out.println("float resultadoError = numeroDouble; // ERROR");

        /* -------------------------------------------------
           2.1.9 Cuándo puede haber pérdida de información
           -------------------------------------------------
           Aunque long -> float sea una conversión implícita
           permitida por Java, puede perder precisión si el
           número es muy grande.

           float tiene aproximadamente 7 dígitos de precisión.
           ------------------------------------------------- */
        long numeroGrandeLong = 123456789012345L;
        float floatDesdeLong = numeroGrandeLong;

        System.out.println("\n2.1.9 Pérdida de precisión con long -> float");
        System.out.println("long numeroGrandeLong = 123456789012345L;");
        System.out.println("float floatDesdeLong = numeroGrandeLong;");
        System.out.println("Salida original long: " + numeroGrandeLong);
        System.out.println("Salida convertida a float: " + floatDesdeLong);

        /* -------------------------------------------------
           Ejemplo claro de pérdida de precisión
           -------------------------------------------------
           int -> float también puede perder exactitud si el
           número tiene demasiados dígitos significativos.
           ------------------------------------------------- */
        int numeroPrecision = 123456789;
        float floatPrecision = numeroPrecision;

        System.out.println("\nEjemplo claro de pérdida de precisión");
        System.out.println("int numeroPrecision = 123456789;");
        System.out.println("float floatPrecision = numeroPrecision;");
        System.out.println("Salida original int: " + numeroPrecision);
        System.out.println("Salida convertida a float: " + floatPrecision);

        /* -------------------------------------------------
           2.1.10 Otro caso de pérdida de precisión
           -------------------------------------------------
           long -> double está permitido implícitamente, pero
           double también tiene un límite de precisión.
           ------------------------------------------------- */
        long numeroMuyGrande = 9999999999999999L;
        double doubleDesdeLong = numeroMuyGrande;

        System.out.println("\n2.1.10 Otro caso de pérdida de precisión");
        System.out.println("long numeroMuyGrande = 9999999999999999L;");
        System.out.println("double doubleDesdeLong = numeroMuyGrande;");
        System.out.println("Salida original long: " + numeroMuyGrande);
        System.out.println("Salida convertida a double: " + doubleDesdeLong);

        /* -------------------------------------------------
           2.1.11 Casos que provocan error (no implícitos)
           -------------------------------------------------
           Si Java detecta una posible pérdida clara, NO permite
           la conversión automática.

           Estos ejemplos se dejan comentados para que el
           programa compile.
           ------------------------------------------------- */
        System.out.println("\n2.1.11 Casos que provocan error (comentados)");
        System.out.println("double precio = 9.99;");
        System.out.println("int valor = precio; // ERROR: possible lossy conversion from double to int");

        // double precio = 9.99;
        // int valor = precio; // ERROR

        /* -------------------------------------------------
           2.1.12 Error común con byte y short
           -------------------------------------------------
           Aunque aSimple y bSimple sean byte, la operación
           aSimple + bSimple devuelve int por promoción numérica.

           Por eso esto NO compila:
           byte cSimple = aSimple + bSimple;

           Se deja comentado para que compile.
           ------------------------------------------------- */
        System.out.println("\n2.1.12 Error común con byte y short (comentado)");
        System.out.println("byte aSimple = 10;");
        System.out.println("byte bSimple = 20;");
        System.out.println("byte cSimple = aSimple + bSimple; // ERROR");

        // byte aSimple = 10;
        // byte bSimple = 20;
        // byte cSimple = aSimple + bSimple; // ERROR

        /* -------------------------------------------------
           2.1.13 Regla importante de casting implícito
           -------------------------------------------------
           Java permite conversión automática si el tipo origen
           cabe dentro del tipo destino.

           tipo origen ⊆ tipo destino

           Ejemplos:
           int ⊆ long
           long ⊆ float
           float ⊆ double
           ------------------------------------------------- */
        System.out.println("\n2.1.13 Regla importante");
        System.out.println("Java permite casting automático si:");
        System.out.println("tipo origen ⊆ tipo destino");

        System.out.println("\nResumen de ejemplos válidos mostrados:");
        System.out.println("byte -> int     ✔");
        System.out.println("int -> long     ✔");
        System.out.println("int -> double   ✔");
        System.out.println("float -> double ✔");
        System.out.println("char -> int     ✔");

        System.out.println("\nEjemplo adicional ya creado al leer hijos:");
        System.out.println("int numeroHijos -> double hijosComoDouble = " + hijosComoDouble);

        System.out.println("==============================================\n");
    }

    /* =====================================================
       calcularMedia(a, b)
       -----------------------------------------------------
       - Usa suma y división
       - Devuelve un double
       - 2.0 obliga a trabajar con decimales
       ===================================================== */
    static double calcularMedia(double a, double b) {
        return (a + b) / 2.0;
    }








}