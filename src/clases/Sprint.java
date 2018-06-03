package clases;

import java.util.Date;
import java.util.Iterator;
import java.util.TreeSet;

import Tareas.Tarea;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Sprint implements Comparable<Sprint>{
	
	private	String clave, descripcion;
	private EstadoSprint estado;
	private LocalDate fInicio , fFin,fAvance;
	private int avance,duracion;
	private TreeSet<Tarea> LTareas;
	
	public Sprint(String clave, String descripcion) {
		this.clave = clave;
		this.descripcion = descripcion;
		this.estado = EstadoSprint.PLANIFICADO;
		this.LTareas = new TreeSet<Tarea>();
	}
	
	/**
	 * Retorna la clave del Sprint.
	 * @return clave
	 */
	public String getClave() {
		return clave;
	}
	public void actualizar(String clave, String descripcion) {
		this.clave = clave;
		this.descripcion = descripcion;
	}

	public TreeSet<Tarea> getListaT() {
		return LTareas;
	}
	
	public EstadoSprint getEstado() {
		return estado;
	}
	public void setEstadoSprint(EstadoSprint estado) {
		this.estado = estado;
	}
	public String getDescripcion() {
		return descripcion;
	}
	
	/**
	 * 
	 * @param tarea treeset que se va agregar a tareas
	 */
	public void aSprintTarea(Tarea tare) {
		LTareas.add(tare);
	}
	

	/**
	 * 
	 * @param clave
	 * @param tare
	 * Modifica el valor de la clave del Sprint.
	 * FALTA EL ESTADO :o !!! 
	 */
	public void mSprintTarea(String clave , Tarea tare) {
		for(Tarea c:LTareas ){
			if(c.getId().equals(clave)){
				//if(c.getEstado() != "finalizado" )
					//c.modTarea(tare.getNombre(),tare.getDescripcion() ,tare.getfFin(), tare.getEstado(), tare.getComplejidad());
			}
		}
		
	}
	
	
	/**
	 * 
	 * @param clave
	 * elimina un nodo del treeset que concida con la clave enviada 
	 */
	public void bSprintTarea(String clave , Tarea tare) {
		for(Tarea c:LTareas ){
			if(c.getId().equals(clave)){
				LTareas.remove(c);
			}
		}
	}
	

	public void setClave(String clave) {
		this.clave = clave;
	}

	/**
	 * Permite la comparación entre dos Sprints
	 * utilizando la clave para ordenarlos por
	 * orden alfabético.
	 * 
	 */
	public int compareTo(Sprint arg0) {		
		return this.clave.compareTo(arg0.getClave());
	}
	
	public LocalDate getFechaFin(){
		return fFin;
	}
	
	/**
	 * Comienza el Sprint, indicando
	 * cual es la fecha de inicio y la de fin.
	 * @param fi
	 * @param ff
	 */
	public void comenzar(LocalDate fi,LocalDate ff){
		//estado = EstadoSprint.ENCURSO;
		fInicio = fi;
		fFin = ff;
		fAvance=fInicio;
		avance=1;
		//Cantidad de dias de duracion y avance no se saca automaticamente?
		}
	
	/**
	 * Finaliza el Sprint.
	 */
	
	public void finalizar(){
		estado = EstadoSprint.FINALIZADO;
		//Trasladar Sprints sin terminar
	}
	
	public void bajaTarea(String idT){
		Iterator<Tarea>it=LTareas.iterator();
		Tarea t=null;
		boolean bandera=true;
		while(it.hasNext() && bandera){
			t=it.next();
			if(t.getId().compareTo(idT)==0){
				it.remove();
				bandera=false;
			}
		}
	}
	
	public int estimacionSprint(){
		int est=0;
		Iterator<Tarea> it = LTareas.iterator();
		Tarea tar=null;
		while(it.hasNext()){
			tar=it.next();
			est+=tar.estimacion();
		}
		return est;
	}
	
	public int estimacionHistoriaSprint(){
		int est=0;
		Iterator<Tarea> it = LTareas.iterator();
		Tarea tar=null;
		while(it.hasNext()){
			tar=it.next();
			if(tar.getId().substring(0,3).equals("HIS"))
				est+=tar.estimacion();
		}
		return est;
	}
	
	public void muestraTareasSprint(){
		Iterator<Tarea> it = LTareas.iterator();
		Tarea tar=null;
		while(it.hasNext()){
			tar=it.next();
			System.out.println(tar.getId());
		}
	}
	
	
	public LocalDate getfInicio() {
		return fInicio;
	}

	public LocalDate getfAvance() {
		return fAvance;
	}

	public void setfAvance(LocalDate fa) {
		this.fAvance = fa;
	}

	public int getAvance() {
		return avance;
	}

	public void setAvance() {
		avance+=1;
	}
	public int duracion(){
		int cant=(int)fInicio.until(fFin, ChronoUnit.DAYS);
		duracion=cant;
		return cant;
	}
	
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


		
	
}
