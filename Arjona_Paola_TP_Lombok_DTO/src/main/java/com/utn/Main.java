package com.utn;

import com.utn.dtos.UsuarioDTO;
import com.utn.entities.*;
import com.utn.enums.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        // Instanciación de categorías usando Builder
        Categoria pizzas = Categoria.builder()
                .id(1L).eliminado(false).createdAt(LocalDateTime.now())
                .nombre("Pizzas").descripcion("Pizzas artesanales con masa fresca")
                .build();

        Categoria hamburguesas = Categoria.builder()
                .id(2L).eliminado(false).createdAt(LocalDateTime.now())
                .nombre("Hamburguesas").descripcion("Hamburguesas gourmet con ingredientes frescos")
                .build();

        Categoria bebidas = Categoria.builder()
                .id(3L).eliminado(false).createdAt(LocalDateTime.now())
                .nombre("Bebidas").descripcion("Gaseosas, jugos y bebidas frías")
                .build();

        // Instanciación de productos asociados a categorías
        Producto p1 = Producto.builder()
                .id(1L).eliminado(false).createdAt(LocalDateTime.now())
                .nombre("Pizza Muzzarella").precio(4500.0)
                .descripcion("Pizza clásica con salsa de tomate y muzzarella")
                .stock(20).imagen("pizza-muzzarella.jpg")
                .disponible(true).categoria(pizzas)
                .build();

        Producto p2 = Producto.builder()
                .id(2L).eliminado(false).createdAt(LocalDateTime.now())
                .nombre("Pizza Napolitana").precio(5200.0)
                .descripcion("Pizza con tomate fresco, ajo y albahaca")
                .stock(15).imagen("pizza-napolitana.jpg")
                .disponible(true).categoria(pizzas)
                .build();

        Producto p3 = Producto.builder()
                .id(3L).eliminado(false).createdAt(LocalDateTime.now())
                .nombre("Hamburguesa Clásica").precio(3800.0)
                .descripcion("Medallón de carne, lechuga, tomate y mayo")
                .stock(30).imagen("burger-clasica.jpg")
                .disponible(true).categoria(hamburguesas)
                .build();

        Producto p4 = Producto.builder()
                .id(4L).eliminado(false).createdAt(LocalDateTime.now())
                .nombre("Hamburguesa BBQ Bacon").precio(5100.0)
                .descripcion("Doble medallón, bacon y salsa barbacoa")
                .stock(25).imagen("burger-bbq-bacon.jpg")
                .disponible(true).categoria(hamburguesas)
                .build();

        Producto p5 = Producto.builder()
                .id(5L).eliminado(false).createdAt(LocalDateTime.now())
                .nombre("Coca-Cola 500ml").precio(1200.0)
                .descripcion("Gaseosa Coca-Cola fría, botella personal")
                .stock(100).imagen("coca-cola-500ml.jpg")
                .disponible(true).categoria(bebidas)
                .build();

        Producto p6 = Producto.builder()
                .id(6L).eliminado(false).createdAt(LocalDateTime.now())
                .nombre("Jugo de Naranja Natural").precio(1800.0)
                .descripcion("Jugo exprimido en el momento, vaso 400ml")
                .stock(40).imagen("jugo-naranja.jpg")
                .disponible(true).categoria(bebidas)
                .build();

        Producto p7 = Producto.builder()
                .id(7L).eliminado(false).createdAt(LocalDateTime.now())
                .nombre("Agua Mineral 500ml").precio(800.0)
                .descripcion("Agua mineral sin gas, botella personal")
                .stock(150).imagen("agua-500ml.jpg")
                .disponible(true).categoria(bebidas)
                .build();

        Producto p8 = Producto.builder()
                .id(8L).eliminado(false).createdAt(LocalDateTime.now())
                .nombre("Sprite 500ml").precio(1200.0)
                .descripcion("Gaseosa Sprite fría, botella personal")
                .stock(100).imagen("sprite-500ml.jpg")
                .disponible(true).categoria(bebidas)
                .build();

        Producto p9 = Producto.builder()
                .id(9L).eliminado(false).createdAt(LocalDateTime.now())
                .nombre("Pizza Fugazzeta").precio(5500.0)
                .descripcion("Pizza rellena con cebolla caramelizada")
                .stock(10).imagen("pizza-fugazzeta.jpg")
                .disponible(true).categoria(pizzas)
                .build();

        Producto p10 = Producto.builder()
                .id(10L).eliminado(false).createdAt(LocalDateTime.now())
                .nombre("Hamburguesa Veggie").precio(4200.0)
                .descripcion("Medallón de lentejas, cheddar vegano y rúcula")
                .stock(15).imagen("burger-veggie.jpg")
                .disponible(true).categoria(hamburguesas)
                .build();

        // Colección Set para evitar productos duplicados
        Set<Producto> productos = new HashSet<>();
        productos.add(p1); productos.add(p2); productos.add(p3); productos.add(p4); productos.add(p5);
        productos.add(p6); productos.add(p7); productos.add(p8); productos.add(p9); productos.add(p10);

        // Pedido 1: Pedido con detalles y cálculo automático del total
        Pedido pedido1 = Pedido.builder()
                .id(1L).eliminado(false).createdAt(LocalDateTime.now())
                .fecha(LocalDate.now()).estado(Estado.CONFIRMADO)
                .formaPago(FormaPago.TARJETA)
                .build();
        // Se agregan detalles al pedido
        pedido1.addDetallePedido(new DetallePedido(1, p1));
        pedido1.addDetallePedido(new DetallePedido(1, p3));
        pedido1.addDetallePedido(new DetallePedido(2, p5));
        // Calcula el total sumando subtotales de los detalles
        pedido1.calcularTotal();

        // Pedido 2: Pedido con detalles y cálculo automático del total
        Pedido pedido2 = Pedido.builder()
                .id(2L).eliminado(false).createdAt(LocalDateTime.now())
                .fecha(LocalDate.now()).estado(Estado.PENDIENTE)
                .formaPago(FormaPago.TRANSFERENCIA)
                .build();
        // Se agregan detalles al pedido
        pedido2.addDetallePedido(new DetallePedido(2, p6));
        pedido2.addDetallePedido(new DetallePedido(1, p7));
        pedido2.addDetallePedido(new DetallePedido(1, p9));
        // Calcula el total
        pedido2.calcularTotal();

        // Pedido 3: Pedido con detalles y cálculo automático del total
        Pedido pedido3 = Pedido.builder()
                .id(3L).eliminado(false).createdAt(LocalDateTime.now())
                .fecha(LocalDate.now()).estado(Estado.TERMINADO)
                .formaPago(FormaPago.EFECTIVO)
                .build();
        // Se agregan detalles al pedido
        pedido3.addDetallePedido(new DetallePedido(1, p2));
        pedido3.addDetallePedido(new DetallePedido(3, p8));
        pedido3.addDetallePedido(new DetallePedido(1, p10));
        // Calcula el total
        pedido3.calcularTotal();

        // Instanciación de usuarios mediante Builder
        Usuario u1 = Usuario.builder()
                .id(1L).eliminado(false).createdAt(LocalDateTime.now())
                .nombre("María").apellido("Paz")
                .mail("maria@email.com")
                .celular("1160010000")
                .contrasenia("123456")
                .rol(Rol.USUARIO)
                .build();
        // Asociación de pedidos al usuario
        u1.getPedidos().add(pedido1);
        u1.getPedidos().add(pedido2);
        u1.getPedidos().add(pedido3);

        // Instanciación de usuarios mediante Builder
        Usuario u2 = Usuario.builder()
                .id(2L).eliminado(false).createdAt(LocalDateTime.now())
                .nombre("David").apellido("Pérez")
                .mail("david@email.com")
                .celular("1161110011")
                .contrasenia("admin123456")
                .rol(Rol.ADMIN)
                .build();

        // Colección de usuarios
        Set<Usuario> usuarios = new HashSet<>();
        usuarios.add(u1);
        usuarios.add(u2);

        // PUNTO 4

        // Muestra un producto
        System.out.println("UN PRODUCTO");
        System.out.println(p1);

        // Muestra el listado completo de productos
        System.out.println("\nLISTADO DE PRODUCTOS");
        for (Producto producto : productos) {
            System.out.println(producto);
        }

        // Busca el usuario con más pedidos
        System.out.println("\nUSUARIO CON MÁS PEDIDOS");

        Usuario conMasPedidos = null;

        for (Usuario usuario : usuarios) {
            if (conMasPedidos == null ||
                    usuario.getPedidos().size() > conMasPedidos.getPedidos().size()) {

                conMasPedidos = usuario;
            }
        }

        // Muestra sus pedidos
        if (conMasPedidos != null) {

            System.out.println(conMasPedidos.getNombre() + " "
                    + conMasPedidos.getApellido() + "\nPedidos:");

            for (Pedido pedido : conMasPedidos.getPedidos()) {
                System.out.println(pedido);
            }
        }

        // PUNTO 5

        // Producto duplicado (equals/hashCode)
        System.out.println("\nCOMPARACIÓN CON PRODUCTO DUPLICADO");

        Producto duplicado = Producto.builder()
                .nombre("Pizza Muzzarella")
                .precio(3000.0)
                .descripcion("Otro producto")
                .stock(5)
                .imagen("otro.jpg")
                .disponible(true)
                .categoria(hamburguesas)
                .build();

        System.out.println("Se instancia un nuevo producto: 'Pizza Muzzarella' y se compara con la colección:\n");
        // Compara el producto duplicado con toda la colección
        for (Producto producto : productos) {
            System.out.println("duplicado.equals(" + producto.getNombre()
                    + ") -> " + duplicado.equals(producto));
        }
        // Verifica comportamiento del Set frente a duplicados
        boolean agregado = productos.add(duplicado);

        System.out.println("\n¿Se agregó al Set? -> " + agregado);
        System.out.println("Cantidad final de productos -> " + productos.size());

        // PUNTO 6

        // DTO oculta informacion sensible del usuario (sin contraseña ni rol)
        System.out.println("\nUSUARIO DTO");

        UsuarioDTO dto = new UsuarioDTO(
                u1.getId(),
                u1.getNombre(),
                u1.getApellido(),
                u1.getMail(),
                u1.getCelular()
        );

        System.out.println(dto);
    }
}