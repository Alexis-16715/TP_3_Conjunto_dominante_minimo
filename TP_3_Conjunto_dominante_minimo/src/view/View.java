package view;



import model.Model_Grafo;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class View {
    private JFrame frame;
    private JTextField verticeField;
    private JTextField aristaField;
    private JTextArea resultadoArea;

    public View() {
    }


    public void iniciar() {
        frame = new JFrame("Conjunto Dominante Mínimo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel verticeLabel = new JLabel("Vértice:");
        verticeField = new JTextField(10);
        JLabel aristaLabel = new JLabel("Arista (v1,v2):");
        aristaField = new JTextField(10);

        JButton agregarVerticeButton = new JButton("Agregar Vértice");

        JButton agregarAristaButton = new JButton("Agregar Arista");

        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);

        JButton encontrarConjuntoButton = new JButton("Encontrar Conjunto Dominante");

        JButton cargarArchivoButton = new JButton("Cargar desde archivo");
        

        panel.add(verticeLabel);
        panel.add(verticeField);
        panel.add(aristaLabel);
        panel.add(aristaField);
        panel.add(agregarVerticeButton);
        panel.add(agregarAristaButton);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(resultadoArea, BorderLayout.CENTER);
        frame.add(encontrarConjuntoButton, BorderLayout.SOUTH);
        frame.add(cargarArchivoButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public void actualizarResultado(String resultado) {
        resultadoArea.setText(resultado);
    }
}

