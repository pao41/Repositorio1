package ar.edu.tup.programacion3.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

// Clase base con atributos comunes a las entidades
@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor

public abstract class Base {

    // Identificador único
    private Long id;
    // Estado
    private boolean eliminado;
    // Fecha
    private LocalDateTime createdAt;
}