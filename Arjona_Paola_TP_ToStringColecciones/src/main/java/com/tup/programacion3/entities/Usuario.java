package com.tup.programacion3.entities;

import com.tup.programacion3.enums.Rol;

import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

 // Representa un usuario del sistema. Un usuario puede tener múltiples pedidos.
public class Usuario extends Base {

    private String nombre;
    private String apellido;
    private String mail;
    private String celular;
    private String contrasenia;
    private Rol rol;
    // Colección de pedidos asociados al usuario
    private Set<Pedido> pedidos;

    // Constructor vacío. Inicializa automáticamente la colección.
    public Usuario() {
        super();
        this.pedidos = new HashSet<>();
    }
    // Constructor con parámetros.
    public Usuario(String nombre, String apellido, String mail,
                   String celular, String contrasenia, Rol rol) {

        super();

        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.celular = celular;
        this.contrasenia = contrasenia;
        this.rol = rol;

        this.pedidos = new HashSet<>();
    }

    // Getter de nombre
    public String getNombre() {
        return nombre;
    }

    // Setter de nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter de apellido
    public String getApellido() {
        return apellido;
    }

    // Setter de apellido
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    // Getter de mail
    public String getMail() {
        return mail;
    }

    // Setter de mail
    public void setMail(String mail) {
        this.mail = mail;
    }

    // Getter de celular
    public String getCelular() {
        return celular;
    }

    // Setter de celular
    public void setCelular(String celular) {
        this.celular = celular;
    }

    // Getter de contraseña
    public String getContrasenia() {
        return contrasenia;
    }

    // Setter de contraseña
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    // Getter de rol
    public Rol getRol() {
        return rol;
    }

    // Setter de rol
    public void setRol(Rol rol) {
        this.rol = rol;
    }

    // Getter de pedidos
    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    // Setter de pedidos
    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

     // Representación legible del objeto
     @Override
     public String toString() {
         return "Usuario{" +
                 "nombre='" + nombre + '\'' +
                 ", apellido='" + apellido + '\'' +
                 ", mail='" + mail + '\'' +
                 ", rol=" + rol +
                 '}';
     }
     // Compara usuarios según su identidad lógica
     @Override
     public boolean equals(Object o) {
         if (this == o) {
             return true;
         }
         if (o == null || getClass() != o.getClass()) {
             return false;
         }
         Usuario usuario = (Usuario) o;
         return Objects.equals(mail, usuario.mail);
     }
     // Genera un código hash coherente con la igualdad definida
     @Override
     public int hashCode() {
         return Objects.hash(mail);
     }
}