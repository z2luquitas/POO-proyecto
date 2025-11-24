package com.hotel.sistema.modelo;

public class Suite extends Habitacion {

    private  boolean tieneJacuzzi;

    public Suite(String numero, double precioPorNoche, String descripcion, boolean tieneJacuzzi) {
        // Capacidad 4, Tipo "Suite"
        super(numero, precioPorNoche, 4, "Suite", descripcion);
        this.tieneJacuzzi = tieneJacuzzi;
    }

    @Override
    public double calcularPrecioReal() {
        // POLIMORFISMO: La Suite cobra 20% más del precio base
        return this.precioPorNoche * 1.20;
    }
    
    public boolean isTieneJacuzzi() {
        return tieneJacuzzi;
    }
    
    @Override
    public String mostrarDatos() {
        return super.mostrarDatos() + (tieneJacuzzi ? " [Con Jacuzzi]" : " [Sin Jacuzzi]");
    }
}