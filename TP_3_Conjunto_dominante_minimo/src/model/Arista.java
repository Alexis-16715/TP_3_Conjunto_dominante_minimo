package model;

public class Arista {
    private String vertice1;
    private String vertice2;

    public Arista(String vertice1, String vertice2) {
        this.vertice1 = vertice1;
        this.vertice2 = vertice2;
    }

    public String getVertice1() {
        return vertice1;
    }

    public String getVertice2() {
        return vertice2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Arista arista = (Arista) o;
        return (vertice1.equals(arista.vertice1) && vertice2.equals(arista.vertice2)) ||
               (vertice1.equals(arista.vertice2) && vertice2.equals(arista.vertice1));
    }

    @Override
    public int hashCode() {
        int result = vertice1.hashCode() + vertice2.hashCode();
        return result;
    }
}

