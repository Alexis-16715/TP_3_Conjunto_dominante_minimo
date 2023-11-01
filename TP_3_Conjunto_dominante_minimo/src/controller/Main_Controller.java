package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import model.Model_Grafo;
import view.Main_View;





public class Main_Controller {
    private Model_Grafo grafo;
    private Main_View view;
    
    private JTextField verticeField;
    private JTextField aristaField;
    private JTextArea resultadoArea;
    
    private JLabel vertexLabel;
    private JLabel aristaLabel;
    
    
    private JButton addVerticeButton;
    private JButton addAristaButton;
    
    private JButton findingDominatButton;
    private JButton fieldUploadButton;
    
    
    

    public Main_Controller(Model_Grafo grafo, Main_View view) {
        this.grafo = grafo;
        this.view = view;
        
        attachListenersMain();

//        vista.agregarControlador(this);
    }
    
    private void attachListenersMain() {
    	verticeField = view.getVerticeField();
        aristaField = view.getAristaField();
        resultadoArea = view.getResultadoArea();
        
        vertexLabel = view.getVertexLabel();
        aristaLabel = view.getAristaLabel();
        
        
        addVerticeButton = view.getAddVerticeButton();
        addAristaButton = view.getAddAristaButton();
        
        findingDominatButton = view.getFindingDominatButton();
        fieldUploadButton = view.getFieldUploadButton();
        
        addVerticeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String vertice = verticeField.getText().trim();
                if (!vertice.isEmpty()) {
                	grafo.AddVertice(vertice);
                    verticeField.setText("");
                }
            }
        });
        
        addAristaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] arista = aristaField.getText().trim().split(",");
                if (arista.length == 2) {
                    grafo.addArista(arista[0], arista[1]);
                    aristaField.setText("");
                }
            }
        });
        
        
        findingDominatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findSetDominant();
            }
        });
        
        
        fieldUploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File archivoSeleccionado = fileChooser.getSelectedFile();
                    loadFromFile(archivoSeleccionado);
                }
            }
        });
        
        
        
        
    }

    public void loadFromFile(File archivo) {
        grafo.loadFromFile(archivo.getAbsolutePath());
    }
    
    
    //Esto se tendria que cambiar de lugar para que cumpla con MVC

    public void findSetDominant() {
        Set<String> conjuntoDominante = grafo.setDominantMinimum();
        view.actualizarResultado("Conjunto Dominante Mínimo: " + conjuntoDominante);
    }
    
    
    

    public static void main(String[] args) {
    	
    	SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Main_View view = new Main_View();
            	Model_Grafo grafo = new Model_Grafo();
            	
                new Main_Controller(grafo, view);
            	
            }
        });

	}
    
}

