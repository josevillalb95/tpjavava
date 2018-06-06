/**
 * 
 */
package clases;

//import java.util.Date;
import java.util.Iterator;
import java.util.TreeSet;

import javax.swing.plaf.OptionPaneUI;

import Tareas.Tarea;
import UI.InterfazGrafica;
import backLogs.Backlog;
import estadosTareas.Estado;
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
	
	public static Proyecto getInstance(){
		
		if (instance == null)
			instance = new Proyecto(); 
		
		return instance; 	
	}
	
	public Backlog getBlog() {
		return blog;
	}

	public void diasig(){
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
	
	public void agregarTareasSprint(String idS,String idT){
		Iterator<Sprint>it=LSprints.iterator();
		Sprint sp=null;
		boolean bandera=true;
		while(it.hasNext() && bandera){
			sp=it.next();
			if(sp.getClave().equals(idS)){
				//sp.aSprintTarea(t);
				bandera=false;
			}
		}
		Iterator<Tarea>it1=blog.getLTareasP().iterator();
		Tarea tar=null;
		bandera=true;
		while(it1.hasNext() && bandera){
			tar=it1.next();
			if(tar.getId().equals(idT)){
				sp.aSprintTarea(tar);
				//blog.bajaTarea(tar.getId());
				bandera=false;
			}
			
		}
	}
	public void cargarTareas(){
		blog.cargaListaTareas();
	}
	public void mostrarTareas(){
		blog.muestraTareas();
	}
	
	public void agregarDependencias(String idT,String idDep){
		blog.agregaDependencia(idT, idDep);
	}
	public void eliminarDependencia(String idT,String idDep){
		blog.bajaDependencia(idT, idDep);
	}
	
	public void agregarFlujoPaso(String idT, String descripcion, int pasos){
		blog.agregaFP(idT, descripcion, pasos);
	}
	
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
	
	public void bajaTareaBackLog(String idTarea){
		blog.bajaTarea(idTarea);
	}
	/**
	 * 
	 * @param idT tarea a la que hay que agregarle la subTarea
	 * @param idSubT subTarea que hay que agregar
	 */
	public void agregaSubT(String idT,String idSubT){
		blog.agregaSubTarea(idT, idSubT);
	}
	public void eliminarSubT(String idT,String idSubT){
		blog.bajaSubTarea(idT, idSubT);
	}
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
	
	public Sprint devuelveSprint(String idSprint){
		Iterator<Sprint>it=LSprints.iterator();
		Sprint sp=null;
		boolean bandera=true;
		while(it.hasNext() && bandera){
			sp=it.next();
			if(sp.getClave().compareTo(idSprint)==0){
				bandera=false;
			}
		}
		return sp;
	}
	public void sprintEnCurso(String idSprint, LocalDate fi,LocalDate ff){
		Sprint s=devuelveSprint(idSprint);
		s.comenzar(fi, ff);
	}
	
	public void avance(String idSprint){
		Sprint s=devuelveSprint(idSprint);
		//LocalDate fecha=s.getfInicio().plusDays(1);
		if(s.getEstado().toString().equals("ENCURSO")){
			LocalDate fecha=s.getfAvance().plusDays(1);
			int avance=(int)s.getfInicio().until(fecha, ChronoUnit.DAYS);
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
}