package com.roberts.gestionvehiculos.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Vehiculo {

    // Metodos estaticos para interactuar con la base de datos

    public static List<Vehiculo> obtenerVehiculos(Connection connection) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        String sql = "SELECT * FROM Vehiculo";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                String caracteristicasString = resultSet.getString("caracteristicas");
                String[] caracteristicas = caracteristicasString != null ? caracteristicasString.split(",")
                        : new String[0];

                Vehiculo vehiculo = new Vehiculo(
                        resultSet.getString("marca"),
                        resultSet.getString("modelo"),
                        resultSet.getInt("anio"),
                        TipoVehiculo.valueOf(resultSet.getString("tipoVehiculo")),
                        EstadoVehiculo.valueOf(resultSet.getString("estadoVehiculo")),
                        resultSet.getFloat("precio"),
                        resultSet.getInt("kilometraje"),
                        caracteristicas);
                vehiculo.setId(resultSet.getInt("id"));
                vehiculos.add(vehiculo);
            }

            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al obtener los vehículos: " + e.getMessage());
        }

        return vehiculos;
    }

    public static Vehiculo obtenerVehiculoPorId(Connection connection, int id) {
        Vehiculo vehiculo = null;
        String sql = "SELECT * FROM Vehiculo WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                String caracteristicasString = resultSet.getString("caracteristicas");
                String[] caracteristicas = caracteristicasString != null ? caracteristicasString.split(",")
                        : new String[0];

                vehiculo = new Vehiculo(
                        resultSet.getString("marca"),
                        resultSet.getString("modelo"),
                        resultSet.getInt("anio"),
                        TipoVehiculo.valueOf(resultSet.getString("tipoVehiculo")),
                        EstadoVehiculo.valueOf(resultSet.getString("estadoVehiculo")),
                        resultSet.getFloat("precio"),
                        resultSet.getInt("kilometraje"),
                        caracteristicas);
                vehiculo.setId(resultSet.getInt("id"));
            }

            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al obtener el vehículo: " + e.getMessage());
        }

        return vehiculo;
    }

    public static List<Vehiculo> filtrarHastaAnio(Connection connection, int anio) throws SQLException {
        List<Vehiculo> vehiculos = new ArrayList<>();
        String sql = "SELECT id, marca, modelo, anio, estado FROM Vehiculo WHERE anio <= ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, anio);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {

                    String caracteristicasString = rs.getString("caracteristicas");
                    String[] caracteristicas = caracteristicasString != null ? caracteristicasString.split(",")
                            : new String[0];

                    Vehiculo vehiculo = new Vehiculo(
                            rs.getString("marca"),
                            rs.getString("modelo"),
                            rs.getInt("anio"),
                            TipoVehiculo.valueOf(rs.getString("tipo_vehiculo").toUpperCase()), // Convertir string a
                                                                                               // TipoVehiculo
                            EstadoVehiculo.valueOf(rs.getString("estado_vehiculo").toUpperCase()), // Convertir string a
                                                                                                   // EstadoVehiculo
                            rs.getFloat("precio"),
                            rs.getInt("kilometraje"),
                            caracteristicas);
                    vehiculos.add(vehiculo);
                }
            }
        }

        return vehiculos;
    }

    // Método estático para obtener vehículos desde un año específico (incluyendo
    // ese año y hacia arriba)
    public static List<Vehiculo> filtrarDesdeAnio(Connection connection, int anio) throws SQLException {
        List<Vehiculo> vehiculos = new ArrayList<>();
        String sql = "SELECT id, marca, modelo, anio, estado FROM Vehiculo WHERE anio >= ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, anio);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {

                    String caracteristicasString = rs.getString("caracteristicas");
                    String[] caracteristicas = caracteristicasString != null ? caracteristicasString.split(",")
                            : new String[0];

                    Vehiculo vehiculo = new Vehiculo(
                            rs.getString("marca"),
                            rs.getString("modelo"),
                            rs.getInt("anio"),
                            TipoVehiculo.valueOf(rs.getString("tipo_vehiculo").toUpperCase()), // Convertir string a
                                                                                               // TipoVehiculo
                            EstadoVehiculo.valueOf(rs.getString("estado_vehiculo").toUpperCase()), // Convertir string a
                                                                                                   // EstadoVehiculo
                            rs.getFloat("precio"),
                            rs.getInt("kilometraje"),
                            caracteristicas);
                    vehiculos.add(vehiculo);
                }
            }
        }

        return vehiculos;
    }

    // Definición de enumeraciones
    public enum TipoVehiculo {
        LIGERO, PESADO, ESPECIAL, AGRICOLA, OTRO
    }

    public enum EstadoVehiculo {
        NUEVO, USADO
    }

    // Atributos
    private int id;
    private String marca;
    private String modelo;
    private int anio;
    private TipoVehiculo tipoVeiculo;
    private EstadoVehiculo estadoVehiculo;
    private float precio;
    private int kilometraje;
    private String[] caracteristicas;

    public Vehiculo(String marca, String modelo, int anio, TipoVehiculo tipoVeiculo,
            EstadoVehiculo estadoVehiculo, float precio, int kilometraje, String[] caracteristicas) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.tipoVeiculo = tipoVeiculo;
        this.estadoVehiculo = estadoVehiculo;
        this.precio = precio;
        this.kilometraje = kilometraje;
        this.caracteristicas = caracteristicas;
    }

    // Getters
    public Integer getId() {
        return this.id;
    }

    public String getMarca() {
        return this.marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public int getAnio() {
        return this.anio;
    }

    public TipoVehiculo getTipoVehiculo() {
        return this.tipoVeiculo;
    }

    public EstadoVehiculo getEstadoVehiculo() {
        return this.estadoVehiculo;
    }

    public float getPrecio() {
        return this.precio;
    }

    public int getKilometraje() {
        return this.kilometraje;
    }

    public String[] getCaracteristicas() {
        return this.caracteristicas;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVeiculo = tipoVehiculo;
    }

    public void setEstadoVehiculo(EstadoVehiculo estadoVehiculo) {
        this.estadoVehiculo = estadoVehiculo;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    public void setCaracteristicas(String[] caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    // Metodos que interactuan con la base de datos
    public void crearVehiculo(Connection connection) {
        String sql = "INSERT INTO Vehiculo (marca, modelo, anio, tipoVehiculo, estadoVehiculo, precio, kilometraje, caracteristicas) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, this.marca);
            statement.setString(2, this.modelo);
            statement.setInt(3, this.anio);
            statement.setString(4, this.tipoVeiculo.name());
            statement.setString(5, this.estadoVehiculo.name());
            statement.setFloat(6, this.precio);
            statement.setInt(7, this.kilometraje);

            // Convertir el array de características a un string
            String caracteristicasString = String.join(",", this.caracteristicas);

            statement.setString(8, caracteristicasString);

            // Ejecutar la inserción
            int rowsInserted = statement.executeUpdate();

            // Obtener el id generado automáticamente
            if (rowsInserted > 0) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        this.id = generatedKeys.getInt(1); // Asignar el id generado al objeto
                    }
                }
            }

            System.out.println("Vehículo creado con ID: " + this.id);

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al crear el vehículo: " + e.getMessage());
        }
    }

    public void actualizarVehiculo(Connection connection) {
        String sql = "UPDATE Vehiculo SET marca = ?, modelo = ?, anio = ?, tipoVehiculo = ?, estadoVehiculo = ?, precio = ?, kilometraje = ?, caracteristicas = ?, WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, this.marca);
            statement.setString(2, this.modelo);
            statement.setInt(3, this.anio);
            statement.setString(4, this.tipoVeiculo.name());
            statement.setString(5, this.estadoVehiculo.name());
            statement.setFloat(6, this.precio);
            statement.setInt(7, this.kilometraje);

            // Convertir el array de características a un string
            String caracteristicasString = String.join(",", this.caracteristicas);

            statement.setString(8, caracteristicasString);

            statement.setInt(9, this.id); // Usamos el id para identificar el vehículo a actualizar

            // Ejecutar la actualización
            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Vehículo actualizado con ID: " + this.id);
            } else {
                System.out.println("No se encontró el vehículo con ID: " + this.id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al actualizar el vehículo: " + e.getMessage());
        }
    }

    public void eliminarVehiculo(Connection connection) {
        String sql = "DELETE FROM Vehiculo WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, this.id); // Usamos el id para identificar el vehículo a eliminar

            // Ejecutar la eliminación
            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Vehículo con ID " + this.id + " eliminado correctamente.");
            } else {
                System.out.println("No se encontró un vehículo con ID " + this.id + " para eliminar.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al eliminar el vehículo: " + e.getMessage());
        }
    }

    public String compararCon(Vehiculo otroVehiculo) {
        String resultado;

        if (this.precio > otroVehiculo.getPrecio()) {
            resultado = "El vehículo " + this.modelo + " es más caro que " + otroVehiculo.getModelo();
        } else if (this.precio < otroVehiculo.getPrecio()) {
            resultado = "El vehículo " + this.modelo + " es más barato que " + otroVehiculo.getModelo();
        } else {
            resultado = "Ambos vehículos tienen el mismo precio";
        }

        return resultado;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anio=" + anio +
                ", tipoVeiculo=" + tipoVeiculo +
                ", estadoVehiculo=" + estadoVehiculo +
                ", precio=" + precio +
                ", kilometraje=" + kilometraje +
                ", caracteristicas=" + caracteristicas +
                '}';
    }
}
