package controller;

import java.io.File;
import java.util.Set;

import model.Model_Grafo;
import view.View;

public class Controller {
    private Model_Grafo grafo;
    private View vista;

    public Controller(Model_Grafo grafo, View vista) {
        this.grafo = grafo;
        this.vista = vista;

//        vista.agregarControlador(this);
    }

    public void cargarDesdeArchivo(File archivo) {
        grafo.cargarDesdeArchivo(archivo.getAbsolutePath());
    }

    public void encontrarConjuntoDominante() {
        Set<String> conjuntoDominante = grafo.conjuntoDominanteMinimo();
        vista.actualizarResultado("Conjunto Dominante Mínimo: " + conjuntoDominante);
    }

    public static void main(String[] args) {
    	Model_Grafo grafo = new Model_Grafo();
    	View vista = new View();
        Controller controlador = new Controller(grafo, vista);

        vista.iniciar();
    }
}

