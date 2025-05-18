package ar.edu.unlam.pb2;

public class Camion extends Vehiculo {
    private String patente;

    public Camion(String patente) {
        super(null); // No usa id
        this.patente = patente;
        this.volumenMaximo = 20.0;
        this.pesoMaximo = 16000.0;
    }

    public String getPatente() {
        return this.patente;
    }

    @Override
    public boolean puedeTransportar(Paquete paquete) {
        if (getVolumenTotalCargado() + paquete.getVolumen() > volumenMaximo) return false;
        if (getPesoTotalCargado() + paquete.getPeso() > pesoMaximo) return false;
        return agregarPaquete(paquete);
    }
}
