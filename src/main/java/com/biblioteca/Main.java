package com.biblioteca;

import java.util.Scanner;

/**
 * Clase principal - Demuestra el uso del sistema de biblioteca.
 * 
 * SITUACIONES DONDE NO SE PUEDE REALIZAR HERENCIA:
 * 
 * SITUACIÓN 1 - Atributos privados en clase padre:
 *   Los atributos de Libro (titulo, autor, numEjemplares, numEjemplaresPrestados)
 *   son declarados como PRIVATE. Esto significa que las subclases (LibroTexto,
 *   LibroTextoUNIAC, Novela) NO pueden acceder directamente a ellos.
 *   Fragmento con falla potencial:
 *   
 *   // En LibroTexto - ESTO NO COMPILARÍA:
 *   public String mostrarTitulo() {
 *       return titulo;  // ERROR: titulo tiene acceso privado en Libro
 *   }
 *   // SOLUCIÓN: usar getTitulo() (método getter público heredado)
 *
 * SITUACIÓN 2 - Clases o métodos declarados como final:
 *   Si la clase Libro se declarara como "final class Libro", ninguna otra
 *   clase podría heredar de ella. De igual forma, si toString() fuera
 *   declarado "final", las subclases no podrían sobreescribirlo.
 *   Fragmento con falla potencial:
 *   
 *   // En Libro - ESTO IMPEDIRÍA LA HERENCIA:
 *   public final class Libro { ... }
 *   // En LibroTexto - ESTO DARÍA ERROR en tiempo de compilación:
 *   public class LibroTexto extends Libro { ... } // ERROR: no se puede heredar de final
 *
 * NUEVOS ATRIBUTOS QUE TIENEN SENTIDO:
 *   1. String isbn           → Identificador único internacional del libro (ISBN-13)
 *   2. String editorial      → Editorial que publicó el libro
 *   Método adicional:
 *   - boolean renovar()      → Permite renovar el préstamo de un libro si hay 
 *                              menos del 50% de ejemplares prestados; de lo 
 *                              contrario devuelve false.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║      SISTEMA DE GESTIÓN DE BIBLIOTECA            ║");
        System.out.println("║      Parcial I - Programación II - G411          ║");
        System.out.println("╚══════════════════════════════════════════════════╝\n");

        // -------------------------------------------------------
        // OBJETO 1: libro1 - constructor CON parámetros
        // -------------------------------------------------------
        System.out.println("─── Creando libro1 con constructor con parámetros ───");
        Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", 5, 2);
        System.out.println(libro1);

        // -------------------------------------------------------
        // OBJETO 2: libro2 - constructor por DEFECTO + datos por consola
        // -------------------------------------------------------
        System.out.println("\n─── Creando libro2 con constructor por defecto (datos por consola) ───");
        Libro libro2 = new Libro();
        System.out.print("Ingrese el título del libro: ");
        libro2.setTitulo(scanner.nextLine());
        System.out.print("Ingrese el autor: ");
        libro2.setAutor(scanner.nextLine());
        System.out.print("Ingrese el número de ejemplares: ");
        libro2.setNumEjemplares(Integer.parseInt(scanner.nextLine()));
        System.out.print("Ingrese el número de ejemplares prestados: ");
        libro2.setNumEjemplaresPrestados(Integer.parseInt(scanner.nextLine()));
        System.out.println(libro2);

        // -------------------------------------------------------
        // OBJETO 3: libroTextoUNIAC - todos sus atributos
        // -------------------------------------------------------
        System.out.println("\n─── Creando libroTextoUNIAC con todos sus atributos ───");
        LibroTextoUNIAC libroTextoUNIAC = new LibroTextoUNIAC(
            "Fundamentos de Programación",
            "Luis Joyanes Aguilar",
            10,
            3,
            "Programación II",
            "Facultad de Ingeniería de Sistemas"
        );
        System.out.println(libroTextoUNIAC);

        // -------------------------------------------------------
        // OBJETO 4: novela - indicando su tipo
        // -------------------------------------------------------
        System.out.println("\n─── Creando novela indicando su tipo ───");
        Novela novela = new Novela(
            "El nombre del viento",
            "Patrick Rothfuss",
            4,
            1,
            Novela.TipoNovela.AVENTURAS
        );
        System.out.println(novela);

        // -------------------------------------------------------
        // PRUEBA DE MÉTODOS: préstamo y devolución
        // -------------------------------------------------------
        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("║         PRUEBA DE PRÉSTAMOS Y DEVOLUCIONES       ║");
        System.out.println("╚══════════════════════════════════════════════════╝");

        System.out.println("\n--- Pruebas con libro1 (5 ejemplares, 2 prestados → 3 disponibles) ---");
        libro1.prestamo();    // debe ser exitoso (disponibles: 3 → 2)
        libro1.prestamo();    // debe ser exitoso (disponibles: 2 → 1)
        libro1.prestamo();    // debe ser exitoso (disponibles: 1 → 0)
        libro1.prestamo();    // debe FALLAR (disponibles: 0)
        System.out.println(libro1);

        System.out.println("\n--- Devoluciones de libro1 ---");
        libro1.devolucion();  // debe ser exitosa
        libro1.devolucion();  // debe ser exitosa
        System.out.println(libro1);

        System.out.println("\n--- Pruebas con libroTextoUNIAC ---");
        libroTextoUNIAC.prestamo();
        libroTextoUNIAC.prestamo();
        libroTextoUNIAC.devolucion();
        System.out.println(libroTextoUNIAC);

        System.out.println("\n--- Pruebas con novela ---");
        novela.devolucion();  // debe ser exitosa (hay 1 prestado)
        novela.devolucion();  // debe FALLAR (ya no hay prestados)
        System.out.println(novela);

        scanner.close();

        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("║            FIN DEL PROGRAMA                      ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
    }
}
