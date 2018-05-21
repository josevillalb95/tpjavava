/**
 * 
 */
package estadosTareas;

/**
 * @author tomi_
 *
 */
public class Estado {
	/* Hay que pensar distinto los hijos de Estado.
	 * No sirve de nada una clase vacia
	 * Podrian terminar siendo enums
	 */
	
	private String nombre,descripcion;
	private Estado eSig=null,eAnt=null;
	//Estado siguiente y anterior
	
	public Estado(String nombre, String descripcion, Estado eSig, Estado eAnt) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.eSig = eSig;
		this.eAnt = eAnt;
	}
	
	public void seteSig(Estado eSig) {
		this.eSig = eSig;
	}

	public void seteAnt(Estado eAnt) {
		this.eAnt = eAnt;
	}
	
	
}
