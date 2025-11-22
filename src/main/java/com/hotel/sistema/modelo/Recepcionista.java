
package com.hotel.sistema.modelo;

public class Recepcionista extends Empleado {
        private String turno; 
        public Recepcionista (String dni, String nombres, String apellidos, String usuario, String password, String turno){
            super(dni, nombres, apellidos, usuario, password , "Recepcionista");
            this.turno = turno;
            
        }
        public String getTurno () {
            return turno;
        }
        public void setTurno (String turno){
            this.turno = turno;
            
        }
        @Override
        public String toString (){ 
            return super.toString () + "(Turno: " + turno + ")";
        }
}
