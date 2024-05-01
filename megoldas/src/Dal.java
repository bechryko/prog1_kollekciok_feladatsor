import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Dal {
    private String cim;
    private final int hossz;
    private final Set<String> cimkek;
    private final List<String> dalszoveg;

    /**
     * Készíts el egy privát kétparaméteres konstruktort, ami várja a dal címét és hosszát, és beállítja a megfelelő
     * adattagokat. A többi adattagot inicializáld értelemszerűen.
     */
    private Dal(String cim, int hossz) {
        this.cim = cim;
        this.hossz = hossz;
        // értelemszerű inicializálás alatt kollekciók esetében általában az üres kollekciót értjük
        this.cimkek = new HashSet<>();
        this.dalszoveg = new ArrayList<>();
        /* a példában lévő, felesleges konstruktorban látható null-ra való inicializálásnak nem sok értelme van, hiszen
        mivel final adattagjaink vannak, így nem is tudjuk őket azután változtatni - egy rendes, használható kollekcióvá
        alakítani */
    }
    /* felmerülhet a kérdés, hogy mi értelme privát konstruktornak?
    dalokat nem kézzel akarunk majd létrehozni, hanem generálni vagy bővíteni akarjuk a statikus metódusunkkal
    ha privát a konstruktor, azt statikus metódusban lehet használni, de az osztályon kívül nem, így csak ezek a
    metódusok fognak tudni új Dal példányokat létrehozni */

    /**
     * Készíts el egy másik konstruktort, ami a cím és hossz mellett tetszőlegesen sok címkét vár paraméterben. A
     * címkéket tárold el a nekik megfelelő adattagban.
     */
    private Dal(String cim, int hossz, String ...cimkek) {
        // a függvény fejlécében látszik, hogy hogy adható meg tetszőlegesen sok paraméter
        // (a cimkek változó így egy tömb lesz, olyan típusú, amit a fejlécben elé írtunk)
        // használjuk a már elkészített konstruktort!
        this(cim, hossz);
        // mivel már létrehoztuk a másik konstruktorban a cimkek halmazt, így csak hozzá kell adni a címkéket
        Collections.addAll(this.cimkek, cimkek);
        // a Collections osztály addAll metódusa segítségével egyszerűen hozzá tudjuk adni a tömb elemeit a halmazhoz
    }

    /**
     * Készítsd el az atnevez metódust, ami egy szöveget vár paraméterben, és átnevezi a dalt a kapott szövegre. (Minek
     * nevezzük az ilyen típusú metódusokat?)
     */
    public void atnevez(String ujCim) {
        cim = ujCim;
        // egy adattagot beállít valamilyen szabály szerint, tehát hiába nem olyan neve van, ez a metódus egy setter
    }

    /**
     * Készítsd el az isInstrumentalis metódust, ami egy igazságértékkel tér vissza, hogy az adott szám
     * instrumentális-e. Akkor mondunk egy számot instrumentálisnak, ha nincs dalszövege.
     */
    public boolean isInstrumentalis() {
        // nincs dalszövege a számnak, ha üres a versszakokat tartalmazó listája
        return dalszoveg.isEmpty();
        /* megnézhetnénk a méretét is, hogy nulla-e, az is helyes megoldás, de ha van rá külön metódus, használhatjuk
        azt is */
    }

    /**
     * Készítsd el a hasCimke metódust, ami egy igazságértékkel tér vissza, hogy a paraméterben érkező címkével (szöveg)
     * rendelkezik-e a dal.
     */
    public boolean hasCimke(String cimke) {
        // a halmazok contains metódusa pontosan azt mondja meg, hogy az adott elem benne van-e a halmazban
        return cimkek.contains(cimke);
    }

    /**
     * Készítsd el a statikus general metódust, ami megvalósítja egy új dal generálását. A metódus várja a dal címét, a
     * címkéket egy tömbként, és a dalszöveget (mely tetszőlegesen sok szövegből állhat). A metódus visszatérési értéke
     * a generált dal. A dal hossza úgy számolódik ki, hogy ha instrumentális, akkor pontosan 90 másodperc hosszú lesz.
     * Ha a címkék bármelyikében szerepel a "rock" kifejezés, akkor a Suno nem bír magával, és legalább 3 perc hosszúra
     * csinálja, különben befejezi a generálást legfeljebb 2 percnél. Továbbá ha a címkék között szerepel pontosan a
     * "pop" elem, akkor még 2 perc hosszúra sem nyúlik ki a szám, hanem annyi másodperccel lesz rövidebb nála, ahány
     * sorból áll a dalszöveg. (Vigyázat, a Suno jobban szereti a rock-ot, mint amennyire nem szereti a pop-ot!) Ha
     * legalább 4 címkéje van a rock számnak, egy "symphonic rock" számról beszélünk, vagy legalább 7 versszakból áll,
     * akkor a Suno egy epikus 6,4 perces számmal rukkol elő.
     */
    public static Dal general(String cim, String[] cimkek, String... dalszoveg) {
        // állítsuk be a dal hosszát 90 másodpercre, és írjuk felül később, ha mégsem instrumentális
        int hossz = 90;
        if(dalszoveg.length > 0) {
            /* mivel a következő feladatban is meg kell állapítanunk a számról, hogy rock szám-e, ezért érdemes rá
            készíteni egy saját metódust */
            if(isRock(cimkek)) {
                // állítsuk be az alapértelmezetten a rock számokra jellemző hosszt, és később írjuk felül, ha kell
                hossz = 180;
                /* mivel a címkék tömbként vannak megadva, ezért ahhoz, hogy egyszerűen megállapítsuk, tartalmazza-e a
                "symphonic rock" elemet, konvertáljuk egy listává (más kollekcióvá is lehetne, de tömböt közvetlenül
                csak listává lehet konvertálni, így ez a legegyszerűbb megoldás) */
                if(cimkek.length >= 4 || Arrays.asList(cimkek).contains("symphonic rock") || dalszoveg.length >= 7) {
                    /* nem kell számológépet ragadnunk, közvetlenül be is írhatjuk a kívánt hosszt - a gép majd
                    kiszámolja figyelni kell azonban, hogy ezt konvertáljuk egész számmá, mert alapból double lenne */
                    hossz = (int)(6.4 * 60);
                }
            } else {
                // "különben befejezi a generálást legfeljebb 2 percnél", azaz állítsuk a hosszt egyelőre 2 percre
                hossz = 120;
                /* itt egy az egyben azt kérdezi a feladat, hogy a "pop" címke szerepel-e a címkék között, azaz itt
                lehet contains-t használni */
                if (Arrays.asList(cimkek).contains("pop")) {
                    // számoljuk össze, hány sorból áll a dalszöveg (a sorokat sortörések választják el egymástól)
                    int sorokSzama = 0;
                    for (String sor : dalszoveg) {
                        sorokSzama += sor.split("\n").length;
                    }
                    hossz -= sorokSzama;
                }
            }
        }
        // most, hogy ismerjük a hosszt, már létre tudjuk hozni az új dalt
        Dal ujDal = new Dal(cim, hossz, cimkek);
        // ne felejtsük el hozzáadni a dalszöveget, mert azt nem lehet a konstruktoron keresztül
        ujDal.dalszoveg.addAll(Arrays.asList(dalszoveg));
        return ujDal;
    }

    /**
     * Készítsd el a statikus bovit metódust, ami egy meglévő dalt bővíti egy újabb részlettel. A metódus várja az
     * eredeti dalt, az új címet, az új címkéket egy tömbként, és az új dalszöveget (mely tetszőlegesen sok szövegből
     * állhat). A metódus visszatérési értéke a bővített dal. Az új dal címe az új cím lesz, valamint a címkéi is, a
     * dalszöveg pedig az eredeti dalszöveghez fűződik hozzá. Az új dal hossza a következőképpen alakul a régi dal
     * hosszán felül: ha az új rész instrumentális, akkor pontosan másfél perc új melódiával gazdagodik, különben csak
     * 0,6-tal. Ha a címkék bármelyikében szerepel a "rock" kifejezés, akkor a Suno megduplázza az eredeti hosszát. Ha
     * esetleg több új versszakkal bővítjük a dalt, mint amennyi eredetileg volt, akkor háromszorozódik a hossz.
     * Különben, ha az új címkék között mindegyik régi szerepel, és ezen kívül legalább két új is, akkor a Suno egy bug
     * folytán mindössze egyetlen másodperccel hosszabbítja meg a dalt.
     */
    public static Dal bovit(Dal eredeti, String cim, String[] cimkek, String... dalszoveg) {
        /* mivel bővítjük a dalt, ezért az eredetit hosszabbítjuk meg, szóval jó kiindulás, ha a hossz változónk
        kezdőértéke a dal régi hossza */
        int hossz = eredeti.hossz;
        // a feladat arra kérdez rá, hogy a bővítés, szóval nem a teljes, új szám instrumentális-e
        if(dalszoveg.length > 0) {
            // itt újra fel tudjuk használni a privát segédfüggvényünket
            if(isRock(cimkek)) {
                // ternary operator segítségével könnyebben tudjuk megadni, hogy mennyivel kell szorozni a régi hosszt
                hossz *= eredeti.dalszoveg.size() < dalszoveg.length ? 3 : 2;
                /* ternary operatort leginkább akkor lehet használni, ha egy konkrét érték függ egy feltételtől, mint pl
                a hossz szorzója
                ha több utasítást kell végrehajtanunk, vagy pl ciklusokat, akkor már tanácsos az if-ek használata */
            } else if(
                /* a listának is van containsAll metódusa, viszont az IDEA szól, hogy ha átalakítjuk a listát egy
                halmazzá, akkor sokkal gyorsabb
                mi most nem a sebességre megyünk, de általánosságban jó tanács elfogadni az IDEA sárgán kiemelt
                javaslatait */
                new HashSet<>(Arrays.asList(cimkek)).containsAll(eredeti.cimkek) &&
                cimkek.length >= eredeti.cimkek.size() + 2
            ) {
                hossz++;
            } else {
                hossz += (int)(0.6 * 60);
            }
        } else {
            hossz += 90;
        }
        Dal ujDal = new Dal(cim, hossz, cimkek);
        // FIGYELEM!
        // egy kollekcióhoz egy másik kollekció elemeit az addAll metódussal tudjuk hozzáadni
        ujDal.dalszoveg.addAll(eredeti.dalszoveg);
        /* hogyha viszont egy tömb elemeit akarjuk a kollekcióhoz hozzáadni, akkor a Collections osztály addAll statikus
        metódusát kell használnunk */
        Collections.addAll(ujDal.dalszoveg, dalszoveg);
        // az is jó megoldás lenne, ha a tömböt az ismert módon listává alakítjuk, majd azt adjuk hozzá az első módon
        return ujDal;
    }

    /* készítettem egy segédfüggvényt, ami megadja, hogy a címkék alapján meghatározott szám rock-e, azaz szerepel-e a
    címkéi bármelyikében a "rock" string
    priváttá tettem, hiszen ezt a segédfüggvényt csak belül használjuk, nem szeretném, ha kívülről hozzáférhető lenne
    statikusnak kell lennie, mert nem egy dalhoz tartozik, hanem egy általános segédfüggvény, amit egy másik statikus
    függvényből hívunk meg */
    private static boolean isRock(String[] cimkek) {
        for(String cimke : cimkek) {
            if(cimke.contains("rock")) {
                return true;
            }
        }
        return false;
    }
    // ti is bátran használjatok ilyen apró segédfüggvényeket, sokszor a kód olvashatóságán is javítanak

    public String getCim() {
        return cim;
    }

    public int getHossz() {
        return hossz;
    }

    public List<String> getDalszoveg() {
        return dalszoveg;
    }

    @Override
    public String toString() {
        return cim + " (" + hossz + " mp)";
    }

    public String getCimkek() {
        return cimkek.toString();
    }
}
