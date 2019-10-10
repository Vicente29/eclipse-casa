package Practicas_1ªTrimestre;

import java.util.Scanner;

public class PracticaFicheros_Main {

	static Scanner leer=new Scanner(System.in);
	static Metodos metod=new Metodos();
	public static void main(String[] args) {
		/*Ejercicio el cual implementara todos los tipos de ficheros que hemos estado viendo,
		 * ello incluye ficheros de texto, binario, de objetos y de acceso aleatorio.*/
		int opcion=0;
		do {
			System.out.println("0.-Salir");
			System.out.println("1.-Añdir nueva ropa al almacen de la Tienda.");
			System.out.println("2.-Mostrar toda la ropa que hay en la tienda.");
			System.out.println("3.-Vender un producto.");
			System.out.println("4.-Modificar la Talla y Precio de las prendas de ropa.");
			System.out.println("5.-Dar de baja o dar de alta una prenda de ropa.");
			System.out.println("6.-Mostrar todas la ventas del dia.");
			System.out.println("7.-Copia de seguridad. "
					+ "(ficheroXML)");
			System.out.println();
			System.out.print("Introduce una de las opciones anteriores: ");
			opcion=leer.nextInt();leer.nextLine();
			System.out.println();
			switch(opcion) {
			case 1:		
					metod.insertarRopaTienda();
				break;
			case 2:
					metod.mostrarRopaTienda();
				break;
			case 3:
					metod.ventas();
				break;
			case 4:
					metod.modificarRopa();
				break;
			case 5:
					//metod.baja_altaRopaTienda();
				break;
			case 6:
					//metd.copiaSeguridad();
				break;
			
			}
		}while(opcion!=0);
	}

}
