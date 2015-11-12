package lab8;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

public class FortuneServerImpl extends UnicastRemoteObject implements FortuneServerIntf {
	Random r;
	private static final String [] FORTUNES = { "You will be older than ever before.",
											    "Money is coming your way?",
											    "You left the oven on.",
											    "Something might be beneficial; keep a lookout.",
											    "You will be dissapointed by this GUI.",
											    "Tomorrow is another day.",
											    "Good things come in threes, bad things in fives, suprising things in nines.",
											    "You should write down your passwords and change them often.",
											    "The coffee is ready.",
											    "You have a 10% chance of getting this fortune."};
	
	protected FortuneServerImpl() throws RemoteException {
		super();
		r = new Random();
	}

	@Override
	public String tellFortune() throws RemoteException {
		return FORTUNES[r.nextInt(10)];
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
