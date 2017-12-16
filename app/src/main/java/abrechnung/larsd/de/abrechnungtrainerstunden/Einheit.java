package abrechnung.larsd.de.abrechnungtrainerstunden;

/**
 * Created by larsd on 16.12.17.
 */

public class Einheit {

    public String datum;
    public double zeit;
    public double lohn;
    public double summe;

    public Einheit(){
        //leer für Database
    }

    public Einheit(String pDatum, double pZeit, double pLohn){
        datum = pDatum;
        zeit = pZeit;
        lohn = pLohn;
        summe = zeit * lohn;

    }
}
