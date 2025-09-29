
package com.mycompany.semana15;

/**
 *
 * @author corne
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Aplicacion para gestionar una lista de tareas con Java Swing
public class ListaTareasApp extends JFrame {

    // Modelo que almacena las tareas de forma dinamica
    // Se escoge DefaultListModel porque facilita añadir, editar y eliminar elementos de la lista
    private DefaultListModel<String> modeloLista;

    // Componente visual que muestra la lista de tareas
    private JList<String> listaTareas;

    // Campo de entrada para escribir nuevas tareas
    private JTextField campoTarea;

    // Botones de la interfaz
    private JButton botonAgregar, botonCompletar, botonEliminar;

    // Constructor: define la estructura de la interfaz grafica
    public ListaTareasApp() {
        setTitle("Lista de Tareas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // centrar la ventana para mejor usabilidad

        // --- Configuracion de componentes principales ---
        modeloLista = new DefaultListModel<>();
        listaTareas = new JList<>(modeloLista);

        // se usa un renderer personalizado para diferenciar tareas completadas visualmente
        listaTareas.setCellRenderer(new ListCellRendererPersonalizado());

        campoTarea = new JTextField(20);
        botonAgregar = new JButton("Añadir Tarea");
        botonCompletar = new JButton("Marcar como Completada");
        botonEliminar = new JButton("Eliminar Tarea");

        // --- Organizacion de la interfaz (layouts y paneles) ---
        // Panel superior: campo de texto + boton de añadir
        JPanel panelSuperior = new JPanel(new BorderLayout(5, 0));
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelSuperior.add(campoTarea, BorderLayout.CENTER);
        panelSuperior.add(botonAgregar, BorderLayout.EAST);

        // Panel inferior: botones de completar y eliminar
        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelInferior.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        panelInferior.add(botonCompletar);
        panelInferior.add(botonEliminar);

        // La lista se agrega dentro de un JScrollPane para permitir desplazamiento
        JScrollPane scrollLista = new JScrollPane(listaTareas);
        scrollLista.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        // Ensamblaje de la interfaz
        add(panelSuperior, BorderLayout.NORTH);
        add(scrollLista, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        // Configuracion de eventos de interacción
        configurarEventos();
    }

    // Metodo que asocia acciones a los componentes 
    private void configurarEventos() {
        // Boton Añadir y Enter en el campo cumplen la misma funcion, reutilizamos el mismo metodo
        botonAgregar.addActionListener(e -> agregarTarea());
        campoTarea.addActionListener(e -> agregarTarea());

        // Boton para marcar tareas como completadas
        botonCompletar.addActionListener(e -> marcarComoCompletada());

        // Boton para eliminar tareas con confirmacion
        botonEliminar.addActionListener(e -> eliminarTarea());

        // doble clic sobre una tarea = marcar/desmarcar como completada (mejora de usabilidad)
        listaTareas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    marcarComoCompletada();
                }
            }
        });
    }

    // Agregar tarea al modelo de lista
    private void agregarTarea() {
        String textoTarea = campoTarea.getText().trim();

        if (!textoTarea.isEmpty()) {
            // Se añade inicialmente como pendiente
            modeloLista.addElement("[Pendiente] " + textoTarea);
            campoTarea.setText(""); // Limpiar campo para la siguiente entrada
        } else {
            // Validación básica: no permitir tareas vacías
            JOptionPane.showMessageDialog(this, "Por favor, escribe una tarea.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Marcar o desmarcar tarea como completada
    private void marcarComoCompletada() {
        int indice = listaTareas.getSelectedIndex();

        if (indice != -1) {
            String tarea = modeloLista.getElementAt(indice);

            // Decisión: usamos prefijos "[Pendiente]" y "[Completada]" para identificar el estado
            if (tarea.startsWith("[Pendiente]")) {
                modeloLista.setElementAt("[Completada] " + tarea.substring(11), indice);
            } else if (tarea.startsWith("[Completada]")) {
                modeloLista.setElementAt("[Pendiente] " + tarea.substring(12), indice);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una tarea.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Eliminar tarea seleccionada con confirmación del usuario
    private void eliminarTarea() {
        int indice = listaTareas.getSelectedIndex();

        if (indice != -1) {
            // Confirmación antes de borrar: evita eliminación accidental
            int confirm = JOptionPane.showConfirmDialog(
                this,
                "¿Estás seguro de que deseas eliminar la tarea seleccionada?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                modeloLista.remove(indice);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una tarea para eliminar.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Renderer: cambia el estilo visual según el estado de la tarea
    private static class ListCellRendererPersonalizado extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(
                JList<?> list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {

            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            String tarea = value.toString();

            // Decisión: tareas completadas se muestran en gris e itálicas para diferenciarlas claramente
            if (tarea.startsWith("[Completada]")) {
                label.setForeground(Color.GRAY);
                label.setFont(label.getFont().deriveFont(Font.ITALIC));
            } else {
                label.setForeground(Color.BLACK);
                label.setFont(label.getFont().deriveFont(Font.PLAIN));
            }
            return label;
        }
    }

    // Método principal que arranca la aplicación
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ListaTareasApp().setVisible(true));
    }
}
