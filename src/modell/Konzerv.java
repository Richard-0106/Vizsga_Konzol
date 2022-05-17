package modell;

import java.io.File;
import java.time.LocalDate;

public class Konzerv extends Elelmiszer {

    private String leiras;
    private File receptAjanlas;

    public Konzerv(String nev, String gyarto, LocalDate datum) throws HibasDatumException {
        super(nev, gyarto, datum);
    }

    public void receptMutat() {
        if(receptAjanlas.exists()){
            System.out.println("Létezik a file");
        }else{
            System.out.println("Nem létezik");
        }
    }

    @Override
    public String toString() {
        String os = super.toString();
        return os
                + "Konzerv{" + "leiras=" + leiras + ", receptAjanlas=" + receptAjanlas + '}';
    }

}
