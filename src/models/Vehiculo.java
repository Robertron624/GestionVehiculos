package models;

public class Vehiculo {


    public enum TipoVehiculo {
        LIGERO, PESADO, ESPECIAL, AGRICOLA, OTRO
    }

    public enum EstadoVehiculo {
        NUEVO, USADO
    }

    private int id;
    private String marca;
    private String modelo;
    private int anio;
    private TipoVehiculo tipoVeiculo; // Se usará un enum en el futuro
    private EstadoVehiculo estadoVehiculo; // Se usará un enum en el futuro
    private float precio;
    private int kilometraje;
    private String[] caracteristicas;

    public Vehiculo(int id, String marca, String modelo, int anio, TipoVehiculo tipoVeiculo, EstadoVehiculo estadoVehiculo, float precio, int kilometraje, String[] caracteristicas) {
        this.id = id;
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


    // Metodos
    public void crearVehiculo() {
        // Lógica para crear un vehículo
    }

    public void actualizarVehiculo() {
        // Lógica para actualizar un vehículo
    }

    public void eliminarVehiculo() {
        // Lógica para eliminar un vehículo
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
