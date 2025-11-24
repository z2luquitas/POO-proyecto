package com.hotel.sistema.controlador;

import com.hotel.sistema.modelo.*; // Importamos todas las clases del modelo
import java.util.ArrayList;

public class SistemaHotel {

    // --- BASE DE DATOS EN MEMORIA (ArrayLists) ---
    private ArrayList<Empleado> listaEmpleados;
    private ArrayList<Habitacion> listaHabitaciones;
    private ArrayList<Huesped> listaHuespedes;
    private ArrayList<ServicioAdicional> listaServicios;
    private ArrayList<Reserva> listaReservas;
    private ArrayList<Estadia> listaEstadias;
    
    // Usuario actualmente logueado (para controlar permisos)
    private Empleado usuarioAutenticado;

    // --- CONSTRUCTOR ---
    public SistemaHotel() {
        // Inicializamos las listas vacías
        this.listaEmpleados = new ArrayList<>();
        this.listaHabitaciones = new ArrayList<>();
        this.listaHuespedes = new ArrayList<>();
        this.listaServicios = new ArrayList<>();
        this.listaReservas = new ArrayList<>();
        this.listaEstadias = new ArrayList<>();
        
        // Cargamos datos de prueba automáticamente
        this.inicializarDatos();
    }

    // --- MÉTODO DE CARGA INICIAL (Para pruebas) ---
    private void inicializarDatos() {
        // 1. Crear un ADMINISTRADOR por defecto (Para poder entrar al sistema)
        // DNI, Nombre, Apellido, User, Pass
        Administrador admin = new Administrador("001", "Admin", "General", "admin", "123");
        listaEmpleados.add(admin);
        
        // 2. Crear un RECEPCIONISTA por defecto
        Recepcionista recep = new Recepcionista("002", "Juan", "Perez", "juan", "123", "Mañana");
        listaEmpleados.add(recep);
        
        // 3. Crear algunas habitaciones
        listaHabitaciones.add(new Simple("101", 50.0, "Simple vista calle"));
        listaHabitaciones.add(new Doble("102", 80.0, "Doble matrimonial"));
        listaHabitaciones.add(new Suite("201", 150.0, "Suite con vista al mar", true)); // Con Jacuzzi
        
        // 4. Crear servicios básicos
        listaServicios.add(new ServicioAdicional("S01", "Coca Cola", "Bebidas", 5.0, "Lata 350ml"));
        listaServicios.add(new ServicioAdicional("S02", "Lavandería", "Servicios", 15.0, "Por kilo"));
    }

    // --- LÓGICA DE AUTENTICACIÓN (LOGIN) ---
    
    /**
     * Busca un empleado con esas credenciales.
     * @return El objeto Empleado si es correcto, o null si falló.
     */
    public Empleado iniciarSesion(String usuario, String password) {
        for (Empleado emp : listaEmpleados) {
            if (emp.iniciarSesion (usuario, password)) {
                this.usuarioAutenticado = emp; // Guardamos quién entró
                return emp; // Login exitoso
            }
        }
        return null; // Login fallido
    }
    
    // Método para cerrar sesión
    public void cerrarSesion() {
        this.usuarioAutenticado = null;
    }

    // --- GETTERS DE LAS LISTAS (Para que las Ventanas puedan ver y agregar datos) ---
    
    public ArrayList<Empleado> getListaEmpleados() { return listaEmpleados; }
    public ArrayList<Habitacion> getListaHabitaciones() { return listaHabitaciones; }
    public ArrayList<Huesped> getListaHuespedes() { return listaHuespedes; }
    public ArrayList<ServicioAdicional> getListaServicios() { return listaServicios; }
    public ArrayList<Reserva> getListaReservas() { return listaReservas; }
    public ArrayList<Estadia> getListaEstadias() { return listaEstadias; }
    
    public Empleado getUsuarioAutenticado() { return usuarioAutenticado; }
}