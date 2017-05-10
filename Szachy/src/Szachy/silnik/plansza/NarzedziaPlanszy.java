
package Szachy.silnik.plansza;

public class NarzedziaPlanszy {

    public static boolean[] PIERWSZA_KOLUMNA = null;
    public static boolean[] DRUGA_KOLUMNA = null;
    public static boolean[] SIODMA_KOLUMNA = null;
    public static boolean[] OSMA_KOLUMNA = null;
    
    private NarzedziaPlanszy(){
        throw new RuntimeException("Nie można inicjować tej klasy!");
    }
    
     public static boolean poprawnaPozycjaPola(int pozycja) {
        return pozycja >=0 && pozycja <64;
    }
}
