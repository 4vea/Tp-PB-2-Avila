package ar.edu.unlam.pb2;

import java.util.ArrayList;

public abstract class Vehiculo {
    protected Integer id;
    protected Double volumenMaximo;
    protected Double pesoMaximo;
    protected ArrayList<Paquete> paquetes;

    public Vehiculo(Integer id) {
        this.id = id;
        this.paquetes = new ArrayList<Paquete>();
    }

    public Integer getId() {
        return id;
    }

    public boolean agregarPaquete(Paquete p) {
        this.paquetes.add(p);
        return true;
    }

    protected Double getVolumenTotalCargado() {
        Double total = 0.0;
        for (int i = 0; i < paquetes.size(); i++) {
            total += paquetes.get(i).getVolumen();
        }
        return total;
    }

    protected Double getPesoTotalCargado() {
        Double total = 0.0;
        for (int i = 0; i < paquetes.size(); i++) {
            total += paquetes.get(i).getPeso();
        }
        return total;
    }

    public abstract boolean puedeTransportar(Paquete paquete);
}
