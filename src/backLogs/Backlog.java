package backLogs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

import Tareas.Bug;
import Tareas.EstadoTarea;
import Tareas.Historia;
import Tareas.Mejora;
import Tareas.Tarea;

public class Backlog {
	private TreeSet<Tarea> LTareasP = new TreeSet<Tarea>();

	
	/**
	 * SE AGREGA UN BACKLOGS  ( ES UNA TREESET DE TAREA ) 
	 */
	public void agrega() {
		/*Tarea t= new Tarea("45Julia", null, null, null, 0);
		Tarea t2= new Tarea("45Maria", null, null, null, 0);
		Tarea t3= new Tarea("16Julia", null, null, null, 0);
		LTareasP = new TreeSet<Tarea>();
		LTareasP.add(t);
		LTareasP.add(t2);
		LTareasP.add(t3);*/
		
		for(Tarea lt : LTareasP) {
			System.out.println(lt.getId());
		}
	}

	

	
	public TreeSet<Tarea> getLTareasP() {
		return LTareasP;
	}

	/**
	 * Permite agregar tareas a LTareasP
	 * @param tipo
	 * @param id
	 * @param nombre
	 * @param desc
	 * @param finalizacion
	 * @param comp
	 * DEPENDE DE SU TIPO BUG , HISTORIA , ETC 
	 */
	public void altaTarea(String tipo, String id, String nombre, String desc,EstadoTarea est, LocalDate finalizacion, int comp){
		Tarea tar;
		switch (tipo){
			case "Bug":
				tar = new Bug(id,nombre,desc,est,finalizacion,comp);
				break;
			case "Historia":
				tar = new Historia(id,nombre,desc,est,finalizacion,comp);
				break;
			case "Mejora":
				tar = new Mejora(id,nombre,desc,est,finalizacion,comp);
				break;
			case "Tarea":
				tar = new Tarea(id,nombre,desc,est,finalizacion,comp);
				break;
			default:
				tar = null;
				break;	
		}
		LTareasP.add(tar);
	}
	
	/**
	 * Busca tarea con el id pasado como parametro y la retorna
	 * @param id
	 * @return
	 */
	public Tarea buscaTarea(String id){
		Iterator<Tarea>it = LTareasP.iterator();
		Tarea tar = null;
		boolean bandera = false;
		while(it.hasNext() && !bandera){
			tar= it.next();
			if(tar.getId().equals(id))
				bandera = true;
		}
		return tar;
	}

	/**
	 * 
	 * @param clave
	 * @param tare
	 * Modifica el valor de la clave del backglog.
	 * FALTA EL ESTADO :o !!! 
	 */
	
	public void mBacklogTarea(String clave , Tarea tare) {
		for(Tarea c:LTareasP ){
			if(c.getId().equals(clave)){
				if(c.getEstado() != "finalizado" )
					//c.modTarea(tare.getNombre(),tare.getDescripcion() ,tare.getfFin(), tare.getEstado(), tare.getComplejidad());
			c.getDescripcion();
			}
		}
	}
	
	
	/**
	 * Retorna la tarea con el id inicado por parametro
	 * @param id
	 * @return
	 */
	public Tarea getTarea(String id){
		boolean bandera = false;
		Iterator<Tarea> it = LTareasP.iterator();
		Tarea tar = null;
		while (it.hasNext() && !bandera){
			tar = it.next();
			if(tar.getId().equals(id))
				bandera = true;
		}
		if (bandera)
			return tar;
		else
			return null;
	}
	
	/**
	 * 
	 * @param clave
	 * elimina un nodo del treeset que concida con la clave enviada 
	 */
	
	public void bajaTarea(String clave) {
		Iterator<Tarea>it=LTareasP.iterator();
		Tarea t=null;
		boolean bandera=true;
		while(it.hasNext() && bandera){
			t=it.next();
			if(t.getId().equals(clave)){
				it.remove();
				bandera=false;
			}
		}
	}
	/**
	 * CARGA LISTA DE TAREAS DESDE UN .TXT 
	 */
	public void cargaListaTareas(){
		Tarea t=null;
		File f=new File("Tareas.txt");
		String id,nombre,descripcion,dep,subT,fp;
		String e;
		LocalDate fechaFinalizacion;
		EstadoTarea est=null;
		int comp;
		DateTimeFormatter dateForm=DateTimeFormatter.ofPattern("dd/M/yyyy");
		
		try{
		Scanner s=new Scanner(f);
			while(s.hasNextLine()){
				String linea=s.nextLine();
				Scanner sl=new Scanner(linea);
				sl.useDelimiter("\\s*-\\s*");
				id=sl.next();
				nombre=sl.next();
				descripcion=sl.next();
				e=sl.next();
				switch(e){
				case"ToDo":
					est=EstadoTarea.TODO;
					break;
				case"InProgress":
					est=EstadoTarea.INPROGRESS;
					break;
				case"PendingToBuild":
					est=EstadoTarea.PENDINGTOBUILD;
					break;
				case"ReadyToTest":
					est=EstadoTarea.READYTOTEST;
					break;
				case"Testing":
					est=EstadoTarea.TESTING;
					break;
				case"Done":
					est=EstadoTarea.DONE;
				}
				comp=Integer.valueOf(sl.next());
				dep=sl.next();
				subT=sl.next();
				try{
					fechaFinalizacion=LocalDate.parse(sl.next(), dateForm);
				}catch(DateTimeParseException ex){
					fechaFinalizacion=null;
				}
				fp=sl.next();
				switch(id.substring(0,3)){
				case"TAR":{
					t=new Tarea(id,nombre,descripcion,est,fechaFinalizacion,comp);
					break;
				}
				case"HIS":{
					t=new Historia(id,nombre,descripcion,est,fechaFinalizacion,comp);
					//t.agregarFlujoPaso(fp);
					break;
				}
				case"MEJ":{
					t=new Mejora(id,nombre,descripcion,est,fechaFinalizacion,comp);
					break;
				}
				case "BUG":{
					t=new Bug(id,nombre,descripcion,est,fechaFinalizacion,comp);
					break;
				}
				}
				//t.agregarDependencia(dep);
				//t.agregarSubTarea(subT);
				LTareasP.add(t);
				//tareasAuxiliar.add(t);
				//serializa(listaTareas,"tareas.ser");
				//serializa(tareasAuxiliar,"tareasAux.ser");
				sl.close();
				
			}
			
			s.close();
			
		}catch(FileNotFoundException ex){
			ex.printStackTrace();
		}
		
		
	}
	
	public void muestraTareas(){
		for(Tarea t:LTareasP){
			t.muestra();
			t.muestraDependencias();
			t.muestraSubTareas();
		}
	}
	
	public void agregaDependencia(String idT,String idDep){
		Iterator<Tarea>it=LTareasP.iterator();
		Tarea t=null; //tarea a la que hay que agregarle la dependencia
		Tarea tDep=null;//dependencia que hay que agregar
		boolean bandera=true;
		while(it.hasNext() && bandera){
			t=it.next();
			if(t.getId().equals(idT)){
				bandera=false;
			}
		}
		Iterator<Tarea>it2=LTareasP.iterator();
		bandera=true;
		while(it2.hasNext() && bandera){
			tDep=it2.next();
			if(tDep.getId().equals(idDep)){
				t.agregarDep(tDep);
				bandera=false;
			}
		}
	}
	
	public void bajaDependencia(String idT, String idDep){
		Iterator<Tarea>it=LTareasP.iterator();
		Tarea t=null; 
		Tarea subT=null;
		boolean bandera=true;
		while(it.hasNext() && bandera){
			t=it.next();
			if(t.getId().equals(idT)){
				bandera=false;
			}
		}
		Iterator<Tarea>it2=LTareasP.iterator();
		bandera=true;
		while(it2.hasNext() && bandera){
			subT=it2.next();
			if(subT.getId().equals(idDep)){
				t.bajaDependencia(idDep);
				bandera=false;
			}
		}
	}
	
	
	public void agregaFP(String idT,String desc,int pasos){
		Iterator<Tarea>it=LTareasP.iterator();
		Tarea t=null; 
		boolean bandera=true;
		while(it.hasNext() && bandera){
			t=it.next();
			if(t.getId().equals(idT)){
				t.agregaFlujoPaso(desc, pasos);
				bandera=false;
			}
		}
	}
	
	public void agregaSubTarea(String idT, String idSubT){
		Iterator<Tarea>it=LTareasP.iterator();
		Tarea t=null; 
		Tarea subT=null;
		boolean bandera=true;
		while(it.hasNext() && bandera){
			t=it.next();
			if(t.getId().equals(idT)){
				bandera=false;
			}
		}
		Iterator<Tarea>it2=LTareasP.iterator();
		bandera=true;
		while(it2.hasNext() && bandera){
			subT=it2.next();
			if(subT.getId().equals(idSubT)){
				t.agregarSubT(subT);
				bandera=false;
			}
		}
	}
	
	public void bajaSubTarea(String idT, String idSubT){
		Iterator<Tarea>it=LTareasP.iterator();
		Tarea t=null; 
		Tarea subT=null;
		boolean bandera=true;
		while(it.hasNext() && bandera){
			t=it.next();
			if(t.getId().equals(idT)){
				bandera=false;
			}
		}
		Iterator<Tarea>it2=LTareasP.iterator();
		bandera=true;
		while(it2.hasNext() && bandera){
			subT=it2.next();
			if(subT.getId().equals(idSubT)){
				t.bajaSubT(idSubT);
				bandera=false;
			}
		}
	}
	
}
