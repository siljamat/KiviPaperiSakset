package kivipaperisakset;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PeliTest {

    private Peli peli;

    @BeforeEach
    void setUp() {
        peli = new Peli();
    }

    @Test
    void testPeliNotNull() {
        assertNotNull(peli, "Pelin luominen epäonnistui");
    }

    @Test
    void testPelaaTasapeli() {
        for (int i = 0; i < 3; i++) {
            peli.tarkistaVoittaja(Pelaaja.Valinta.KIVI, Pelaaja.Valinta.KIVI);
        }
        assertEquals(3, peli.getTasapelit(), "Tasapelien määrän tulee olla 3");
        assertEquals(0, peli.getP1().getVoitot(), "Pelaajan 1 voittojen määrän tulee olla 0");
        assertEquals(0, peli.getP2().getVoitot(), "Pelaajan 2 voittojen määrän tulee olla 0");
    }

    @Test
    void testPelaaPelaaja1Voittaa() {
        for (int i = 0; i < 3; i++) {
            peli.tarkistaVoittaja(Pelaaja.Valinta.KIVI, Pelaaja.Valinta.SAKSET);
        }
        assertEquals(3, peli.getP1().getVoitot(), "Pelaajan 1 voittojen määrän tulee olla 3");
        assertEquals(0, peli.getP2().getVoitot(), "Pelaajan 2 voittojen määrän tulee olla 0");
    }

    @Test
    void testPelaaPelaaja2Voittaa() {
        for (int i = 0; i < 3; i++) {
            peli.tarkistaVoittaja(Pelaaja.Valinta.KIVI, Pelaaja.Valinta.PAPERI);
        }
        assertEquals(0, peli.getP1().getVoitot(), "Pelaajan 1 voittojen määrän tulee olla 0");
        assertEquals(3, peli.getP2().getVoitot(), "Pelaajan 2 voittojen määrän tulee olla 3");
    }

    @Test
    void testPelaaPeliPaattyy() {
        for (int i = 0; i < 3; i++) {
            peli.tarkistaVoittaja(Pelaaja.Valinta.KIVI, Pelaaja.Valinta.PAPERI);
        }
        assertTrue(peli.getP1().getVoitot() >= 3 || peli.getP2().getVoitot() >= 3, "Pelin tulee päättyä, kun jompikumpi pelaajista saavuttaa 3 voittoa");
    }

    @Test
    void testPelienLukumaaranKasvu() {
        peli.pelaa();
        assertTrue(peli.getPelatutPelit() >= 3, "Pelattujen pelien lukumäärän tulee olla vähintään 1");
    }

    @Test
    void testVoittojenLaskenta() {
        peli.pelaa();
        assertTrue(peli.getP1().getVoitot() >= 0 && peli.getP1().getVoitot() <= 3, "Pelaajan 1 voittojen määrän tulee olla välillä 0-3");
        assertTrue(peli.getP2().getVoitot() >= 0 && peli.getP2().getVoitot() <= 3, "Pelaajan 2 voittojen määrän tulee olla välillä 0-3");
    }

    @Test
    void testTasapelienLaskenta() {
        peli.pelaa();
        assertTrue(peli.getTasapelit() >= 0, "Tasapelien lukumäärän tulisi olla vähintään 0");
    }

    @Test
    void testPeliLoppuuOikein() {
        peli.pelaa();
        assertTrue(peli.getP1().getVoitot() >= 3 || peli.getP2().getVoitot() >= 3, "Pelin tulisi päättyä, kun jompikumpi pelaajista voittaa kolme kertaa");
    }

}
