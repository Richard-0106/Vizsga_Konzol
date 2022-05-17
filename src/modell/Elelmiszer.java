
package modell;

import java.io.Serializable;
import java.text.Collator;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

class NevComparator implements Comparator<Elelmiszer>{

    @Override
    public int compare(Elelmiszer o1, Elelmiszer o2) {
   Collator coll = Collator.getInstance();
        return coll.compare(o1.getNev(), o2.getNev());
    }
}
class GyartoComparator implements Comparator<Elelmiszer>{

    @Override
    public int compare(Elelmiszer o1, Elelmiszer o2) {
   Collator coll = Collator.getInstance();
        return coll.compare(o1.getGyarto(), o2.getGyarto());
    }
}

public abstract class Elelmiszer implements Serializable{
    private String nev,gyarto;
 
   private LocalDate datum;

    public Elelmiszer(String nev, String gyarto) throws HibasDatumException {
        this(nev,gyarto,LocalDate.now());
    }
    public Elelmiszer(String nev, String gyarto, LocalDate datum) throws HibasDatumException {
        if(datum.isBefore(LocalDate.now())){
        throw new HibasDatumException("Lejárt élelmiszer");
        }
        this.nev = nev;
        this.gyarto = gyarto;
        this.datum = datum;
    }

    public String getNev() {
        return nev;
    }

    public String getGyarto() {
        return gyarto;
    }

    public LocalDate getDatum() {
        return datum;
    }
  public static NevComparator nevRendezo(){
        return new NevComparator();
    }
    
    public static GyartoComparator gyartoRendezo(){
        return new GyartoComparator();
    }
    @Override
    public String toString() {
        return "Elelmiszer{" + "nev=" + nev + ", gyarto=" + gyarto + ", datum=" + datum + '}';
    }
    
}
