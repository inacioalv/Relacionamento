package br.com.inacio.OneToOne.exception;


public class ObjectNotFoundException extends  RuntimeException {

	private static final long serialVersionUID = 8966538926167993896L;
	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	
	public ObjectNotFoundException() {}
	

}
