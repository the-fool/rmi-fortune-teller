package lab8;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

public class FortuneServerImpl extends UnicastRemoteObject implements FortuneServerIntf {
	Random r;
	private static final String [] FORTUNES = {};
	
	protected FortuneServerImpl() throws RemoteException {
		super();
		r = new Random();
	}

	@Override
	public String tellFortune() throws RemoteException {
		
		return null;
	}
	
	
}
