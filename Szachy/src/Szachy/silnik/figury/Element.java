package Szachy.silnik.figury;

import Szachy.silnik.Druzyna;
import Szachy.silnik.plansza.Ruch;
import Szachy.silnik.plansza.Plansza;

import java.util.List;

public abstract class Element {

    protected final int pozycjaElementu;
    protected final Druzyna druzynaElementu;
    
    Element (final int pozycjaElementu, final Druzyna druzynaElementu)
    {
        this.pozycjaElementu = pozycjaElementu;
        this.druzynaElementu = druzynaElementu;        
    }
    
    public Druzyna getDruzynaElementu(){
        return this.druzynaElementu;
    }
    
    public abstract List<Ruch> poprawneRuchy(final Plansza plansza);
}
