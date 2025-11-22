package com.hotel.sistema.modelo;

public class Empleado {
        protected String dni;
        protected String nombres; 
        protected String apellidos;
        protected String usuario;
        protected String password;
        protected String rol; 
        
        public Empleado (String dni, String nombres, String apellidos, String usuario, String password, String rol ){
            this.dni = dni;
            this.nombres = nombres; 
            this.apellidos = apellidos; 
            this.usuario = usuario;
            this.password = password;
            this.rol = rol; 
            
        }
        public boolean iniciarSesion (String user, String pass) {
                return this.usuario.equals(user) && this.password.equals(pass);
        }

    public String getDni() {
        return dni;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getRol() {
        return rol;
    }
        @Override
        public String toString(){
            return nombres + " " + apellidos + " - " + rol;
            
        } 
}
