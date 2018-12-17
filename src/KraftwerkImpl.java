import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TimerTask;

public class KraftwerkImpl extends TimerTask implements Kraftwerk {


    private String Name;
    private String Standort;
    private String Kraftwerktyp;
    private Integer Nennleistung;
    private Integer Momentanleistung;

    public KraftwerkImpl(String Name, String Standort, String Kraftwerktyp, Integer Nennleistung) {
        this.Name = Name;
        this.Standort = Standort;
        this.Kraftwerktyp = Kraftwerktyp;
        this.Nennleistung = Nennleistung;
        setLeistung();
    }

    public String getName() {
        return Name;
    }


    public Integer getNennleistung() {
        return Nennleistung;
    }



    public String getStandort() {
        return Standort;
    }

    private void setLeistung() {
        Random r = new Random();
        Momentanleistung = (int) Math.abs(Math.round(r.nextGaussian() * Nennleistung));
    }


    public String getKraftwerktyp() {
        return Kraftwerktyp;
    }

    @Override
    public int getLeistung() {
        return Momentanleistung;
    }

    public void run() {
        this.setLeistung();
    }
}

