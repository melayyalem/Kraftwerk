import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Random;

public interface Kraftwerk extends Remote{
    String getLeistung() throws RemoteException;
}


