package com.biblioteca;

/**
 * Clase LibroTextoUNIAC - hereda de LibroTexto.
 * Agrega el atributo "facultad" que indica qué facultad publicó el libro.
 */
public class LibroTextoUNIAC extends LibroTexto {

    // Atributo adicional
    private String facultad;

    // -------------------------------------------------------
    // CONSTRUCTOR
    // -------------------------------------------------------

    public LibroTextoUNIAC(String titulo, String autor, int numEjemplares,
                            int numEjemplaresPrestados, String curso, String facultad) {
        // Llamada al constructor de LibroTexto
        super(titulo, autor, numEjemplares, numEjemplaresPrestados, curso);
        this.facultad = facultad;
    }

    // -------------------------------------------------------
    // GETTER Y SETTER
    // -------------------------------------------------------

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    // -------------------------------------------------------
    // toString REDEFINIDO
    // -------------------------------------------------------

    @Override
    public String toString() {
        return "=== LIBRO TEXTO UNIAC ===" +
               "\n  Título             : " + getTitulo() +
               "\n  Autor              : " + getAutor() +
               "\n  Total ejemplares   : " + getNumEjemplares() +
               "\n  Prestados          : " + getNumEjemplaresPrestados() +
               "\n  Disponibles        : " + (getNumEjemplares() - getNumEjemplaresPrestados()) +
               "\n  Curso asociado     : " + getCurso() +
               "\n  Facultad           : " + facultad;
    }
}
