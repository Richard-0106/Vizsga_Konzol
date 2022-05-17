package modell;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Raktar implements Iterable<Elelmiszer>, Serializable {

    private ArrayList<Elelmiszer> elelmiszerek;

    public Raktar() {
        elelmiszerek = new ArrayList<>();
        try {
            Konzerv k1 = new Konzerv("finom kutya konzerv", "kutya konzerv", "3gyartó ", LocalDate.now()); 
               Konzerv k2 = new Konzerv("nem finom macska konzerv", "macska konzerv", "2gyartó ", LocalDate.now());  
               Konzerv k3 = new Konzerv("abcd kukorica", "kukorica konzerv", "1gyartó ", LocalDate.now());  
            elelmiszerek.add(k1);
            elelmiszerek.add(k2);
            elelmiszerek.add(k3);
           
        }
        catch (HibasDatumException ex) {
            Logger.getLogger(Raktar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void felvesz(Elelmiszer elelmiszer) {
        elelmiszerek.add(elelmiszer);
    }

    @Override
    public Iterator<Elelmiszer> iterator() {
        return Collections.unmodifiableList(elelmiszerek).iterator();
    }

    public List<Elelmiszer> rendezNevSzerint() {
        Collections.sort(elelmiszerek, Elelmiszer.nevRendezo());
        return Collections.unmodifiableList(elelmiszerek);
    }

    public List<Elelmiszer> rendezGyartoSzerint() {
        Collections.sort(elelmiszerek, Elelmiszer.gyartoRendezo());
        return Collections.unmodifiableList(elelmiszerek);
    }

}
