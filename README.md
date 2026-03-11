# 📚 Sistema de Gestión de Biblioteca
**Parcial I - Programación II - G411**  
**Tema:** POO - Abstracción, Encapsulamiento y Herencia con Maven + GIT

---

## 📋 Descripción

Sistema de gestión de biblioteca que maneja diferentes tipos de libros aplicando los principios de POO: **Abstracción**, **Encapsulamiento** y **Herencia**.

---

## 🗂️ Diagrama UML de Clases

```
┌─────────────────────────────────────────────┐
│                   Libro                      │
├─────────────────────────────────────────────┤
│ - titulo: String                             │
│ - autor: String                              │
│ - numEjemplares: int                         │
│ - numEjemplaresPrestados: int                │
├─────────────────────────────────────────────┤
│ + Libro()                                    │
│ + Libro(titulo, autor, numEj, numEjPrest)    │
│ + getTitulo(): String                        │
│ + setTitulo(titulo: String): void            │
│ + getAutor(): String                         │
│ + setAutor(autor: String): void              │
│ + getNumEjemplares(): int                    │
│ + setNumEjemplares(n: int): void             │
│ + getNumEjemplaresPrestados(): int           │
│ + setNumEjemplaresPrestados(n: int): void    │
│ + prestamo(): boolean                        │
│ + devolucion(): boolean                      │
│ + toString(): String                         │
└──────────────────┬──────────────────────────┘
                   │  hereda
       ┌───────────┴────────────────────┐
       │                                │
┌──────▼──────────────────┐   ┌────────▼─────────────────┐
│      LibroTexto          │   │         Novela            │
├──────────────────────────┤   ├──────────────────────────┤
│ - curso: String          │   │ - tipo: TipoNovela        │
├──────────────────────────┤   ├──────────────────────────┤
│ + LibroTexto(...)        │   │ «enum» TipoNovela:        │
│ + getCurso(): String     │   │   HISTORICA               │
│ + setCurso(c: String):v  │   │   ROMANTICA               │
│ + toString(): String     │   │   POLICIACA               │
└──────────┬───────────────┘   │   REALISTA                │
           │ hereda             │   CIENCIA_FICCION         │
┌──────────▼───────────────┐   │   AVENTURAS               │
│    LibroTextoUNIAC        │   ├──────────────────────────┤
├──────────────────────────┤   │ + Novela(...)             │
│ - facultad: String        │   │ + getTipo(): TipoNovela   │
├──────────────────────────┤   │ + setTipo(t): void        │
│ + LibroTextoUNIAC(...)   │   │ + toString(): String      │
│ + getFacultad(): String  │   └──────────────────────────┘
│ + setFacultad(f: String) │
│ + toString(): String     │
└──────────────────────────┘
```

---

## 📁 Estructura del Proyecto (Maven)

```
sistema-biblioteca/
├── pom.xml
├── README.md
└── src/
    ├── main/
    │   └── java/
    │       └── com/
    │           └── biblioteca/
    │               ├── Libro.java
    │               ├── LibroTexto.java
    │               ├── LibroTextoUNIAC.java
    │               ├── Novela.java
    │               └── Main.java
    └── test/
        └── java/
            └── com/
                └── biblioteca/
```

---

## ▶️ Cómo ejecutar

### Prerrequisitos
- Java JDK 11 o superior
- Apache Maven 3.6+

### Comandos

```bash
# Compilar el proyecto
mvn compile

# Ejecutar
mvn exec:java -Dexec.mainClass="com.biblioteca.Main"

# Compilar y empaquetar en JAR
mvn package

# Ejecutar el JAR generado
java -jar target/sistema-biblioteca-1.0-SNAPSHOT.jar
```

---

## ⚠️ Situaciones donde NO se puede realizar herencia

### Situación 1 - Atributos privados (`private`)
Los atributos de `Libro` son `private`, por lo que las subclases **no pueden acceder directamente** a ellos:

```java
// En LibroTexto - ESTO NO COMPILARÍA:
public String mostrarTitulo() {
    return titulo;  // ❌ ERROR: titulo tiene acceso privado en Libro
}
// ✅ SOLUCIÓN: usar getTitulo()
```

### Situación 2 - Clases o métodos `final`
Si `Libro` se declarara `final`, ninguna subclase podría heredar de ella:

```java
// En Libro - ESTO IMPEDIRÍA LA HERENCIA:
public final class Libro { ... }

// En LibroTexto - ERROR en compilación:
public class LibroTexto extends Libro { ... } // ❌ no se puede heredar de final
```

---

## ➕ Nuevos atributos y método adicional

| Elemento | Nombre | Descripción |
|----------|--------|-------------|
| Atributo | `isbn` (String) | Identificador único internacional ISBN-13 del libro |
| Atributo | `editorial` (String) | Editorial que publicó el libro |
| Método   | `renovar(): boolean` | Renueva el préstamo si hay menos del 50% de ejemplares prestados; retorna `false` si no es posible |

---

## 👤 Autor
Parcial I · Programación II G411
