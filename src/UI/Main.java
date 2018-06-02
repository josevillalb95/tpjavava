/**
 * 
 */
package UI;

import java.awt.EventQueue;
//BORRAR
import BackLogs.Backlog;
import clases.Proyecto;
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
		Proyecto proy=new Proyecto();
		//bl.cargaListaTareas();
		proy.cargarTareas();
		//proy.mostrarTareas();
		proy.altaSprint("SPR001", "Sprint 1");
		proy.agregarTareasSprint("SPR001","HIS001");
		proy.agregarTareasSprint("SPR001","HIS004");
		proy.corrersp();
		
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
