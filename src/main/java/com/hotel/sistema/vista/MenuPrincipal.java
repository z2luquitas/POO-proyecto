package com.hotel.sistema.vista;

import com.hotel.sistema.controlador.SistemaHotel;
import com.hotel.sistema.modelo.Empleado;
import javax.swing.JOptionPane;

public class MenuPrincipal extends javax.swing.JFrame {

    // ATRIBUTOS DE CLASE
    private SistemaHotel sistema;
    private Empleado usuarioActual;

    // --- CONSTRUCTOR PRINCIPAL ---
    // Este es el que usamos cuando alguien se loguea
    public MenuPrincipal(SistemaHotel sistema, Empleado usuarioActual) {
        this.sistema = sistema;
        this.usuarioActual = usuarioActual;
        
        // 1. Iniciar componentes visuales (Botones, textos, etc.)
        initComponents();
        
        // 2. Configuración Visual Personalizada
        configurarBienvenida();
        aplicarPermisosDeRol();
    }

    // Constructor vacío (Solo para que NetBeans no muestre error en el diseño)
    public MenuPrincipal() {
        initComponents();
    }
    
    // --- MÉTODOS PROPIOS (Modularidad) ---
    
    private void configurarBienvenida() {
        // Centrar la ventana
        this.setLocationRelativeTo(null);
        // Mostrar quién entró
        lblUsuario.setText("Usuario: " + usuarioActual.getNombres() + " " + usuarioActual.getApellidos());
        lblRol.setText("Rol: " + usuarioActual.getRol());
    }

    private void aplicarPermisosDeRol() {
        // REGLA DE NEGOCIO: Restricción por Rol
        if (usuarioActual.getRol().equals("RECEPCIONISTA")) {
            // El recepcionista NO puede tocar la configuración del hotel
            btnGestionarHabitaciones.setEnabled(false);
            btnGestionarEmpleados.setEnabled(false);
            btnReportes.setEnabled(false);
        }
    }

    /**
     * CÓDIGO GENERADO POR NETBEANS (Visual)
     * No te preocupes por las líneas largas aquí, es automático.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblRol = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        
        // Panel de Operaciones (Recepción)
        jPanel1 = new javax.swing.JPanel();
        btnNuevaReserva = new javax.swing.JButton();
        btnCheckIn = new javax.swing.JButton();
        btnCheckOut = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        // Panel de Administración (Admin)
        jPanel2 = new javax.swing.JPanel();
        btnGestionarHabitaciones = new javax.swing.JButton();
        btnGestionarEmpleados = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Hotelero - Menú Principal");

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setText("HOTEL SISTEMA");

        lblUsuario.setText("Usuario: ...");
        lblRol.setText("Rol: ...");

        // --- BOTÓN SALIR ---
        btnSalir.setText("Cerrar Sesión");
        btnSalir.setBackground(new java.awt.Color(255, 102, 102)); // Rojo suave
        // AQUÍ ESTÁ EL "VIGILANTE" DEL QUE HABLAMOS
        btnSalir.addActionListener(this::btnSalirActionPerformed);

        // Configuración Panel Recepción
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setText("Recepción");
        btnNuevaReserva.setText("Crear Reserva");
        btnCheckIn.setText("Check-In");
        btnCheckOut.setText("Check-Out");

        // Configuración Panel Admin
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel2.setText("Administración");
        btnGestionarHabitaciones.setText("Habitaciones");
        btnGestionarEmpleados.setText("Empleados");
        btnReportes.setText("Reportes");

        // Layout (Diseño visual) - Simplificado para copiar/pegar
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsuario)
                            .addComponent(lblRol)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUsuario)
                        .addComponent(lblRol)))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(20, 20, 20))
        );
        
        // Agregar botones a los paneles (Simplificación manual del diseño)
        jPanel1.add(jLabel1); jPanel1.add(btnNuevaReserva); jPanel1.add(btnCheckIn); jPanel1.add(btnCheckOut);
        jPanel2.add(jLabel2); jPanel2.add(btnGestionarHabitaciones); jPanel2.add(btnGestionarEmpleados); jPanel2.add(btnReportes);

        pack();
    }// </editor-fold>                        

    // --- LÓGICA DE LOS BOTONES ---

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // 1. Confirmar si quiere salir
        int confirm = JOptionPane.showConfirmDialog(this, "¿Seguro que desea cerrar sesión?", "Salir", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            // 2. Crear la ventana de login de nuevo
            VentanaLogin login = new VentanaLogin (sistema);
            login.setVisible(true);
            login.setLocationRelativeTo(null);
            
            // 3. Destruir esta ventana (Menú)
            this.dispose();
        }
    }                                        

    // Declaración de Variables (Generado por NetBeans)
    private javax.swing.JButton btnCheckIn;
    private javax.swing.JButton btnCheckOut;
    private javax.swing.JButton btnGestionarEmpleados;
    private javax.swing.JButton btnGestionarHabitaciones;
    private javax.swing.JButton btnNuevaReserva;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblRol;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    // End of variables declaration                   
}