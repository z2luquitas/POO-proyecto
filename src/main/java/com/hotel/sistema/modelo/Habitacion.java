package com.hotel.sistema.modelo;

public abstract class Habitacion {


    protected String numero;
    protected int capacidadMaxima;
    protected double precioPorNoche;
    protected String tipo;           
    protected String estadoHabitacion;
    protected String descripcion;     

 
    public Habitacion (String numero, double precioPorNoche, int capacidadMaxima, String tipo, String descripcion) {
        this.numero = numero;
        this.precioPorNoche = precioPorNoche;
        this.capacidadMaxima = capacidadMaxima;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.estadoHabitacion = "DISPONIBLE"; 
    }
 
    public void marcarOcupada() {
        this.estadoHabitacion = "OCUPADA";
    }

    public void marcarLibre() {
        this.estadoHabitacion = "DISPONIBLE"; 
       
    }
    
    public String mostrarDatos() {
        return "Hab: " + numero + " (" + tipo + ") - Estado: " + estadoHabitacion + " - Precio: S/." + precioPorNoche;
    }


    public abstract double calcularPrecioReal(); 

    public String getNumero() { return numero; }
    public String getEstadoHabitacion() { return estadoHabitacion; }
    public double getPrecioPorNoche() { return precioPorNoche; }
    public int getCapacidadMaxima() { return capacidadMaxima; }
    public String getTipo() { return tipo; }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }
}