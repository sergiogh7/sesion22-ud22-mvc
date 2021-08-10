package main;

import controladores.Controlador;
import modelos.Modelo;
import vistas.Vista;

public class mainApp {

	public static void main(String[] args) {
		
//		Instancia el modelo, la vista y el controlador.
		Modelo modelo = new Modelo();
		Vista vista = new Vista();
		Controlador controlador = new Controlador(modelo, vista);
		
//		Ejecuta la vista.
		controlador.ejecutarVista();

	}

}