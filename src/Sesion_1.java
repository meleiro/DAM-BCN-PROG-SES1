import java.util.Scanner;

/**
 * ============================================================
 * MINI SIMULADOR DE MATRÍCULA — VERSIÓN MUY COMENTADA (OPERADORES)
 * ============================================================
 *
 * Este archivo mezcla varios temas de Java en un mismo programa
 * para practicar conceptos de programación básica:
 *
 * 1) Estructura de una clase en Java
 * 2) Método main() como punto de entrada
 * 3) Constantes con static final
 * 4) Tipos primitivos y tipos de referencia
 * 5) Lectura por teclado con Scanner
 * 6) Métodos con y sin retorno
 * 7) Operadores aritméticos, relacionales y lógicos
 * 8) Condicionales if / else
 * 9) switch clásico
 * 10) switch moderno con flecha ->
 * 11) switch como expresión que devuelve un valor
 * 12) yield en switch con bloques
 * 13) Conversión implícita y explícita entre tipos
 * 14) Impresión formateada con printf
 *
 */
public class Sesion_1 {

    /* =========================================================
       1) CONSTANTES (static final)
       ---------------------------------------------------------
       Una constante es una variable cuyo valor no cambia.

       En Java, normalmente se declara con:
       - static: pertenece a la clase
       - final: no puede modificarse

       Se usan para:
       - evitar "números mágicos"
       - hacer el código más legible
       - centralizar reglas del programa

       Ejemplo:
       en vez de poner 0.10 o 500.0 muchas veces,
       usamos nombres significativos.
       ========================================================= */

    // Nota mínima para aprobar
    static final double NOTA_APROBADO = 5.0;

    // Impuesto (IVA) aplicado al precio final (10% = 0.10)
    // Recordatorio: en programación los porcentajes se suelen expresar
    // como decimal. 10% = 0.10, 5% = 0.05, etc.
    static final double IVA = 0.10;

    // Precio base de matrícula antes de aplicar descuentos e impuestos
    static final double PRECIO_BASE = 500.0;

    // Descuento fijo por familia numerosa (10%)
    static final double DESC_FAMILIA_NUM = 0.10;

    // Descuento máximo permitido total (15%)
    // Esto impide que el descuento acumulado supere ese límite.
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
       Estas variables están declaradas fuera de los métodos,
       por lo que son atributos de clase.

       Como además son static, pueden ser usados desde main()
       y desde otros métodos static sin crear objetos.

       Aquí conviven:
       - Tipos de referencia: String, Scanner
       - Tipos primitivos: int, double, boolean
       ========================================================= */

    // Nombre del alumno
    // String es un tipo de referencia, no un tipo primitivo.
    static String nombre;

    // Edad en años
    static int edad;

    // Notas del alumno
    static double nota1;
    static double nota2;

    // Realmente aquí se guarda si es familia numerosa o no.
    // Aunque el dato original sea "número de hijos", el resultado final
    // se transforma en un boolean.
    static boolean familiaNumerosa;

    // Indica si el usuario ha elegido pago fraccionado.
    static boolean pagoFraccionado;

    // Scanner para leer desde teclado.
    // System.in representa la entrada estándar del sistema.
    static Scanner sc = new Scanner(System.in);

    /* =========================================================
       main(): punto de entrada del programa
       ---------------------------------------------------------
       Todo programa Java empieza a ejecutarse desde aquí.

       Firma correcta:
       public static void main(String[] args)

       Significado:
       - public: accesible
       - static: pertenece a la clase
       - void: no devuelve nada
       - String[] args: argumentos de entrada
       ========================================================= */
    public static void main(String[] args) {

        /*
        // 1) ENTRADA
        leerDatos();

        // 2) PROCESAMIENTO: cálculo de media
        double media = calcularMedia(nota1, nota2);

        boolean aprobado = esAprobado(media);

        double precioFinal = calcularPrecioFinal(PRECIO_BASE);

        imprimirInforme(media, aprobado, precioFinal);

        sc.close();
        */

        // En este momento, la parte activa del main solo llama a
        // obtenerCalificacion(7) y la imprime por pantalla.
        //
        // Como obtenerCalificacion devuelve un String,
        // System.out.println muestra ese resultado.
        System.out.println(obtenerCalificacion(7));
    }

    /* =========================================================
       mostrarDiaSemana(int dia)
       ---------------------------------------------------------
       Este método practica:
       - switch clásico
       - comparación de una sola variable
       - case
       - break
       - default

       Se usa cuando queremos comparar UN valor exacto
       contra varias opciones concretas.
       ========================================================= */
    static void mostrarDiaSemana(int dia) {

        // switch evalúa la variable "dia"
        switch (dia) {

            // Si dia vale 1, ejecuta este bloque
            case 1:
                System.out.println("Lunes");
                break; // sale del switch

            // Si dia vale 2, ejecuta este bloque
            case 2:
                System.out.println("Martes");
                break;

            // Si dia vale 3, ejecuta este bloque
            case 3:
                System.out.println("Miércoles");
                break;

            // Si no coincide con ningún case anterior
            default:
                System.out.println("Día no válido");
        }
    }

    /* =========================================================
       mostrarTipoDia(int dia)
       ---------------------------------------------------------
       Aquí vemos un switch clásico con varios case que comparten
       el mismo bloque.

       Esto es útil cuando distintos valores deben provocar
       exactamente la misma acción.
       ========================================================= */
    static void mostrarTipoDia(int dia) {

        switch (dia) {

            // Todos estos valores representan días laborables
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                // Estas tres líneas imprimen lo mismo repetido.
                // Funciona, pero didácticamente bastaría con una sola.
                System.out.println("Día Laborable");
                System.out.println("Día Laborable");
                System.out.println("Día Laborable");
                break;

            // Sábado y domingo
            case 6:
            case 7:
                System.out.println("Fin de semana");
                break;

            // Cualquier otro valor
            default:
                System.out.println("Día no válido");
        }
    }

    /* =========================================================
       mostarOpcionChar(char opcion)
       ---------------------------------------------------------
       Este método usa switch con char.

       char representa un solo carácter:
       - 'A'
       - 'B'
       - '1'
       - '+'

       Es muy útil en menús sencillos por letras.
       ========================================================= */
    static void mostarOpcionChar(char opcion) {

        switch (opcion) {

            case 'A':
                System.out.println("Has elegido Alta");
                break;

            case 'B':
                System.out.println("Has elegido Baja");
                break;

            default:
                System.out.println("Opción no válida");
        }
    }

    /* =========================================================
       mostrarTurno(String turno)
       ---------------------------------------------------------
       Este método usa switch con String.

       Desde Java 7 se puede usar switch con cadenas de texto.

       Observa:
       turno.toLowerCase()

       Eso convierte la entrada a minúsculas para aceptar
       distintas variantes:
       - "mañana"
       - "MAÑANA"
       - "Mañana"

       todas pasarían a "mañana"
       ========================================================= */
    static void mostrarTurno(String turno) {

        switch (turno.toLowerCase()) {

            case "mañana":
                System.out.println("Turno de mañana, empiezas a las 8 am");
                break;

            case "tarde":
                System.out.println("Turno de tarde, empiezas a las 15 pm");
                break;

            default:
                System.out.println("Turno no reconocido");
        }
    }

    /* =========================================================
       mostrarDiaSemanaNuevo(int dia)
       ---------------------------------------------------------
       Este método usa switch moderno con notación flecha ->

       Ventajas:
       - más limpio
       - no necesita break
       - evita errores de "caída" entre casos

       También permite agrupar varios valores separados por comas.
       ========================================================= */
    static void mostrarDiaSemanaNuevo(int dia) {

        switch (dia) {

            // Si dia vale 1, 2, 3, 4 o 5
            case 1, 2, 3, 4, 5 -> {
                // Cuando usamos un bloque con llaves,
                // podemos poner varias instrucciones.
                String m = "hola";
                System.out.println("Día Laborable");
                System.out.println("dsdsd");
            }

            // Si dia vale 6 o 7
            case 6, 7 -> System.out.println("Fin de semana");

            // Si no coincide ningún caso
            default -> System.out.println("Opción incorrecta");
        }
    }

    /* =========================================================
       obtenerCalificacion(int nota)
       ---------------------------------------------------------
       Este método usa switch como expresión.

       Eso significa que el switch no solo ejecuta instrucciones,
       sino que devuelve directamente un valor.

       Aquí devuelve un String.

       Además, en uno de los casos usa:
       yield

       yield se utiliza cuando el case tiene un bloque con varias
       instrucciones y queremos indicar qué valor devuelve ese bloque.
       ========================================================= */
    static String obtenerCalificacion(int nota) {

        return switch (nota) {

            // Si la nota es 10 o 9
            case 10, 9 -> "Sobresaliente";

            // Si la nota es 8 o 7
            case 8, 7 -> {
                // Podemos ejecutar instrucciones adicionales
                System.out.println("Nota buena");

                // yield devuelve el valor de este bloque del switch
                yield "Notable";
            }

            // Si la nota es 6 o 5
            case 6, 5 -> "Aprobado";

            // Cualquier otra nota
            default -> "Supenso";
        };
    }

    /* =========================================================
       esAprobado(double nota)
       ---------------------------------------------------------
       Método boolean:
       - recibe una nota
       - devuelve true si es mayor o igual al mínimo
       - devuelve false en caso contrario

       Es un buen ejemplo de método que responde a una pregunta.
       ========================================================= */
    static boolean esAprobado(double nota) {
        return nota >= NOTA_APROBADO;
    }

    /* =====================================================
       leerDatos(): lee información del usuario
       -----------------------------------------------------
       Este método:
       - no recibe parámetros
       - no devuelve nada
       - modifica los atributos de clase

       Practica:
       - Scanner
       - validaciones
       - if / else
       - conversión de tipos
       ===================================================== */
    static void leerDatos() {

        System.out.print("Nombre: ");
        nombre = sc.nextLine();

        // Validación básica del nombre
        // nombre.equals("") detecta cadena vacía
        // nombre.trim().equals("") detecta espacios en blanco
        if (nombre.equals("") || nombre.trim().equals("")) {
            System.out.println("Nombre vacío. Se asigna 'Alumno'.");
            nombre = "Alumno";
        }

        System.out.print("Edad: ");
        edad = sc.nextInt();

        // Clasificación simple con if / else
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
           Estas variables se crean para practicar casting,
           no porque sean necesarias para el cálculo final.

           numeroHijos es int
           hijosComoDouble es double

           Aquí Java hace conversión implícita:
           int -> double
           ------------------------------------------------- */
        double hijosComoDouble = numeroHijos;

        // Validación para evitar valores imposibles
        if (numeroHijos < 0) {
            System.out.println("Número de hijos no puede ser negativo. Se ajusta a 0.");
            numeroHijos = 0;
        }

        // Convertimos un número a una idea lógica:
        // familia numerosa sí o no
        if (numeroHijos >= HIJOS_FAMILIA_NUMEROSA) {
            familiaNumerosa = true;
        }

        // Limpiar buffer:
        // después de nextInt() queda el Enter pendiente
        sc.nextLine();

        System.out.print("¿Pago fraccionado? (sí/no): ");
        String respuesta = sc.nextLine();

        // equalsIgnoreCase compara ignorando mayúsculas/minúsculas
        if (respuesta.equalsIgnoreCase("sí") || respuesta.equalsIgnoreCase("si")) {
            pagoFraccionado = true;
        } else {
            pagoFraccionado = false;
        }

        /* =====================================================
           PRUEBAS DE CASTING IMPLÍCITO
           ===================================================== */

        System.out.println("\n==============================================");
        System.out.println("PRUEBAS DE CASTING IMPLÍCITO");
        System.out.println("==============================================");

        int numero = 10;
        double resultadoBasico = numero;

        System.out.println("\n2.1.2 Ejemplo básico");
        System.out.println("int numero = 10;");
        System.out.println("double resultadoBasico = numero;");
        System.out.println("Salida: " + resultadoBasico);

        byte a = 10;
        int b = a;
        long c = b;
        double d = c;

        System.out.println("\n2.1.3 Ejemplo con varios tipos");
        System.out.println("byte a = " + a);
        System.out.println("int b = a;      -> " + b);
        System.out.println("long c = b;     -> " + c);
        System.out.println("double d = c;   -> " + d);

        int enteroOperacion = 5;
        double decimalOperacion = 2.5;
        double resultadoOperacion = enteroOperacion + decimalOperacion;

        System.out.println("\n2.1.4 Conversión en operaciones matemáticas");
        System.out.println("int enteroOperacion = " + enteroOperacion);
        System.out.println("double decimalOperacion = " + decimalOperacion);
        System.out.println("double resultadoOperacion = enteroOperacion + decimalOperacion;");
        System.out.println("Salida: " + resultadoOperacion);

        byte byte1 = 10;
        byte byte2 = 20;
        int resultadoPromocion = byte1 + byte2;

        System.out.println("\n2.1.5 Promoción automática en expresiones");
        System.out.println("byte byte1 = " + byte1);
        System.out.println("byte byte2 = " + byte2);
        System.out.println("int resultadoPromocion = byte1 + byte2;");
        System.out.println("Salida: " + resultadoPromocion);

        char letra = 'A';
        int codigo = letra;

        System.out.println("\n2.1.6 Ejemplo con char");
        System.out.println("char letra = 'A';");
        System.out.println("int codigo = letra;");
        System.out.println("Salida: " + codigo);

        int resultadoChar = letra + 1;

        System.out.println("char letra = 'A';");
        System.out.println("int resultadoChar = letra + 1;");
        System.out.println("Salida: " + resultadoChar);

        int valorMetodo = 10;

        System.out.println("\n2.1.7 Conversión implícita en métodos");
        System.out.println("int valorMetodo = 10;");
        System.out.println("Llamada: imprimirNumero(valorMetodo);");


        float numeroFloat = 3.5f;
        double resultadoFloatADouble = numeroFloat;

        System.out.println("\n2.1.8 Caso especial con float");
        System.out.println("float numeroFloat = 3.5f;");
        System.out.println("double resultadoFloatADouble = numeroFloat;");
        System.out.println("Salida: " + resultadoFloatADouble);

        System.out.println("Ejemplo no válido (comentado en código):");
        System.out.println("double numeroDouble = 3.5;");
        System.out.println("float resultadoError = numeroDouble; // ERROR");

        long numeroGrandeLong = 123456789012345L;
        float floatDesdeLong = numeroGrandeLong;

        System.out.println("\n2.1.9 Pérdida de precisión con long -> float");
        System.out.println("long numeroGrandeLong = 123456789012345L;");
        System.out.println("float floatDesdeLong = numeroGrandeLong;");
        System.out.println("Salida original long: " + numeroGrandeLong);
        System.out.println("Salida convertida a float: " + floatDesdeLong);

        int numeroPrecision = 123456789;
        float floatPrecision = numeroPrecision;

        System.out.println("\nEjemplo claro de pérdida de precisión");
        System.out.println("int numeroPrecision = 123456789;");
        System.out.println("float floatPrecision = numeroPrecision;");
        System.out.println("Salida original int: " + numeroPrecision);
        System.out.println("Salida convertida a float: " + floatPrecision);

        long numeroMuyGrande = 9999999999999999L;
        double doubleDesdeLong = numeroMuyGrande;

        System.out.println("\n2.1.10 Otro caso de pérdida de precisión");
        System.out.println("long numeroMuyGrande = 9999999999999999L;");
        System.out.println("double doubleDesdeLong = numeroMuyGrande;");
        System.out.println("Salida original long: " + numeroMuyGrande);
        System.out.println("Salida convertida a double: " + doubleDesdeLong);

        System.out.println("\n2.1.11 Casos que provocan error (comentados)");
        System.out.println("double precio = 9.99;");
        System.out.println("int valor = precio; // ERROR: possible lossy conversion from double to int");

        System.out.println("\n2.1.12 Error común con byte y short (comentado)");
        System.out.println("byte aSimple = 10;");
        System.out.println("byte bSimple = 20;");
        System.out.println("byte cSimple = aSimple + bSimple; // ERROR");

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
       Método sencillo que:
       - recibe dos notas
       - las suma
       - las divide entre 2.0
       - devuelve la media

       Se usa 2.0 para remarcar que trabajamos con decimales.
       ===================================================== */
    static double calcularMedia(double a, double b) {
        return (a + b) / 2.0;
    }

    /* =====================================================
       calcularPrecioFinal(double base)
       -----------------------------------------------------
       Este método reúne la lógica principal de descuentos,
       recargos e IVA.

       Trabaja paso a paso:
       1) calcula descuentos
       2) limita el descuento máximo
       3) calcula recargo si hay pago fraccionado
       4) calcula IVA
       5) devuelve el precio final
       ===================================================== */
    static double calcularPrecioFinal(double base) {

        double descuento = 0.0;
        double recargo = 0.0;

        // Si es familia numerosa, suma descuento
        if (familiaNumerosa) {
            descuento += DESC_FAMILIA_NUM;
        }

        // Descuento por edad
        if (edad < 18) {
            descuento += DESC_MENOR_EDAD;
        } else if (edad > 65) {
            descuento += DESC_MAYOR_65;
        }

        // Limitar descuento máximo
        if (descuento > DESC_MAX) {
            descuento = DESC_MAX;
        }

        // Transformar porcentaje en dinero real
        double importeDescuento = base * descuento;

        // Aplicar descuento
        double precioConDescuento = base - importeDescuento;

        // Recargo por pago fraccionado
        if (pagoFraccionado && base >= 500) {
            recargo = RECARGO_FRACCIONADO_ALTO;
        } else if (pagoFraccionado) {
            recargo = RECARGO_FRACCIONADO_BAJO;
        }

        // Subtotal antes de impuestos
        double subtotal = precioConDescuento + recargo;

        // IVA en euros
        double importeIva = subtotal * IVA;

        // Precio final
        double precioFinal = subtotal + importeIva;

        return precioFinal;
    }

    /* =====================================================
       imprimirInforme(double media, boolean aprobado, double precioFinal)
       -----------------------------------------------------
       Muestra por pantalla el resumen del alumno.

       Practica:
       - concatenación con +
       - if / else
       - operador ternario
       - printf para decimales
       ===================================================== */
    static void imprimirInforme(double media, boolean aprobado, double precioFinal) {

        System.out.println("\n---INFORME---");

        
        System.out.printf("Alumno: " + nombre);
        System.out.printf("Edad: " + edad);

        if (familiaNumerosa) {
            System.out.println("Familia numerosa: Sí");
        } else {
            System.out.println("Familia numerosa: No");
        }

        if (aprobado) {
            System.out.println("Estado: APTO");
        } else {
            System.out.println("Estado: NO APTO");
        }

        // Operador ternario:
        // condición ? valorSiTrue : valorSiFalse
        String textoFraccionado = (pagoFraccionado) ? "Sí" : "No";

        System.out.println("Pago Fraccionado: " + textoFraccionado);

        // printf permite formatear mejor números
        // %.2f -> número decimal con dos cifras
        // %n   -> salto de línea portable
        System.out.printf("Media: %.2f%n", media);
        System.out.printf("Precio Final: %.2f €%n", precioFinal);
    }
}
