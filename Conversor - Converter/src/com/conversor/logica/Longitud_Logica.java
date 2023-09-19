package com.conversor.logica;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class Longitud_Logica {
    
	private static final Map<String, Double> unidadesConversion = new HashMap<>();

    static {
        unidadesConversion.put("Milímetros", 0.001);
        unidadesConversion.put("Centímetros", 0.01);
        unidadesConversion.put("Metros", 1.0);
        unidadesConversion.put("Kilómetros", 1000.0);
        unidadesConversion.put("Pulgadas", 0.0254);
        unidadesConversion.put("Pies", 0.3048);
        unidadesConversion.put("Yardas", 0.9144);
        unidadesConversion.put("Milla", 1609.34);
        
    }

    public static String convertirLongitud(double cantidad, String unidadOrigen, String unidadDestino) {
        if (cantidad < 0) {
        	JOptionPane.showMessageDialog(null, "La cantidad de longitud debe ser mayor o igual a 0.");
            return "-1";
        }

        double resultadoLongitud = -1.0; // Valor por defecto si no se puede realizar la conversión

        // Verificar si las unidades son válidas
        if (unidadesConversion.containsKey(unidadOrigen) && unidadesConversion.containsKey(unidadDestino)) {
            double factorOrigen = unidadesConversion.get(unidadOrigen);
            double factorDestino = unidadesConversion.get(unidadDestino);

            resultadoLongitud = cantidad * (factorOrigen / factorDestino);
        }

        if (resultadoLongitud >= 0) {
            return String.valueOf(resultadoLongitud);
        } else {
            return "No se pudo realizar la conversión.";
        }
    }
}

