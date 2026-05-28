package com.utn.dtos;

// DTO que expone información del usuario ocultando datos sensibles
// Se omiten: contraseña y rol

public record UsuarioDTO(
        Long id,
        String nombre,
        String apellido,
        String mail,
        String celular
) {
}