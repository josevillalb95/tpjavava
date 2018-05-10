/**
 * 
 */
package UI;

import java.awt.EventQueue;

import clases.Sprint;

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
					Sprint s= new Sprint("hola","mundoo");
					//s.addDay();
					
					InterfazGrafica window = InterfazGrafica.getInstance();
					window.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
