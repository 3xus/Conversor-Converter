package com.conversor.logica;

public class Temperatura_Logica {

    public static double convertirTemperatura(double cantidad, String unidadOrigen, String unidadDestino) {
        double resultadoTemperatura = 0.0;

        if (unidadOrigen.equals("Celcius (°C)")) {
            if (unidadDestino.equals("Fahrenheit (°F)")) {
            	resultadoTemperatura = (cantidad * 9/5) + 32;
            } else if (unidadDestino.equals("Kelvin (K)")) {
            	resultadoTemperatura = cantidad + 273.15;
            } else {
            	resultadoTemperatura = cantidad; // Misma unidad de temperatura
            }
        } else if (unidadOrigen.equals("Fahrenheit (°F)")) {
            if (unidadDestino.equals("Celcius (°C)")) {
            	resultadoTemperatura = (cantidad - 32) * 5/9;
            } else if (unidadDestino.equals("Kelvin (K)")) {
            	resultadoTemperatura = ((cantidad - 32) * 5/9) + 273.15;
            } else {
            	resultadoTemperatura = cantidad; // Misma unidad de temperatura
            }
        } else if (unidadOrigen.equals("Kelvin (K)")) {
            if (unidadDestino.equals("Celcius (°C)")) {
            	resultadoTemperatura = cantidad - 273.15;
            } else if (unidadDestino.equals("Fahrenheit (°F)")) {
            	resultadoTemperatura = ((cantidad - 273.15) * 9/5) + 32;
            } else {
            	resultadoTemperatura = cantidad; // Misma unidad de temperatura
            }
        }

        return resultadoTemperatura;
    }
}


