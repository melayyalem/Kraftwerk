import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class Server {
    public static void main(String[] args) throws RemoteException {
        LocateRegistry.createRegistry( Registry.REGISTRY_PORT );

        Timer timer = new Timer();
        KraftwerkImpl ki1 = new KraftwerkImpl("Etzelwerk", "Sihlsee", "WK", 120);
        KraftwerkImpl ki2 = new KraftwerkImpl("Le Havre", "Le Havre", "FK", 1450);


        timer.schedule(ki1,0,5000);
        timer.schedule(ki2,0,5000);



        Kraftwerk k1 = (Kraftwerk) UnicastRemoteObject.exportObject(ki1,0);
        Kraftwerk k2 = (Kraftwerk) UnicastRemoteObject.exportObject(ki2,0);

        RemoteServer.setLog( System.out );

        Registry registry = LocateRegistry.getRegistry();
        registry.rebind( "Kraftwerk1", k1 );
        registry.rebind( "Kraftwerk2", k2 );
    }
}

