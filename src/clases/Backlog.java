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
	
	TreeSet<Tarea> LTareasP;
	TreeSet<Sprint> LSprints;
	
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
	

}