package com.conversor.control;

import com.conversor.gui.Monedas_GUI;
import com.conversor.logica.Monedas_Logica;

public class Monedas_Control {
	
	private Monedas_Logica logica = new Monedas_Logica();
	private String resultadoConversionMoneda;
	private Monedas_GUI interfaz;
	
	public Monedas_Control(Monedas_GUI interfaz) {
        this.interfaz = interfaz;
    }
	
	// Método para recibir los datos recolectados en la interfaz
    public void datosColectadosGUI(String unidadOrigen, String unidadDestino, double cantidadMonedaNumero) {
        // Llamamos al método de la lógica para realizar la conversión
    	resultadoConversionMoneda = logica.convertirMoneda(cantidadMonedaNumero, unidadOrigen, unidadDestino);
    	
    	// Llamamos a un método en la instancia de Monedas_GUI para actualizar la interfaz
    	interfaz.mostrarResultadoConversion(String.valueOf(resultadoConversionMoneda));

    }
    
    // Método para obtener el resultado de la conversión
    public String getResultadoConversion() {
        return resultadoConversionMoneda;
    }

}
