/**
 * 
 */
package estadosTareas;

/**
 * @author tomi_
 *
 */
public class PendingToBuild extends Estado {

	public PendingToBuild() {
		super("Pending to Build","La tarea esta esperando para ser construida", new ReadyToTest(), new ToDo());
	}

}
