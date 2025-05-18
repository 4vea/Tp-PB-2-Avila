package ar.edu.unlam.pb2;

public class Paquete {
    private Double alto, ancho, profundo, peso;
    private Destino destino;

    public Paquete(Double alto, Double ancho, Double profundo, Double peso, Destino destino) {
        this.alto = alto;
        this.ancho = ancho;
        this.profundo = profundo;
        this.peso = peso;
        this.destino = destino;
    }

    public Double getVolumen() {
        return alto * ancho * profundo;
    }

    public Double getPeso() {
        return peso;
    }

    public Destino getDestino() {
        return destino;
    }
}
