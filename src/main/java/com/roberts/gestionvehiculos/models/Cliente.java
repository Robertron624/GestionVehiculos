package com.roberts.gestionvehiculos.models;

import java.util.Date;

public class Cliente {
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

    void registrarse() {
        System.out.println("Registrando al cliente " + this.nombre);
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
