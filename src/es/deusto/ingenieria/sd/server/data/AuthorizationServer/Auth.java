package es.deusto.ingenieria.sd.server.data.AuthorizationServer;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Auth extends UnicastRemoteObject implements IAuth {
	private static final long serialVersionUID = 1L;
	private String email1 = "ruben";
	private String pass1 = "1234";

	
	protected Auth() throws RemoteException {
		super();
	}
	
	
	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("usage: java [policy] [codebase] server.Server [host] [port] [server]"); 
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {		
			IAuth objServer = new Auth();
			Naming.rebind(name, objServer);//To include in RMIregistry
			System.out.println("* Server '" + name + "' active and waiting...");
		} catch (Exception e) {
			System.err.println("- Exception running the server: " + e.getMessage());
			e.printStackTrace();
		}
	}


	@Override
	public boolean connectTwitterService(String email, String password) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("connectTwitter print");
		if(email.equals(email1)){
			if(password.equals(pass1)){
				return true;
			}

		}
		return false;
	}

	

}
