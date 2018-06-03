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
		
		proy.altaSprint("SPR001", "Sprint 1");
		proy.agregarTareasSprint("SPR001","HIS001");
		proy.agregarTareasSprint("SPR001","TAR004");
		proy.agregarTareasSprint("SPR001","TAR005");
		proy.agregarTareasSprint("SPR001","TAR003");
		proy.agregarTareasSprint("SPR001","HIS004");
		proy.agregarTareasSprint("SPR001","TAR008");
		proy.agregarTareasSprint("SPR001","TAR009");
		
		proy.altaSprint("SPR002", "Sprint 2");
		proy.agregarTareasSprint("SPR002", "TAR001");
		proy.agregarTareasSprint("SPR002", "HIS002");
		proy.agregarTareasSprint("SPR002", "TAR006");
		proy.agregarTareasSprint("SPR002", "HIS005");
		proy.agregarTareasSprint("SPR002", "TAR002");
		proy.agregarTareasSprint("SPR002", "TAR010");
		proy.agregarTareasSprint("SPR002","MEJ002");
		proy.agregarTareasSprint("SPR002","TAR012");
		
		proy.agregarDependencias("HIS002","TAR003");
		proy.agregarDependencias("HIS005","HIS004");
		proy.agregarDependencias("HIS006","HIS004");
		proy.agregarDependencias("HIS006","HIS005");
		proy.agregarDependencias("MEJ002","TAR003");
		proy.agregarFlujoPaso("HIS001", "Usuario invalido", 6);
		proy.agregarFlujoPaso("HIS001", "Contraseña invalida", 8);
		proy.agregarFlujoPaso("HIS001", "Usuario y contraseña inexistente", 10);
		proy.agregarFlujoPaso("HIS001", "Usuario y contraseña correctos", 12);
		proy.agregarFlujoPaso("HIS004", "Solicitar listado", 15);
		proy.agregarFlujoPaso("HIS004", "Listado vacio", 6);
		proy.agregarFlujoPaso("HIS004", "Navegar listado", 12);
		proy.agregarFlujoPaso("HIS005", "Agregar pelicula a mi lista", 11);
		proy.agregarFlujoPaso("HIS005", "Agregar pelicula ya agregada", 8);
		proy.agregarFlujoPaso("HIS006", "Remover pelicula de mi lista", 13);
		proy.agregarFlujoPaso("HIS006", "Cancelar remocion", 8);
		proy.agregarFlujoPaso("HIS002","Solicitar listado",15);
		proy.agregarFlujoPaso("HIS002","Actualizar listado",15);
		proy.agregarFlujoPaso("HIS002","Navegar listado",12);
		
		proy.agregaSubT("HIS001", "TAR004");
		proy.agregaSubT("HIS001", "TAR005");
		//proy.agregaSubT("HIS001", "TAR001");
	
		
		
		//TAR001, HIS002, TAR006, HIS005, TAR002, TAR010, MEJ002, TAR012
		
		
		
		System.out.println("Estimacion SPR001:"+proy.calcularEstimacionSprint("SPR001"));
		System.out.println("Estimacion SPR002:"+proy.calcularEstimacionSprint("SPR002"));
		//proy.bajaSprint("SPR002");
		//proy.bajaTareaSprint("SPR002", "TAR002");
		//proy.bajaTareaBackLog("TAR008");
		proy.eliminarSubT("HIS001", "TAR005");
		proy.eliminarDependencia("HIS006", "HIS004");
		proy.mostrarTareas();
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
