package model;

public class Arista {
    private Integer vertice1;
    private Integer vertice2;

    public Arista(Integer vertice1, Integer vertice2) {
        this.vertice1 = vertice1;
        this.vertice2 = vertice2;
    }

    public Integer getVertice1() {
        return vertice1;
    }

    public Integer getVertice2() {
        return vertice2;
    }
    public boolean vertice1Equals(Integer vertice) {
    	if (vertice1 == vertice)
    		return true;
    	return false;
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

