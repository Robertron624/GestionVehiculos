package com.roberts.gestionvehiculos;

import com.roberts.gestionvehiculos.models.Cliente;
import com.roberts.gestionvehiculos.models.Vehiculo;
import com.roberts.gestionvehiculos.models.Transportista;
import com.roberts.gestionvehiculos.models.Compra;

public class Main {
        public static void main(String[] args) {
                // Crear un vehículo
                Vehiculo vehiculo = new Vehiculo(
                                111, "Toyota", "Corolla", 2020,
                                Vehiculo.TipoVehiculo.LIGERO, Vehiculo.EstadoVehiculo.NUEVO, 20000, 0,
                                new String[] { "Aire acondicionado", "GPS", "Bluetooth" });

                // Crear un cliente
                Cliente cliente = new Cliente(
                                1, "Maria Lopez", "123 Calle Principal, Ciudad Ejemplo", "555-1234",
                                "usuario123@ejempo.com");

                // Crear un transportista
                Transportista transportista = new Transportista(
                                123, "Juan Perez", "555-9876");

                // Imprimir información del vehículo
                System.out.println("Vehículo:");
                System.out.println("Marca: " + vehiculo.getMarca());
                System.out.println("Modelo: " + vehiculo.getModelo());
                System.out.println("Año: " + vehiculo.getAnio());
                System.out.println("Precio: $" + vehiculo.getPrecio());
                System.out.println("Estado: " + vehiculo.getEstadoVehiculo());
                System.out.println("Tipo: " + vehiculo.getTipoVehiculo());

                // Imprimir información del cliente
                System.out.println("\nCliente:");
                System.out.println("Nombre: " + cliente.getNombre());
                System.out.println("Dirección: " + cliente.getDireccion());
                System.out.println("Teléfono: " + cliente.getTelefono());

                // Asignar el vehículo para ser transportado a la dirección del cliente
                System.out.println("\nAsignando transporte...");
                transportista.asignarEntrega(vehiculo, cliente.getDireccion());

                // Simular compra
                System.out.println("\nProcesando compra...");
                Compra resultadoCompra = cliente.comprarVehiculo(vehiculo);
                System.out.println("Compra realizada con la siguiente información:");
                System.out.println(resultadoCompra);
        }
}
