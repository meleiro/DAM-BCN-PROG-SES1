// Importamos clases que vienen incluidas dentro de la librería estándar de Java.

// Importamos la clase Scanner del paquete java.util.
// Scanner es una clase que permite leer datos que el usuario introduce
// desde diferentes fuentes de entrada, como por ejemplo:
// - El teclado (System.in)
// - Un archivo
// - Un String
// En este caso la utilizaremos para leer datos escritos por el usuario en consola.

import java.sql.SQLOutput;
import java.util.Scanner;


// Declaración de la clase principal del programa.
//
// En Java TODO programa debe estar dentro de al menos una clase.
// La clase es como una "plantilla" que define propiedades (variables)
// y comportamientos (métodos).
//
// El nombre de la clase normalmente coincide con el nombre del archivo.
// En este caso el archivo debería llamarse:
// Sesion_1.java
public class Sesion_1 {


    // ================================
    // DECLARACIÓN DE CONSTANTES
    // ================================

    // Una constante es una variable cuyo valor NO puede cambiar.
    // Se define utilizando la palabra clave "final".

    // static:
    // Significa que la variable pertenece a la CLASE y no a un objeto.
    // Esto permite usarla directamente desde métodos estáticos como main.

    // final:
    // Indica que el valor no se puede modificar una vez asignado.

    // double:
    // Tipo de dato numérico decimal en Java.
    // Permite números con decimales (por ejemplo 5.5, 10.25, etc.)

    // Convención:
    // Las constantes suelen escribirse en MAYÚSCULAS con guiones bajos.

    // Nota mínima para aprobar una asignatura
    static final double NOTA_APROBADO = 5.0;

    // IVA del 10%
    // Este valor podría utilizarse para calcular precios finales.
    static final double IVA = 0.10;

    // Precio base de algún producto o servicio
    // Sobre este precio se podrían aplicar impuestos o descuentos.
    static final double PRECIO_BASE = 500.0;

    // Descuento por familia numerosa (10%)
    static final double DESC_FAMILIA_NUM = 0.10;


    // ================================
    // DECLARACIÓN DE VARIABLES GLOBALES
    // ================================

    // Estas variables son estáticas (static).
    // Esto significa que pueden utilizarse desde cualquier método estático
    // de la clase sin necesidad de crear un objeto.

    // Variables de tipo String
    // String es una clase que representa cadenas de texto.
    static String nombre;
    static String apellido;

    // Variable entera
    // int almacena números enteros sin decimales.
    static int edad;

    // Variables decimales
    // double permite almacenar números con decimales.
    static double nota1;
    static double nota2;

    // Variable booleana
    // boolean solo puede tener dos valores:
    // true (verdadero)
    // false (falso)
    static boolean familiaNumerosa;


    // Creamos un objeto Scanner para leer datos por teclado.
    //
    // new Scanner(System.in)
    // System.in representa la entrada estándar del sistema (el teclado).
    //
    // Gracias a este objeto podremos usar métodos como:
    // nextLine()   -> leer texto
    // nextInt()    -> leer números enteros
    // nextDouble() -> leer números decimales
    static Scanner sc = new Scanner(System.in);


    // ================================
    // MÉTODO PRINCIPAL
    // ================================

    // main es el punto de entrada del programa.
    // Cuando ejecutamos un programa Java, la ejecución SIEMPRE comienza aquí.

    // public:
    // significa que el método es accesible desde cualquier lugar.

    // static:
    // permite ejecutar el método sin crear un objeto de la clase.

    // void:
    // indica que el método no devuelve ningún valor.

    // String[] args:
    // permite recibir argumentos desde la línea de comandos.

    public static void main(String[] args) {

        /*
        // Llamamos al método saludar() sin parámetros.
        // Ejecuta la versión que solo imprime "Hola".
        saludar();

        // Llamamos al método saludar(String nombre)
        // Java sabe qué método usar gracias a la SOBRECARGA (overloading).
        saludar("pepe");

        // Llamamos al método saludar(String, String)
        // Este devuelve un String, por eso lo imprimimos con println.
        System.out.println(saludar("pepe", "perez"));


        // Mostramos el nombre ingresado por el usuario.
        System.out.println(nombre);

        // Volvemos a usar el método sobrecargado con el nombre ingresado.
        saludar(nombre);
        */

        // Llamamos al método que pide datos al usuario.
        // Este método se encarga de interactuar con el usuario
        // pidiendo información como nombre, edad y notas.
        leer_datos();

    }


    // ================================
    // MÉTODOS
    // ================================

    // Método que lee datos del usuario.
    // static: pertenece a la clase.
    // void: no devuelve ningún valor.
    static void leer_datos() {

        // Mostramos mensaje solicitando el nombre.
        // println imprime texto en consola y salta de línea.
        System.out.println("Ingrese su nombre: ");

        // nextLine() lee una línea completa de texto introducida por el usuario.
        // Por ejemplo: "Juan Pérez"
        //
        // El valor introducido se guarda en la variable global 'nombre'.
        nombre = sc.nextLine();

        // Validación del nombre
        //
        // nombre.equals("")
        // comprueba si el String está vacío.
        //
        // nombre.trim()
        // elimina espacios al inicio y al final.
        //
        // Esto evita casos como:
        // "   "
        // que parecerían tener texto pero realmente son espacios.

        if(nombre.equals("")  || nombre.trim().equals("")  ){
            System.out.println("No puedes dejar nombre vacío");

            // Si el usuario no introduce nombre,
            // asignamos un valor por defecto.
            nombre="Alumno";
        }


        // Leemos la edad del usuario
        System.out.println("Edad: ");

        // nextInt() lee un número entero introducido por el usuario
        edad = sc.nextInt();

        // Estructura condicional IF - ELSE IF - ELSE
        //
        // Permite ejecutar diferentes bloques de código
        // dependiendo de una condición.

        if (edad < 18) {
            System.out.println("Es menor de edad");

        } else if (edad < 55){

            // Si no es menor de edad pero es menor de 55
            System.out.println("Es de mediana edad");

        } else {

            // En cualquier otro caso
            System.out.println("Es maduric@");
        }


        // Pedimos las notas del alumno
        System.out.println("Nota 1: ");
        nota1 = sc.nextDouble();

        System.out.println("Nota 2: ");
        nota2 = sc.nextDouble();

    }


    // Método sin parámetros y sin retorno.
    // Solo imprime "Hola".
    //
    // Se puede utilizar cuando simplemente queremos ejecutar
    // una acción sin recibir ni devolver datos.
    static void saludar() {
        System.out.println("Hola");
    }


    // Método sobrecargado (Overloading).
    //
    // La sobrecarga permite tener varios métodos
    // con el MISMO nombre pero con DIFERENTES parámetros.
    //
    // En este caso recibe un String llamado nombre.
    static void saludar(String nombre) {

        // Concatenación de Strings con +
        // Une varias cadenas de texto en una sola.
        System.out.println("Hola " + nombre + " !");
    }


    // Otro método sobrecargado.
    //
    // Este método recibe dos parámetros:
    // nombre y apellido.
    //
    // A diferencia de los anteriores,
    // este método SÍ devuelve un valor (String).
    static String saludar(String nombre, String apellido) {

        // Creamos una variable local llamada mensaje.
        // Las variables locales solo existen dentro del método.
        String mensaje = "Hola " + nombre + " " + apellido + " !";

        // return devuelve el valor al lugar donde se llamó el método.
        // Por ejemplo:
        // System.out.println(saludar("Juan","Pérez"));
        return mensaje;
    }

}