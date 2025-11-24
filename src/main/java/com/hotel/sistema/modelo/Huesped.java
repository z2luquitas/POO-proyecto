package com.hotel.sistema.modelo;

public class Huesped {

    // Atributos (Datos de contacto requeridos en el PDF)
    private String dni;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String correo;

    // Constructor
    public Huesped(String dni, String nombres, String apellidos, String telefono, String correo) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
    }

    // Getters
    public String getDni() { return dni; }
    public String getNombres() { return nombres; }
    public String getApellidos() { return apellidos; }
    
    // Método para mostrar información rápida
    @Override
    public String toString() {
        return nombres + " " + apellidos + " (DNI: " + dni + ")";
    }
}