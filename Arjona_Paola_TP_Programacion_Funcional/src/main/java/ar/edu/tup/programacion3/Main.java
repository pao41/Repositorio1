package ar.edu.tup.programacion3;

import ar.edu.tup.programacion3.entities.*;
import ar.edu.tup.programacion3.enums.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        // Instanciación de categorías
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
                .stock(3).imagen("burger-bbq-bacon.jpg")
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
                .stock(2).imagen("burger-veggie.jpg")
                .disponible(true).categoria(hamburguesas)
                .build();

        // Colección de productos
        Set<Producto> productos = new HashSet<>();

        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        productos.add(p4);
        productos.add(p5);
        productos.add(p6);
        productos.add(p7);
        productos.add(p8);
        productos.add(p9);
        productos.add(p10);

        // Pedido con cálculo funcional del total
        Pedido pedido1 = Pedido.builder()
                .id(1L).eliminado(false).createdAt(LocalDateTime.now())
                .fecha(LocalDate.now()).estado(Estado.CONFIRMADO)
                .formaPago(FormaPago.TARJETA)
                .build();
        // Agrega detalles al pedido
        pedido1.addDetallePedido(new DetallePedido(1, p1));
        pedido1.addDetallePedido(new DetallePedido(1, p3));
        pedido1.addDetallePedido(new DetallePedido(2, p5));
        // Calcula el total
        pedido1.calcularTotal();

        // Pedido con cálculo funcional del total
        Pedido pedido2 = Pedido.builder()
                .id(2L).eliminado(false).createdAt(LocalDateTime.now())
                .fecha(LocalDate.now()).estado(Estado.PENDIENTE)
                .formaPago(FormaPago.TRANSFERENCIA)
                .build();
        // Agrega detalles al pedido
        pedido2.addDetallePedido(new DetallePedido(2, p6));
        pedido2.addDetallePedido(new DetallePedido(1, p7));
        pedido2.addDetallePedido(new DetallePedido(1, p9));

        pedido2.calcularTotal();

        // Pedido con cálculo funcional del total
        Pedido pedido3 = Pedido.builder()
                .id(3L).eliminado(false).createdAt(LocalDateTime.now())
                .fecha(LocalDate.now()).estado(Estado.TERMINADO)
                .formaPago(FormaPago.EFECTIVO)
                .build();
        // Agrega detalles al pedido
        pedido3.addDetallePedido(new DetallePedido(1, p2));
        pedido3.addDetallePedido(new DetallePedido(3, p8));
        pedido3.addDetallePedido(new DetallePedido(1, p10));

        pedido3.calcularTotal();

        // PROGRAMACIÓN FUNCIONAL

        // PUNTO 2 - Muestra productos disponibles usando filter() y forEach()
        System.out.println("\nPRODUCTOS DISPONIBLES");

        productos.stream()
                .filter(Producto::getDisponible)
                .forEach(System.out::println);

        // PUNTO 3 - Calcula la cantidad total de items del pedido
        System.out.println("\nCANTIDAD TOTAL DE ITEMS DEL PEDIDO 1");

        int totalItems = pedido1.getDetalles().stream()
                .mapToInt(DetallePedido::getCantidad)
                .sum();

        System.out.println("Cantidad total de items: " + totalItems);

        // PUNTO 4 - Productos con stock menor a 5 usando filter()
        System.out.println("\nPRODUCTOS CON STOCK MENOR A 5");

        productos.stream()
                .filter(producto -> producto.getStock() < 5)
                .forEach(System.out::println);
    }
}