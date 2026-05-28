package com.utn.entities;

import com.utn.enums.Estado;
import com.utn.enums.FormaPago;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

// Representa un pedido realizado por un usuario
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor

public class Pedido extends Base implements Calculable {

    private LocalDate fecha;
    private Estado estado;
    private Double total;
    private FormaPago formaPago;

    // Detalles asociados al pedido
    @ToString.Exclude
    @Builder.Default
    private Set<DetallePedido> detalles = new HashSet<>();

    // Agrega un detalle al pedido
    public void addDetallePedido(DetallePedido detalle) {
        detalles.add(detalle);
    }

    // Calcula el total sumando subtotales
    @Override
    public void calcularTotal() {

        double suma = 0;

        for (DetallePedido detalle : detalles) {
            suma += detalle.getSubtotal();
        }

        this.total = suma;
    }
}