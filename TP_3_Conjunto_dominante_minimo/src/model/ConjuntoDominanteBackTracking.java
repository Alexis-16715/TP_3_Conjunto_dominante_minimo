package model;

import java.util.HashSet;
import java.util.Set;


public class ConjuntoDominanteBackTracking {
	
    public static Set<Integer> calcularConjuntoDominanteBacktracking(Model_Grafo grafo) {
        Set<Integer> conjuntoDominante = new HashSet<>();
        Set<Integer> mejorConjunto = new HashSet<>();
        backtracking(grafo, conjuntoDominante, mejorConjunto, 0);
        return mejorConjunto;
    }

    private static void backtracking(Model_Grafo grafo, Set<Integer> conjuntoDominante, Set<Integer> mejorConjunto, int indice) {
        if (indice == grafo.getVertices().size()) {
            if (esConjuntoDominante(grafo, conjuntoDominante) && (mejorConjunto.isEmpty() || conjuntoMenorQueOtro(conjuntoDominante, mejorConjunto))) {
                mejorConjunto.clear();
                mejorConjunto.addAll(conjuntoDominante);
            }
            return;
        }
        
        //BACKTRACKING: 
        //Si el conjunto dominante es mayor que la mitad del tamaño hay alguno de más. 
        //Si el conjuntoDominante es mayor que el mejorConjunto actual se corta.
    	if(conjuntoDominante.size() > grafo.tamano()/2 || (!mejorConjunto.isEmpty() && !conjuntoMenorQueOtro(conjuntoDominante, mejorConjunto)))
    		return;
    	
        // Incluir vertice actual en el conjunto dominante
        conjuntoDominante.add(indice);
        backtracking(grafo, conjuntoDominante, mejorConjunto, indice + 1);
        conjuntoDominante.remove(indice); // No incluir vertice actual en el conjunto dominante
        backtracking(grafo, conjuntoDominante, mejorConjunto, indice + 1);
    }

    private static boolean esConjuntoDominante(Model_Grafo grafo, Set<Integer> conjuntoDominante) {
        Set<Integer> verticesNoCubiertos = new HashSet<>(grafo.getVertices());
        for (int vertice : conjuntoDominante) {
            verticesNoCubiertos.remove(vertice);
            for (int adyacente : grafo.getNeightbours(vertice)) {
                verticesNoCubiertos.remove(adyacente);
            }
        }
        return verticesNoCubiertos.isEmpty();
    }

	private static boolean conjuntoMenorQueOtro(Set<Integer> conjunto1, Set<Integer> conjunto2) {
		return conjunto1.size() < conjunto2.size();
	}
}
