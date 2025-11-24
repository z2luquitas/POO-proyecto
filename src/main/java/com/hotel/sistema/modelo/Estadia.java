package com.hotel.sistema.modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Estadia {

    // Atributos según tu lista
    private Reserva reserva; // Enlace a la reserva original
    private ArrayList<ConsumoServicio> listaConsumos; // Lista dinámica de gastos
    private double totalFinal;
    private LocalDate fechaCheckIn;  // Fecha real de entrada
    private LocalDate fechaCheckOut; // Fecha real de salida
    private String estadoEstadia;    // "ACTIVA", "FINALIZADA"

    // Constructor (Se crea al momento del Check-in)
    public Estadia(Reserva reserva) {
        this.reserva = reserva;
        this.listaConsumos = new ArrayList<>(); // Inicializamos la lista vacía
        this.fechaCheckIn = LocalDate.now();    // La fecha es HOY
        this.estadoEstadia = "ACTIVA";
        this.totalFinal = 0.0;
    }

    // --- MÉTODOS DE NEGOCIO ---

    /**
     * Registra un nuevo consumo (Ej. una Coca Cola)
     */
    public void registrarConsumo(ServicioAdicional servicio, int cantidad) {
        ConsumoServicio nuevoConsumo = new ConsumoServicio(servicio, cantidad);
        this.listaConsumos.add(nuevoConsumo);
    }

    /**
     * Calcula la cuenta final (Cierre de caja / Check-out)
     */
    public void calcularTotalFinal() {
        // 1. Empezamos con el costo del alojamiento (ya calculado en Reserva)
        double subtotalHabitacion = reserva.getPrecioTotalHabitacion();
        
        // 2. Sumamos todos los consumos extra
        double subtotalServicios = 0;
        for (ConsumoServicio consumo : listaConsumos) {
            subtotalServicios += consumo.calcularSubtotal();
        }

        // 3. Guardamos el total
        this.totalFinal = subtotalHabitacion + subtotalServicios;
    }

    /**
     * Cierra la estadía (Check-out)
     */
    public void finalizarEstadia() {
        this.fechaCheckOut = LocalDate.now(); // Marca la salida hoy
        this.estadoEstadia = "FINALIZADA";
        this.calcularTotalFinal(); // Calcula cuánto debe pagar
    }

    // --- GETTERS ---
    
    public Reserva getReserva() { return reserva; }
    public ArrayList<ConsumoServicio> getListaConsumos() { return listaConsumos; }
    public double getTotalFinal() { return totalFinal; }
    public String getEstadoEstadia() { return estadoEstadia; }
    
    // Método para imprimir un resumen rápido de la cuenta
    public String generarDetalle() {
        return "Estadía de: " + reserva.getHuesped().getNombres() + 
               " | Habitación: " + reserva.getHabitacion().getNumero() +
               " | Total a Pagar: S/." + totalFinal;
    }
}