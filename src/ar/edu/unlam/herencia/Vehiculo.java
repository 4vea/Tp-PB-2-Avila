package ar.edu.unlam.herencia;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehiculo {
    protected List<Paquete> paquetes = new ArrayList<>();
    protected double volumenMaximo;
    protected double pesoMaximo;

    public boolean puedeAgregarPaquete(Paquete p) {
        return (getVolumenOcupado() + p.getVolumen() <= volumenMaximo) &&
               (getPesoOcupado() + p.getPeso() <= pesoMaximo);
    }

    public boolean agregarPaquete(Paquete p) {
        if (puedeAgregarPaquete(p)) {
            paquetes.add(p);
            return true;
        }
        return false;
    }

    public double getVolumenOcupado() {
        return paquetes.stream().mapToDouble(Paquete::getVolumen).sum();
    }

    public double getPesoOcupado() {
        return paquetes.stream().mapToDouble(Paquete::getPeso).sum();
    }
}
