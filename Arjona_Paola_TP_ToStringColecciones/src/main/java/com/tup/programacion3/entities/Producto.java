package com.tup.programacion3.entities;

import java.util.Objects;

 // Representa un producto del sistema. Cada producto pertenece a una categoría.
public class Producto extends Base {

     private String nombre;
     private Double precio;
     private String descripcion;
     private int stock;
     private String imagen;
     private Boolean disponible;
     // Categoría asociada al producto
     private Categoria categoria;

     // Constructor vacío.
     public Producto() {
         super();
     }

     // Constructor con parámetros.
     public Producto(String nombre, Double precio, String descripcion,
                     int stock, String imagen, Boolean disponible,
                     Categoria categoria) {

         super();

         this.nombre = nombre;
         this.precio = precio;
         this.descripcion = descripcion;
         this.stock = stock;
         this.imagen = imagen;
         this.disponible = disponible;
         this.categoria = categoria;
     }

     // Getter de nombre
     public String getNombre() {
         return nombre;
     }

     // Setter de nombre
     public void setNombre(String nombre) {
         this.nombre = nombre;
     }

     // Getter de precio
     public Double getPrecio() {
         return precio;
     }

     // Setter de precio
     public void setPrecio(Double precio) {
         this.precio = precio;
     }

     // Getter de descripcion
     public String getDescripcion() {
         return descripcion;
     }

     // Setter de descripcion
     public void setDescripcion(String descripcion) {
         this.descripcion = descripcion;
     }

     // Getter de stock
     public int getStock() {
         return stock;
     }

     // Setter de stock
     public void setStock(int stock) {
         this.stock = stock;
     }

     // Getter de imagen
     public String getImagen() {
         return imagen;
     }

     // Setter de imagen
     public void setImagen(String imagen) {
         this.imagen = imagen;
     }

     // Getter de disponible
     public Boolean getDisponible() {
         return disponible;
     }

     // Setter de disponible
     public void setDisponible(Boolean disponible) {
         this.disponible = disponible;
     }

     // Getter de categoria
     public Categoria getCategoria() {
         return categoria;
     }

     // Setter de categoria
     public void setCategoria(Categoria categoria) {
         this.categoria = categoria;
     }

     // Representación legible del objeto
     @Override
     public String toString() {

         return "Producto{" +
                 "nombre='" + nombre + '\'' +
                 ", precio=" + precio +
                 ", descripcion='" + descripcion + '\'' +
                 ", stock=" + stock +
                 ", disponible=" + disponible +
                 '}';
     }

     // Compara productos según su identidad lógica
     @Override
     public boolean equals(Object o) {
         if (this == o) {
             return true;
         }
         if (o == null || getClass() != o.getClass()) {
             return false;
         }
         Producto producto = (Producto) o;
         return Objects.equals(nombre, producto.nombre);
     }

     // Código hash basado en el nombre del producto
     @Override
     public int hashCode() {
         return Objects.hash(nombre);
     }
 }