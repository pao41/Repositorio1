package ar.edu.tup.programacion3.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

// Representa una categoría que agrupa productos
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "nombre", callSuper = false)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor

public class Categoria extends Base {

    private String nombre;
    private String descripcion;

    // Colección de productos asociados a la categoría
    @ToString.Exclude
    @Builder.Default
    private Set<Producto> productos = new HashSet<>();
}