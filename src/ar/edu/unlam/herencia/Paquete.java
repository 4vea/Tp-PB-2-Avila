package ar.edu.unlam.herencia;

public class Paquete {
    private double alto, ancho, profundo, peso;
    private Destino destino;

    public Paquete(double alto, double ancho, double profundo, double peso, Destino destino) {
        this.alto = alto;
        this.ancho = ancho;
        this.profundo = profundo;
        this.peso = peso;
        this.destino = destino;
    }

    public double getVolumen() {
        return alto * ancho * profundo;
    }

    public double getPeso() {
        return peso;
    }

    public Destino getDestino() {
        return destino;
    }
}
