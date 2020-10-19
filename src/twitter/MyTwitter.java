package twitter;

import java.util.Vector;

import exceptions.PEException;
import exceptions.UJCException;
import profile.List_Usuario;
import profile.Perfil;

public class MyTwitter implements ITwitter{

	List_Usuario Banco_de_Dados = new List_Usuario();
	
	@Override
	public void criarPerfil(Perfil usuario) throws PEException {
		if(Banco_de_Dados.buscar(usuario.getUsuario())!=null) {
			try {
				Banco_de_Dados.cadastrar(usuario);
			} catch (UJCException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			throw new PEException(usuario);
		}
	}

	@Override
	public void cancelarPerfil(String usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tweetar(String usuario, String mensagem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<Tweet> timeline(String usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Tweet> tweets(String usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void seguir(String seguidor, String seguido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void numeroSeguidores(String usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<Perfil> seguidores(String usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Perfil> seguidos(String usuario) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
