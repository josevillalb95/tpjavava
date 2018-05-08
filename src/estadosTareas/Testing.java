/**
 * 
 */
package estadosTareas;

/**
 * @author tomi_
 *
 */
public class Testing extends Estado {

	public Testing() {
		super();
		// TODO Auto-generated constructor stub
		seteAnt(new ToDo() );
		seteSig(new Done() );
	}

}
