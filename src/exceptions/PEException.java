package exceptions;

import profile.Perfil;

public class PEException extends Exception {

	private static final long serialVersionUID = 1L;

	public PEException(Perfil usuario) {
		super("Nome de usu�rio " + usuario.getUsuario() + " j� existe");
	}

}
