package com.tup.programacion3.entities;

import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

// Una categoría puede contener múltiples productos
public class Categoria extends Base {

    // Nombre
    private String nombre;

    // Descripción
    private String descripcion;

    // Colección de productos asociados a la categoría
    private Set<Producto> productos;

    // Constructor vacío. Inicializa automáticamente la colección.
    public Categoria() {
        super();
        this.productos = new HashSet<>();
    }

    // Constructor con parámetros.
    public Categoria(String nombre, String descripcion) {
        super();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.productos = new HashSet<>();
    }

    // Getter de nombre
    public String getNombre() {
        return nombre;
    }

    // Setter de nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter de descripcion
    public String getDescripcion() {
        return descripcion;
    }

    // Setter de descripcion
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Getter de productos
    public Set<Producto> getProductos() {
        return productos;
    }

    // Setter de productos
    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }


    // Representación legible del objeto
    @Override
    public String toString() {

        return "Categoria{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    // Compara categorías según su identidad lógica
    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Categoria categoria = (Categoria) o;

        return Objects.equals(nombre, categoria.nombre);
    }

    // Genera un código hash coherente con la igualdad definida
    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}