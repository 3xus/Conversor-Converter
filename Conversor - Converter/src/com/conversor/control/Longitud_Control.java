package com.conversor.control;

import com.conversor.gui.Longitud_GUI;
import com.conversor.logica.Longitud_Logica;

public class Longitud_Control {
	
	private Longitud_Logica logica = new Longitud_Logica();
	private String resultadoConversionLongitud;
	private Longitud_GUI interfaz;
	
	public Longitud_Control(Longitud_GUI interfaz) {
        this.interfaz = interfaz;
    }
	
	// Método para recibir los datos recolectados en la interfaz
    public void datosColectadosGUI(String unidadOrigen, String unidadDestino, double cantidadLongitudNumero) {
        // Llamamos al método de la lógica para realizar la conversión
    	resultadoConversionLongitud = logica.convertirLongitud(cantidadLongitudNumero, unidadOrigen, unidadDestino);
    	
    	// Llamamos a un método en la instancia de Longitud_GUI para actualizar la interfaz
    	interfaz.mostrarResultadoConversion(String.valueOf(resultadoConversionLongitud));

    }
    
    // Método para obtener el resultado de la conversión
    public String getResultadoConversion() {
        return resultadoConversionLongitud;
    }

}
