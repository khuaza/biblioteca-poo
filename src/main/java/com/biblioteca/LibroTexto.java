package com.biblioteca;

/**
 * Clase LibroTexto - hereda de Libro.
 * Agrega el atributo "curso" al que está asociado el libro de texto.
 */
public class LibroTexto extends Libro {

    // Atributo adicional
    private String curso;

    // -------------------------------------------------------
    // CONSTRUCTOR
    // -------------------------------------------------------

    public LibroTexto(String titulo, String autor, int numEjemplares,
                      int numEjemplaresPrestados, String curso) {
        // Llamada al constructor de la clase padre
        super(titulo, autor, numEjemplares, numEjemplaresPrestados);
        this.curso = curso;
    }

    // -------------------------------------------------------
    // GETTER Y SETTER
    // -------------------------------------------------------

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    // -------------------------------------------------------
    // toString REDEFINIDO
    // -------------------------------------------------------

    @Override
    public String toString() {
        return "=== LIBRO DE TEXTO ===" +
               "\n  Título             : " + getTitulo() +
               "\n  Autor              : " + getAutor() +
               "\n  Total ejemplares   : " + getNumEjemplares() +
               "\n  Prestados          : " + getNumEjemplaresPrestados() +
               "\n  Disponibles        : " + (getNumEjemplares() - getNumEjemplaresPrestados()) +
               "\n  Curso asociado     : " + curso;
    }
}
