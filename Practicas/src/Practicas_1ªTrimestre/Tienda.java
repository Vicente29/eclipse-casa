package Practicas_1ªTrimestre;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/*Vamos a usar las anotacines XML para poder usar la tecnologai JAXB*/
@XmlRootElement
@XmlType(propOrder = {"nombre","prendas"})
public class Tienda {

	private String nombreTienda;
	private ArrayList<Ropa> prendas=new ArrayList<>();
	
	public Tienda(){
		
	}
	
	@XmlElement(name="nombreTienda")
	public String getNombreTienda() {
		return nombreTienda;
	}
	public void setNombreTienda(String nombreTienda) {
		this.nombreTienda = nombreTienda;
	}
	@XmlElementWrapper
	@XmlElement(name="prenda")
	public ArrayList<Ropa> getPrendas() {
		return prendas;
	}
	public void setPrendas(ArrayList<Ropa> prendas) {
		this.prendas =prendas;
	}
	
	
	
	
}
