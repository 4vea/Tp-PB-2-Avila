package ar.edu.unlam.herencia;

public class test {

	public static void main(String[] args) {
		Bicicleta bici = new Bicicleta();
		Automovil auto = new Automovil();
		Camion camion = new Camion();
		Destino destino1 = new Destino("San Justo", "Siempreviva 548");
		Destino destino2 = new Destino("Lanus", "colibri 143");
		Destino destino3 = new Destino("Pompeya", "Saenz 123");
		Destino destino4 = new Destino("Moron", "Rivadavia 12300");

		Vehiculo vehiculos[] = { bici, auto, camion };

		Paquete paquete1 = new Paquete(0.1, 0.1, 0.1, 5.0, destino1);
		Paquete paquete5 = new Paquete(0.1, 0.1, 0.1, 5.0);
		Paquete paquete2 = new Paquete(1.0, 1.0, 1.0, 10.0, destino2);
		Paquete paquete3 = new Paquete(2.0, 2.0, 2.0, 10.0, destino3);
		Paquete paquete4 = new Paquete(0.1, 0.1, 0.1, 5.0, destino4);
		Paquete[] paquetes = { paquete1, paquete5, paquete2, paquete3, paquete4 };

		for (Vehiculo vehiculo : vehiculos) {
			for (int i = 0; i < paquetes.length; i++) {
				if (paquetes[i] != null) {
					if (vehiculo.agregarPaquete(paquetes[i])) {
						System.out.println(vehiculo.toString() + vehiculo.getDestinos());
						paquetes[i] = null;
					}
				}
			}
		}

	}

}
