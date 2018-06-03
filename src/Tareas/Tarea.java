package Tareas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

import estadosTareas.Estado;
import estadosTareas.ToDo;
import historial.Historial;

public class Tarea implements Comparable<Tarea> {

	private String id, nombre, descripcion;
	private LocalDate fFin;
	private EstadoTarea estado;
	private ArrayList<Estado> Lhist; //Podria ser un Treeset para ordenarlos por fecha?
	private int complejidad;
	private TreeSet<Tarea> LSTareas;
	private int estimacion; //Conviene sacar valor en Constructor o en otra funcion?
	private TreeSet<Tarea> Ldependencias;
	private TreeSet<Tarea> LSubtareas;
	private Historial historialEstados;
	
	public Tarea(String id, String nombre, String descripcion,EstadoTarea e, LocalDate finalizacion,
			int complejidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fFin = finalizacion;
		//this.estado = EstadoTarea.TODO;
		this.estado = e;
		//this.LSTareas = null;
		this.complejidad = complejidad;
		//Lhist =null;
		Ldependencias=new TreeSet<Tarea>();
		LSubtareas=new TreeSet<Tarea>();
	}
	public TreeSet<Tarea> getListaS() {
		return LSTareas;
	}
	public void aBacklogTarea(Tarea tare) {
		LSTareas.add(tare);
	}
	
	public TreeSet<Tarea> getLdependencias() {
		return Ldependencias;
	}
	
	public void setLdependencias(TreeSet<Tarea> ldependencias) {
		Ldependencias = ldependencias;
	}
	/**
	 * 
	 * @param clave
	 * @param tare
	 * Modifica el valor de la clave del backlog.
	 * FALTA EL ESTADO :o !!! 
	 */
	public void mBacklogTarea(String clave , Tarea tare) {
		for(Tarea c:LSTareas ){
			if(c.getId().equals(clave)){
				//if(c.getEstado() != "finalizado" )
					//c.modTarea(tare.getNombre(),tare.getDescripcion() ,tare.getfFin(), tare.getEstado(), tare.getComplejidad());
			c.getDescripcion();
			}
		}
	}
	/**
	 * 
	 * @param clave
	 * elimina un nodo del treeset que concida con la clave enviada 
	 */
	public void bSprintTarea(String clave , Tarea tare) {
		for(Tarea c:LSTareas ){
				LSTareas.remove(c); 
		}
	}
	
	
	public void modTarea( String nombre, String descripcion, LocalDate finalizacion, EstadoTarea estado,int complejidad) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fFin = finalizacion;
		this.estado = estado;
		this.complejidad = complejidad;
		Lhist = new ArrayList<>();
	}
	
	
	public String getNombre() {
		return nombre;
	}


	 
	public String getDescripcion() {
		return descripcion;
	} 
	public LocalDate getfFin() {
		return fFin;
	} 
	public String getEstado() {
		return estado.toString();
	}
 
	public ArrayList<Estado> getLhist() {
		return Lhist;
	}

 
	public int getEstimacion() {
		return estimacion;
	}
	
	public void TareaMOD(String nombre, String descripcion, LocalDate finalizacion, EstadoTarea estado,int complejidad) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fFin = finalizacion;
		this.estado = estado;
		this.complejidad = complejidad;
	}
	/**
	 * Retorna el id de la Tarea.
	 * @return id
	 */

	public String getId() {
		return id;
	}
	
	/**
	 * Modifica el id de la Tarea.
	 * @param id
	 */

	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Retorna complejidad de la Tarea.
	 * @return complejidad
	 */
	
	public int getComplejidad() {
		return complejidad;
	}
	
	/**
	 * Compara dos Tareas.
	 * Retorna True si son iguales.
	 * Retorna False si son diferentes.
	 * @param obj
	 * @return true || false
	 */

	public boolean equals(Tarea obj) {
		if (id.equals(obj.getId()))
			return true;
		else
			return false;
	}
	
	/**
	 * Muestra los datos de los pasos que realizó la tarea
	 * hasta el punto actual.
	 */
	
	public void muestraHistorico(){
		Iterator<Estado> it = Lhist.iterator();
		while (it.hasNext()){
			System.out.println(it.next().toString() + "\n");
		}		
	}
	public void agregarSubT(Tarea tar){
		if(tar.getId().substring(0, 3).equals("TAR") && tar.getComplejidad()==0)
			LSubtareas.add(tar);
		else
			System.out.println("Las subtareas solo pueden ser de tipo tarea y no tienen que tener complejidad");
	}
	
	public void bajaSubT(String idSubT){
		Iterator<Tarea>it=LSubtareas.iterator();
		Tarea t=null;
		boolean bandera=true;
		while(it.hasNext() && bandera){
			t=it.next();
			if(t.getId().equals(idSubT)){
				it.remove();
				bandera=false;
			}
		}
	}
	
	public void agregarDep(Tarea tar){
		Ldependencias.add(tar);
	}
	
	public void bajaDependencia(String idDep){
		Iterator<Tarea>it=Ldependencias.iterator();
		Tarea t=null;
		boolean bandera=true;
		while(it.hasNext() && bandera){
			t=it.next();
			if(t.getId().equals(idDep)){
				it.remove();
				bandera=false;
			}
		}
	}
	
	public int estimacion(){
		return complejidad;
	}

	/**
	 * Permite la comparación entre una Tarea y 
	 * la Tarea actual.
	 * param @arg0 	
	 */
	@Override
	public int compareTo(Tarea arg0) {
		return this.id.compareTo(arg0.getId());
	}
	
	public void muestraDependencias(){
		Iterator<Tarea>it=Ldependencias.iterator();
		Tarea t=null;
		if(!Ldependencias.isEmpty()){
			System.out.println("Dependencias:");
			while(it.hasNext()){
				t=it.next();
				System.out.println(t.getId());
			}
		}
	}
	
	public void muestraSubTareas(){
		Iterator<Tarea>it=LSubtareas.iterator();
		Tarea t=null;
		if(!LSubtareas.isEmpty()){
			System.out.println("Subtareas:");
			while(it.hasNext()){
				t=it.next();
				System.out.println(t.getId());
			}
		}
	}
	
	public void agregaFlujoPaso(String descripcion,int pasos){
		
	}
	
	/*public void agregarSubTarea(Tarea tar){
		if(tar.getId().substring(0, 3).equals("TAR") && tar.getComplejidad()!=0)
			LSubtareas.add(tar);
		else
			System.out.println("Las subtareas solo pueden ser de tipo tarea");
	}*/
	public void muestra(){
		System.out.println(id);
	}


	/*
	 * @Override public int compare(Object o1, Object o2) { // TODO
	 * Auto-generated method stub return 0; }
	 */

}
