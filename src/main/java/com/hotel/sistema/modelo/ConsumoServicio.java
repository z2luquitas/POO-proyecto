package com.hotel.sistema.modelo;

import java.time.LocalDate;

public class ConsumoServicio {

    // Atributos
    private ServicioAdicional servicio; // El objeto del producto
    private int cantidad;
    private LocalDate fechaConsumo;

    // Constructor
    public ConsumoServicio(ServicioAdicional servicio, int cantidad) {
        this.servicio = servicio;
        this.cantidad = cantidad;
        this.fechaConsumo = LocalDate.now(); // Toma la fecha actual del sistema
    }

    // Método de negocio: Calcular Subtotal
    public double calcularSubtotal() {
        return this.servicio.getPrecio() * this.cantidad;
    }
    
    // Getters
    public ServicioAdicional getServicio() { return servicio; }
    public int getCantidad() { return cantidad; }
    public LocalDate getFechaConsumo() { return fechaConsumo; }
}