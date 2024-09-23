package com.roberts.gestionvehiculos.models;

import java.util.Date;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Envio {
    private int id;
    private Date fechaEnvio;
    private Date fechaEntrega;
    private String remitente;
    private String receptor;
    private String transportista;
    private String marcaVehiculo;
    private String modeloVehiculo;
    private String estadoVehiculo;

    // Getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public String getTransportista() {
        return transportista;
    }

    public void setTransportista(String transportista) {
        this.transportista = transportista;
    }

    public String getMarcaVehiculo() {
        return marcaVehiculo;
    }

    public void setMarcaVehiculo(String marcaVehiculo) {
        this.marcaVehiculo = marcaVehiculo;
    }

    public String getModeloVehiculo() {
        return modeloVehiculo;
    }

    public void setModeloVehiculo(String modeloVehiculo) {
        this.modeloVehiculo = modeloVehiculo;
    }

    public String getEstadoVehiculo() {
        return estadoVehiculo;
    }

    public void setEstadoVehiculo(String estadoVehiculo) {
        this.estadoVehiculo = estadoVehiculo;
    }

    // Metodos estaticos
    public String obtenerTrazabilidadPorFactura(Connection connection, int idFactura) throws SQLException {
        String trazabilidad = "";

        // Consulta SQL para obtener la trazabilidad basada en el ID de la factura
        String sql = "SELECT envio.id, envio.fecha_envio, envio.fecha_entrega, "
                + "remitente.nombre AS remitente, receptor.nombre AS receptor, "
                + "transportista.nombre AS transportista, vehiculo.marca, "
                + "vehiculo.modelo, vehiculo.estado "
                + "FROM Envio "
                + "JOIN Cliente AS remitente ON envio.remitente_id = remitente.id "
                + "JOIN Cliente AS receptor ON envio.receptor_id = receptor.id "
                + "JOIN Transportista ON envio.transportista_id = Transportista.id "
                + "JOIN Vehiculo ON envio.vehiculo_id = Vehiculo.id "
                + "JOIN Factura ON envio.factura_id = Factura.id " // Relacion con Factura
                + "WHERE Factura.id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idFactura);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Crear el string de trazabilidad con la información obtenida
                    trazabilidad = "ID de Envío: " + rs.getInt("id") + "\n"
                            + "Fecha de Envío: " + rs.getString("fecha_envio") + "\n"
                            + "Fecha de Entrega: " + rs.getString("fecha_entrega") + "\n"
                            + "Remitente: " + rs.getString("remitente") + "\n"
                            + "Receptor: " + rs.getString("receptor") + "\n"
                            + "Transportista: " + rs.getString("transportista") + "\n"
                            + "Vehículo: " + rs.getString("marca") + " " + rs.getString("modelo") + "\n"
                            + "Estado del Vehículo: " + rs.getString("estado");
                } else {
                    trazabilidad = "No se encontró un envío asociado con la factura con ID: " + idFactura;
                }
            }
        }

        return trazabilidad; // Retorna el string de trazabilidad
    }

}
