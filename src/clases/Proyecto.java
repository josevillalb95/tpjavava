/**
 * 
 */
package clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
//import java.util.Date;
import java.util.Iterator;
import java.util.TreeSet;

import javax.swing.plaf.OptionPaneUI;

import Tareas.Tarea;
import UI.InterfazGrafica;
import backLogs.Backlog;
import estadosTareas.Estado;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @author jose_
 *
 */
public final class Proyecto {
	private LocalDate today = LocalDate.now();
	private Backlog blog = new Backlog();
	private TreeSet<Sprint> LSprints = new TreeSet<Sprint>();
	
	private static Proyecto instance = null;
	
	/**
	 * Retorna la unica instancia de Proyecto existente
	 * @return un Proyecto
	 */
	public static Proyecto getInstance(){
		
		if (instance == null)
			instance = new Proyecto(); 
		
		return instance; 	
	}
	
	/**
	 * Retorna un Backlog
	 * @return Backlog
	 */
	public Backlog getBlog() {
		return blog;
	}
	
	/**
	 * Adelanta un dia para procesar los cambios de los Sprints y Tareas
	 */
	public void diaSig(){
		today= today.plus(1, ChronoUnit.DAYS);
		for(Sprint c:LSprints){
			if(c.getFechaFin().compareTo(today)==1);{
				c.setEstadoSprint(EstadoSprint.FINALIZADO);
					for(Tarea b:c.getListaT()){
						System.out.println(b.getDescripcion());  //faltan las otras descripciones ... 
					
						
					}
			}
		}
		
	}
	
	/**
	 * Genera una alta de un nuevo Sprint
	 * @param clave Se le asignara la clave al nuevo Sprint
	 * @param descripcion Se le asignara la descripcion al nuevo Sprint
	 */
	public void altaSprint(String clave , String descripcion) {
		LSprints.add(new Sprint(clave, descripcion));
	}
	
	/**
	 * Retorna la lista de Sprints del Proyecto
	 * @return Lista de Sprints
	 */
	public TreeSet<Sprint> getLSprints() {
		return LSprints;
	}
	
	/**
	 * Da de baja un Sprint de la lista con la clave indicada
	 * @param clave Clave del Sprint a buscar para dar de baja
	 * @throws SprintNoValido cuando el Sprint es ENCURSO o FINALIZADO, los cuales no pueden ser dados de baja
	 */
	public void bajaSprint(String clave) throws SprintNoValido{
		boolean bandera = true;
		Iterator<Sprint> it = LSprints.iterator();
		Sprint sp = null;
		while(bandera && it.hasNext()){
			sp = it.next();
			if(sp.getClave().compareTo(clave)<=0){
				if(sp.getClave().equals(clave)){
					if(sp.getEstado()==EstadoSprint.PLANIFICADO){
	/*					for(Tarea p: c.getListaT()){                               TRABAJAR CON LAS TAREAS
							blog.getListaTB().add(p);
						}*/
						LSprints.remove(sp);
						bandera = false;
					}
					else
						throw new SprintNoValido();
				}
			}
		}
	}
	
	/**
	 * Permite actualizar el Sprint pasado como parametro
	 * @param clave Clave del Sprint a modificar
	 * @param descricion Descripcion que se desea actualizar
	 */
	public void modificacionSprint(String clave ,String descricion){
		for(Sprint c:LSprints){
			if(c.getClave().equals(clave)){
				c.actualizar(clave, descricion);
			}
		}
	}
	
	/**
	 * Para ver lista de Sprints
	 * Despues borrar
	 */
	public void corrersp(){
		for(Sprint lt : LSprints) {
			System.out.println(lt.getClave());
			lt.muestraTareasSprint();
		}
	}
	
	/*public Sprint getSprint(String clave){
		LSprints.
	}*/
	
	/**
	 * Agrega una Tarea a un String
	 * @param idS Sprint al cual se le agregara una Tarea
	 * @param idT Tarea que sera agregada al Sprint
	 */
	public void agregarTareasSprint(String idS,String idT){
		Iterator<Sprint>its=LSprints.iterator();
		Iterator<Tarea>itt;
		Sprint sp=null;
		Tarea tar=null;
		boolean bandera=true;
		while(its.hasNext() && bandera){
			sp=its.next();
			if(sp.getClave().equals(idS)){
				//sp.aSprintTarea(t);
				bandera=false;
			}
		}
		itt=blog.getLTareasP().iterator();
		bandera=true;
		while(itt.hasNext() && bandera){
			tar=itt.next();
			if(tar.getId().equals(idT)){
				sp.aSprintTarea(tar);
				//blog.bajaTarea(tar.getId());
				//itt.remove();
				bandera=false;
			}
			
		}
	}
	
	/**
	 * Carga las tareas de un txt
	 */
	public void cargarTareas(){
		blog.cargaListaTareas();
	}
	
	/**
	 * Imprime por pantalla la lista de tareas
	 */
	public void mostrarTareas(){
		blog.muestraTareas();
	}
	
	/**
	 * Agrega una Tarea como dependencia de otra Tarea.
	 * @param idT Id de Tarea a la que agregarle una dependencia.
	 * @param idDep Id de la Tarea que sera agregada como dependencia.
	 */
	public void agregarDependencias(String idT,String idDep){
		blog.agregaDependencia(idT, idDep);
	}
	
	/**
	 * Elimina una Dependencia de una Tarea.
	 * @param idT Id de la Tarea a la que eliminarle la Dependencia.
	 * @param idDep Id de la Dependencia a ser eliminada de la Tarea.
	 */
	public void eliminarDependencia(String idT,String idDep){
		blog.bajaDependencia(idT, idDep);
	}
	
	/**
	 * Agrega un FlujoPaso a una Tarea.
	 * @param idT Id de la Tarea a la que agregarle un FlujoPaso.
	 * @param descripcion del FlujoPaso.
	 * @param pasos del FlujoPaso.
	 */
	public void agregarFlujoPaso(String idT, String descripcion, int pasos){
		blog.agregaFP(idT, descripcion, pasos);
	}
	
	/**
	 * Retorna todos los Sprints que se encuentren ENCURSO
	 * @return Springs en Curso
	 */
	public TreeSet<Tarea> getTareasSprintEnCurso() {
		Sprint sp = null;
		boolean bandera = true;
		Iterator<Sprint> it = LSprints.iterator();
		while(it.hasNext() && bandera)
			sp = it.next();
			if(sp.getEstado() == EstadoSprint.ENCURSO)
				bandera = false;
		if (bandera)
			return null;
		else
			return sp.getListaT();
	}
	
	/**
	 * Calcula la estimacion del Sprint indicado
	 * @param idSprint Id del Sprint
	 * @return la estimacion del Sprint
	 */
	public int calcularEstimacionSprint(String idSprint){
		Sprint sp=null;
		boolean bandera=true;
		Iterator<Sprint> it = LSprints.iterator();
		int estimacion=0;
		while(it.hasNext() && bandera){
			sp=it.next();
			if(sp.getClave().equals(idSprint)){
				estimacion=sp.estimacionSprint();
				bandera=false;
			}
		}
		return estimacion;
	}
	
	/**
	 * Calcula la estimacion de la Historia indicada
	 * @param idSprint Id del Sprint que contiene la Historia
	 * @return la estimacion de la Historia
	 */
	public int calcularEstimacionHistoriaSprint(String idSprint){
		Sprint sp=null;
		boolean bandera=true;
		Iterator<Sprint> it = LSprints.iterator();
		int estimacion=0;
		while(it.hasNext() && bandera){
			sp=it.next();
			if(sp.getClave().equals(idSprint)){
				estimacion=sp.estimacionHistoriaSprint();
				bandera=false;
			}
		}
		return estimacion;
	}
	
	/**
	 * Da de baja una Tarea de un Sprint.
	 * @param idSprint Id del Sprint al que se le dara de baja la Tarea.
	 * @param idTarea Id de la Tarea que sera dada de baja.
	 */
	public void bajaTareaSprint(String idSprint,String idTarea){
		Iterator<Sprint>it=LSprints.iterator();
		Sprint sp=null;
		boolean bandera=true;
		while(it.hasNext() && bandera){
			sp=it.next();
			if(sp.getClave().compareTo(idSprint)==0){
				sp.bajaTarea(idTarea);
				bandera=false;
			}
				
		}
	}
	
	/**
	 * Da de baja una tarea del Backlog.
	 * @param idTarea Id de la Tarea a dar de baja del Backlog.
	 */
	public void bajaTareaBackLog(String idTarea){
		blog.bajaTarea(idTarea);
	}
	/**
	 * Agregar Tarea como Subtarea de otra Tarea.
	 * @param idT Id Tarea a la que se le agregara la Subtarea.
	 * @param idSubT Id Tarea a agregar como Subtarea.
	 */
	public void agregaSubT(String idT,String idSubT){
		blog.agregaSubTarea(idT, idSubT);
	}
	
	/**
	 * Eliminar Subtarea de una Tarea.
	 * @param idT Id Tarea a la que se le eliminara la Subtarea.
	 * @param idSubT Id Tarea a eliminar como Subtarea.
	 */
	public void eliminarSubT(String idT,String idSubT){
		blog.bajaSubTarea(idT, idSubT);
	}
	
	/**
	 * Cambia el estado de un Sprint por el pasado como parametro.
	 * @param idSprint Id del Sprint a cambiarle el estado.
	 * @param estado Estado al que se le desea cambiar el Sprint.
	 */
	public void cambiarEstadoSprint(String idSprint,String estado){
		
		Iterator<Sprint>it=LSprints.iterator();
		Sprint sp=null;
		boolean bandera=true;
		while(it.hasNext() && bandera){
			sp=it.next();
			if(sp.getEstado().toString().equals("ENCURSO"))
				bandera=false;
		}
		Sprint s=devuelveSprint(idSprint);
		if(bandera)
			s.cambiarEstado(estado);
		else
			System.out.println("Ya hay un sprint en curso");
	}
	
	/**
	 * Busca un Sprint y lo retorna.
	 * @param idSprint Id del Sprint a buscar
	 * @return Sprint buscado.
	 */
	public Sprint devuelveSprint(String idSprint){
		Iterator<Sprint>it=LSprints.iterator();
		Sprint sp=null;
		boolean bandera=false;
		while(it.hasNext() && !bandera){
			sp=it.next();
			if(sp.getClave().compareTo(idSprint)==0){
				bandera=true;
			}
		}
		return sp;
	}
	
	/**
	 * Pone en curso un Sprint, asignandole Fecha de inicio y de fin.
	 * @param idSprint Id del Sprint a poner en curso.
	 * @param fi Fecha de inicio a asignar.
	 * @param ff Fecha de fin a asignar.
	 */
	public void sprintEnCurso(String idSprint, LocalDate fi,LocalDate ff){
		Sprint s=devuelveSprint(idSprint);
		s.comenzar(fi, ff);
	}
	
	
	/**
	 * Genera un avance en dias al Sprint indicado.
	 * @param idSprint Sprint en el cual se generara el avance.
	 */
	public void avance(String idSprint){
		Sprint s=devuelveSprint(idSprint);
		LocalDate fecha;
		int avance;
		//LocalDate fecha=s.getfInicio().plusDays(1);
		if(s.getEstado().toString().equals("ENCURSO")){
			fecha = s.getfAvance().plusDays(1);
			avance = (int)s.getfInicio().until(fecha, ChronoUnit.DAYS);
			s.setAvance();
			s.setfAvance(fecha);
			System.out.println(s.getfAvance());
			if(fecha.equals(s.getFechaFin())){
				s.cambiarEstado("finalizado");
				System.out.println(s.estimacionSprint());
				System.out.println(s.estimacionHistoriaSprint());
			}
		}
		else
			System.out.println("El sprint ya esta finalizado");
	}
	

	public int cantAvance(String id){
		Sprint s=devuelveSprint(id);
		return s.getAvance();
	}
	
	public int calcularDuracion(String idSprint){
		Sprint s=devuelveSprint(idSprint);
		return s.duracion();
	}
	
	public void cambiarEstadoTarea(String idSprint,String idT,String est){
		Sprint s=devuelveSprint(idSprint);
		s.cambiarEstadoTarea(idT, est);
	}
	public LocalDate getFechaAvanceSprint(String idSprint){
		LocalDate fecha;
		Sprint s=devuelveSprint(idSprint);
		fecha=s.getfAvance();
		return fecha;
	}
	public void historial(String idSprint){
		Sprint s=devuelveSprint(idSprint);
		s.muestraHistorial();
	}
	
	public ArrayList<Sprint> RankingEstimacion(){
		ArrayList<Sprint>listaEsti = new ArrayList<Sprint>() ; 
		for(Sprint s:LSprints){
			//s.estimacionHistoriaSprint();
			listaEsti.add(s);
		}
		Collections.sort(listaEsti,new Comparator<Sprint>(){
			public int compare(Sprint s1, Sprint s2) {
				int est1=s1.estimacionHistoriaSprint();
				int est2=s2.estimacionHistoriaSprint();
				if(est1==est2)
					return 0;
				else
					if(est1<est2)
						return 1;
					else
						return -1;
			}
		});
		return listaEsti;	
	}
	public void reporteListado(){
		for(Sprint s:LSprints){
			System.out.println(s.getClave());
			System.out.println("Completadas:");
			
			int est=0;
			for(Tarea t:s.tareasCompletadas()){
				est+=t.estimacion();
			}
			System.out.println(s.tareasCompletadas().toString()+" "+est);
			System.out.println("No completadas:");
			est=0;
			for(Tarea t:s.tareasNoCompletadas())
				est+=t.estimacion();
			System.out.println(s.tareasNoCompletadas().toString()+" "+est);
		}
	}
	/**
	 * Serializa
	 * @param obj Object a serializar
	 * @param output Path y nombre del archivo a serializar
	 * @throws IOException si ocurre un error al abrir el archivo
	 */
	public void Escribir(Object obj, String output) throws IOException{
		File fich;
		fich = new File(output);
		FileOutputStream fos = new FileOutputStream(fich);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj);
		oos.close();
	}
	
	/**
	 * Desserializa
	 * @param output Path y nombre del archivo a desserializar
	 * @return Object con lo obtenido del archivo
	 * @throws IOException si ocurre un error al abrir el archivo
	 * @throws ClassNotFoundException si no encuentra el archivo buscado
	 */
	public Object Leer(String output) throws IOException, ClassNotFoundException{
		File fich;
		fich = new File(output);
		FileInputStream fis = new FileInputStream(fich);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object obj = ois.readObject();
		ois.close();
		
		return obj;
	}
	
	
}