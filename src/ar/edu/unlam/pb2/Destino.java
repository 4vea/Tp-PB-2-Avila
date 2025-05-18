package ar.edu.unlam.pb2;

public class Destino {
    private String nombre;

    public Destino(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean equals(Object otro) {
        if (this == otro) return true;
        if (otro == null || getClass() != otro.getClass()) return false;

        Destino destino = (Destino) otro;
        return this.nombre.equals(destino.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }
}
