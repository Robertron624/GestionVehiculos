package com.roberts.gestionvehiculos;

import com.roberts.gestionvehiculos.database.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.roberts.gestionvehiculos.models.Vehiculo;
import com.roberts.gestionvehiculos.models.Cliente;

public class Main {
        public static void main(String[] args) {
                Connection connection = DatabaseConnection.getConnection();

                if (connection != null) {
                        try {
                                List<Vehiculo> vehiculos = Vehiculo.obtenerVehiculos(connection);

                                System.out.println("Vehículos:");

                                for (Vehiculo vehiculo : vehiculos) {
                                        System.out.println(vehiculo);
                                }

                                System.out.println("============================\n");

                                System.out.println("Vehículo con id 1:");

                                Vehiculo vehiculo = Vehiculo.obtenerVehiculoPorId(connection, 1);

                                System.out.println(vehiculo);

                                System.out.println("============================\n");

                                System.out.println("Clientes:");

                                List<Cliente> clientes = Cliente.obtenerClientes(connection);

                                for (Cliente cliente : clientes) {
                                        System.out.println(cliente);
                                }

                                System.out.println("============================\n");

                                System.out.println("Cliente con id 1:");

                                Cliente cliente = Cliente.obtenerClientePorId(connection, 1);

                                System.out.println(cliente);

                                connection.close();

                                // Finalizamos la ejecución
                                System.out.println("Finalizando la ejecución...");
                                System.exit(0);
                        } catch (Exception e) {
                                e.printStackTrace();
                                System.err.println("Error al ejecutar la consulta: " + e.getMessage());
                        }
                } else {
                        System.err.println("Conexión a la base de datos no establecida.");
                }
        }
}