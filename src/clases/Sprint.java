/**
 * 
 */
package clases;

import java.util.TreeSet;

/**
 * @author tomi_
 *
 */
public class Sprint implements Comparable<Sprint>{
	
	String clave, descripcion;
	EstadoSprint estado;
	TreeSet<Tarea> LTareas;
	
	
	
	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public int compareTo(Sprint arg0) {
		// TODO Auto-generated method stub
		
		return this.clave.compareTo(arg0.getClave());
	}
	
}
