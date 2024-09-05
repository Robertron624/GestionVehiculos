package models;

import java.util.Date;
import java.util.Optional;

public class Compra {


    public enum EstadoCompra {
        PENDIENTE, COMPLETADA, CANCELADA
    }

    private int id;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private float montoTotal;
    private Date fechaCompra;
    private EstadoCompra estadoCompra;

    public Compra(int id, Cliente cliente, Vehiculo vehiculo, float montoTotal, Date fechaCompra) {
        this.id = id;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.montoTotal = montoTotal;
        this.fechaCompra = fechaCompra;
        this.estadoCompra = EstadoCompra.PENDIENTE;
    }

    // Getters
    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public float getMonto() {
        return montoTotal;
    }

    public Date getFecha() {
        return fechaCompra;
    }

    public EstadoCompra getEstadoCompra() {
        return estadoCompra;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setMonto(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    public void setFecha(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public void setEstadoCompra(EstadoCompra estadoCompra) {
        this.estadoCompra = estadoCompra;
    }

    // Metodos de la clase
    public void procesarCompra() {
        // Lógica para procesar la compra
        System.out.println("Procesando la compra del vehículo " + vehiculo.getModelo() + " por el cliente " + cliente.getNombre() + " por un monto de $" + montoTotal + ".");
    }

    //Puede haber un error al generar la factura, por lo que se retorna un Optional
    public Optional<Factura> generarFactura() {

        Factura factura = new Factura(1, this.cliente, this.vehiculo, this.fechaCompra, this.montoTotal);

        boolean facturaGenerada = factura.generarFactura();

        if (facturaGenerada) {
            return Optional.of(factura);
        } else {
            return Optional.empty();
        }
    }
}
