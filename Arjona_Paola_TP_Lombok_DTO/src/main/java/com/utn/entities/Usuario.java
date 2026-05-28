package com.utn.entities;

import com.utn.enums.Rol;

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

// Representa un usuario del sistema
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "mail", callSuper = false)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor

public class Usuario extends Base {

    private String nombre;
    private String apellido;
    private String mail;
    private String celular;
    private String contrasenia;
    private Rol rol;

    // Pedidos asociados al usuario
    @ToString.Exclude
    @Builder.Default
    private Set<Pedido> pedidos = new HashSet<>();
}