import java.rmi.RemoteException;
import java.util.Random;

public class KraftwerkImpl implements Kraftwerk {
private String Name;
private String Standort;
private String Kraftwerktyp;
private Integer Nennleistung;
private Integer Momentanleistung;

public KraftwerkImpl(String Name, String Standort, String Kraftwerktyp, Integer Nennleistung){
    this.Name = Name;
    this.Standort = Standort;
    this. Kraftwerktyp = Kraftwerktyp;
    this.Nennleistung = Nennleistung;
    setLeistung();
}

private void setLeistung(){
     Random r = new Random();
     Momentanleistung = (int) Math.round(r.nextGaussian() * Nennleistung);
}

    @Override
    public String getLeistung() {
        return Name;
    }
}
