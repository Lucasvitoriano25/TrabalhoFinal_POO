package profile;

import java.util.ArrayList;
import java.util.List;

import exceptions.UJCException;
import exceptions.UNCException;

public class List_Usuario implements IRepositorioUsuario {

	List<Perfil> list = new ArrayList<Perfil>();

	public void cadastrar(Perfil usuario) throws UJCException {
		if (list.contains(usuario)) {
			throw new UJCException(usuario);
		} else {
			list.add(usuario);
		}
	}

	@Override
	public Perfil buscar(String usuario) {
		for (Perfil obj : list) {
			if (obj.getUsuario().equals(usuario)) {
				return obj;
			}
		}
		return null;

	}

	@Override
	// MUDAR ATUALIZAR
	public void atualizar(Perfil usuario) throws UNCException {
		if (!list.contains(usuario)) {
			throw new UNCException(usuario);
		}
		for (Perfil obj : list) {
			if (obj.equals(usuario)) {
				obj = usuario;
			}
		}
	}

}
