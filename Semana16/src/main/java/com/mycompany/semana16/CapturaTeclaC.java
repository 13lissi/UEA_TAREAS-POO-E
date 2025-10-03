
package com.mycompany.semana16;

/**
 *
 * @author corne
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CapturaTeclaC extends JFrame {

    private JList<String> listaNotas;
    private DefaultListModel<String> modeloNotas;
    private boolean capturado = false; // indica si la tecla C se presiono

    public CapturaTeclaC() {
        super("Captura Tecla C");

        // configuracion ventana
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // modelo de lista con elementos
        modeloNotas = new DefaultListModel<>();
        modeloNotas.addElement("Taylor Swift");
        modeloNotas.addElement("Fearless");
        modeloNotas.addElement("Speak Now");
        modeloNotas.addElement("Red");
        modeloNotas.addElement("1989");
        modeloNotas.addElement("REPUTATION");
        modeloNotas.addElement("Lover");

        listaNotas = new JList<>(modeloNotas);
        listaNotas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaNotas.setFont(new Font("Arial", Font.PLAIN, 16));

        // label para mostrar estado
        JLabel estadoLabel = new JLabel("Esperando la tecla C...", SwingConstants.CENTER);
        estadoLabel.setFont(new Font("Arial", Font.BOLD, 16));
        estadoLabel.setForeground(Color.BLUE);

        // boton de ejemplo 
        JButton botonEjemplo = new JButton("Boton de ejemplo");
        botonEjemplo.setFont(new Font("Arial", Font.PLAIN, 14));
        botonEjemplo.addActionListener(e -> System.out.println("Boton presionado")); // accion simple

        // renderer para pintar la linea capturada
        listaNotas.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                if (isSelected && capturado) {
                    c.setBackground(new Color(34, 139, 34)); // verde cuando capturada
                    c.setForeground(Color.WHITE);
                } else if (isSelected) {
                    c.setBackground(new Color(184, 207, 229)); // seleccion normal
                    c.setForeground(Color.BLACK);
                } else {
                    c.setBackground(Color.WHITE);
                    c.setForeground(Color.BLACK);
                }
                return c;
            }
        });

        // listener de teclado
        listaNotas.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_C) {
                    int seleccionado = listaNotas.getSelectedIndex();
                    if (seleccionado != -1) {
                        capturado = !capturado; // alterna estado
                        if (capturado) {
                            estadoLabel.setText("Tecla C capturada!");
                            estadoLabel.setForeground(new Color(34, 139, 34));
                        } else {
                            estadoLabel.setText("Esperando la tecla C...");
                            estadoLabel.setForeground(Color.BLUE);
                        }
                        listaNotas.repaint(); // refresca color
                        System.out.println("Elemento seleccionado: " + modeloNotas.get(seleccionado));
                    }
                }
            }
        });

        // agregamos los componentes a la ventana
        add(estadoLabel, BorderLayout.NORTH);
        add(new JScrollPane(listaNotas), BorderLayout.CENTER);
        add(botonEjemplo, BorderLayout.SOUTH); // boton al final

        setVisible(true);
        listaNotas.requestFocusInWindow();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CapturaTeclaC());
    }
}



