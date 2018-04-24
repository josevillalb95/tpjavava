/**
 * 
 */
package UI;

import java.awt.EventQueue;

/**
 * @author Alumno
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazGrafica window = new InterfazGrafica();
					window.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
