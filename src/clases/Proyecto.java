/**
 * 
 */
package clases;

import java.util.Date;
import java.util.Iterator;
import java.util.TreeSet;

import UI.InterfazGrafica;
import estadosTareas.Estado;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @author jose_
 *
 */
public final class Proyecto {
	private LocalDate today = LocalDate.now();
	private Backlog blog = new Backlog();
	private TreeSet<Sprint> LSprints = new TreeSet<Sprint>();
	
	private static Proyecto instance = null;
	
	public static Proyecto getInstance(){
		
		if (instance == null)
			instance = new Proyecto(); 
		
		return instance; 	
	}
	
	public Backlog getBlog() {
		return blog;
	}

	public void diasig(){
		today= today.plus(1, ChronoUnit.DAYS);
		for(Sprint c:LSprints){
			if(c.getFechaFin().compareTo(today)==1);{
				c.setEstadoSprint(EstadoSprint.FINALIZADO);
					for(Tarea b:c.getListaT()){
						System.out.println(b.getDescripcion());  //faltan las otras descripciones ... 
					
						
					}
			}
		}
		
	}
	
	public void altaSprint(String clave , String descripcion) {
		LSprints.add(new Sprint(clave, descripcion));
	}
	
	/**
	 * Retorna la lista de Sprints del Proyecto
	 * @return Lista de Sprints
	 */
	public TreeSet<Sprint> getLSprints() {
		return LSprints;
	}
	
	public void bajaSprint(String clave){
		boolean bandera = false;
		Iterator<Sprint> it = LSprints.iterator();
		Sprint sp = it.next();
		while(!bandera && it.hasNext() && (sp.getClave().compareTo(clave)<=0)){
			if(sp.getClave().equals(clave)){
				if(sp.getEstado()==EstadoSprint.PLANIFICADO){
/*					for(Tarea p: c.getListaT()){                               TRABAJAR CON LAS TAREAS
						blog.getListaTB().add(p);
					}*/
					
				}
				LSprints.remove(sp);
				bandera = true;
				System.out.println("Hola");
			}
			else
				sp = it.next();
		}
	}
	
	public void modificacionSprint(String clave ,String descricion){
		for(Sprint c:LSprints){
			if(c.getClave().equals(clave)){
				c.actualizar(clave, descricion);
			}
		}
	}
	
	/**
	 * Para ver lista de Sprints
	 * Despues borrar
	 */
	public void corrersp(){
		for(Sprint lt : LSprints) {
			System.out.println(lt.getClave());
		}
	}
	
	/*public Sprint getSprint(String clave){
		LSprints.
	}*/

	public TreeSet<Tarea> getTareasSprintEnCurso() {
		Sprint sp = null;
		boolean bandera = true;
		Iterator<Sprint> it = LSprints.iterator();
		while(it.hasNext() && bandera)
			sp = it.next();
			if(sp.getEstado() == EstadoSprint.ENCURSO)
				bandera = false;
		if (bandera)
			return null;
		else
			return sp.getListaT();
	}
	
	
}