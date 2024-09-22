package com.roberts.gestionvehiculos.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/vehiculos_app";
    private static final String USER = "root";
    private static final String PASSWORD = "12345678";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            System.exit(1);
        }
        return connection;
    }
}