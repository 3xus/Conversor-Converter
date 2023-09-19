package com.conversor.logica;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class Monedas_Logica {
	private static final Map<String, Double> tasasCambio = new HashMap<>();

    static {
        // Tasas de cambio con respecto al Peso Mexicano (MXN)
        tasasCambio.put("Peso Mexicano (MXN)", 1.0);
        tasasCambio.put("Dolar Estadounidense (USD)", 0.058); 
        tasasCambio.put("Libra Esterlina (GBP)", 0.047); 
        tasasCambio.put("Euro (EUR)", 0.055); 
        tasasCambio.put("Yen Japonés (JPY)", 8.61); 
        tasasCambio.put("Won Surcoreano (KRW)", 77.17); 
        
    }

    public static String convertirMoneda(double cantidad, String monedaOrigen, String monedaDestino) {
        if (cantidad < 0) {
        	JOptionPane.showMessageDialog(null, "La cantidad de monetaria debe ser mayor o igual a 0.");
            return "-1";
        }

        double tasaOrigen = tasasCambio.getOrDefault(monedaOrigen, -1.0);
        double tasaDestino = tasasCambio.getOrDefault(monedaDestino, -1.0);
        

        if (tasaOrigen >= 0 && tasaDestino >= 0) {
            double resultadoConversion = (cantidad / tasaOrigen) * tasaDestino;
            return String.valueOf(resultadoConversion);
        } else {
            return "No se pudo realizar la conversión.";
        }
    }

}
