package com.conversor.gui;

import com.conversor.control.Masa_Control;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Masa_GUI extends JFrame {

    private JPanel panelMasa;
    private Masa_Control control;
    
    
    // Variables de recolección de datos
    private JComboBox<String> unidadInicial;
    private JComboBox<String> unidadConvertir;
    private JTextField cantidadOrigen;
    private JTextField cantidadDestino;
    double cantidadMasaNumero = 0.0;

    public Masa_GUI(Conversor_GUI ventanaConversor) {
    	
        setTitle("Conversor Alura Challenge - Masa");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(300, 150));
        
        control = new Masa_Control(this);

        inicializarComponentes(ventanaConversor);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void inicializarComponentes(Conversor_GUI ventanaConversor) {
    	
        colocarPanel();
        etiquetaConversionMasa();
        opcionesConversion();
        cantidadesConversion();
        botonesMasa(ventanaConversor);
    }

    private void colocarPanel() {
        panelMasa = new JPanel();
        panelMasa.setLayout(new GridLayout(4, 2, 10, 10)); // Cuatro filas y dos columnas
        this.getContentPane().add(panelMasa);
    }

    private void etiquetaConversionMasa() {
    	
        JLabel etiquetaTitulo = new JLabel("Conversiones de masa");
        etiquetaTitulo.setFont(new Font("Times New Roman", Font.BOLD, 16));
        etiquetaTitulo.setHorizontalAlignment(JLabel.CENTER);
        panelMasa.add(etiquetaTitulo);
    }

    // Creación de listas desplegables	
    private void opcionesConversion() {
    	
        JPanel panelOpciones = new JPanel(new GridLayout(1, 2, 10, 10));

        String[] opciones = {"Kilogramos (kg)", "Gramos (g)", "Libras (lb)", "Onzas (oz)"};

        // Lista de opciones Iniciales
        unidadInicial = new JComboBox<>(opciones); 
        panelOpciones.add(unidadInicial);
        
        // Lista de opciones a Convertir
        unidadConvertir = new JComboBox<>(opciones); 
        panelOpciones.add(unidadConvertir);

        panelMasa.add(panelOpciones);
    }

    // Espacios para ingreso de datos numéricos y resultado
    private void cantidadesConversion() {
    	
        JPanel panelCantidades = new JPanel(new GridLayout(1, 2, 10, 10));

        cantidadOrigen = new JTextField();
        panelCantidades.add(cantidadOrigen);
        
        cantidadDestino = new JTextField();
        panelCantidades.add(cantidadDestino);
        cantidadDestino.setEditable(false);

        panelMasa.add(panelCantidades);
    }

    private void botonesMasa(Conversor_GUI ventanaConversor) {
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Botón Convertir
        JButton botonConvertir = new JButton("Convertir");
        botonConvertir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	//Recolección de datos del usuario
            	String unidadInicialMasa = (String) unidadInicial.getSelectedItem();
            	String unidadConversionMasa = (String) unidadConvertir.getSelectedItem();
            	String cantidadMasaString = cantidadOrigen.getText();
            	
            	try {
                    cantidadMasaNumero = Double.parseDouble(cantidadMasaString);
                    
                    // Envia los datos a Masa_Control. Conexión Interfaz-Control
                    control.datosColectadosGUI(unidadInicialMasa, unidadConversionMasa, cantidadMasaNumero);
                    
                } catch (NumberFormatException ex) {
                    // Manejo de error si la entrada no es un número válido
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese una cantidad numérica válida.");
                    return; 
                }
            }
        });
        
        //Botón Volver
        JButton botonVolver = new JButton("Volver");
        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Volver a la ventana principal
                ventanaConversor.setVisible(true);
                setVisible(false);
            }
        });

        panelBotones.add(botonConvertir);
        panelBotones.add(botonVolver);

        panelMasa.add(panelBotones);
        
        // Actualizar la interfaz
        revalidate();
        repaint();
    }
    
    public void mostrarResultadoConversion(String resultado) {
        cantidadDestino.setText(resultado);
    }
}

