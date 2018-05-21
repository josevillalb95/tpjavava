/**
 * 
 */
package estadosTareas;

/**
 * @author tomi_
 *
 */
public class InProgress extends Estado {

	public InProgress() {
		super("In Progress","La tarea se encuentra en progreso", null, new PendingToBuild());
	}
	

}
