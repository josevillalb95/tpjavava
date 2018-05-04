/**
 * 
 */
package clases;

import java.util.TreeSet;

/**
 * @author tomi_
 *
 */
public class Backlog {
	
	private TreeSet<Tarea> LTareasP;

	
	/**
	 * @param args
	 */
	public void agrega() {
		Tarea t= new Tarea("45Julia", null, null, null, null, 0);
		Tarea t2= new Tarea("45Maria", null, null, null, null, 0);
		Tarea t3= new Tarea("16Julia", null, null, null, null, 0);
		LTareasP = new TreeSet<Tarea>();
		LTareasP.add(t);
		LTareasP.add(t2);
		LTareasP.add(t3);
		
		for(Tarea lt : LTareasP) {
			System.out.println(lt.getId());
		}
	}

	

	
	public TreeSet<Tarea> getListaTB() {
		return LTareasP;
	}
	/**
	 * 
	 * @param tarea treeset que se va agregar a tareas
	 */
	public void aBacklogTarea(Tarea tare) {
		LTareasP.add(tare);
	}
	

	/**
	 * 
	 * @param clave
	 * @param tare
	 * Modifica el valor de la clave del backglog.
	 * FALTA EL ESTADO :o !!! 
	 */
	public void mBacklogTarea(String clave , Tarea tare) {
		for(Tarea c:LTareasP ){
			if(c.getId().equals(clave)){
				if(c.getEstado() != "finalizado" )
					c.modTarea(tare.getNombre(),tare.getDescripcion() ,tare.getfFin(), tare.getEstado(), tare.getComplejidad());
			c.getDescripcion()
			}
		}
	}
	/**
	 * 
	 * @param clave
	 * elimina un nodo del treeset que concida con la clave enviada 
	 */
	public void bSprintTarea(String clave , Tarea tare) {
		for(Tarea c:LTareasP ){
			if(c.getId().equals(clave)){
				LTareasP.remove(c); 
		}
	}
	
	

	

}