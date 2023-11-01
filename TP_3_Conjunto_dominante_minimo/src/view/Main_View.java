package view;


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

import javax.swing.JFileChooser;


public class Main_View {
    private JFrame frame;
    private JTextField verticeField;
    private JTextField aristaField;
    private JTextArea resultadoArea;
    
    private JLabel vertexLabel;
    private JLabel aristaLabel;
    
    
    private JButton addVerticeButton;
    private JButton addAristaButton;
    
    private JButton findingDominatButton;
    private JButton fieldUploadButton;
    
    
    
    private JFileChooser fileChooser;

    public Main_View() {
    	initialize();
    }


    public void initialize() {
        frame = new JFrame("Minimal Dominant Set");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        vertexLabel = new JLabel("Vertex:");
        verticeField = new JTextField(10);
        aristaLabel = new JLabel("Arista (v1,v2):");
        aristaField = new JTextField(10);

        addVerticeButton = new JButton("Add Vertex");

        addAristaButton = new JButton("Add Arista");

        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);

        findingDominatButton = new JButton("Finding Dominant Set");

        fieldUploadButton = new JButton("Load from file");
        

        panel.add(vertexLabel);
        panel.add(verticeField);
        panel.add(aristaLabel);
        panel.add(aristaField);
        panel.add(addVerticeButton);
        panel.add(addAristaButton);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(resultadoArea, BorderLayout.CENTER);
        frame.add(findingDominatButton, BorderLayout.SOUTH);
        frame.add(fieldUploadButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
    
    

    public void actualizarResultado(String resultado) {
        resultadoArea.setText(resultado);
    }


	public JFrame getFrame() {
		return frame;
	}


	public JTextField getVerticeField() {
		return verticeField;
	}


	public JTextField getAristaField() {
		return aristaField;
	}


	public JTextArea getResultadoArea() {
		return resultadoArea;
	}


	public JLabel getVertexLabel() {
		return vertexLabel;
	}


	public JLabel getAristaLabel() {
		return aristaLabel;
	}


	public JButton getAddVerticeButton() {
		return addVerticeButton;
	}


	public JButton getAddAristaButton() {
		return addAristaButton;
	}


	public JButton getFindingDominatButton() {
		return findingDominatButton;
	}


	public JButton getFieldUploadButton() {
		return fieldUploadButton;
	}
    
    
    
}
