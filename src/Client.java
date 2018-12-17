import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<Kraftwerk> Kraftwerke = new ArrayList<>();
        try {
            Registry registry = LocateRegistry.getRegistry();
            String[] KraftwerkeNamen = registry.list();
            for (String name : KraftwerkeNamen){
                System.out.println(name);
                Kraftwerke.add((Kraftwerk) registry.lookup(name));
            }
        }catch (Exception e1){
            System.out.println("Error connecting");
        }

        while(true) {
            try {
                for(Kraftwerk kf: Kraftwerke){
                    System.out.println("Name: "+kf.getName()+" Leistung: "+kf.getLeistung()+"/"+kf.getNennleistung()+" Standort: "+kf.getStandort());
                }
                Thread.sleep(1000);
            } catch (Exception e1) {
                System.out.println("Error");
            }
        }
    }
}

