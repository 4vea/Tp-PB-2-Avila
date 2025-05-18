package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Empresa {
    private String nombre;
    private List<Vehiculo> vehiculos;
    private Set<String> patentesRegistradas;
    private Set<Integer> idsRegistrados;

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.vehiculos = new ArrayList<Vehiculo>();
        this.patentesRegistradas = new HashSet<String>();
        this.idsRegistrados = new HashSet<Integer>();
    }

    public boolean agregarVehiculo(Vehiculo v) {
        if (v instanceof Automovil) {
            String patente = ((Automovil) v).getPatente();
            if (patentesRegistradas.contains(patente)) {
                return false;
            }
            patentesRegistradas.add(patente);
        } else if (v instanceof Camion) {
            String patente = ((Camion) v).getPatente();
            if (patentesRegistradas.contains(patente)) {
                return false;
            }
            patentesRegistradas.add(patente);
        } else if (v instanceof Bicicleta) {
            Integer id = v.getId();
            if (id == null || idsRegistrados.contains(id)) {
                return false;
            }
            idsRegistrados.add(id);
        }

        vehiculos.add(v);
        return true;
    }

    public boolean agregarPaqueteA(Integer idVehiculo, Paquete paquete) {
        Vehiculo v = buscarVehiculoPorId(idVehiculo);
        if (v != null) {
            return v.puedeTransportar(paquete);
        }
        return false;
    }

    public boolean agregarPaquetePorPatente(String patente, Paquete paquete) {
        for (Vehiculo v : this.vehiculos) {
            if (v instanceof Automovil) {
                Automovil auto = (Automovil) v;
                if (auto.getPatente().equals(patente)) {
                    return auto.puedeTransportar(paquete);
                }
            } else if (v instanceof Camion) {
                Camion camion = (Camion) v;
                if (camion.getPatente().equals(patente)) {
                    return camion.puedeTransportar(paquete);
                }
            }
        }
        return false;
    }

    public Vehiculo buscarVehiculoPorId(Integer idVehiculo) {
        for (Vehiculo v : vehiculos) {
            if (v.getId() != null && v.getId().equals(idVehiculo)) {
                return v;
            }
        }
        return null;
    }

    public int getCantidadDeVehiculos() {
        return this.vehiculos.size();
    }

    public List<Vehiculo> getVehiculos() {
        return this.vehiculos;
    }

	public String getNombre() {
		return nombre;
	}
}
