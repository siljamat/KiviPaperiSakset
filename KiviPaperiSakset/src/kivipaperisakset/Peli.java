/**
 * Peli-luokka hallinnoi kivipaperisakset-pelin kulkua ja tuloksia.
 */
package kivipaperisakset;

public class Peli {

        private Pelaaja p1;
        private Pelaaja p2;
        private int pelatutPelit = 0;
        private int tasapelit = 0;

    /**
     * Peli-luokan konstruktori, alustaa kaksi pelaajaa peliin.
     */
        public Peli() {
            p1 = new Pelaaja();
            p2 = new Pelaaja();
        }

    /**
     * Käynnistää pelin ja hallinnoi pelin kulkua, kunnes jompikumpi pelaaja saavuttaa kolme voittoa.
     */
    public void pelaa() {

        boolean peliLoppui = false;
        while (!peliLoppui) {
            pelatutPelit++;
            System.out.println("Erä: " + pelatutPelit + " =====================\n");
            Pelaaja.Valinta p1Valinta = p1.pelaajanValinta();
            Pelaaja.Valinta p2Valinta = p2.pelaajanValinta();

            System.out.println("Pelaaja 1: " + p1Valinta);
            System.out.println("Pelaaja 2: " + p2Valinta);

            tarkistaVoittaja(p1Valinta, p2Valinta);

            System.out.println("Pelaaja 1:llä koossa " + p1.getVoitot() + " voittoa.");
            System.out.println("Pelaaja 2:lla koossa " + p2.getVoitot() + " voittoa.");
            System.out.println("Tasapelien lukumäärä: " + tasapelit + "\n");

            if ((p1.getVoitot() >= 3) || (p2.getVoitot() >= 3)) {
                peliLoppui = true;
                System.out.println("KOLME VOITTOA - PELI PÄÄTTYY");
            }
        }
    }

    /**
     * Tarkistaa ja ilmoittaa pelin voittajan, päivittäen tarvittaessa voittojen laskuria.
     * @param p1Valinta Pelaajan 1 valinta
     * @param p2Valinta Pelaajan 2 valinta
     * @return Voittanut pelaaja, null tasapelissä
     */
    protected Pelaaja tarkistaVoittaja(Pelaaja.Valinta p1Valinta, Pelaaja.Valinta p2Valinta) {
        if (p1Valinta == p2Valinta) {
            tasapelit++;
            System.out.println("\n\t\t\t Tasapeli \n");
            return null;
        } else if ((p1Valinta == Pelaaja.Valinta.KIVI && p2Valinta == Pelaaja.Valinta.PAPERI) ||
                (p1Valinta == Pelaaja.Valinta.SAKSET && p2Valinta == Pelaaja.Valinta.KIVI) ||
                (p1Valinta == Pelaaja.Valinta.PAPERI && p2Valinta == Pelaaja.Valinta.SAKSET)) {
            p2.lisaaVoitto();
            System.out.println("Pelaaja 2 voittaa \n");
            return p2;
        } else {
            p1.lisaaVoitto();
            System.out.println("Pelaaja 1 voittaa \n");
            return p1;
        }
    }

    /**
     * Palauttaa pelaajan 1.
     * @return Pelaaja 1
     */
    public Pelaaja getP1() {
        return p1;
    }

    /**
     * Palauttaa pelaajan 2.
     * @return Pelaaja 2
     */
    public Pelaaja getP2() {
        return p2;
    }

    /**
     * Palauttaa pelattujen pelien lukumäärän.
     * @return Pelattujen pelien lukumäärä
     */
    public int getPelatutPelit() {
        return pelatutPelit;
    }

    /**
     * Palauttaa tasapelien lukumäärän.
     * @return Tasapelien lukumäärä
     */
    public int getTasapelit() {
        return tasapelit;
    }
}
