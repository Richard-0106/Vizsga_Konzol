package modell;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Raktar implements Iterable<Elelmiszer> {

    private ArrayList<Elelmiszer> elelmiszerek;

    public Raktar() {
        elelmiszerek = new ArrayList<>();

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
