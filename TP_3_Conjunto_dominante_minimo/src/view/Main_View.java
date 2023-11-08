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
import javax.swing.SwingConstants;
import java.awt.Component;


public class Main_View {
    private JFrame frame;
    private JTextField verticeField;
    private JTextField aristaField;
    private JTextArea resultadoArea;
    private JTextArea resultadoArea2;
    
    private JLabel vertexLabel;
    private JLabel aristaLabel;
    
    
    private JButton addVerticeButton;
    private JButton addAristaButton;
    
    private JButton findingDominatButton;
    private JButton fieldUploadButton;
    
    
    
    private JFileChooser fileChooser;
    private final JButton btnNewButton = new JButton("New button");

    public Main_View() {
    	initialize();
    }


    public void initialize() {
        frame = new JFrame("Minimal Dominant Set");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 350);
        frame.getContentPane().setLayout(new BorderLayout());

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
        
        resultadoArea2 = new JTextArea();
        resultadoArea2.setEditable(false);

        findingDominatButton = new JButton("Finding Dominant Set");
        findingDominatButton.setBounds(10, 30, 200, 45);

        fieldUploadButton = new JButton("Load from file");
        

        panel.add(vertexLabel);
        panel.add(verticeField);
        panel.add(aristaLabel);
        panel.add(aristaField);
        panel.add(addVerticeButton);
        panel.add(addAristaButton);
        
        
        
        
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        frame.getContentPane().add(resultadoArea, BorderLayout.CENTER);
        frame.getContentPane().add(resultadoArea2, BorderLayout.CENTER);
//        frame.getContentPane().add(findingDominatButton, BorderLayout.WEST);
        frame.getContentPane().add(fieldUploadButton, BorderLayout.SOUTH);
        
        frame.getContentPane().add(findingDominatButton, BorderLayout.EAST);
        
        frame.setVisible(true);
    }
    
    

    public void actualizarResultado(String resultado) {
        resultadoArea.setText(resultado);
    }
    
    public void actualizarResultado2(String resultado) {
        resultadoArea2.setText(resultado);
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
