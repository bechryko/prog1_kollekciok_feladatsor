import java.util.Set;

public class HalmazOsztalyozas {
    // legegyszerűbb egy adattagként eltárolni azt a halmazt, aminek az osztályát meg akarjuk adni
    public Set<Integer> halmaz;

    // elég egy egyparaméteres konstruktor, ahol megkapjuk a halmazt
    public HalmazOsztalyozas(Set<Integer> halmaz) {
        this.halmaz = halmaz;
    }

    // a Map a kulcsainak egyenlőségét a kulcsként kapott objektumok equals és hashCode metódusaival vizsgálja
    /* ha egy o1 és o2 objektumra o1.equals(o2) igaz, és o1.hashCode() == o2.hashCode() is igaz, akkor fogja a Map
    azonos kulcsnak érzékelni őket */
    // éppen ezért az equals és hashCode metódusokat kell megfelelően megvalósítani

    /* a legegyszerűbb megoldás ekkor, ha azt mondjuk, hogy akkor legyen két ilyen halmazosztályozás egyenlő, ha
    egyenlők a hash kódjaik */
    @Override
    public boolean equals(Object obj) {
        // ha a paraméterben kapott objektum null, mivel this nem lehet null, ezért nem egyenlők
        if(obj == null) return false;
        // ha a kapott objektum nem HalmazOsztalyozas, akkor sem egyenlők
        if(obj instanceof HalmazOsztalyozas ho) { // a metódus végi kommentben jobban látszik, hogy mi is ez a "ho"
            // ha a két objektum hash kódja megegyezik, akkor egyenlők
            return hashCode() == ho.hashCode();
        }
        // ez else ágba is mehetne, de felesleges, mert a fenti if ágban minden esetben visszatérünk
        return false;
        // az instanceof-os if teljesen ekvivalens a következő kóddal:
        /*if(obj instanceof HalmazOsztalyozas) {
            HalmazOsztalyozas ho = (HalmazOsztalyozas)obj;
            return hashCode() == ho.hashCode();
        }*/
    }

    // azt mondtuk, hogy akkor tartozzon egy osztályba két halmaz, ha elemeik szorzatának előjele megegyezik
    // legyen akkor a hash kódja minden halmaznak az elemei szorzatának előjele (szignuma)
    // ekkor biztosan meg fog egyezni az egy osztályba tartozó halmazok esetében, és különbözni fog eltérők esetében
    @Override
    public int hashCode() {
        int szorzat = 1;
        // a változónkat megszorozzuk a halmaz adattag minden elemének előjelével
        for(int i: halmaz) {
            szorzat *= (int)Math.signum(i);
        }
        return szorzat;
        // felmerülhet a kérdés, hogy nem elég-e kiszámolni a szorzatot, és annak az előjelét visszaadni
        // ha ezt csinálnánk, fennállna a túlcsordulás lehetősége, még akkor is, ha egy long típusú változót használnánk
        /* a legbiztosabb, ha csak az előjelekkel szorzunk, az eredmény így is helyes lesz, és így a szorzat változó
        csak a -1, 0, 1 értékeket veheti fel */
    }
}
