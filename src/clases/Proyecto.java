/**
 * 
 */
package clases;

import java.util.Date;
import java.util.TreeSet;

import estadosTareas.Estado;

/**
 * @author tomi_
 *
 */
public class Proyecto {
	Backlog blog;
	TreeSet<Sprint> LSprints;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Backlog b = new Backlog();
		b.agrega();
		
	}
	public void altaTareaBack(Tarea p) {
		blog.getListaTB().add(p);
	}
	
	public void modiTareaBack(String clave, Tarea p ) {
		lista=blog.getListaTB();  //porque falla ?  no se le puede asignar a una variable un treeset ?
		for(Tareas c:blog.getListaTB()) {  //no se puede poner asi el foreach ? 
			if(c.getId().equals(clave)) {
				c.TareaMOD( p.getNombre(), p.getDescripcion(), p.getfFin(), p.getEstado(), p.getComplejidad());
			}
				
		}
	}
	public void altaSprint(Sprint sp) {
		LSprints.add(sp);
	}
	
	public void bajaSprint(String clave){
		for(Sprint c:LSprints){
			if(c.getClave().equals(clave)){
				if(c.getEstado()==EstadoSprint.PLANIFICADO){
					for(Tarea p: c.getListaT()){
						/* CREO QUE ESTO NO VA , VA EN ABM DE TAREA */
						blog.getListaTB().add(p);
					}
					LSprints.remove(c);
				}
			}		
		}
	}
	public void modificacionSprint(String clave , Sprint sp ){
		for(Sprint c:LSprints){
			if(c.getClave().equals(clave)){
				c.actualizar(sp.getClave(), sp.getdescripcion(), sp.getEstado(), sp.getListaT());
				/*se pueden modificar conb el seter y se altera el orden del treeset  */
			}
		}
	}
	
	
	
}