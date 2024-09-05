import models.Vehiculo;
import models.Cliente;

public class Main {

    public static void main(String[] args) {
        System.out.println("Bienvenido a la concesionaria de vehículos");

        Vehiculo vehiculo1 = new Vehiculo(1, "Toyota", "Corolla", 2020, Vehiculo.TipoVehiculo.LIGERO, Vehiculo.EstadoVehiculo.NUEVO, 20000, 10000, new String[]{"Aire acondicionado", "GPS"});
        Vehiculo vehiculo2 = new Vehiculo(2, "Honda", "Civic", 2019, Vehiculo.TipoVehiculo.LIGERO, Vehiculo.EstadoVehiculo.USADO, 18000, 15000, new String[]{"Asientos de cuero", "Bluetooth"});

        String comparacion = vehiculo1.compararCon(vehiculo2);
        System.out.println(comparacion);
    }
}