package com.roberts.gestionvehiculos;

import com.roberts.gestionvehiculos.database.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
        public static void main(String[] args) {
                Connection connection = DatabaseConnection.getConnection();

                if (connection != null) {
                        System.out.println("Conexión a la base de datos establecida en clase Main.");
                        try {
                                Statement statement = connection.createStatement();

                                // Ejemplo para traer todos los vehículos
                                String sqlVehiculo = "SELECT * FROM Vehiculo";
                                ResultSet resultSetVehiculo = statement.executeQuery(sqlVehiculo);

                                System.out.println("=========================================");
                                System.out.println("Vehículos:");

                                while (resultSetVehiculo.next()) {
                                        System.out.println("ID: " + resultSetVehiculo.getInt("id"));
                                        System.out.println("Marca: " + resultSetVehiculo.getString("marca"));
                                        System.out.println("Modelo: " + resultSetVehiculo.getString("modelo"));
                                        System.out.println("Año: " + resultSetVehiculo.getInt("anio"));
                                        System.out.println("Precio: " + resultSetVehiculo.getDouble("precio"));
                                        System.out.println("Estado: " + resultSetVehiculo.getString("estadoVehiculo"));
                                        System.out.println("Tipo: " + resultSetVehiculo.getString("tipoVehiculo"));
                                        System.out.println(
                                                        "Kilometraje: " + resultSetVehiculo.getString("kilometraje"));
                                        System.out.println();
                                }

                                resultSetVehiculo.close();

                                // Ejemplo para traer todos los clientes
                                String sqlCliente = "SELECT * FROM Cliente";
                                ResultSet resultSetCliente = statement.executeQuery(sqlCliente);

                                System.out.println("=========================================");
                                System.out.println("Clientes:");
                                while (resultSetCliente.next()) {
                                        System.out.println("ID: " + resultSetCliente.getInt("id"));
                                        System.out.println("Nombre: " + resultSetCliente.getString("nombre"));
                                        System.out.println("Dirección: " + resultSetCliente.getString("direccion"));
                                        System.out.println("Teléfono: " + resultSetCliente.getString("telefono"));
                                        System.out.println("Email: " + resultSetCliente.getString("email"));
                                        System.out.println();
                                }

                                resultSetCliente.close();

                                statement.close();
                                connection.close();
                        } catch (Exception e) {
                                e.printStackTrace();
                                System.err.println("Error al ejecutar la consulta: " + e.getMessage());
                        }
                } else {
                        System.err.println("Conexión a la base de datos no establecida.");
                }
        }
}