import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class Client {
    public static void main(String[] args) {
        Kraftwerk k = null;
        try {
            Registry registry = LocateRegistry.getRegistry();
            k = (Kraftwerk) registry.lookup("Kraftwerk1");
        }catch (Exception e1){
            System.out.println("Error connecting");
        }

        try{
            System.out.println(k.getLeistung());
        }catch (Exception e1){
            System.out.println("Error");
        }
    }
}
