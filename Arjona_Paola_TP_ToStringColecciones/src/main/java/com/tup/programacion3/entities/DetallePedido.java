package com.tup.programacion3.entities;

import java.util.Objects;

 // Representa detalle dentro de un pedido
public class DetallePedido extends Base {

    private int cantidad;
    private Double subtotal;
    // Producto asociado al detalle
    private Producto producto;

    // Constructor vacío
    public DetallePedido() {
        super();
    }

    // Constructor con parámetros
    public DetallePedido(int cantidad, Producto producto) {

        super();

        this.cantidad = cantidad;
        this.producto = producto;
        // Calcula automáticamente el subtotal
        this.subtotal = cantidad * producto.getPrecio();
     }

    // Getter de cantidad
    public int getCantidad() {
        return cantidad;
    }

    // Setter de cantidad
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Getter de subtotal
    public Double getSubtotal() {
        return subtotal;
    }

    // Setter de subtotal
    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    // Getter de producto
    public Producto getProducto() {
        return producto;
    }

    // Setter de producto
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

     // Representación legible del objeto
     @Override
     public String toString() {

         return "DetallePedido{" +
                 "cantidad=" + cantidad +
                 ", subtotal=" + subtotal +
                 ", producto=" + (producto != null ? producto.getNombre() : "Sin producto") +
                 '}';
     }

     // Compara detalles según su identidad lógica
     @Override
     public boolean equals(Object o) {
         if (this == o) {
             return true;
         }
         if (o == null || getClass() != o.getClass()) {
             return false;
         }
         DetallePedido detalle = (DetallePedido) o;
         return Objects.equals(producto, detalle.producto);
     }

     // Genera un código hash coherente con la igualdad definida
     @Override
     public int hashCode() {
         return Objects.hash(producto);
     }
}