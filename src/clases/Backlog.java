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
	
	TreeSet<Tarea> LTareas;
	
	/**
	 * @param args
	 */
	public void agrega() {
		Tarea t= new Tarea("45Julia", null, null, null, null, 0);
		Tarea t2= new Tarea("45Maria", null, null, null, null, 0);
		Tarea t3= new Tarea("16Julia", null, null, null, null, 0);
		LTareas = new TreeSet<Tarea>();
		LTareas.add(t);
		LTareas.add(t2);
		LTareas.add(t3);
		
		for(Tarea lt : LTareas) {
			System.out.println(lt.getId());
		}
	}
	

}