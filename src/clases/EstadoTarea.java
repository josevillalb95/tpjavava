package clases;

public enum EstadoTarea {
	TODO,
	INPROGRESS,
	PENDINGTOBUILD,
	READYTOTEST,
	TESTING,
	DONE;
	
	public EstadoTarea next(){
		switch (this){
		case TODO:
			return INPROGRESS;
		case INPROGRESS:
			return PENDINGTOBUILD;
		case PENDINGTOBUILD:
			return READYTOTEST;
		case READYTOTEST:
			return TESTING;
		case TESTING:
			return DONE;
		case DONE:
			return null;
		default:
			return null;
		}
	}
	
	public EstadoTarea previous(){
		switch (this){
		case TODO:
			return null;
		case INPROGRESS:
			return null;
		case PENDINGTOBUILD:
			return TODO;
		case READYTOTEST:
			return null;
		case TESTING:
			return TODO;
		case DONE:
			return null;
		default:
			return null;
		}
	}
	
}
