package Szachy.silnik.figury;

import Szachy.silnik.Druzyna;
import Szachy.silnik.plansza.NarzedziaPlanszy;
import Szachy.silnik.plansza.Plansza;
import Szachy.silnik.plansza.Pole;
import Szachy.silnik.plansza.Ruch;
import static Szachy.silnik.plansza.NarzedziaPlanszy.poprawnaPozycjaPola;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Skoczek extends Element {

    private final static int[] MOZLIWE_RUCHY = {-17, -15, -10, -6, 6, 10, 15, 17};

    public Skoczek(int pozycjaElementu, Druzyna druzynaElementu) {
        super(pozycjaElementu, druzynaElementu);
    }

    @Override
    public List<Ruch> poprawneRuchy(Plansza plansza) {

        final List<Ruch> poprawneRuchy = new ArrayList<>();

        for (final int obecnyRuch : MOZLIWE_RUCHY) {

            final int docelowaPozycja = this.pozycjaElementu + obecnyRuch;
            if (poprawnaPozycjaPola(docelowaPozycja)) {

                if (jestWPierwszejKolumnie(this.pozycjaElementu, obecnyRuch)
                        || jestWDrugiejKolumnie(this.pozycjaElementu, obecnyRuch)
                        || jestWSiodmejKolumnie(this.pozycjaElementu, obecnyRuch)
                        || jestWOsmejKolumnie(this.pozycjaElementu, obecnyRuch)) {
                    continue;
                }

                final Pole docelowePole = plansza.getPole(docelowaPozycja);
                if (docelowePole.czyZajete()) {
                    poprawneRuchy.add(new Ruch());
                } else {
                    final Element pozycjaElementu = docelowePole.getElement();
                    final Druzyna druzynaElementu = pozycjaElementu.getDruzynaElementu();

                    if (this.druzynaElementu != druzynaElementu) {
                        poprawneRuchy.add(new Ruch());
                    }
                }
            }

        }

        return Collections.unmodifiableList(poprawneRuchy);
    }

    private static boolean jestWPierwszejKolumnie(final int aktualnaPozycja, final int obecnyRuch) {

        return NarzedziaPlanszy.PIERWSZA_KOLUMNA[aktualnaPozycja] && (obecnyRuch == -17 || obecnyRuch == -10
                || obecnyRuch == 6 || obecnyRuch == 15);
    }

    private static boolean jestWDrugiejKolumnie(final int aktualnaPozycja, final int obecnyRuch) {
        return NarzedziaPlanszy.DRUGA_KOLUMNA[aktualnaPozycja] && (obecnyRuch == -10 || obecnyRuch == 6);
    }

    private static boolean jestWSiodmejKolumnie(final int aktualnaPozycja, final int obecnyRuch) {
        return NarzedziaPlanszy.SIODMA_KOLUMNA[aktualnaPozycja] && (obecnyRuch == -6 || obecnyRuch == 10);
    }

    private static boolean jestWOsmejKolumnie(final int aktualnaPozycja, final int obecnyRuch) {
        return NarzedziaPlanszy.OSMA_KOLUMNA[aktualnaPozycja] && (obecnyRuch == -15 || obecnyRuch == -6
                || obecnyRuch == 10 || obecnyRuch == 17);
    }
}
