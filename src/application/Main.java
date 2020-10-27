package application;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

import exceptions.MFPException;
import exceptions.PDException;
import exceptions.PEException;
import exceptions.PIException;
import exceptions.SIException;
import exceptions.UJCException;
import profile.Perfil;
import profile.Pessoa_Fisica;
import profile.Pessoa_Juridica;
import twitter.MyTwitter;
import twitter.Tweet;

public class Main {

	public static void main(String[] args) {
		int funcao = 1;
		System.out.println("Bem vindo ao Twitter!");
		Scanner sc = new Scanner(System.in);
		MyTwitter Twitter = new MyTwitter();
		while (funcao != 0) {
			System.out.println();
			System.out.println("Digite oque você quer fazer:");
			System.out.println("1 Para cadastrar perfil");
			System.out.println("2 Para cancelar perfil");
			System.out.println("3 Para apagar perfil");
			System.out.println("4 Para entrar no seu perfil");
			System.out.println("0 Se você quiser sair do Twitter");
			try {
			funcao = sc.nextInt();
			}
			catch(InputMismatchException e){
				System.out.println();
				System.out.println("Digite um número!");
				funcao=5;
				sc.next();
			}
			switch (funcao) {
			case 1:
				System.out.println("Qual será o nickname ?");
				String usuario = sc.next();

				System.out.println("O perfil será PF ou PJ ?");
				String perfilType;

				perfilType = sc.next();

				if (perfilType.equals("PF")) {
					Pessoa_Fisica perfil = new Pessoa_Fisica(usuario);
					try {
						Twitter.criarPerfil(perfil);
						System.out.println("Perfil criado");

					} catch (PEException e) {
						System.out.println(e.getMessage());

					} catch (UJCException e) {
						System.out.println(e.getMessage());
					}

				} else if (perfilType.equals("PJ")) {
					Pessoa_Juridica perfil = new Pessoa_Juridica(usuario);
					try {
						Twitter.criarPerfil(perfil);
						System.out.println("Perfil criado");

					} catch (PEException e) {
						System.out.println(e.getMessage());

					} catch (UJCException e) {
						System.out.println(e.getMessage());
					}

				} else {
					System.out.println("O perfil deve ser PF ou PJ, repita a operação");
				}
				break;
			case 2:
				System.out.println("Qual será o perfil a ser cancelado ?");
				usuario = sc.next();
				try {
					Twitter.cancelarPerfil(usuario);
					System.out.println("Perfil cancelado");

				} catch (PIException e) {
					System.out.println(e.getMessage());

				} catch (PDException e) {
					System.out.println(e.getMessage());
				}

				break;

			case 3:
				System.out.println("Qual será o perfil a ser apagado ?");
				usuario = sc.next();

				try {
					Twitter.removerperfil(usuario);
					System.out.println("Perfil apagado");

				} catch (PIException e) {
					System.out.println(e.getMessage());
				}

				break;
			case 4:
					System.out.println("Qual seu nickname ?");
					usuario = sc.next();
	
					System.out.println();
					System.out.println("1 Para saber seus tweets");
					System.out.println("2 Para saber sua timeline");
					System.out.println("3 Para tweetar");
					System.out.println("4 Para saber quantos seguidores você tem");
					System.out.println("5 Para saber quem segue você");
					System.out.println("6 Para saber quem você segue");
					System.out.println("7 Para seguir");
					try {
						funcao = sc.nextInt();
						}
						catch(InputMismatchException e){
							System.out.println();
							System.out.println("Digite um número!");
							funcao=8;
							sc.next();
						}
					System.out.println();
	
					switch (funcao) {
					case 1:
						try {
							Vector<Tweet> tweet = Twitter.tweets(usuario);
							System.out.println("Seus tweets: ");
							for (Tweet obj : tweet) {
								System.out.println(obj.getMensagem());
							}
						} catch (PIException e) {
							System.out.println(e.getMessage());
						} catch (PDException e) {
							System.out.println(e.getMessage());
						}
						break;
	
					case 2:
						try {
							System.out.println("Timeline: ");
							Vector<Tweet> tweet = Twitter.timeline(usuario);
							for (Tweet obj : tweet) {
								System.out.println(obj.getUsuario());
								System.out.println(obj.getMensagem());
								System.out.println();
							}
						} catch (PIException e) {
							System.out.println(e.getMessage());
						} catch (PDException e) {
							System.out.println(e.getMessage());
						}
						break;
	
					case 3:
						System.out.println("Digite a mensagem: ");
						sc.nextLine();
						String mensagem = sc.nextLine();
						try {
							Twitter.tweetar(usuario, mensagem);
						} catch (PIException e) {
							System.out.println(e.getMessage());
						} catch (MFPException e) {
							System.out.println(e.getMessage());
						} catch (PDException e) {
							System.out.println(e.getMessage());
						}
						break;
	
					case 4:
						try {
							int seguidores = Twitter.numeroSeguidores(usuario);
							System.out.println("Você tem: " + seguidores+" seguidores");
						} catch (PDException e) {
							System.out.println(e.getMessage());
						} catch (PIException e) {
							System.out.println(e.getMessage());
						}
						break;
					case 5:
						try {
							System.out.println("Seus seguidores: ");
							Vector<Perfil> perfil = Twitter.seguidores(usuario);
							for (Perfil obj : perfil) {
								System.out.println(obj.getUsuario());
							}
						} catch (PDException e) {
							System.out.println(e.getMessage());
						} catch (PIException e) {
							System.out.println(e.getMessage());
						}
						break;
					case 6:
						try {
							System.out.println("Quem você segue: ");
							Vector<Perfil> perfil = Twitter.seguidos(usuario);
							for (Perfil obj : perfil) {
								System.out.println(obj.getUsuario());
							}
						} catch (PDException e) {
							System.out.println(e.getMessage());
						} catch (PIException e) {
							System.out.println(e.getMessage());
						}
						break;
					case 7:
						System.out.println("Quem você quer seguir?");
						String usuarioSeguir = sc.next();
						try {
							Twitter.seguir(usuario, usuarioSeguir);
						} catch (SIException e) {
							System.out.println(e.getMessage());
						} catch (PDException e) {
							System.out.println(e.getMessage());
						} catch (PIException e) {
							System.out.println(e.getMessage());
						}
						break;
					
					case 8:
						break;
					}
							
				break;
				
			case 5:
				break;
				
			}
		}
		sc.close();
		System.out.println("Obrigado por usar o Twitter!");
	}

}
