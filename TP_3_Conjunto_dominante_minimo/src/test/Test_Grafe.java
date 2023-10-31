package test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import model.Arista;
import model.Model_Grafo;


public class Test_Grafe {
    private Model_Grafo grafo;

    @Before
    public void setUp() {
        grafo = new Model_Grafo();
    }

    @Test
    public void testAgregarVertice() {
        grafo.agregarVertice("A");
        assertTrue(grafo.getVertices().contains("A"));
    }

    @Test
    public void testAgregarArista() {
        grafo.agregarVertice("A");
        grafo.agregarVertice("B");
        grafo.agregarArista("A", "B");

        assertTrue(grafo.getAristas().contains(new Arista("A", "B")));
    }

    @Test
    public void testConjuntoDominanteMinimo() {
        grafo.agregarVertice("A");
        grafo.agregarVertice("B");
        grafo.agregarVertice("C");
        grafo.agregarVertice("D");
        grafo.agregarArista("A", "B");
        grafo.agregarArista("B", "C");
        grafo.agregarArista("C", "D");

        Set<String> conjuntoDominante = grafo.conjuntoDominanteMinimo();
        assertEquals(2, conjuntoDominante.size());
        assertTrue(conjuntoDominante.contains("B"));
        assertTrue(conjuntoDominante.contains("C"));
    }
}
