package com.conversor.gui;

import com.conversor.control.Monedas_Control;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Monedas_GUI extends JFrame{
	
	private JPanel panelMonedas;
	private Conversor_GUI ventanaConversor; // Referencia a la ventana principal
	private String[] opcionesMonedasCambio = {"Peso Mexicano (MXN)", "Dolar Estadounidense (USD)",
            "Libra Esterlina (GBP)", "Euro (EUR)","Yen Japonés (JPY)", "Won Surcoreano (KRW)"};
	private Monedas_Control control;
	
	// Variables de recolección de datos
	private JComboBox<String> monedaOrigen;
	private JComboBox<String> monedasDestino;
	private JTextField cantidadOrigen;
	private JTextField cantidadDestino;
	double cantidadMonedaNumero = 0.0; 
	
	
	public Monedas_GUI(Conversor_GUI ventanaConversor) {
		
		this.ventanaConversor = ventanaConversor; // Recibir la referencia de la ventana principal
		
		setTitle("Conversor Alura Challenge - Monedas");
		setSize(800,200);
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(300,150));
		
		control = new Monedas_Control(this);
		
		iniciarComponentes();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	private void iniciarComponentes() {
		
		 colocarPanel();
		 etiquetaMonedaInterfaz(); // Etiqueta parte superior
		 cantidadesConvertir(); // Espacios para ingreso de datos y listas de opciones
	     botonesMonedas(); // Botones
		
	}
	
	private void colocarPanel() {
		
		panelMonedas = new JPanel();
		panelMonedas.setLayout(new GridLayout(3, 1, 10, 10)); // Cuatro filas para organizar los elementos
		this.getContentPane().add(panelMonedas);
				
	}
	
	private void etiquetaMonedaInterfaz() {
		
        JLabel etiquetaTitulo = new JLabel("Conversor Alura Challenge - Monedas");
        etiquetaTitulo.setFont(new Font("Times New Roman", Font.BOLD, 20));
        etiquetaTitulo.setForeground(Color.BLACK);
        etiquetaTitulo.setHorizontalAlignment(JLabel.CENTER);
        etiquetaTitulo.setVerticalAlignment(JLabel.CENTER);
        panelMonedas.add(etiquetaTitulo);
    }
	
	private void cantidadesConvertir() {
		
        JPanel panelCantidades = new JPanel(new GridLayout(1, 4, 10, 10)); // Cuatro columnas para organizar
        
        // Cantidad a convertir
        cantidadOrigen = new JTextField();
        cantidadOrigen.setPreferredSize(new Dimension(100, 30));
        panelCantidades.add(cantidadOrigen);
        
        // Listas de opciones
        monedaOrigen = new JComboBox<>(opcionesMonedasCambio);
        panelCantidades.add(monedaOrigen);
        
         // Resultado de conversión               
        cantidadDestino = new JTextField();
        cantidadDestino.setPreferredSize(new Dimension(100, 30));
        cantidadDestino.setEditable(false); // No se puede editar
        panelCantidades.add(cantidadDestino);
        
        // Lista de opciones
        monedasDestino = new JComboBox<>(opcionesMonedasCambio);
        panelCantidades.add(monedasDestino);

        panelMonedas.add(panelCantidades);
    }
	
	private void botonesMonedas() {
		
	    JPanel panelBotones = new JPanel();
	    panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER)); // Alinea los botones a la derecha

	    // Crear el botón "Convertir"
	    JButton botonConvertir = new JButton("Convertir");
	    botonConvertir.setPreferredSize(new Dimension(100, 30)); // Tamaño personalizado
	    botonConvertir.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	
	        	// Recolección de datos ingresados por el usuario
	        	String monedaInicial = (String) monedaOrigen.getSelectedItem();
                String monedaConvertir = (String) monedasDestino.getSelectedItem();
                String cantidadMonedaString = cantidadOrigen.getText();
                
                try {
                    // Convierte la cantidad ingresada a double
                    cantidadMonedaNumero = Double.parseDouble(cantidadMonedaString);
                    
                    // Envia los datos a Monedas_Control. Conexión Interfaz-Control
                    control.datosColectadosGUI(monedaInicial, monedaConvertir, cantidadMonedaNumero);
                    
                } catch (NumberFormatException ex) {
                    // Manejo de error si la entrada no es un número válido
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese una cantidad numérica válida.");
                    return; 
                }
	        }
	    });

	    // Crear el botón "Volver"
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

	    // Agregar los botones al panelBotones
	    panelBotones.add(botonConvertir);
	    panelBotones.add(botonVolver);

	    // Agregar panelBotones al final del panelMonedas
	    panelMonedas.add(panelBotones);

	    // Actualizar la interfaz
	    revalidate();
	    repaint();
	}
	
	public void mostrarResultadoConversion(String resultado) {
        cantidadDestino.setText(resultado);
    }

}





