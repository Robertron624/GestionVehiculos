package com.roberts.gestionvehiculos.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Cliente {

    // Metodos estaticos para interactuar con la base de datos

    public static List<Cliente> obtenerClientes(Connection connection) {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Cliente cliente = new Cliente(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("direccion"),
                        resultSet.getString("telefono"),
                        resultSet.getString("email"));
                clientes.add(cliente);
            }

            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al obtener los clientes: " + e.getMessage());
        }

        return clientes;
    }

    public static Cliente obtenerClientePorId(Connection connection, int id) {
        Cliente cliente = null;
        String sql = "SELECT * FROM Cliente WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                cliente = new Cliente(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("direccion"),
                        resultSet.getString("telefono"),
                        resultSet.getString("email"));
            }

            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al obtener el cliente: " + e.getMessage());
        }

        return cliente;
    }

    public List<String> consultarFacturas(Connection connection) throws SQLException {
        List<String> facturas = new ArrayList<>();

        // Consulta SQL para obtener las facturas asociadas al cliente
        String sql = "SELECT Factura.id, Factura.fecha, Factura.monto_total "
                + "FROM Factura "
                + "JOIN Envio ON Factura.envio_id = Envio.id "
                + "WHERE Envio.remitente_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, this.id); // El cliente actual (remitente)
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    // Crear un string con la información de cada factura
                    String facturaInfo = "ID de Factura: " + rs.getInt("id") + "\n"
                            + "Fecha: " + rs.getString("fecha") + "\n"
                            + "Monto Total: " + rs.getDouble("monto_total");
                    facturas.add(facturaInfo);
                }
            }
        }

        if (facturas.isEmpty()) {
            facturas.add("No se encontraron facturas para el cliente: " + this.nombre);
        }

        return facturas; // Devuelve una lista de strings con la información de las facturas
    }

    // Atributos
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;

    // Constructor
    public Cliente(int id, String nombre, String direccion, String telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Métodos de la clase

    void crearUsuario(Connection connection) {
        System.out.println("Creando usuario para el cliente " + this.nombre);

        String sql = "INSERT INTO Cliente (nombre, direccion, telefono, email) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, this.nombre);
            statement.setString(2, this.direccion);
            statement.setString(3, this.telefono);
            statement.setString(4, this.email);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al crear el usuario: " + e.getMessage());
        }
    }

    void actualizarUsuario(Connection connection) {
        System.out.println("Actualizando usuario para el cliente " + this.nombre);

        String sql = "UPDATE Cliente SET nombre = ?, direccion = ?, telefono = ?, email = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, this.nombre);
            statement.setString(2, this.direccion);
            statement.setString(3, this.telefono);
            statement.setString(4, this.email);
            statement.setInt(5, this.id);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al actualizar el usuario: " + e.getMessage());
        }
    }

    void eliminarUsuario(Connection connection) {
        System.out.println("Eliminando usuario para el cliente " + this.nombre);

        String sql = "DELETE FROM Cliente WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, this.id);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al eliminar el usuario: " + e.getMessage());
        }
    }

    void iniciarSesion() {
        System.out.println("Iniciando sesión para el cliente " + this.nombre);
    }

    void solicitarCotizacion() {
        System.out.println("Solicitando cotización para el cliente " + this.nombre);
    }

    // Métodos de la clase
    public Compra comprarVehiculo(Vehiculo vehiculo) {
        System.out.println("Comprando vehículo para el cliente " + this.nombre);

        // Crear una nueva compra
        Compra compra = new Compra(1, this, vehiculo, vehiculo.getPrecio(), new Date());

        // Procesar la compra
        compra.procesarCompra();

        return compra;
    }

    Compra consultarCompra(Compra compra) {
        System.out.println("Consultando compra para el cliente " + this.nombre);
        return compra;
    }

    String compararVehiculos(Vehiculo vehiculo1, Vehiculo vehiculo2) {
        System.out.println("Comparando vehículos para el cliente " + this.nombre);
        return vehiculo1.compararCon(vehiculo2);
    }

    // reemplazar toString
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' + '}';
    }

}
