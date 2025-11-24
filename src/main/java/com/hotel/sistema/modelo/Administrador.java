package com.hotel.sistema.modelo;

import java.util.ArrayList;

public class Administrador extends Empleado {

    // Constructor: Fija el rol automáticamente
    public Administrador(String dni, String nombres, String apellidos, String usuario, String password) {
        super(dni, nombres, apellidos, usuario, password, "ADMINISTRADOR");
    }

    // --- GESTIÓN DE HABITACIONES ---
    // Recibe la lista del sistema y agrega una nueva habitación (Polimorfismo)
    public void agregarHabitacion(ArrayList<Habitacion> inventario, Habitacion nuevaHab) {
        // Validar si ya existe
        for(Habitacion h : inventario) {
            if(h.getNumero().equals(nuevaHab.getNumero())) {
                System.out.println("Error: La habitación " + nuevaHab.getNumero() + " ya existe.");
                return;
            }
        }
        inventario.add(nuevaHab);
        System.out.println("Habitación agregada con éxito.");
    }

    // --- GESTIÓN DE SERVICIOS ---
    public void agregarServicio(ArrayList<ServicioAdicional> servicios, ServicioAdicional nuevoServicio) {
        servicios.add(nuevoServicio);
        System.out.println("Servicio " + nuevoServicio.getNombre() + " registrado.");
    }
    
    // --- GESTIÓN DE EMPLEADOS ---
    public void registrarEmpleado(ArrayList<Empleado> personal, Empleado nuevoEmp) {
        personal.add(nuevoEmp);
    }
}