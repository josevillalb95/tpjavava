package historial;

import java.time.LocalDate;
import java.util.ArrayList;

import Tareas.EstadoTarea;
import clases.Estados;

public class Historial {
	private LocalDate fecha;
	private Estados estado;
	//private ArrayList<EstadoTarea>estados=new ArrayList<EstadoTarea>();
	public Historial(LocalDate fecha, Estados estado) {
		super();
		this.fecha = fecha;
		this.estado = estado;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Estados getEstado() {
		return estado;
	}
	public void setEstado(Estados estado) {
		this.estado = estado;
	}
	
	
}
