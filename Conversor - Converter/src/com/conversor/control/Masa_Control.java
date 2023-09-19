package com.conversor.control;

import com.conversor.logica.Masa_Logica;
import com.conversor.gui.Masa_GUI;

public class Masa_Control {
	
	private Masa_Logica logica = new Masa_Logica();
	private double resultadoConversionMasa;
	private Masa_GUI interfaz;
	
	public Masa_Control(Masa_GUI interfaz) {
        this.interfaz = interfaz;
    }
	
	// Método para recibir los datos recolectados en la interfaz
    public void datosColectadosGUI(String unidadInicialMasa, String unidadConversionMasa, double cantidadMasaNumero) {
        // Llamamos al método de la lógica para realizar la conversión
    	resultadoConversionMasa = logica.convertirMasa(cantidadMasaNumero, unidadInicialMasa, unidadConversionMasa);
    	
    	// Llamamos a un método en la instancia de Masa_GUI para actualizar la interfaz
    	interfaz.mostrarResultadoConversion(String.valueOf(resultadoConversionMasa));

    }
    
    // Método para obtener el resultado de la conversión
    public double getResultadoConversion() {
        return resultadoConversionMasa;
    }

}
