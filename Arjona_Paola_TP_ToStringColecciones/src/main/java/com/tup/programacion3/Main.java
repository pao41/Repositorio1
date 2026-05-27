package com.tup.programacion3;

import com.tup.programacion3.entities.*;
import com.tup.programacion3.enums.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        // Categorías
        Categoria pizzas       = new Categoria("Pizzas",       "Pizzas artesanales con masa fresca");
        Categoria hamburguesas = new Categoria("Hamburguesas", "Hamburguesas gourmet con ingredientes frescos");
        Categoria bebidas      = new Categoria("Bebidas",      "Gaseosas, jugos y bebidas frías");

        // Productos
        Producto p1  = new Producto("Pizza Muzzarella",         4500.0, "Pizza clásica con salsa de tomate y muzzarella", 20,  "pizza-muzzarella.jpg",  true, pizzas);
        Producto p2  = new Producto("Pizza Napolitana",          5200.0, "Pizza con tomate fresco, ajo y albahaca",        15,  "pizza-napolitana.jpg",  true, pizzas);
        Producto p3  = new Producto("Hamburguesa Clásica",       3800.0, "Medallón de carne, lechuga, tomate y mayo",      30,  "burger-clasica.jpg",    true, hamburguesas);
        Producto p4  = new Producto("Hamburguesa BBQ Bacon",     5100.0, "Doble medallón, bacon y salsa barbacoa",         25,  "burger-bbq-bacon.jpg",  true, hamburguesas);
        Producto p5  = new Producto("Coca-Cola 500ml",           1200.0, "Gaseosa Coca-Cola fría, botella personal",      100,  "coca-cola-500ml.jpg",   true, bebidas);
        Producto p6  = new Producto("Jugo de Naranja Natural",   1800.0, "Jugo exprimido en el momento, vaso 400ml",       40,  "jugo-naranja.jpg",      true, bebidas);
        Producto p7  = new Producto("Agua Mineral 500ml",         800.0, "Agua mineral sin gas, botella personal",        150,  "agua-500ml.jpg",        true, bebidas);
        Producto p8  = new Producto("Sprite 500ml",              1200.0, "Gaseosa Sprite fría, botella personal",         100,  "sprite-500ml.jpg",      true, bebidas);
        Producto p9  = new Producto("Pizza Fugazzeta",           5500.0, "Pizza rellena con cebolla caramelizada",         10,  "pizza-fugazzeta.jpg",   true, pizzas);
        Producto p10 = new Producto("Hamburguesa Veggie",        4200.0, "Medallón de lentejas, cheddar vegano y rúcula",  15,  "burger-veggie.jpg",     true, hamburguesas);

        // Colección de productos
        Set<Producto> productos = new HashSet<>();
        productos.add(p1); productos.add(p2); productos.add(p3); productos.add(p4); productos.add(p5);
        productos.add(p6); productos.add(p7); productos.add(p8); productos.add(p9); productos.add(p10);

        // Pedido 1: confirmado, pago con tarjeta
        Pedido pedido1 = new Pedido(LocalDate.now(), Estado.CONFIRMADO, FormaPago.TARJETA);
        pedido1.setId(1L);
        pedido1.addDetallePedido(new DetallePedido(1, p1));
        pedido1.addDetallePedido(new DetallePedido(1, p3));
        pedido1.addDetallePedido(new DetallePedido(2, p5));
        pedido1.calcularTotal();

        // Pedido 2: pendiente, pago por transferencia
        Pedido pedido2 = new Pedido(LocalDate.now(), Estado.PENDIENTE, FormaPago.TRANSFERENCIA);
        pedido2.setId(2L);
        pedido2.addDetallePedido(new DetallePedido(2, p6));
        pedido2.addDetallePedido(new DetallePedido(1, p7));
        pedido2.addDetallePedido(new DetallePedido(1, p9));
        pedido2.calcularTotal();

        // Pedido 3: terminado, pago en efectivo
        Pedido pedido3 = new Pedido(LocalDate.now(), Estado.TERMINADO, FormaPago.EFECTIVO);
        pedido3.setId(3L);
        pedido3.addDetallePedido(new DetallePedido(1, p2));
        pedido3.addDetallePedido(new DetallePedido(3, p8));
        pedido3.addDetallePedido(new DetallePedido(1, p10));
        pedido3.calcularTotal();

        // Usuarios
        Usuario u1 = new Usuario("María", "Paz", "maria@email.com", "1160010000", "123456", Rol.USUARIO);
        u1.getPedidos().add(pedido1);
        u1.getPedidos().add(pedido2);
        u1.getPedidos().add(pedido3);

        Usuario u2 = new Usuario("David", "Pérez", "david@email.com", "1161110011", "admin123456", Rol.ADMIN);

        Set<Usuario> usuarios = new HashSet<>();
        usuarios.add(u1);
        usuarios.add(u2);

        // PUNTO 4 ***********

        // Muestra un producto
        System.out.println("UN PRODUCTO");
        System.out.println(p1);

        // Muestra el listado completo de productos
        System.out.println("\nLISTADO DE PRODUCTOS");
        for (Producto producto : productos) {
            System.out.println(producto);
        }

        // Determina el usuario con más pedidos
        System.out.println("\nUSUARIO CON MÁS PEDIDOS");
        Usuario conMasPedidos = null;
        for (Usuario usuario : usuarios) {
            if (conMasPedidos == null || usuario.getPedidos().size() > conMasPedidos.getPedidos().size()) {
                conMasPedidos = usuario;
            }
        }

        // Muestra sus pedidos
        if (conMasPedidos != null) {
            System.out.println(conMasPedidos.getNombre() + " " + conMasPedidos.getApellido() + "\nPedidos:");
            for (Pedido pedido : conMasPedidos.getPedidos()) {
                System.out.println(pedido);
            }
        }

        // PUNTO 5 ***********

        // Instancia un producto con el mismo nombre que p1
        System.out.println("\nCOMPARACIÓN CON PRODUCTO DUPLICADO");
        Producto duplicado = new Producto("Pizza Muzzarella", 3000.0, "Otro producto", 5, "otro.jpg", true, hamburguesas);

        System.out.println("Se instancia un nuevo producto:'Pizza Muzzarella' y se compara con la colección:\n");

        // Compara el duplicado contra toda la colección
        for (Producto producto : productos) {
            System.out.println("duplicado.equals(" + producto.getNombre() + ") -> " + duplicado.equals(producto));
        }

        // Intenta agregar el duplicado al Set
        boolean agregado = productos.add(duplicado);
        System.out.println("\n¿Se agregó al Set? -> " + agregado);
        System.out.println("Cantidad final de productos -> " + productos.size());
    }
}