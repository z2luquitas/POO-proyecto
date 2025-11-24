package com.hotel.sistema.modelo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva {

    // Atributos según tu lista
    private String idReserva;
    private Huesped huesped;
    private Habitacion habitacion; // El objeto habitación asignado
    private LocalDate fechaInicio; // Check-in programado
    private LocalDate fechaFin;    // Check-out programado
    private double precioTotalHabitacion;
    private String estadoReserva;  // "PENDIENTE", "CONFIRMADA", "CANCELADA"

    // Constructor
    public Reserva(String idReserva, Huesped huesped, Habitacion habitacion, LocalDate fechaInicio, LocalDate fechaFin) {
        this.idReserva = idReserva;
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estadoReserva = "PENDIENTE";
        
        // Calculamos el precio automáticamente al crear la reserva
        this.calcularPrecio();
    }

    // --- MÉTODOS DE NEGOCIO ---

    public void calcularPrecio() {
        // 1. Calcular cuántas noches hay entre fechaInicio y fechaFin
        long dias = ChronoUnit.DAYS.between(fechaInicio, fechaFin);
        
        // Validación por si ponen la misma fecha (mínimo 1 noche)
        if (dias < 1) dias = 1; 

        // 2. Obtener el precio real de la habitación (USANDO POLIMORFISMO)
        double precioNoche = habitacion.calcularPrecioReal();

        // 3. Guardar el total
        this.precioTotalHabitacion = dias * precioNoche;
    }

    public boolean esActiva() {
        return "CONFIRMADA".equals(this.estadoReserva);
    }

    // --- GETTERS Y SETTERS ---
    
    public String getIdReserva() { return idReserva; }
    public Huesped getHuesped() { return huesped; }
    public Habitacion getHabitacion() { return habitacion; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }
    public double getPrecioTotalHabitacion() { return precioTotalHabitacion; }
    public String getEstadoReserva() { return estadoReserva; }

    public void setEstadoReserva(String estadoReserva) {
        this.estadoReserva = estadoReserva;
    }
    
    // ToString para mostrar resumen rápido
    @Override
    public String toString() {
        return "Reserva: " + idReserva + " - Cliente: " + huesped.getNombres();
    }
}