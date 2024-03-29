package Aceso_Secuencial_Texto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1_FicherosDeTexto {

	public static Scanner leer=new Scanner(System.in);
	static String nombreF="Almacen.txt";
	
	public static void main(String[] args) {
		// Vamosa usar FileReader y BufferedReader.

	//Este menu sera el que usemos en todos los futuros ejercicios.	
		int opcion=0;
		
		do {
			
			System.out.println("0.-Salir");
			System.out.println("1.-Leer/Mostrar.");
			System.out.println("2.-Insertar/A�adir material.");
			System.out.println("3.-Modificar material.");
			System.out.println("4.-Borrar. material");
			System.out.println();
			System.out.print("Introduce una de las opciones anteriores: ");
			opcion=leer.nextInt();leer.nextLine();
			System.out.println();
			switch(opcion) {
			
			case 1:
					mostrarFicheros();
				break;
			case 2:
					insertarMaterial();
				break;
			case 3:
					//Parametro a false porque modifica y no borra
					modificarMaterial(false);
				break;
			case 4:
					//Se le llama al mismo metodo pero con un booleano a true.
					modificarMaterial(true);
				break;
			
			}
			
			
		}while(opcion!=0);
		
	}
	
	
	
	
		//METODOS DE ESTA CLASE.
	/*--------------------------------------------------------------------------*/

	private static void mostrarFicheros() {
		//Declaramos el fichero para lectura. Usamos BufferedReader.
		BufferedReader fichero=null;
		
		//Abrimos el fichero.
		try {
			fichero=new BufferedReader(new FileReader(nombreF));
			String linea;
			while((linea=fichero.readLine())!=null) {
				//Obtenemos cada campo de la linea.
				String campos[]=linea.split(";");
			 System.out.println("Codigo: "+campos[0]+
					 "\tNombre: "+campos[1]+
					 "\tPrecio: "+Float.parseFloat(campos[2])+
					 "\tStock: "+Integer.parseInt(campos[3])+
					 "\tBaja: "+campos[4]);
			 System.out.println();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("ERROR: No se ha encontrado el fichero de texto.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally {
			
			//Cerramos el fichero.
			if(fichero!=null) {
				try {
					fichero.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.err.println("ERROR: No se ha cerrado el fichero correctamente.");
				}
			}
			
		}	
	}
	
	
	
	
	
	private static void insertarMaterial() {
		
		//Declaramos el fichero de escritura.
		BufferedWriter fichero=null;
		BufferedReader fichero2=null;
		//Abrimos el fichero.
		try {
			fichero=new BufferedWriter(new FileWriter(nombreF, true));
			fichero2=new BufferedReader(new FileReader(nombreF));
			
			//Pedimos los datos.
			String linea="";
			System.out.print("Introduce el codigo del producto: ");
			linea+=leer.nextLine()+";";
			if(!existeMateria(linea)) {
			System.out.println();
			System.out.print("Introduce el nombre del producto: ");
			linea+=leer.nextLine()+";";
			System.out.println();
			System.out.print("Introduce el precio del producto: ");
			linea+=leer.nextLine()+";";
			System.out.println();
			System.out.println("Introduce el stock del producto: ");
			linea+=leer.nextLine()+";";
			System.out.println();
			
			//Por defecto el material esta de alta.
			linea +="Si\n";
			
			//Escribimos las lineas.
			fichero.write(linea);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			if(fichero!=null) {
				try {
					fichero.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	
	
	
	private static boolean existeMateria(String linea) {
		// Comprobaremos si existe el codigo introducido o no.
		
		
		
		return false;
	}




	private static void modificarMaterial(boolean borrar) {
		
		//Pedimos el codigo del material a modificar.
		System.out.println("Introduce el codigo que desees modificar: ");
		String codigo=leer.nextLine();
				
		//Declaramos el fichero original para lectura.
		BufferedReader ficheroO=null;
		
		//Declaramos un fichero temporal para escritura.
		BufferedWriter ficheroTmp=null;
		
		try {
			//Abrimos los ficheros.
			ficheroO=new BufferedReader(new FileReader(nombreF));
			//El fichero temporal se sobre escribe: append = false.
			ficheroTmp=new BufferedWriter(new FileWriter("almacen.tmp",false));
			
			//Ahora lo que vamos hacer es ir recorriendo el fichero original.
			//Leemos todas las lineas del fichero original.
			String linea;
			while((linea=ficheroO.readLine())!=null) {
				//Dividimos la linea en campos.
				String campos[]=linea.split(";");
				
				//Comprobamos si la linea es la linea a modificar.
				if(codigo.equalsIgnoreCase(campos[0])) {
					if(!borrar) {
					//Pedimos el nuevo nombre.
					System.out.println("Introduce el nuevo nombre: ");
					campos[1]=leer.nextLine();
					System.out.println("Introduce el nuevo precio: ");
					campos[2]=Float.toString(leer.nextFloat());leer.nextLine();
					System.out.println("Introduce le nuevo Stock: ");
					campos[3]=Integer.toString(leer.nextInt());leer.nextLine();
					
					//Escribimos la linea modificada en el fichero temporal.
					ficheroTmp.write(campos[0]+";"+campos[1]+";"+campos[2]+";"+
							campos[3]+";"+campos[4]+"\n");	
					}
				}else {
					
					//Escribimos la linea tal cual se ha leido.
					ficheroTmp.write(linea+"\n");
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("ERROR: No se ha encontrado el fichero.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			//Cerramos ambos ficheros.
			if(ficheroO!=null) {
				try {
					ficheroO.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(ficheroTmp!=null) {
				try {
					ficheroTmp.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		//Declaramos objeto de la clase File para borrar el fichero original
		//y para renombrar el ficehro temporal.
		File fO =new File(nombreF);
		File fTmp=new File("almacen.tmp");
		
		//Borramos el fichero original.
		if(fO.delete()) {
			if(!fTmp.renameTo(fO)) {
				System.out.println("ERROR: No se pudo renombrar el fichero.");
			}
			
			
		}else {
			System.out.println("ERRO: No se pudo borrar el fichero "+nombreF);
		}
		
		
		
		
		
		
		
	}
	
	
	
	
}
