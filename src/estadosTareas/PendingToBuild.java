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
		super();
		// TODO Auto-generated constructor stub
		seteSig(new ReadyToTest() );
		seteAnt(new ToDo() );
	}

}
