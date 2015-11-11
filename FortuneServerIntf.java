package lab8;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FortuneServerIntf extends Remote {
	public String tellFortune() throws RemoteException;
}
