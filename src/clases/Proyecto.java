/**
 * 
 */
package clases;

import java.util.Date;
import java.util.TreeSet;

import estadosTareas.Estado;

/**
 * @author jose_
 *
 */
public class Proyecto {
	private Backlog blog;
	private TreeSet<Sprint> LSprints;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Backlog b = new Backlog();
		b.agrega();
		
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