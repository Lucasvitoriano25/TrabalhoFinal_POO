package exceptions;

public class MFPException extends Exception {

	private static final long serialVersionUID = 1L;

	public MFPException() {
		super("Limite de 140 caracteres atingido");
	}
}
