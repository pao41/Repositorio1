package com.tup.programacion3.entities;

import java.time.LocalDateTime;

// Clase abstracta base que contiene atributos comunes
public abstract class Base {

    // Identificador único de la entidad
    private Long id;
    private boolean eliminado;
    private LocalDateTime createdAt;

    // Constructor vacío. Inicializa valores por defecto para nuevas entidades.
    public Base() {
        this.eliminado = false;
        this.createdAt = LocalDateTime.now();
    }

    // Constructor completo. Permite reconstruir entidades con todos sus datos.
    public Base(Long id, boolean eliminado, LocalDateTime createdAt) {
        this.id = id;
        this.eliminado = eliminado;
        this.createdAt = createdAt;
    }

    // Getter del id
    public Long getId() {
        return id;
    }

    // Setter del id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter de eliminado
    public boolean isEliminado() {
        return eliminado;
    }

    // Setter de eliminado
    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    // Getter de createdAt
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // Setter de createdAt
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}