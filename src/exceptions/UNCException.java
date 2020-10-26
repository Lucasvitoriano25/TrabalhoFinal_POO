package exceptions;

import profile.Perfil;

public class UNCException extends Exception {

	private static final long serialVersionUID = 1L;

	public UNCException(Perfil usuario) {
		super("Usuario " + usuario.getUsuario() + " não existe");

	}
}