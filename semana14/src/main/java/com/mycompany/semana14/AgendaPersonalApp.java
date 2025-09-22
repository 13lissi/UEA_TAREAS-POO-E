package com.mycompany.semana14;

/**
 *
 * @author corne
 */

// Importaciones necesarias para la interfaz y manejo de fechas.
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

// Clase principal que representa la ventana de la aplicacion.
public class AgendaPersonalApp extends JFrame {

    // --- Componentes de la interfaz ---
    private DefaultTableModel tableModel;
    private JTable tablaActividades;
    private JSpinner spinnerFecha;
    private JSpinner spinnerHora;
    private JTextArea txtDescripcion; 
    private JButton btnAgregar;
    private JButton btnEliminar;
    private JButton btnSalir;

    // Constructor: se ejecuta al crear la ventana.
    public AgendaPersonalApp() {
        setTitle("Agenda Personal");
        setSize(700, 600); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10)); 

        
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(10, 10, 10, 10));

        initComponents();
        initListeners();
    }

    // Metodo para crear y organizar los componentes visuales.
    private void initComponents() {

        // --- Panel de Registro de Actividad  ---
        JPanel panelRegistro = new JPanel(new GridBagLayout()); // GridBagLayout para mas flexibilidad.
        panelRegistro.setBorder(BorderFactory.createTitledBorder("Registrar Actividad"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espaciado entre componentes.
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Etiqueta y Spinner de Fecha
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        panelRegistro.add(new JLabel("Fecha:"), gbc);

        gbc.gridx = 1;
        spinnerFecha = new JSpinner(new SpinnerDateModel());
        spinnerFecha.setEditor(new JSpinner.DateEditor(spinnerFecha, "dd/MM/yyyy"));
        spinnerFecha.setToolTipText("Formato dd/MM/yyyy"); 
        panelRegistro.add(spinnerFecha, gbc);

        // Etiqueta y Spinner de Hora
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelRegistro.add(new JLabel("Hora:"), gbc);

        gbc.gridx = 1;
        spinnerHora = new JSpinner(new SpinnerDateModel());
        spinnerHora.setEditor(new JSpinner.DateEditor(spinnerHora, "HH:mm"));
        spinnerHora.setToolTipText("Formato HH:mm"); 
        panelRegistro.add(spinnerHora, gbc);

        // Etiqueta de Descripcion
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2; // La etiqueta ocupa dos columnas.
        panelRegistro.add(new JLabel("Descripcion:"), gbc);

        // Descripcion
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2; 
        gbc.fill = GridBagConstraints.BOTH; 
        gbc.weightx = 1.0; 
        gbc.weighty = 1.0; 
        txtDescripcion = new JTextArea(4, 20); 
        txtDescripcion.setLineWrap(true);      
        txtDescripcion.setWrapStyleWord(true); 
        JScrollPane scrollDescripcion = new JScrollPane(txtDescripcion); 
        panelRegistro.add(scrollDescripcion, gbc);

        // --- Tabla de Actividades ---
        String[] columnas = {"Fecha", "Hora", "Descripcion"};
        tableModel = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };
        tablaActividades = new JTable(tableModel);
        JScrollPane scrollTabla = new JScrollPane(tablaActividades);
        scrollTabla.setBorder(BorderFactory.createTitledBorder("Actividades Agendadas"));

        // --- Panel Inferior Botones de Accion ---
        JPanel panelAcciones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnAgregar = new JButton("Agregar");
        btnEliminar = new JButton("Eliminar Seleccionado");
        btnSalir = new JButton("Salir");
        panelAcciones.add(btnAgregar);
        panelAcciones.add(btnEliminar);
        panelAcciones.add(btnSalir);

        // --- Agregamos todos los paneles a la ventana principal ---
        add(panelRegistro, BorderLayout.NORTH);  
        add(scrollTabla, BorderLayout.CENTER);   
        add(panelAcciones, BorderLayout.SOUTH);  
    }

    // Metodo para configurar las acciones de los botones.
    private void initListeners() {
        btnAgregar.addActionListener(e -> agregarActividad());
        btnEliminar.addActionListener(e -> eliminarActividad());
        btnSalir.addActionListener(e -> dispose());
    }
    
    // agregar una actividad.
    private void agregarActividad() {
        String descripcion = txtDescripcion.getText().trim();
        if (descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La descripcion no puede estar vacia.", "Validacion", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Date fecha = (Date) spinnerFecha.getValue();
        Date hora = (Date) spinnerHora.getValue();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
        
        tableModel.addRow(new Object[]{
            formatoFecha.format(fecha),
            formatoHora.format(hora),
            descripcion
        });

        txtDescripcion.setText("");
        txtDescripcion.requestFocusInWindow();
    }

    // eliminar una actividad.
    private void eliminarActividad() {
        int filaSeleccionada = tablaActividades.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una actividad primero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Eliminar la actividad seleccionada?", "Confirmar eliminacion", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            tableModel.removeRow(filaSeleccionada);
        }
    }

    // Metodo principal para iniciar la aplicacion.
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AgendaPersonalApp().setVisible(true));
    }
}