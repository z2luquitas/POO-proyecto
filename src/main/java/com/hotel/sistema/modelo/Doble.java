package com.hotel.sistema.modelo;

public class Doble extends Habitacion {

    public Doble(String numero, double precioPorNoche, String descripcion) {
        // Pasamos capacidad fija de 2 y tipo "Doble"
        super(numero, precioPorNoche, 2, "Doble", descripcion);
    }

    @Override
    public double calcularPrecioReal() {
        // Ejemplo: La doble podría tener un costo extra fijo o porcentual si se desea
        // Por ahora retornamos el precio base
        return this.precioPorNoche;
    }
}