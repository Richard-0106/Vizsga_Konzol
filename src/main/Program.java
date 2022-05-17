
package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import modell.Elelmiszer;
import modell.Konzerv;
import modell.Raktar;


public class Program {

   
    public static void main(String[] args) throws IOException {
       Raktar raktar= new Raktar();
        System.out.println("Név szerinti:");
        for (Elelmiszer elelmiszer : raktar.rendezNevSzerint()) {
            System.out.println(elelmiszer);
        }
        
        System.out.println("Gyártó szerinti:");
        for (Elelmiszer elelmiszer : raktar.rendezGyartoSzerint()) {
            System.out.println(elelmiszer);
        }
//        for (Elelmiszer elelmiszer : raktar) {
//            if(elelmiszer instanceof Konzerv){
//                ((Konzerv)elelmiszer).receptMutat();
//            }
//        
//        }
         try {
            ObjectOutputStream objKi = new ObjectOutputStream(new FileOutputStream("raktar.bin"));
            objKi.writeObject(raktar);
            objKi.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        raktar = null;
        
        try {
            ObjectInputStream objBe = new ObjectInputStream(new FileInputStream("raktar.bin"));
            raktar = (Raktar)objBe.readObject();
            
            objBe.close();
            
            System.out.println("Visszaállítás:");
            for (Elelmiszer elelmiszer : raktar) {
                System.out.println(elelmiszer);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    

