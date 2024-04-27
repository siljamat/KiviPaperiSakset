/**
 * Main-luokka käynnistää kivipaperisakset-pelin.
 * Tämä luokka toimii ohjelman käynnistyspisteenä.
 */
package kivipaperisakset;

public class Main {

    /**
     * Main-metodi käynnistää kivipaperisakset-pelin kutsumalla Peli-luokan pelaa-metodia.
     */
    public static void main(String[] args) {
        new Peli().pelaa();
    }
}
