/**
 * 
 */
package estadosTareas;

/**
 * @author tomi_
 *
 */
public class ReadyToTest extends Estado {

	public ReadyToTest() {
		super("Ready to Test","La tarea se encuentra lista para probar", null, new Testing());
	}

}
