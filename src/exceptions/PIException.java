package exceptions;

public class PIException extends Exception {

	private static final long serialVersionUID = 1L;

	public PIException(String usuario) {
		super("O usuario " + usuario + " N�o existe");
	}

}
