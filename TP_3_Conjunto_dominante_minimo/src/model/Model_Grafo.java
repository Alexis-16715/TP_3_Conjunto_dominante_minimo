package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Model_Grafo {
    private Set<String> vertices;
    private Set<Arista> aristas;

    public Model_Grafo() {
        vertices = new HashSet<>();
        aristas = new HashSet<>();
    }

    public void agregarVertice(String vertice) {
        vertices.add(vertice);
    }

    public void agregarArista(String v1, String v2) {
        aristas.add(new Arista(v1, v2));
    }

    public Set<String> conjuntoDominanteMinimo() {
        Set<String> conjuntoDominante = new HashSet<>();
        Set<Arista> aristasNoCubiertas = new HashSet<>(aristas);

        while (!aristasNoCubiertas.isEmpty()) {
            String mejorVertice = null;
            int maxCubiertos = 0;

            for (String vertice : vertices) {
                if (!conjuntoDominante.contains(vertice)) {
                    int cubiertos = contarAristasCubiertas(vertice, conjuntoDominante, aristasNoCubiertas);

                    if (cubiertos > maxCubiertos) {
                        maxCubiertos = cubiertos;
                        mejorVertice = vertice;
                    }
                }
            }

            if (mejorVertice != null) {
                conjuntoDominante.add(mejorVertice);
                eliminarAristasCubiertas(mejorVertice, conjuntoDominante, aristasNoCubiertas);
            }
        }

        return conjuntoDominante;
    }
    
    private int contarAristasCubiertas(String vertice, Set<String> conjuntoDominante, Set<Arista> aristasNoCubiertas) {
        int cubiertos = 0;
        for (Arista arista : aristasNoCubiertas) {
            if (arista.getVertice1().equals(vertice) || arista.getVertice2().equals(vertice)) {
                cubiertos++;
            } else if (conjuntoDominante.contains(arista.getVertice1()) || conjuntoDominante.contains(arista.getVertice2())) {
                cubiertos++;
            }
        }
        return cubiertos;
    }

    private void eliminarAristasCubiertas(String vertice, Set<String> conjuntoDominante, Set<Arista> aristasNoCubiertas) {
        Set<Arista> aristasAEliminar = new HashSet<>();

        for (Arista arista : aristasNoCubiertas) {
            if (arista.getVertice1().equals(vertice) || arista.getVertice2().equals(vertice)) {
                aristasAEliminar.add(arista);
            }
        }

        aristasNoCubiertas.removeAll(aristasAEliminar);
    }



    public void cargarDesdeArchivo(String nombreArchivo) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            String linea;

            while ((linea = br.readLine()) != null) {
                if (linea.contains(",")) {
                    String[] partes = linea.split(",");
                    if (partes.length == 2) {
                        agregarArista(partes[0], partes[1]);
                    }
                } else {
                    agregarVertice(linea);
                }
            }

            br.close();
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
        }
    }
    
    
    public Set<String> getVertices() {
        return vertices;
    }

    public Set<Arista> getAristas() {
        return aristas;
    }
    
    
}

