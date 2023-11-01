package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Model_Grafo {
	
	//Advertencia no si la logica esta correcta, talvez este mal, con un 75%
    private Set<String> vertices;
    private Set<Arista> aristas;

    public Model_Grafo() {
        vertices = new HashSet<>();
        aristas = new HashSet<>();
    }

    public void AddVertice(String vertice) {
        vertices.add(vertice);
    }

    public void addArista(String v1, String v2) {
        aristas.add(new Arista(v1, v2));
    }

    public Set<String> setDominantMinimum() {
        Set<String> setDominant = new HashSet<>();
        
        Set<Arista> aristasNotCovered = new HashSet<>(aristas);

        while (!aristasNotCovered.isEmpty()) {
            String bestVertice = null;
            int maxCovered = 0;

            for (String vertice : vertices) {
                if (!setDominant.contains(vertice)) {
                    int covered = countAristasCovers(vertice, setDominant, aristasNotCovered);

                    if (covered > maxCovered) {
                        maxCovered = covered;
                        bestVertice = vertice;
                    }
                }
            }

            if (bestVertice != null) {
                setDominant.add(bestVertice);
                removeCoverAristas(bestVertice, setDominant, aristasNotCovered);
            }
        }

        return setDominant;
    }
    
    private int countAristasCovers(String vertice, Set<String> setDominant, Set<Arista> aristasNotCovered) {
        int cubiertos = 0;
        for (Arista arista : aristasNotCovered) {
            if (arista.getVertice1().equals(vertice) || arista.getVertice2().equals(vertice)) {
                cubiertos++;
            } else if (setDominant.contains(arista.getVertice1()) || setDominant.contains(arista.getVertice2())) {
                cubiertos++;
            }
        }
        return cubiertos;
    }

    private void removeCoverAristas(String vertice, Set<String> conjuntoDominante, Set<Arista> aristasNoCubiertas) {
        Set<Arista> aristasAEliminar = new HashSet<>();

        for (Arista arista : aristasNoCubiertas) {
            if (arista.getVertice1().equals(vertice) || arista.getVertice2().equals(vertice)) {
                aristasAEliminar.add(arista);
            }
        }

        aristasNoCubiertas.removeAll(aristasAEliminar);
    }



    public void loadFromFile(String nameOfTheFile) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(nameOfTheFile));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(",")) {
                    String[] partes = line.split(",");
                    if (partes.length == 2) {
                        addArista(partes[0], partes[1]);
                    }
                } else {
                    AddVertice(line);
                }
            }

            br.close();
        } catch (IOException e) {
            System.out.println("Error uploading file: " + e.getMessage());
        }
    }
    
    
    public Set<String> getVertices() {
        return vertices;
    }

    public Set<Arista> getAristas() {
        return aristas;
    }

    
    
}

