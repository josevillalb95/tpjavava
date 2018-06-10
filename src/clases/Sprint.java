package clases;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

import Tareas.Tarea;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Sprint implements Comparable<Sprint>, Serializable{
	
	private	String clave, descripcion;
	private EstadoSprint estado;
	private LocalDate fInicio , fFin,fAvance;
	private int avance,duracion;
	private TreeSet<Tarea> LTareas;
	
	
	/**
	 * Constructor de Sprints
	 * @param clave Clave a asignarle al Sprint a crear
	 * @param descripcion Descripcion a asignarle al Sprint a crear
	 */
	public Sprint(String clave, String descripcion) {
		this.clave = clave;
		this.descripcion = descripcion;
		this.estado = EstadoSprint.PLANIFICADO;
		this.LTareas = new TreeSet<Tarea>();
	}
	
	/**
	 * Retorna la clave del Sprint.
	 * @return clave identificadora del Sprint.
	 */
	public String getClave() {
		return clave;
	}
	
	/**
	 * Actualiza la informacion del Sprint con los datos pasados como parametros.
	 * @param clave Clave que sobreescribira la existente.
	 * @param descripcion Descripcion que sobreescribira la existente.
	 */
	public void actualizar(String clave, String descripcion) {
		this.clave = clave;
		this.descripcion = descripcion;
	}
	
	/**
	 * Retorna la lista de Tareas
	 * @return Lista de Tareas
	 */
	public TreeSet<Tarea> getListaT() {
		return LTareas;
	}
	
	/**
	 * Retorna el estado en el que se encuentra el Sprint.
	 * @return Estado del Sprint.
	 */
	public EstadoSprint getEstado() {
		return estado;
	}
	
	/**
	 * Le asigna el estado al Sprint que se pasa como parametro.
	 * @param estado Estado a asignar.
	 */
	public void setEstadoSprint(EstadoSprint estado) {
		this.estado = estado;
	}
	
	/**
	 * Retorna la descripcion del Sprint.
	 * @return Descripcion del Sprint.
	 */
	public String getDescripcion() {
		return descripcion;
	}
	
	/**
	 * Da de alta una tarea en la lista del Sprint.
	 * @param tar Tarea a agregar a la lista de Tareas.
	 */
	public void aSprintTarea(Tarea tar) {
		LTareas.add(tar);
	}
	
	/**
	 * Busca y da de baja una Tarea con la clave pasada por parametro. 
	 * @param clave Clave a eliminar
	 */
	/*public void bSprintTarea(String clave) {
		Iterator<Tarea> it = LTareas.iterator();
		Tarea t = null;
		boolean bandera = false;
		while(it.hasNext() && !bandera){
			t = it.next();
			if(t.getId().equals(clave)){
				LTareas.remove(t);
				bandera = true;
			}
		}
	}
	*/
	/**
	 * Sobreescribe la clave del Sprint por la pasada por parametro.
	 * @param clave Clave que sobreescribira la existente.
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}

	/**
	 * Permite la comparación entre dos Sprints
	 * utilizando la clave para ordenarlos por
	 * orden alfabético.
	 * @return 	0 si las claves son iguales
	 * 			>0 si la clave es mayor alfabeticamente
	 * 			<0 si la clave es menor alfabeticamente
	 */
	public int compareTo(Sprint arg0) {		
		return this.clave.compareTo(arg0.getClave());
	}
	
	/**
	 * Retorna la fecha de finalizacion del Sprint.
	 * @return fecha de finalizacion del Sprint.
	 */
	public LocalDate getFechaFin(){
		return fFin;
	}
	
	/**
	 * Comienza el Sprint, indicando
	 * cual es la fecha de inicio y la de fin.
	 * @param fi Fecha de inicio del Sprint.
	 * @param ff Fecha de finalizacion del Sprint.
	 */
	public void comenzar(LocalDate fi,LocalDate ff){
		//estado = EstadoSprint.ENCURSO;
		fInicio = fi;
		fFin = ff;
		fAvance=fInicio;
		avance=1;
		duracion=(int) (1+(fInicio.until(fFin, ChronoUnit.DAYS)));
		//Cantidad de dias de duracion y avance no se saca automaticamente?
		}
	
	/**
	 * Finaliza el Sprint.
	 */
	public void finalizar(){
		estado = EstadoSprint.FINALIZADO;
		//Trasladar Sprints sin terminar
	}
	
	/**
	 * Busca y da de baja una Tarea con la clave pasada por parametro. 
	 * @param idT Clave a dar de baja.
	 */
	public void bajaTarea(String idT){
		try{
		LTareas.remove(getTarea(idT));
		} catch(NullPointerException npe){
			npe.getStackTrace();
		}
	}
	
	/**
	 * Calcula y retorna la estimacion calculada con las Tareas.
	 * @return sumatoria de las estimaciones de las Tareas.
	 */
	public int estimacionSprint(){
		int est=0;
		for(Tarea tar : LTareas)
			est+=tar.estimacion();
		return est;
	}
	
	/**
	 * Calcula y retorna la estimacion calculada con las Historias.
	 * @return sumatoria de las estimaciones de las Historias.
	 */
	public int estimacionHistoriaSprint(){
		int est=0;
		for(Tarea tar : LTareas)
			if(tar.getId().substring(0,3).equals("HIS"))
				est+=tar.estimacion();
		return est;
	}
	
	/**
	 * Muestra por consola todos los ids de las tareas en la lista de Tareas del Sprint
	 */
	public void muestraTareasSprint(){
		for(Tarea tar : LTareas)
			System.out.println(tar.getId());
	}
	
	/**
	 * Retorna la fecha de inicio del Sprint.
	 * @return fecha de inicio del Sprint.
	 */
	public LocalDate getfInicio() {
		return fInicio;
	}

	/**
	 * 
	 * @return
	 */
	public LocalDate getfAvance() {
		return fAvance;
	}

	public void setfAvance(LocalDate fa) {
		this.fAvance = fa;
	}

	/**
	 * Retorna el avance hasta la fecha actual del Sprint.
	 * @return cantidad de dias desde que se inicio.
	 */
	public int getAvance() {
		return avance;
	}

	/**
	 * Adelanta un dia en el avance del Sprint
	 */
	public void setAvance() {
		avance+=1;
	}
	
	/**
	 * 
	 * @return
	 */
	public int duracion(){
		return duracion;
	}
	
	/**
	 * Modifica el estado del Sprint por el que se pasa como parametro.
	 * @param est Estado que sobreescribira al actual.
	 */
	public void cambiarEstado(String est){
		EstadoSprint e=null;
		switch(est){
		case"planificado":
			e=EstadoSprint.PLANIFICADO;
			break;
		case"en curso":
			e=EstadoSprint.ENCURSO;
			break;
		case"finalizado":
			e=EstadoSprint.FINALIZADO;
			break;
		}
		estado=e;
	}

	/**
	 * 
	 * @param idT
	 * @param est
	 */
	public void cambiarEstadoTarea(String idT,String est){
		Tarea t=getTarea(idT);
		t.agregarEstadoHistorial(est, fAvance);
		t.setEstado(est);
	}
	
	/**
	 * Busca la Tarea con el id pasado como parametro y lo retorna
	 * @param id Id a buscar en la lista.
	 * @return Tarea a buscar.
	 */
	public Tarea getTarea(String id){
		Iterator<Tarea>lista=LTareas.iterator();
		Tarea t=null;
		boolean bandera=false;
		while(lista.hasNext() && !bandera){
			t=lista.next();
			if(t.getId().equals(id))
				bandera=true;
		}
		return t;
	}
	
	/**
	 * Muestra todo el Historial de cada tarea de la lista.
	 */
	public void muestraHistorial(){
		System.out.println("ID:"+clave);
		for(Tarea tar : LTareas){
			System.out.println(tar.getId());
			tar.muestraHistorico();
		}
	}
	
	/**
	 * Retorna la clave y la estimacion de las Historias del Sprint.
	 */
	public String toString(){
		return clave+" "+estimacionHistoriaSprint();
	}
	
	/**
	 * Retorna un ArrayList con todas las Tareas completadas.
	 * @return ArrayList con todas las Tareas completadas.
	 */
	public ArrayList<Tarea> tareasCompletadas(){
		ArrayList<Tarea>LCompletadas=new ArrayList<Tarea>();
		
		for(Tarea t:LTareas){
			if(t.getEstado().equals("DONE"))
				LCompletadas.add(t);	
		}
		return LCompletadas;
	}
	
	/**
	 * Retorna un ArrayList con todas las Tareas sin completar.
	 * @return ArrayList con todas las Tareas sin completar.
	 */
	public ArrayList<Tarea> tareasNoCompletadas(){
		ArrayList<Tarea>LNoCompletadas=new ArrayList<Tarea>();
		
		for(Tarea t:LTareas){
			if(!t.getEstado().equals("DONE"))
				LNoCompletadas.add(t);	
		}
		return LNoCompletadas;
	}
	
}
