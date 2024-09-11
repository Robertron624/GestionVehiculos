package models;

public class Transportista {
    private String id;            // Identificador único del transportista
    private String nombre;        // Nombre del transportista
    private String telefono;      // Teléfono de contacto

    // Constructor
    public Transportista(String id, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    //asignar una entrega a un transportista
    public void asignarEntrega(Vehiculo vehiculo, String direccionEntrega) {
        System.out.println("El transportista " + this.nombre + " ha sido asignado para transportar el vehículo: ");
        System.out.println("Marca: " + vehiculo.getMarca() + ", Modelo: " + vehiculo.getModelo());
        System.out.println("A la dirección: " + direccionEntrega);
    }
}
