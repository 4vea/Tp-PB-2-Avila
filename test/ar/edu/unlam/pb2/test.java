package ar.edu.unlam.pb2;

import static org.junit.Assert.*;
import org.junit.Test;

public class test{

    @Test
    public void queSePuedaAgregarUnaBicicletaALaEmpresa() {
        Empresa empresa = new Empresa("La transportadora");
        Vehiculo bici = new Bicicleta(1);
        
        assertTrue(empresa.agregarVehiculo(bici));
        
        assertEquals(1, empresa.getCantidadDeVehiculos());
        assertEquals(bici, empresa.buscarVehiculoPorId(1));
    }
    
    @Test
    public void queNoSePuedaAgregarDosBicicletasConElMismoId() {
        Empresa empresa = new Empresa("La transportadora");
        Vehiculo bici = new Bicicleta(1);
        Vehiculo bici2 = new Bicicleta(1);
        assertTrue(empresa.agregarVehiculo(bici));
        assertFalse(empresa.agregarVehiculo(bici2));
        assertEquals(1, empresa.getCantidadDeVehiculos());
        assertEquals(bici, empresa.buscarVehiculoPorId(1));
    }

    @Test
    public void queSePuedaAgregarPaqueteABicicletaExistente() {
        Empresa empresa = new Empresa("La transportadora");
        Bicicleta bici = new Bicicleta(10);
        empresa.agregarVehiculo(bici);

        Paquete paquete = new Paquete(0.5, 0.5, 0.5, 10.0, new Destino("Morón")); //0.125m3

        boolean resultado = empresa.agregarPaqueteA(10, paquete);

        assertTrue(resultado);
    }

    @Test
    public void queNoSePuedaAgregarPaqueteAVehiculoInexistente() {
        Empresa empresa = new Empresa("La transportadora");

        Paquete paquete = new Paquete(0.5, 0.5, 0.5, 10.0, new Destino("Morón"));
        boolean resultado = empresa.agregarPaqueteA(999, paquete);

        assertFalse(resultado);
    }

    @Test
    public void queBicicletaRechaceTercerPaquete() {
        Empresa empresa = new Empresa("La transportadora");
        Bicicleta bici = new Bicicleta(7);
        empresa.agregarVehiculo(bici);

        Destino destino = new Destino("Lanús");

        Paquete p1 = new Paquete(0.5, 0.5, 0.5, 12.0, destino);
        Paquete p2 = new Paquete(0.5, 0.5, 0.5, 13.0, destino);
        Paquete p3 = new Paquete(0.5, 0.5, 0.5, 10.0, destino);

        assertTrue(empresa.agregarPaqueteA(7, p1));
        assertTrue(empresa.agregarPaqueteA(7, p2));
        assertFalse(empresa.agregarPaqueteA(7, p3)); // ya tiene 2 paquetes
    }
    
    @Test
    public void queBicicletaRechaceDosPaquetesDeMasDeCeroPunto125m3CadaUno() {
        Empresa empresa = new Empresa("La transportadora");
        Bicicleta bici = new Bicicleta(7);
        empresa.agregarVehiculo(bici);

        Destino destino = new Destino("Lanús");

        Paquete p1 = new Paquete(0.5, 0.5, 0.5, 12.0, destino);//0.125
        Paquete p2 = new Paquete(0.5, 0.5, 0.6, 13.0, destino);//0.15

        assertTrue(empresa.agregarPaqueteA(7, p1));
        assertFalse(empresa.agregarPaqueteA(7, p2)); // 0.275 > 0.25
    }
    
    @Test
    public void queBicicletaRechaceMoverseFueraDeUnaCiudad() {
        Empresa empresa = new Empresa("La transportadora");
        Bicicleta bici = new Bicicleta(7);
        empresa.agregarVehiculo(bici);

        Destino destino = new Destino("Lanús");
        Destino destino2 = new Destino("San Justo");
        
        Paquete p1 = new Paquete(0.5, 0.5, 0.5, 12.0, destino);
        Paquete p2 = new Paquete(0.5, 0.5, 0.5, 13.0, destino2);

        assertTrue(empresa.agregarPaqueteA(7, p1));
        assertFalse(empresa.agregarPaqueteA(7, p2)); 
    }
    
    
    @Test
    public void queAutomovilPermitaAgregarPaquetesYAsignarDestinos() {
        Empresa empresa = new Empresa("La transportadora");
        Automovil auto = new Automovil("AAS123");
        empresa.agregarVehiculo(auto);

        assertTrue(auto.agregarDestino("San Justo"));
        assertTrue(auto.agregarDestino("Morón"));
        assertTrue(auto.agregarDestino("Lomas"));

        Paquete paquete = new Paquete(1.0, 1.0, 1.0, 100.0, new Destino("Lomas"));

        assertTrue(empresa.agregarPaquetePorPatente("AAS123", paquete)); 
    }

    @Test
    public void queAutomovilNoPermitaMasDeTresDestinosNiRepetidos() {
        Automovil auto = new Automovil("456LKA123");
        assertTrue(auto.agregarDestino("Quilmes"));
        assertTrue(auto.agregarDestino("Lanús"));
        assertTrue(auto.agregarDestino("Avellaneda"));

        assertFalse(auto.agregarDestino("Quilmes")); // repetido
        assertFalse(auto.agregarDestino("Berazategui")); // ya tiene 3
    }

    @Test
    public void queAutomovilRechacePaqueteSiExcedePeso() {
        Automovil auto1 = new Automovil("LOL123");
        
        assertTrue(auto1.agregarDestino("Quilmes"));
        assertTrue(auto1.agregarDestino("CABA"));
        
        Paquete p1 = new Paquete(1.0, 1.0, 1.0, 400.0, new Destino("Quilmes")); // 1 m3, 400 kg
        Paquete p2 = new Paquete(1.0, 1.0, 1.0, 150.0, new Destino("CABA")); // total 550 kg > 500

        assertTrue(auto1.puedeTransportar(p1));
        assertFalse(auto1.puedeTransportar(p2));
    }
    
    @Test
    public void queAutomovilRechacePaqueteSiExcedeVolumen() {
        Automovil auto1 = new Automovil("LOL123");
        
        assertTrue(auto1.agregarDestino("Quilmes"));
        assertTrue(auto1.agregarDestino("CABA"));
        
        Paquete p1 = new Paquete(1.0, 1.0, 1.0, 150.0, new Destino("Quilmes")); // 1 m3, 400 kg
        Paquete p2 = new Paquete(2.0, 2.0, 2.0, 150.0, new Destino("CABA")); // 8 + 1 = 9m3 > 2m3

        assertTrue(auto1.puedeTransportar(p1));
        assertFalse(auto1.puedeTransportar(p2));
    }
    
    @Test
    public void queNoSePuedanAgregarVehiculosConPatenteDuplicada() {
        Empresa empresa = new Empresa("La transportadora");

        Automovil auto1 = new Automovil("ABC123");
        Camion camion1 = new Camion("ABC123"); // misma patente

        assertTrue(empresa.agregarVehiculo(auto1));
        assertFalse(empresa.agregarVehiculo(camion1)); // rechaza patente duplicada
    }


    @Test
    public void queCamionPermitaCargarMuchosPaquetesSinExcederLimite() {
        Empresa empresa = new Empresa("La transportadora");
        Camion camion = new Camion("OQI456");
        empresa.agregarVehiculo(camion);
        
        Paquete p1 = new Paquete(1.0, 1.0, 1.0, 2000.0, new Destino("Salta"));
        Paquete p2 = new Paquete(1.0, 1.0, 1.0, 2000.0, new Destino("Córdoba"));
        Paquete p3 = new Paquete(1.0, 1.0, 1.0, 2000.0, new Destino("Mendoza"));
        Paquete p4 = new Paquete(1.0, 1.0, 1.0, 2000.0, new Destino("Santa Fe"));
        Paquete p5 = new Paquete(1.0, 1.0, 1.0, 2000.0, new Destino("Tucumán"));

        assertTrue(empresa.agregarPaquetePorPatente("OQI456", p1));
        assertTrue(empresa.agregarPaquetePorPatente("OQI456", p2));
        assertTrue(empresa.agregarPaquetePorPatente("OQI456", p3));
        assertTrue(empresa.agregarPaquetePorPatente("OQI456", p4));
        assertTrue(empresa.agregarPaquetePorPatente("OQI456", p5));
    }
    
    @Test
    public void queCamionRechacePaquetePorExcesoDeVolumen() {
        Empresa empresa = new Empresa("La transportadora");
        Camion camion = new Camion("QWE236");
        empresa.agregarVehiculo(camion);

        Paquete p1 = new Paquete(2.0, 2.0, 1.0, 1000.0, new Destino("Rosario"));  // 4 m3
        Paquete p2 = new Paquete(2.0, 2.0, 1.0, 1000.0, new Destino("CABA"));     // 4 m3
        Paquete p3 = new Paquete(2.0, 2.0, 1.0, 1000.0, new Destino("La Plata")); // 4 m3
        Paquete p4 = new Paquete(2.0, 2.0, 1.0, 1000.0, new Destino("Bahía Blanca")); // 4 m3
        Paquete p5 = new Paquete(2.0, 2.0, 1.0, 1000.0, new Destino("Neuquén"));  // 4 m3
        Paquete extra = new Paquete(2.0, 2.0, 1.0, 1000.0, new Destino("Tandil")); // 4 m3 → total 24 m3

        assertTrue(empresa.agregarPaquetePorPatente("QWE236", p1));
        assertTrue(empresa.agregarPaquetePorPatente("QWE236", p2));
        assertTrue(empresa.agregarPaquetePorPatente("QWE236", p3));
        assertTrue(empresa.agregarPaquetePorPatente("QWE236", p4));
        assertTrue(empresa.agregarPaquetePorPatente("QWE236", p5));
        assertFalse(empresa.agregarPaquetePorPatente("QWE236", extra)); // se excede el volumen
    }
    
    
    @Test
    public void queCamionRechacePaquetePorExcesoDePeso() {
        Empresa empresa = new Empresa("La Transportadora");
        Camion camion = new Camion("LOQ478");
        empresa.agregarVehiculo(camion);

        Paquete p1 = new Paquete(1.0, 1.0, 1.0, 15000.0, new Destino("San Juan")); // 15000 kg
        Paquete p2 = new Paquete(1.0, 1.0, 1.0, 2000.0, new Destino("San Juan"));  // total 17000 kg > 16000

        assertTrue(empresa.agregarPaquetePorPatente("LOQ478", p1));
        assertFalse(empresa.agregarPaquetePorPatente("LOQ478", p2)); // se excede el peso
    }
    
    
    
}
