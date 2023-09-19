package com.conversor.control;

import com.conversor.logica.Temperatura_Logica;
import com.conversor.gui.Temperatura_GUI;

public class Temperatura_Control {
	
	private Temperatura_Logica logica = new Temperatura_Logica();
	private double resultadoConversionTemperatura;
	private Temperatura_GUI interfaz;
	
	public Temperatura_Control(Temperatura_GUI interfaz) {
        this.interfaz = interfaz;
    }
	
	// Método para recibir los datos recolectados en la interfaz
    public void datosColectadosGUI(String unidadOrigen, String unidadDestino, double cantidadGradosNumero) {
        // Llamamos al método de la lógica para realizar la conversión
    	resultadoConversionTemperatura = logica.convertirTemperatura(cantidadGradosNumero, unidadOrigen, unidadDestino);
    	
    	// Llamamos a un método en la instancia de Temperatura_GUI para actualizar la interfaz
    	interfaz.mostrarResultadoConversion(String.valueOf(resultadoConversionTemperatura));

    }
    
    // Método para obtener el resultado de la conversión
    public double getResultadoConversion() {
        return resultadoConversionTemperatura;
    }
	
}



