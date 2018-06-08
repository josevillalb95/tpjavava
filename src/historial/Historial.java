package historial;

import java.time.LocalDate;
import java.util.ArrayList;

import Tareas.EstadoTarea;

public class Historial {
	private LocalDate fecha;
	private EstadoTarea estado;
	//private ArrayList<EstadoTarea>estados=new ArrayList<EstadoTarea>();
	public Historial(LocalDate fecha, EstadoTarea estado) {
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
	public EstadoTarea getEstado() {
		return estado;
	}
	public void setEstado(EstadoTarea estado) {
		this.estado = estado;
	}
	
	
}
