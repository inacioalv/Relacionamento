package br.com.inacio.ManyToOne.exception;


public class ResourceNotFoundException extends  RuntimeException {

	private static final long serialVersionUID = 8966538926167993896L;
	
	public ResourceNotFoundException(String msg) {
		super(msg);
	}
	
	public ResourceNotFoundException() {}
	

}
