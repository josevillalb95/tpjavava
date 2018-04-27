/**
 * 
 */
package clases;

import java.util.TreeSet;

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
	public void altaSprint(Sprint sp) {
		LSprints.add(sp);
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
	public void modificacionSprint(String clave , Sprint sp ){
		for(Sprint c:LSprints){
			if(c.getClave().equals(clave)){
				LSprints.remove(c);
				LSprints.add(sp);
				/*se pueden modificar conb el seter y se altera el orden del treeset  */
			}
		}
	}
	
	
	
}