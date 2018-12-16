import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) throws RemoteException {
        LocateRegistry.createRegistry( Registry.REGISTRY_PORT );

        KraftwerkImpl ki1 = new KraftwerkImpl("Etzelwerk", "Sihlsee", "WK", 120);
        KraftwerkImpl ki2 = new KraftwerkImpl("Le Havre", "Le Havre", "FK", 1450);

        Kraftwerk k1 = (Kraftwerk) UnicastRemoteObject.exportObject(ki1,0);
        Kraftwerk k2 = (Kraftwerk) UnicastRemoteObject.exportObject(ki2,0);

        RemoteServer.setLog( System.out );

        Registry registry = LocateRegistry.getRegistry();
        registry.rebind( "Kraftwerk1", k1 );
        registry.rebind( "Kraftwerk2", k2 );
    }
}


