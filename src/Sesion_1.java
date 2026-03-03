// Importamos la clase Scanner del paquete java.util
// Scanner nos permite leer datos que el usuario introduce por teclado.
import java.sql.SQLOutput;
import java.util.Scanner;

// Declaración de la clase principal.
// En Java todo programa debe estar dentro de una clase.
public class Sesion_1 {

    // ================================
    // DECLARACIÓN DE CONSTANTES
    // ================================

    // static: pertenece a la clase y no a un objeto.
    // final: indica que es una constante (no se puede modificar).
    // double: tipo de dato numérico decimal.

    // Nota mínima para aprobar
    static final double NOTA_APROBADO = 5.0;

    // IVA del 10%
    static final double IVA = 0.10;

    // Precio base de algún producto o servicio
    static final double PRECIO_BASE = 500.0;

    // Descuento por familia numerosa (10%)
    static final double DESC_FAMILIA_NUM = 0.10;


    // ================================
    // DECLARACIÓN DE VARIABLES GLOBALES
    // ================================

    // Variables estáticas accesibles desde cualquier método estático
    static String nombre;
    static String apellido;

    static int edad;

    static double nota1;
    static double nota2;

    static boolean familiaNumerosa;

    // Creamos un objeto Scanner para leer datos por teclado.
    // System.in indica que leerá desde la entrada estándar (teclado).
    static Scanner sc = new Scanner(System.in);


    // ================================
    // MÉTODO PRINCIPAL
    // ================================

    // main es el punto de entrada del programa.
    // La ejecución empieza aquí.
    public static void main(String[] args) {

        // Llamamos al método saludar() sin parámetros.
        // Ejecuta la versión que solo imprime "Hola".
        saludar();

        // Llamamos al método saludar(String nombre)
        // Java sabe qué método usar gracias a la SOBRECARGA (overloading).
        saludar("pepe");

        // Llamamos al método saludar(String, String)
        // Este devuelve un String, por eso lo imprimimos con println.
        System.out.println(saludar("pepe", "perez"));

        // Llamamos al método que pide datos al usuario.
        leer_datos();

        // Mostramos el nombre ingresado por el usuario.
        System.out.println(nombre);

        // Volvemos a usar el método sobrecargado con el nombre ingresado.
        saludar(nombre);


    }


    // ================================
    // MÉTODOS
    // ================================

    // Método que lee datos del usuario.
    // No devuelve nada (void).
    static void leer_datos() {

        // Mostramos mensaje solicitando el nombre.
        System.out.println("Ingrese su nombre: ");

        // nextLine() lee una línea completa de texto.
        // Guardamos el valor en la variable global 'nombre'.
        nombre = sc.nextLine();
    }


    // Método sin parámetros y sin retorno.
    // Solo imprime "Hola".
    static void saludar(){
        System.out.println("Hola");
    }


    // Método sobrecargado (mismo nombre, diferente parámetro).
    // Recibe un String como parámetro.
    static void saludar(String nombre){

        // Concatenamos texto con la variable usando +
        System.out.println("Hola " + nombre + " !");
    }


    // Método sobrecargado que recibe dos parámetros.
    // Devuelve un String.
    static String saludar(String nombre, String apellido){

        // Creamos una variable local llamada mensaje.
        String mensaje = "Hola " + nombre + " " + apellido +" !";

        // return devuelve el valor al lugar donde se llamó el método.
        return mensaje;
    }

}