package ar.edu.unlam.pb2;

public class Bicicleta extends Vehiculo {
    private Destino destino;

    public Bicicleta(Integer id) {
        super(id);
        this.volumenMaximo = 0.125 * 2;
        this.pesoMaximo = 15.0;
        this.destino = null;
    }

    @Override
    public boolean puedeTransportar(Paquete paquete) {
        if (this.paquetes.size() >= 2) return false;
        if (paquete.getVolumen() > 0.125 || paquete.getPeso() > 15.0) return false;

        if (this.destino == null) {
            this.destino = paquete.getDestino();
        } else if (!this.destino.equals(paquete.getDestino())) {
            return false;
        }

        return agregarPaquete(paquete);
    }
}
