package ar.edu.unlam.herencia;

public class Bicicleta extends Vehiculo {
    private Destino destino;

    public Bicicleta() {
        this.volumenMaximo = 0.125 * 2;
        this.pesoMaximo = 15;
    }

    @Override
    public boolean agregarPaquete(Paquete p) {
        if (paquetes.size() >= 2) return false;
        if (destino == null) destino = p.getDestino();
        if (!destino.equals(p.getDestino())) return false;
        return super.agregarPaquete(p);
    }
}
