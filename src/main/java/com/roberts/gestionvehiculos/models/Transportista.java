package com.roberts.gestionvehiculos.models;

public class Transportista {
    private int id;
    private String nombre;
    private String telefono;

    // Constructor
    public Transportista(int id, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // asignar una entrega a un transportista
    public void asignarEntrega(Vehiculo vehiculo, String direccionEntrega) {
        System.out.println("El transportista " + this.nombre + " ha sido asignado para transportar el vehículo: ");
        System.out.println("Marca: " + vehiculo.getMarca() + ", Modelo: " + vehiculo.getModelo());
        System.out.println("A la dirección: " + direccionEntrega);
    }
}
