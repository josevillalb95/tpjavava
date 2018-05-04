/**
 * 
 */
package clases;

import java.util.Date;
import java.util.TreeSet;

import UI.InterfazGrafica;
import estadosTareas.Estado;

/**
 * @author jose_
 *
 */
public final class Proyecto {
	private Backlog blog;
	private TreeSet<Sprint> LSprints;
	
	private static Proyecto instance = null;
	
	public static Proyecto getInstance(){
		
		if (instance == null)
			instance = new Proyecto(); 
		
		return instance; 
		
	}
	
	public void altaSprint(String clave , String descripcion) {
		Sprint  spri= new Sprint(clave, descripcion);
		LSprints.add(spri);
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
	
	
	
}