package com.hotel.sistema.modelo;

public class Simple extends Habitacion {

    public Simple(String numero, double precioPorNoche, String descripcion) {
        // Pasamos capacidad fija de 1 y tipo "Simple"
        super(numero, precioPorNoche, 1, "Simple", descripcion);
    }

    @Override
    public double calcularPrecioReal() {
        // La simple cobra el precio base sin recargos
        return this.precioPorNoche;
    }
}