package com.conversor.control;

import com.conversor.gui.Conversor_GUI;
import com.conversor.gui.Longitud_GUI;
import com.conversor.gui.Masa_GUI;
import com.conversor.gui.Monedas_GUI;
import com.conversor.gui.Temperatura_GUI;

public class Main_Conversor {
    private Conversor_GUI ventanaConversor;
    private Monedas_GUI ventanaMonedas;
    private Masa_GUI ventanaMasa;
    private Temperatura_GUI ventanaTemperatura;
    private Longitud_GUI ventanaLongitud;

    public Main_Conversor() {
    	ventanaMonedas = new Monedas_GUI(ventanaConversor); 
    	ventanaMasa = new Masa_GUI(ventanaConversor); 
    	ventanaTemperatura = new Temperatura_GUI(ventanaConversor); 
    	ventanaLongitud = new Longitud_GUI(ventanaConversor); 
        ventanaConversor = new Conversor_GUI(ventanaMonedas, ventanaMasa, ventanaTemperatura, ventanaLongitud); 
    	        
    }

    public static void main(String[] args) {
        Main_Conversor app = new Main_Conversor();
        app.iniciar();
    }

    public void iniciar() {
        ventanaConversor.setVisible(true);
    }
}
