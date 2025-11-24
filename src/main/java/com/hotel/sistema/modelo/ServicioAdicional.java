package com.hotel.sistema.modelo;

public class ServicioAdicional {

    // Atributos según tu lista
    private String idServicio;
    private String nombre;
    private String tipoServicio; // Ej: "Alimentos", "Bebidas", "Spa"
    private double precio;
    private String descripcion;

    // Constructor
    public ServicioAdicional(String idServicio, String nombre, String tipoServicio, double precio, String descripcion) {
        this.idServicio = idServicio;
        this.nombre = nombre;
        this.tipoServicio = tipoServicio;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    // Método solicitado
    public String mostrarDatos() {
        return nombre + " (" + tipoServicio + ") - Precio: S/." + precio;
    }

    // Getters
    public String getIdServicio() { return idServicio; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public String getTipoServicio() { return tipoServicio; }
    
    @Override
    public String toString() {
        return mostrarDatos(); // Para que se vea bonito en las listas de NetBeans
    }
}