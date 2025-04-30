package ar.edu.unlam.herencia;

import static org.junit.Assert.*;
import org.junit.Test;

public class test {

    @Test
    public void testBicicletaConUnSoloDestino() {
        Bicicleta bici = new Bicicleta();
        Destino d1 = new Destino("Lanús");
        Destino d2 = new Destino("Avellaneda");

        Paquete p1 = new Paquete(0.5, 0.5, 0.5, 5, d1); 
        Paquete p2 = new Paquete(0.5, 0.5, 0.5, 5, d1);
        Paquete p3 = new Paquete(0.5, 0.5, 0.5, 5, d2);

        assertTrue(bici.agregarPaquete(p1));
        assertTrue(bici.agregarPaquete(p2));
        assertFalse(bici.agregarPaquete(p3));
    }

    @Test
    public void testAutomovilConTresDestinos() {
        Automovil auto = new Automovil();
        Destino d1 = new Destino("Lanús");
        Destino d2 = new Destino("Avellaneda");
        Destino d3 = new Destino("Quilmes");
        Destino d4 = new Destino("Lomas");

        Paquete p1 = new Paquete(1, 1, 1, 100, d1); // 1 m3
        Paquete p2 = new Paquete(0.5, 1, 1, 100, d2); // 0.5 m3
        Paquete p3 = new Paquete(0.5, 0.5, 1, 100, d3); // 0.25 m3
        Paquete p4 = new Paquete(0.5, 0.5, 0.5, 50, d4); // 0.125 m3

        assertTrue(auto.agregarPaquete(p1));
        assertTrue(auto.agregarPaquete(p2));
        assertTrue(auto.agregarPaquete(p3));
        assertFalse(auto.agregarPaquete(p4));
    }

    @Test
    public void testCamionConMuchosPaquetes() {
        Camion camion = new Camion();
        Destino d1 = new Destino("CABA");

        for (int i = 0; i < 50; i++) {
            Paquete p = new Paquete(0.5, 0.5, 0.5, 100, d1); // 0.125 m3
            camion.agregarPaquete(p);
        }

        assertTrue(camion.getVolumenOcupado() <= 20);
        assertTrue(camion.getPesoOcupado() <= 16000);
    }
}
