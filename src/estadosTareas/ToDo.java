/**
 * 
 */
package estadosTareas;

/**
 * @author tomi_
 *
 */
public class ToDo extends Estado {

	public ToDo() {
		super("To Do","La tarea esta esperando para ser realizada", null, new InProgress());
	}
	

}
