package com.biblioteca;

/**
 * Clase Novela - hereda de Libro.
 * Puede ser de diferentes tipos definidos en el enum TipoNovela.
 */
public class Novela extends Libro {

    /**
     * Enumeración de tipos posibles de novela.
     */
    public enum TipoNovela {
        HISTORICA,
        ROMANTICA,
        POLICIACA,
        REALISTA,
        CIENCIA_FICCION,
        AVENTURAS
    }

    // Atributo adicional
    private TipoNovela tipo;

    // -------------------------------------------------------
    // CONSTRUCTOR
    // -------------------------------------------------------

    public Novela(String titulo, String autor, int numEjemplares,
                  int numEjemplaresPrestados, TipoNovela tipo) {
        super(titulo, autor, numEjemplares, numEjemplaresPrestados);
        this.tipo = tipo;
    }

    // -------------------------------------------------------
    // GETTER Y SETTER
    // -------------------------------------------------------

    public TipoNovela getTipo() {
        return tipo;
    }

    public void setTipo(TipoNovela tipo) {
        this.tipo = tipo;
    }

    // -------------------------------------------------------
    // toString REDEFINIDO
    // -------------------------------------------------------

    @Override
    public String toString() {
        return "=== NOVELA ===" +
               "\n  Título             : " + getTitulo() +
               "\n  Autor              : " + getAutor() +
               "\n  Total ejemplares   : " + getNumEjemplares() +
               "\n  Prestados          : " + getNumEjemplaresPrestados() +
               "\n  Disponibles        : " + (getNumEjemplares() - getNumEjemplaresPrestados()) +
               "\n  Tipo de novela     : " + tipo;
    }
}
