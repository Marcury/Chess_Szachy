package Szachy.silnik.plansza;

import Szachy.silnik.figury.Element;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public abstract class Pole {
    
    protected final int pozycjaPola;
    
    private static final Map <Integer, PustePole> PUSTE_POLA = stworzWszystkiePustePola();
    
    private Pole(int pozycjaPola){
        this.pozycjaPola = pozycjaPola;
    }
    
   public abstract boolean czyZajete();
   public abstract Element getElement();

    private static Map<Integer, PustePole> stworzWszystkiePustePola() {
       
      final Map<Integer, PustePole> mapaPustePola = new HashMap<>();
        
      for (int i=0; i<64; i++){
          mapaPustePola.put(i,new PustePole(i));
      }
      return Collections.unmodifiableMap(mapaPustePola);
    }
    
    public static Pole stworzPole(final int pozycjaPola, final Element element){
        return element !=null ? new ZajetePole(pozycjaPola, element) : PUSTE_POLA.get(pozycjaPola);
    }
   
   public static final class PustePole extends Pole{
       PustePole(final int pozycja)
       {
           super(pozycja);
       }

        @Override
        public boolean czyZajete() {
            return false;
        }

        @Override
        public Element getElement() {
          return null;
        }
   }
   
   public static final class ZajetePole extends Pole{
       
      private final Element elementNaPlanszy;
       
       ZajetePole(int pozycjaPola, Element elementNaPLanszy){
           super(pozycjaPola);
           this.elementNaPlanszy = elementNaPLanszy;
       }

        @Override
        public boolean czyZajete() {
            return true;
        }

        @Override
        public Element getElement() {
        return this.elementNaPlanszy;
        }
   }
}
