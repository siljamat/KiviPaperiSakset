/**
 * Pelaaja-luokka edustaa yhtä pelissä osallistuvaa pelaajaa.
 */
package kivipaperisakset;

public class Pelaaja {

    private int voitot;

    /**
     * Enumeraatio Valinta määrittelee kivipaperisakset-pelin mahdolliset valinnat: KIVI, PAPERI ja SAKSET.
     */
    public enum Valinta {
        KIVI, PAPERI, SAKSET;

        /**
         * Arpoo satunnaisen valinnan Valinta-enumeraation mahdollisista vaihtoehdoista.
         * @return Arvottu Valinta
         */
    public static Valinta arvo() {
        Valinta[] valinnat = Valinta.values();
        int c = (int) (Math.random() * valinnat.length);
        return valinnat[c];
    }
    }

    /**
     * Palauttaa pelaajan tekemän valinnan pelissä.
     * @return Pelaajan valitsema Valinta
     */
    public Valinta pelaajanValinta() {
        return Valinta.arvo();
    }

    /**
     * Lisää pelaajalle voiton laskuriin.
     */
    public void lisaaVoitto() {
        voitot++;
    }

    /**
     * Palauttaa pelaajan voittojen lukumäärän.
     * @return Pelaajan voittojen lukumäärä
     */
    public int getVoitot() {
        return voitot;
    }
}
