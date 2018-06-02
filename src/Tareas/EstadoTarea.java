package Tareas;

public enum EstadoTarea {
	TODO,
	INPROGRESS,
	PENDINGTOBUILD,
	READYTOTEST,
	TESTING,
	DONE;
	
	public EstadoTarea next(){
		EstadoTarea estado;
		switch (this){
		case TODO:
			estado = INPROGRESS;
		case INPROGRESS:
			estado = PENDINGTOBUILD;
		case PENDINGTOBUILD:
			estado = READYTOTEST;
		case READYTOTEST:
			estado = TESTING;
		case TESTING:
			estado = DONE;
		case DONE:
			estado = null;
		default:
			estado = null;
		}
		return estado;
	}
	
	public EstadoTarea previous(){
		EstadoTarea estado;
		switch (this){
		case TODO:
			estado = null;
			break;
		case INPROGRESS:
			estado = null;
			break;
		case PENDINGTOBUILD:
			estado = TODO;
			break;
		case READYTOTEST:
			estado = null;
			break;
		case TESTING:
			estado = TODO;
			break;
		case DONE:
			estado = null;
			break;
		default:
			estado = null;
		}
		return estado;
	}
	
}
