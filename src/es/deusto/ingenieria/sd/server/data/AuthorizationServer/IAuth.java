package es.deusto.ingenieria.sd.server.data.AuthorizationServer;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAuth extends Remote{

	public boolean connectTwitterService(String email, String password) throws RemoteException;
}
