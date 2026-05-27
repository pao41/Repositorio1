package com.tup.programacion3.entities;

import com.tup.programacion3.enums.Estado;
import com.tup.programacion3.enums.FormaPago;
import com.tup.programacion3.interfaces.Calculable;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

// Un pedido contiene múltiples detalles
public class Pedido extends Base implements Calculable {

    private LocalDate fecha;
    private Estado estado;
    private Double total;
    private FormaPago formaPago;
    // Colección de detalles del pedido
    private Set<DetallePedido> detalles;

    // Constructor vacío. Inicializa automáticamente la colección
    public Pedido() {
        super();
        this.detalles = new HashSet<>();
    }
    // Constructor con parámetros
    public Pedido(LocalDate fecha, Estado estado,
                  FormaPago formaPago) {

        super();

        this.fecha = fecha;
        this.estado = estado;
        this.formaPago = formaPago;

        this.detalles = new HashSet<>();
    }

    // Agrega un detalle al pedido.
    public void addDetallePedido(DetallePedido detalle) {
        this.detalles.add(detalle);
    }

    // Busca un detalle por producto.
    public DetallePedido findDetallePedidoByProducto(Producto producto) {

        for (DetallePedido detalle : detalles) {

            if (detalle.getProducto().equals(producto)) {
                return detalle;
            }
        }
        return null;
    }

    // Elimina un detalle según producto.
    public void deleteDetallePedidoByProducto(Producto producto) {

        DetallePedido detalle = findDetallePedidoByProducto(producto);

        if (detalle != null) {
            detalles.remove(detalle);
        }
    }

    // Calcula el total del pedido.
    @Override
    public void calcularTotal() {

        double suma = 0;

        for (DetallePedido detalle : detalles) {
            suma += detalle.getSubtotal();
        }

        this.total = suma;
    }

    // Getter de fecha
    public LocalDate getFecha() {
        return fecha;
    }

    // Setter de fecha
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    // Getter de estado
    public Estado getEstado() {
        return estado;
    }

    // Setter de estado
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    // Getter de total
    public Double getTotal() {
        return total;
    }

    // Setter de total
    public void setTotal(Double total) {
        this.total = total;
    }

    // Getter de formaPago
    public FormaPago getFormaPago() {
        return formaPago;
    }

    // Setter de formaPago
    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    // Getter de detalles
    public Set<DetallePedido> getDetalles() {
        return detalles;
    }

    // Setter de detalles
    public void setDetalles(Set<DetallePedido> detalles) {
        this.detalles = detalles;
    }


    // Representación legible del objeto
    @Override
    public String toString() {

        return "Pedido{" +
                "fecha=" + fecha +
                ", estado=" + estado +
                ", total=" + total +
                ", formaPago=" + formaPago +
                '}';
    }

    // Compara pedidos según su identidad lógica
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pedido pedido = (Pedido) o;
        return Objects.equals(getId(), pedido.getId());
    }

    // Genera un código hash coherente con la igualdad definida
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}