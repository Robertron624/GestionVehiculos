package com.roberts.gestionvehiculos.models;

import java.util.Date;

public class Factura {

    private int idCompra;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private Date fechaEmision;
    private float montoTotal;
    private boolean generada;

    public Factura(int idCompra, Cliente cliente, Vehiculo vehiculo, Date fechaEmision, float montoTotal) {
        this.idCompra = idCompra;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fechaEmision = fechaEmision;
        this.montoTotal = montoTotal;
        this.generada = false; // Por defecto, la factura no está generada
    }

    // Getters
    public int getIdCompra() {
        return idCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Date getFecha() {
        return fechaEmision;
    }

    public float getTotal() {
        return montoTotal;
    }

    // Setters
    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setFecha(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public void setTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    // Métodos de la clase
    public void imprimirFactura() {
        System.out.println("Factura para la compra:");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Vehículo: " + vehiculo.getMarca() + " " + vehiculo.getModelo());
        System.out.println("Fecha de compra: " + fechaEmision);
        System.out.println("Total: $" + montoTotal);
    }

    public boolean generarFactura() {
        if (cliente != null && vehiculo != null && montoTotal > 0) {
            this.generada = true;
            System.out.println("Factura generada exitosamente.");
            return true;
        } else {
            System.out.println("Error: Datos incompletos o inválidos. La factura no puede generarse.");
            return false;
        }
    }

    boolean ordenEstaGenerada() {
        return generada;
    }
}
