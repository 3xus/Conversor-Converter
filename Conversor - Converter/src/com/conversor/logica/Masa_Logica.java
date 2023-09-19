package com.conversor.logica;

import javax.swing.JOptionPane;

public class Masa_Logica {
    public static double convertirMasa(double cantidad, String unidadOrigen, String unidadDestino) {
    	
    	if (cantidad < 0) {
    		JOptionPane.showMessageDialog(null, "La cantidad de masa debe ser mayor o igual a 0.");
            return -1;        
        }
    	
    	double resultadoConversionMasa = 0.0;

        if (unidadOrigen.equals("Kilogramos (kg)")) {
            if (unidadDestino.equals("Gramos (g)")) {
                resultadoConversionMasa = cantidad * 1000;
            } else if (unidadDestino.equals("Libras (lb)")) {
                resultadoConversionMasa = cantidad * 2.20462;
            } else if (unidadDestino.equals("Onzas (oz)")) {
                resultadoConversionMasa = cantidad * 35.274;
            } else {
                resultadoConversionMasa = cantidad; // Misma unidad de masa
            }
        } else if (unidadOrigen.equals("Gramos (g)")) {
            if (unidadDestino.equals("Kilogramos (kg)")) {
                resultadoConversionMasa = cantidad / 1000;
            } else if (unidadDestino.equals("Libras (lb)")) {
                resultadoConversionMasa = cantidad / 453.592;
            } else if (unidadDestino.equals("Onzas (oz)")) {
                resultadoConversionMasa = cantidad / 28.3495;
            } else {
                resultadoConversionMasa = cantidad; // Misma unidad de masa
            }
        } else if (unidadOrigen.equals("Libras (lb)")) {
            if (unidadDestino.equals("Kilogramos (kg)")) {
                resultadoConversionMasa = cantidad / 2.20462;
            } else if (unidadDestino.equals("Gramos (g)")) {
                resultadoConversionMasa = cantidad * 453.592;
            } else if (unidadDestino.equals("Onzas (oz)")) {
                resultadoConversionMasa = cantidad * 16;
            } else {
                resultadoConversionMasa = cantidad; // Misma unidad de masa
            }
        } else if (unidadOrigen.equals("Onzas (oz)")) {
            if (unidadDestino.equals("Kilogramos (kg)")) {
                resultadoConversionMasa = cantidad / 35.274;
            } else if (unidadDestino.equals("Gramos (g)")) {
                resultadoConversionMasa = cantidad * 28.3495;
            } else if (unidadDestino.equals("Libras (lb)")) {
                resultadoConversionMasa = cantidad / 16;
            } else {
                resultadoConversionMasa = cantidad; // Misma unidad de masa
            }
        }

        return resultadoConversionMasa;
    }
}

