package BackLogs;

import java.util.Date;
import java.util.Iterator;
import java.util.TreeSet;

import Tareas.Bug;
import Tareas.Historia;
import Tareas.Mejora;
import Tareas.Tarea;

public class Backlog {
	private TreeSet<Tarea> LTareasP = new TreeSet<Tarea>();

	
	/**
	 * @param args
	 */
	public void agrega() {
		/*Tarea t= new Tarea("45Julia", null, null, null, 0);
		Tarea t2= new Tarea("45Maria", null, null, null, 0);
		Tarea t3= new Tarea("16Julia", null, null, null, 0);
		LTareasP = new TreeSet<Tarea>();
		LTareasP.add(t);
		LTareasP.add(t2);
		LTareasP.add(t3);*/
		
		for(Tarea lt : LTareasP) {
			System.out.println(lt.getId());
		}
	}

	

	
	public TreeSet<Tarea> getLTareasP() {
		return LTareasP;
	}

	/**
	 * Permite agregar tareas a LTareasP
	 * @param tipo
	 * @param id
	 * @param nombre
	 * @param desc
	 * @param finalizacion
	 * @param comp
	 */
	public void altaTarea(String tipo, String id, String nombre, String desc, Date finalizacion, int comp){
		Tarea tar;
		switch (tipo){
			case "Bug":
				tar = new Bug(id,nombre,desc,finalizacion,comp);
				break;
			case "Historia":
				tar = new Historia(id,nombre,desc,finalizacion,comp);
				break;
			case "Mejora":
				tar = new Mejora(id,nombre,desc,finalizacion,comp);
				break;
			case "Tarea":
				tar = new Tarea(id,nombre,desc,finalizacion,comp);
				break;
			default:
				tar = null;
				break;	
		}
		LTareasP.add(tar);
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
					//c.modTarea(tare.getNombre(),tare.getDescripcion() ,tare.getfFin(), tare.getEstado(), tare.getComplejidad());
			c.getDescripcion();
			}
		}
	}
	
	
	/**
	 * Retorna la tarea con el id inicado por parametro
	 * @param id
	 * @return
	 */
	public Tarea getTarea(String id){
		boolean bandera = false;
		Iterator<Tarea> it = LTareasP.iterator();
		Tarea tar = null;
		while (it.hasNext() && !bandera){
			tar = it.next();
			if(tar.getId().equals(id))
				bandera = true;
		}
		if (bandera)
			return tar;
		else
			return null;
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
	
}
