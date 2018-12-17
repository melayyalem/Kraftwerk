import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public interface Kraftwerk extends Remote{
    List<KraftwerkImpl> getKraftwerke() throws RemoteException;
    void addKraftwerke(Kraftwerk neu) throws RemoteException;
    int getLeistung() throws RemoteException;
    String getName() throws RemoteException;
    String getStandort() throws RemoteException;
    Integer getNennleistung()throws RemoteException;
}


