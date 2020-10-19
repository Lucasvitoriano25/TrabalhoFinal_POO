package twitter;

import java.util.Vector;

import exceptions.PEException;
import exceptions.UJCException;
import profile.Perfil;

public interface ITwitter {

	public void criarPerfil(Perfil usuario) throws PEException;

	public void cancelarPerfil(String usuario);

	public void tweetar(String usuario, String mensagem);

	public Vector<Tweet> timeline(String usuario);

	public Vector<Tweet> tweets(String usuario);

	public void seguir(String seguidor, String seguido);

	public void numeroSeguidores(String usuario);

	public Vector<Perfil> seguidores(String usuario);

	public Vector<Perfil> seguidos(String usuario);

}
