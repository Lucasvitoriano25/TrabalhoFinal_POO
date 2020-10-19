package exceptions;

import profile.Perfil;

public class PEException extends Exception {

	private static final long serialVersionUID = 1L;

	public PEException(Perfil usuario) {
		super("Usuario" + usuario.getUsuario() + "já existe");
	}

}
