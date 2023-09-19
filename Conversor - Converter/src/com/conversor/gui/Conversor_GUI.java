package com.conversor.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Conversor_GUI extends JFrame{
	
	public JPanel principalPanel;
	
	public Conversor_GUI(Monedas_GUI ventanaMonedas, Masa_GUI ventanaMasa, Temperatura_GUI ventanaTemperatura, Longitud_GUI ventanaLongitud) {

		setTitle("Conversor Challenge");
		setSize(500, 500);
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(100, 100));
		
		iniciarComponentes();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		
	}
	
	private void iniciarComponentes() {
		
		colocarPanel();
		etiquetaPanelPrincipal();
		botonesOpcionesConversion();
		
	}
	
	
	private void colocarPanel() {
		
		principalPanel = new JPanel();
		principalPanel.setLayout(new GridLayout(0,1));
		this.getContentPane().add(principalPanel);	
		
	}
	
	private void etiquetaPanelPrincipal() {
		
		JLabel etiquetaTitulo = new JLabel("Conversor.");
		etiquetaTitulo.setFont(new Font("Times New Roman", Font.BOLD, 20));
		etiquetaTitulo.setForeground(Color.BLACK);
		etiquetaTitulo.setHorizontalAlignment(JLabel.CENTER);
		etiquetaTitulo.setVerticalAlignment(JLabel.CENTER);
		principalPanel.add(etiquetaTitulo);
		
    }
	
	private void botonesOpcionesConversion() {
        JPanel panelBotones = new JPanel(new GridLayout(2, 2, 10, 10));

        String[] nombresBotones = {"Longitud", "Temperatura", "Masa", "Monedas"};

        for (String nombreBoton : nombresBotones) {
            JButton boton = new JButton(nombreBoton);
            boton.setPreferredSize(new Dimension(40, 50));

            // ActionListener para el botón "Monedas"
            if (nombreBoton.equals("Monedas")) {
                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Ocultar la ventana actual (Conversor_GUI)
                        setVisible(false);
                        // Mostrar la ventana de monedas (ventanaMonedas)
                        Monedas_GUI ventanaMonedas = new Monedas_GUI(Conversor_GUI.this);
                        ventanaMonedas.setVisible(true);
                    }
                });
            }
            
            // ActionListener para el botón "Masa"
            if (nombreBoton.equals("Masa")) {
                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Ocultar la ventana actual (Conversor_GUI)
                        setVisible(false);
                        // Mostrar la ventana de masa (ventanaMasa)
                        Masa_GUI ventanaMasa = new Masa_GUI(Conversor_GUI.this);
                        ventanaMasa.setVisible(true);
                    }
                });
            }
            
            // ActionListener para el botón "Temperatura"
            if (nombreBoton.equals("Temperatura")) {
                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Ocultar la ventana actual (Conversor_GUI)
                        setVisible(false);
                        // Mostrar la ventana de temperatura (ventanaTemperatura)
                        Temperatura_GUI ventanaTemperatura = new Temperatura_GUI(Conversor_GUI.this);
                        ventanaTemperatura.setVisible(true);
                    }
                });
            }
            
            // ActionListener para el botón "Longitud"
            if (nombreBoton.equals("Longitud")) {
                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Ocultar la ventana actual (Conversor_GUI)
                        setVisible(false);
                        // Crear y mostrar la ventana de longitud (Longitud_GUI)
                        Longitud_GUI ventanaLongitud = new Longitud_GUI(Conversor_GUI.this);
                        ventanaLongitud.setVisible(true);
                    }
                });
            }


            panelBotones.add(boton);
        }

        principalPanel.add(panelBotones);
    }
}
