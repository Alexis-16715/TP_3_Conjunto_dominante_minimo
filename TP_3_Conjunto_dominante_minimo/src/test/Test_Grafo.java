package test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import model.Arista;
import model.Model_Grafo;


public class Test_Grafo {
    private Model_Grafo grafo;

    @Before
    public void setUp() {
        grafo = new Model_Grafo();
    }

    @Test
    public void testAgregarVertice() {
        grafo.AddVertice("A");
        assertTrue(grafo.getVertices().contains("A"));
    }

    @Test
    public void testAgregarArista() {
        grafo.AddVertice("A");
        grafo.AddVertice("B");
        grafo.addArista("A", "B");

        assertTrue(grafo.getAristas().contains(new Arista("A", "B")));
    }

    @Test
    public void testConjuntoDominanteMinimo() {
        grafo.AddVertice("A");
        grafo.AddVertice("B");
        grafo.AddVertice("C");
        grafo.AddVertice("D");
        grafo.addArista("A", "B");
        grafo.addArista("B", "C");
        grafo.addArista("C", "D");

        Set<String> conjuntoDominante = grafo.setDominantMinimum();
        assertEquals(2, conjuntoDominante.size());
        assertTrue(conjuntoDominante.contains("B"));
        assertTrue(conjuntoDominante.contains("C"));
    }
    
    @Test
    public void testConjuntoDominanteMinimo2() {
        // Construye un grafo con vértices y aristas
        grafo.AddVertice("1");
        grafo.AddVertice("2");
        grafo.AddVertice("3");
        grafo.AddVertice("4");
        grafo.AddVertice("5");
        grafo.AddVertice("6");

        grafo.addArista("6", "4");
        grafo.addArista("4", "2");
        grafo.addArista("4", "5");
        grafo.addArista("2", "3");

        // Encuentra el conjunto dominante mínimo
        Set<String> conjuntoDominante = grafo.setDominantMinimum();

        // Verifica que el conjunto dominante mínimo sea correcto
        Set<String> conjuntoDominanteEsperado = new HashSet<>();
        conjuntoDominanteEsperado.add("2");
        conjuntoDominanteEsperado.add("4");

        assertEquals(conjuntoDominanteEsperado, conjuntoDominante);
    }
    
}

