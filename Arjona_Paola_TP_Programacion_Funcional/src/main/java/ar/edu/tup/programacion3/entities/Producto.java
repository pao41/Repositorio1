package ar.edu.tup.programacion3.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

// Representa un producto del sistema
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "nombre", callSuper = false)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor

public class Producto extends Base {

    private String nombre;
    private Double precio;
    private String descripcion;
    private int stock;
    private String imagen;
    private Boolean disponible;

    // Categoría asociada
    @ToString.Exclude
    private Categoria categoria;
}