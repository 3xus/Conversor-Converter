package com.conversor.gui;

import com.conversor.control.Temperatura_Control;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Temperatura_GUI extends JFrame {

    private JPanel panelTemperatura;
    private Conversor_GUI ventanaConversor; // Referencia a la ventana principal
    private String[] opcionesTemperatura = {"Celcius (°C)", "Fahrenheit (°F)", "Kelvin (K)"};
    private Temperatura_Control control;
    
    // Variables de recolección de datos
    private JComboBox<String> temperaturaOrigen;
	private JComboBox<String> temperaturaDestino;
	private JTextField cantidadOrigen;
	private JTextField cantidadDestino;
	double cantidadGradosNumero = 0.0; 

    public Temperatura_GUI(Conversor_GUI ventanaConversor) {

        this.ventanaConversor = ventanaConversor; // Recibir la referencia de la ventana principal

        setTitle("Conversor Alura Challenge - Temperatura");
        setSize(800, 200);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(300, 150));
        
        control = new Temperatura_Control(this);

        iniciarComponentes();

        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private void iniciarComponentes() {

        colocarPanel();
        etiquetaTemperaturaInterfaz(); // Etiqueta parte superior
        cantidadesConvertir(); // Espacios para ingreso de datos y listas de opciones
        botonesTemperatura(); // Botones

    }

    private void colocarPanel() {

        panelTemperatura = new JPanel();
        panelTemperatura.setLayout(new GridLayout(4, 1, 10, 10)); // Cuatro filas para organizar los elementos
        this.getContentPane().add(panelTemperatura);

    }

    private void etiquetaTemperaturaInterfaz() {
    	
        JLabel etiquetaTitulo = new JLabel("Conversor Alura Challenge - Temperatura");
        etiquetaTitulo.setFont(new Font("Times New Roman", Font.BOLD, 20));
        etiquetaTitulo.setForeground(Color.BLACK);
        etiquetaTitulo.setHorizontalAlignment(JLabel.CENTER);
        etiquetaTitulo.setVerticalAlignment(JLabel.CENTER);
        panelTemperatura.add(etiquetaTitulo);
    }

    private void cantidadesConvertir() {
    	
        JPanel panelTempOrigen = new JPanel(new GridLayout(1, 2, 10, 10));
        JPanel panelTempDestino = new JPanel(new GridLayout(1, 2, 10, 10));
        
        // Temperatura Origen
        temperaturaOrigen = new JComboBox<>(opcionesTemperatura);
        panelTempOrigen.add(temperaturaOrigen);

        // Cantidad de grados a convertir
        cantidadOrigen = new JTextField();
        cantidadOrigen.setPreferredSize(new Dimension(100, 30));
        panelTempOrigen.add(cantidadOrigen);

        // Temperatura Destino
        temperaturaDestino = new JComboBox<>(opcionesTemperatura);
        panelTempDestino.add(temperaturaDestino);

        // Cantidad de grados convertidos
        cantidadDestino = new JTextField();
        cantidadDestino.setPreferredSize(new Dimension(100, 30));
        cantidadDestino.setEditable(false); // No se puede editar
        panelTempDestino.add(cantidadDestino);

        panelTemperatura.add(panelTempOrigen);
        panelTemperatura.add(panelTempDestino);
    }

    private void botonesTemperatura() {
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER)); // Alinea los botones al centro

        // Crear el botón "Convertir"
        JButton botonConvertir = new JButton("Convertir");
        botonConvertir.setPreferredSize(new Dimension(100, 30)); // Tamaño personalizado
        botonConvertir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Recolección de datos por el usuario
            	String unidadOrigen = (String) temperaturaOrigen.getSelectedItem();
                String unidadDestino = (String) temperaturaDestino.getSelectedItem();
                String cantidadGradosString = cantidadOrigen.getText();
                
                try {
                    // Convierte la cantidad ingresada a double
                    cantidadGradosNumero = Double.parseDouble(cantidadGradosString);
                    
                    // Envia los datos a Temperatura_Control. Conexión Interfaz-Control
                    control.datosColectadosGUI(unidadOrigen, unidadDestino, cantidadGradosNumero);
                    
                } catch (NumberFormatException ex) {
                    // Manejo de error si la entrada no es un número válido
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese una cantidad numérica válida.");
                    return; 
                }
            }

        });

        // Crear el botón "Volver"
        JButton botonVolver = new JButton("Volver");
        botonVolver.setPreferredSize(new Dimension(100, 30)); // Tamaño personalizado
        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar la ventana principal (Conversor_GUI)
                ventanaConversor.setVisible(true);
                // Ocultar la ventana actual (Temperatura_GUI)
                setVisible(false);
            }
        });

        // Agregar los botones al panelBotones
        panelBotones.add(botonConvertir);
        panelBotones.add(botonVolver);

        // Agregar panelBotones al final del panelTemperatura
        panelTemperatura.add(panelBotones);

        // Actualizar la interfaz
        revalidate();
        repaint();
    }
    
    public void mostrarResultadoConversion(String resultado) {
        cantidadDestino.setText(resultado);
    }
}

