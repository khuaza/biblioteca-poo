package com.biblioteca;

/**
 * Clase base que representa un Libro en el sistema de biblioteca.
 * Aplica los principios de abstracción y encapsulamiento.
 */
public class Libro {

    // Atributos privados - Encapsulamiento
    private String titulo;
    private String autor;
    private int numEjemplares;
    private int numEjemplaresPrestados;

    // -------------------------------------------------------
    // CONSTRUCTORES
    // -------------------------------------------------------

    /**
     * Constructor por defecto - crea un libro vacío.
     */
    public Libro() {
        this.titulo = "";
        this.autor = "";
        this.numEjemplares = 0;
        this.numEjemplaresPrestados = 0;
    }

    /**
     * Constructor con parámetros.
     */
    public Libro(String titulo, String autor, int numEjemplares, int numEjemplaresPrestados) {
        this.titulo = titulo;
        this.autor = autor;
        this.numEjemplares = numEjemplares;
        this.numEjemplaresPrestados = numEjemplaresPrestados;
    }

    // -------------------------------------------------------
    // GETTERS Y SETTERS
    // -------------------------------------------------------

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumEjemplares() {
        return numEjemplares;
    }

    public void setNumEjemplares(int numEjemplares) {
        this.numEjemplares = numEjemplares;
    }

    public int getNumEjemplaresPrestados() {
        return numEjemplaresPrestados;
    }

    public void setNumEjemplaresPrestados(int numEjemplaresPrestados) {
        this.numEjemplaresPrestados = numEjemplaresPrestados;
    }

    // -------------------------------------------------------
    // MÉTODOS DE NEGOCIO
    // -------------------------------------------------------

    /**
     * Realiza el préstamo de un libro.
     * Solo es posible si hay ejemplares disponibles (no prestados).
     * @return true si el préstamo fue exitoso, false en caso contrario.
     */
    public boolean prestamo() {
        int disponibles = numEjemplares - numEjemplaresPrestados;
        if (disponibles > 0) {
            numEjemplaresPrestados++;
            System.out.println("✔ Préstamo exitoso de: \"" + titulo + "\"");
            return true;
        } else {
            System.out.println("✘ No hay ejemplares disponibles de: \"" + titulo + "\"");
            return false;
        }
    }

    /**
     * Realiza la devolución de un libro.
     * Solo es posible si hay libros prestados.
     * @return true si la devolución fue exitosa, false en caso contrario.
     */
    public boolean devolucion() {
        if (numEjemplaresPrestados > 0) {
            numEjemplaresPrestados--;
            System.out.println("✔ Devolución exitosa de: \"" + titulo + "\"");
            return true;
        } else {
            System.out.println("✘ No hay ejemplares prestados de: \"" + titulo + "\"");
            return false;
        }
    }

    /**
     * Muestra la información del libro.
     */
    @Override
    public String toString() {
        return "=== LIBRO ===" +
               "\n  Título             : " + titulo +
               "\n  Autor              : " + autor +
               "\n  Total ejemplares   : " + numEjemplares +
               "\n  Prestados          : " + numEjemplaresPrestados +
               "\n  Disponibles        : " + (numEjemplares - numEjemplaresPrestados);
    }
}
