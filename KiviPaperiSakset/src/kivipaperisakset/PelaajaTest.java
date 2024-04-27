package kivipaperisakset;

import kivipaperisakset.Pelaaja.Valinta;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PelaajaTest {

    @Test
    void testPelaajanValinta() {
        Pelaaja pelaaja = new Pelaaja();
        Valinta valinta = pelaaja.pelaajanValinta();
        assertNotNull(valinta);
    }

    @Test
    void testVoittojenLisays() {
        Pelaaja pelaaja = new Pelaaja();
        pelaaja.lisaaVoitto();
        assertEquals(1, pelaaja.getVoitot());
    }
}
