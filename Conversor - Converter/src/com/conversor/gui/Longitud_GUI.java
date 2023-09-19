package com.conversor.gui;

import com.conversor.control.Longitud_Control;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Longitud_GUI extends JFrame {

    private JPanel panelLongitud;
    private Conversor_GUI ventanaConversor; // Referencia a la ventana principal
    private String[] opcionesLongitud = {"Milímetros", "Centímetros", "Metros", "Kilómetros", "Pulgadas", "Pies", "Yardas", "Milla"};
    private Longitud_Control control;
    
    // Variables de recolección de datos
    private JComboBox<String> longitudOrigen;
	private JComboBox<String> longitudDestino;
	private JTextField cantidadLongitudOrigen;
	private JTextField cantidadLongitudDestino;
	double cantidadLongitudNumero = 0.0; 

    // Constructor
    public Longitud_GUI(Conversor_GUI ventanaConversor) {
    	
        this.ventanaConversor = ventanaConversor; // Recibir la referencia de la ventana principal

        setTitle("Conversor Alura Challenge - Longitud");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(300, 150));
        
        control = new Longitud_Control(this);

        iniciarComponentes();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // Métodos para inicializar los componentes de la interfaz
    private void iniciarComponentes() {
    	
        colocarPanel();
        etiquetaLongitud();
        opcionesConversion();
        botonesLongitud();
        
    }

    private void colocarPanel() {
    	
        panelLongitud = new JPanel();
        panelLongitud.setLayout(new GridLayout(3, 1, 10, 10)); // Cuatro filas para organizar los elementos
        this.getContentPane().add(panelLongitud);
        
    }

    private void etiquetaLongitud() {
    	
        JLabel etiquetaTitulo = new JLabel("Conversor Longitud");
        etiquetaTitulo.setFont(new Font("Times New Roman", Font.BOLD, 20));
        etiquetaTitulo.setForeground(Color.BLACK);
        etiquetaTitulo.setHorizontalAlignment(JLabel.CENTER);
        etiquetaTitulo.setVerticalAlignment(JLabel.CENTER);
        panelLongitud.add(etiquetaTitulo);
        
    }
    
    private void opcionesConversion() {
    	
        JPanel panelOpciones = new JPanel(new GridLayout(2, 2, 10, 10)); // Dos filas, dos columnas

        longitudOrigen = new JComboBox<>(opcionesLongitud);
        panelOpciones.add(longitudOrigen);

        cantidadLongitudOrigen = new JTextField();
        cantidadLongitudOrigen.setPreferredSize(new Dimension(100, 30));
        panelOpciones.add(cantidadLongitudOrigen);

        longitudDestino = new JComboBox<>(opcionesLongitud);
        panelOpciones.add(longitudDestino);

        cantidadLongitudDestino = new JTextField();
        cantidadLongitudDestino.setPreferredSize(new Dimension(100, 30));
        cantidadLongitudDestino.setEditable(false); // No se puede editar
        panelOpciones.add(cantidadLongitudDestino);

        panelLongitud.add(panelOpciones);
        
    }
    
    private void botonesLongitud() {
    	
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER)); // Alinea los botones al centro

        JButton botonConvertir = new JButton("Convertir");
        botonConvertir.setPreferredSize(new Dimension(100, 30));
        botonConvertir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Recolección de datos por el usuario
            	String unidadLongitudOrigen = (String) longitudOrigen.getSelectedItem();
                String unidadLongitudDestino = (String) longitudDestino.getSelectedItem();
                String cantidadLongitudString = cantidadLongitudOrigen.getText();
                
                try {
                    // Convierte la cantidad ingresada a double
                    cantidadLongitudNumero = Double.parseDouble(cantidadLongitudString);
                    
                    // Envia los datos a Temperatura_Control. Conexión Interfaz-Control
                    control.datosColectadosGUI(unidadLongitudOrigen, unidadLongitudDestino, cantidadLongitudNumero);
                    
                } catch (NumberFormatException ex) {
                    // Manejo de error si la entrada no es un número válido
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese una cantidad numérica válida.");
                    return; 
                }
            }
        });

        JButton botonVolver = new JButton("Volver");
        botonVolver.setPreferredSize(new Dimension(100, 30));
        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar la ventana principal (Conversor_GUI)
                ventanaConversor.setVisible(true);
                // Ocultar la ventana actual (Longitud_GUI)
                setVisible(false);
            }
        });

        panelBotones.add(botonConvertir);
        panelBotones.add(botonVolver);

        panelLongitud.add(panelBotones);

        // Actualizar la interfaz
        revalidate();
        repaint();
    }

    public void mostrarResultadoConversion(String resultado) {
    	cantidadLongitudDestino.setText(resultado);
    }
}


    
