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
	public void seteSig(Estado eSig) {
		this.eSig = eSig;
	}
	public void seteAnt(Estado eAnt) {
		this.eAnt = eAnt;
	}

	
	/** 
	 * Estos se tienen que generar de forma automatica (nombre y descripcion)
	 */
	/*public Estado(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	*/
	
	
}
