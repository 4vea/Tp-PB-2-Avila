package ar.edu.unlam.herencia;

public class Destino {
    private String ciudad;

    public Destino(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCiudad() {
        return ciudad;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Destino destino = (Destino) obj;
        return ciudad.equals(destino.ciudad);
    }

    @Override
    public int hashCode() {
        return ciudad.hashCode();
    }
}
