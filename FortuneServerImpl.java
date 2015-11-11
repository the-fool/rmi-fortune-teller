package lab8;

import java.rmi.Naming;
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
		return "Fortunate, you are.";
	}
	
	public static void main (String [] args) throws RemoteException {
		System.err.println("Initializing server.");
		FortuneServerImpl f = new FortuneServerImpl();
		String serverObjName = "//localhost/server";
		try {
			Naming.rebind(serverObjName, f);
		} catch (Exception e) {
			System.err.println("Server failed: " + e);
		}
	}
}
