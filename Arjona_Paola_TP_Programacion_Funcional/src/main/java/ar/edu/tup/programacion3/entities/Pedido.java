package ar.edu.tup.programacion3.entities;

import ar.edu.tup.programacion3.enums.Estado;
import ar.edu.tup.programacion3.enums.FormaPago;
import lombok.*;
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

    // Calcula el total usando Streams
    @Override
    public void calcularTotal() {
        this.total = detalles.stream()
                .mapToDouble(DetallePedido::getSubtotal)
                .sum();
    }
}