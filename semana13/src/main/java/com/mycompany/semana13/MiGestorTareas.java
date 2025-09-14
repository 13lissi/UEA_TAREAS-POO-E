
package com.mycompany.semana13;

/**
 *
 * @author corne
 */
import javax.swing.*;
import java.awt.*;

public class MiGestorTareas extends JFrame {

    // --- Componentes principales ---
    private final JTextField campoTarea;
    private final JButton botonAgregar;
    private final JButton botonEliminar;
    private final JButton botonLimpiar;
    private final JList<String> listaTareas;
    private final DefaultListModel<String> modeloLista;
    private final JLabel barraEstado;

    public MiGestorTareas() {
        // Configuración ventana principal
        setTitle("<3 Gestor de Tareas <3");
        setSize(550, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Paleta de colores para un mejor estilo y mas llamativo a mi parecer.
        Color fondoOscuro = new Color(0x1A1A2E);
        Color neonCyan = new Color(0x00FFFF);
        Color neonMagenta = new Color(0xFF00FF);
        Font fuenteRetro = new Font("Consolas", Font.BOLD, 14);

        // Panel superior, entrada y boton Agregar
        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panelSuperior.setBackground(fondoOscuro);

        JLabel etiqueta = new JLabel("NUEVA TAREA:");
        etiqueta.setFont(fuenteRetro);
        etiqueta.setForeground(neonCyan);

        campoTarea = new JTextField(20);
        campoTarea.setFont(fuenteRetro);
        campoTarea.setBackground(new Color(0x2A2A4E));
        campoTarea.setForeground(Color.WHITE);
        campoTarea.setCaretColor(neonMagenta);
        campoTarea.setBorder(BorderFactory.createLineBorder(neonCyan));

        botonAgregar = new JButton("AGREGAR");
        estilizarBoton(botonAgregar, neonMagenta, Color.BLACK, fuenteRetro);

        panelSuperior.add(etiqueta);
        panelSuperior.add(campoTarea);
        panelSuperior.add(botonAgregar);
        add(panelSuperior, BorderLayout.NORTH);

        // --- Centro: lista de tareas con scroll ---
        modeloLista = new DefaultListModel<>();
        listaTareas = new JList<>(modeloLista);
        listaTareas.setFont(fuenteRetro);
        listaTareas.setBackground(new Color(0x2A2A4E));
        listaTareas.setForeground(Color.WHITE);
        listaTareas.setSelectionBackground(neonMagenta);
        listaTareas.setSelectionForeground(Color.BLACK);
        add(new JScrollPane(listaTareas), BorderLayout.CENTER);

        // Barra de estado y botones de gestion ---
        JPanel panelSur = new JPanel(new BorderLayout());
        barraEstado = new JLabel("Elementos: 0");
        barraEstado.setForeground(neonCyan);
        barraEstado.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        panelSur.add(barraEstado, BorderLayout.WEST);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        panelBotones.setBackground(fondoOscuro);

        botonEliminar = new JButton("ELIMINAR SELECCIONADO");
        estilizarBoton(botonEliminar, neonCyan, Color.BLACK, fuenteRetro);

        botonLimpiar = new JButton("LIMPIAR TODO");
        estilizarBoton(botonLimpiar, Color.ORANGE, Color.BLACK, fuenteRetro);

        panelBotones.add(botonEliminar);
        panelBotones.add(botonLimpiar);
        panelSur.add(panelBotones, BorderLayout.EAST);

        add(panelSur, BorderLayout.SOUTH);

        // --- Eventos ---
        botonAgregar.addActionListener(e -> agregarTarea());
        campoTarea.addActionListener(e -> agregarTarea());
        botonEliminar.addActionListener(e -> eliminarSeleccion());
        botonLimpiar.addActionListener(e -> limpiarLista());
    }

    // Agrega tarea si no esta vacia
    private void agregarTarea() {
        String tarea = campoTarea.getText().trim();
        if (tarea.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo no puede estar vacio.", "Entrada inválida", JOptionPane.WARNING_MESSAGE);
            return;
        }
        modeloLista.addElement("» " + tarea);
        campoTarea.setText("");
        actualizarEstado();
    }

    // Elimina la tarea seleccionada
    private void eliminarSeleccion() {
        int idx = listaTareas.getSelectedIndex();
        if (idx != -1) {
            modeloLista.remove(idx);
            actualizarEstado();
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una tarea primero.", "Sin seleccion", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Limpia toda la lista 
    private void limpiarLista() {
        modeloLista.clear();
        actualizarEstado();
    }

    // Actualiza contador de elementos
    private void actualizarEstado() {
        barraEstado.setText("Elementos: " + modeloLista.size());
    }

    // Aplica estilo a botones
    private void estilizarBoton(JButton boton, Color fondo, Color texto, Font fuente) {
        boton.setFont(fuente);
        boton.setBackground(fondo);
        boton.setForeground(texto);
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createRaisedBevelBorder());
    }

    // Método principal
    //Tambien podriamos dividirlo en dos clases 
    //como separacion de responsabilidades y llevar una jerarquia.
    public static void main(String[] args) {
        // Ejecuta la GUI 
        SwingUtilities.invokeLater(() -> new MiGestorTareas().setVisible(true));
    }
}

