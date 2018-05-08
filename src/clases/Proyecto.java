/**
 * 
 */
package clases;

import java.util.Date;
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
	
	public void bajaSprint(String clave){
		for(Sprint c:LSprints){
			if(c.getClave().equals(clave)){
				if(c.getEstado()==EstadoSprint.PLANIFICADO){
					for(Tarea p: c.getListaT()){
						blog.getListaTB().add(p);
					}
					LSprints.remove(c);
				}
			}		
		}
	}
	public void modificacionSprint(String clave ,String descricion){
		for(Sprint c:LSprints){
			if(c.getClave().equals(clave)){
				c.actualizar(c.getClave(), descricion, null, null);
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
	
	
}