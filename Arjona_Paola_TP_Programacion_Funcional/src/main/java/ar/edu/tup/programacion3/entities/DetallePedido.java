package ar.edu.tup.programacion3.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

// Representa el detalle de un pedido
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "producto", callSuper = false)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor

public class DetallePedido extends Base {

    private int cantidad;
    private Double subtotal;
    // Producto asociado
    private Producto producto;

    // Constructor que encapsula el calculo automatico del subtotal
    public DetallePedido(int cantidad, Producto producto) {

        this.cantidad = cantidad;
        this.producto = producto;
        this.subtotal = cantidad * producto.getPrecio();
    }
}