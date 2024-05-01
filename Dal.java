import java.util.List;
import java.util.Set;

/**
 * A világhírű SlickClips284 legújabb dalai egy Suno nevű mesterséges intelligencia által lettek generálva. Valósítsd
 * meg a generált dalokat reprezentáló osztályt a megadott minta kiegészítésével!
 * Készíts el egy privát kétparaméteres konstruktort, ami várja a dal címét és hosszát, és beállítja a megfelelő
 * adattagokat. A többi adattagot inicializáld értelemszerűen.
 * Készíts el egy másik privát konstruktort, ami a cím és hossz mellett tetszőlegesen sok címkét vár paraméterben. A
 * címkéket tárold el a nekik megfelelő adattagban.
 * Készítsd el az atnevez metódust, ami egy szöveget vár paraméterben, és átnevezi a dalt a kapott szövegre. (Minek
 * nevezzük az ilyen típusú metódusokat?)
 * Készítsd el az isInstrumentalis metódust, ami egy igazságértékkel tér vissza, hogy az adott szám instrumentális-e.
 * Akkor mondunk egy számot instrumentálisnak, ha nincs dalszövege.
 * Készítsd el a hasCimke metódust, ami egy igazságértékkel tér vissza, hogy a paraméterben érkező címkével (szöveg)
 * rendelkezik-e a dal.
 * Készítsd el a statikus general metódust, ami megvalósítja egy új dal generálását. A metódus várja a dal címét, a
 * címkéket egy tömbként, és a dalszöveget (mely tetszőlegesen sok szövegből állhat). A metódus visszatérési értéke a
 * generált dal. A dal hossza úgy számolódik ki, hogy ha instrumentális, akkor pontosan 90 másodperc hosszú lesz. Ha a
 * címkék bármelyikében szerepel a "rock" kifejezés, akkor a Suno nem bír magával, és legalább 3 perc hosszúra csinálja,
 * különben befejezi a generálást legfeljebb 2 percnél. Továbbá ha a címkék között szerepel pontosan a "pop" elem, akkor
 * még 2 perc hosszúra sem nyúlik ki a szám, hanem annyi másodperccel lesz rövidebb nála, ahány sorból áll a dalszöveg.
 * (Vigyázat, a Suno jobban szereti a rock-ot, mint amennyire nem szereti a pop-ot!) Ha legalább 4 címkéje van a rock
 * számnak, egy "symphonic rock" számról beszélünk, vagy legalább 7 versszakból áll, akkor a Suno egy epikus 6,4 perces
 * számmal rukkol elő.
 * Készítsd el a statikus bovit metódust, ami egy meglévő dalt bővít egy újabb részlettel. A metódus várja az eredeti
 * dalt, az új címet, az új címkéket egy tömbként, és az új dalszöveget (mely tetszőlegesen sok szövegből állhat). A
 * metódus visszatérési értéke a bővített dal. Az új dal címe az új cím lesz, valamint a címkéi is, a dalszöveg pedig az
 * eredeti dalszöveghez fűződik hozzá. Az új dal hossza a következőképpen alakul a régi dal hosszán felül: ha az új rész
 * instrumentális, akkor pontosan másfél perc új melódiával gazdagodik, különben csak 0,6-tal. Ha a címkék bármelyikében
 * szerepel a "rock" kifejezés, akkor a Suno megduplázza az eredeti hosszát. Ha viszont több új versszakkal bővítjük a
 * dalt, mint amennyi eredetileg volt, akkor helyette háromszorozódik a hossz. Különben, ha az új címkék között
 * mindegyik régi szerepel, és ezen kívül legalább két új is, akkor a Suno egy bug folytán mindössze egyetlen
 * másodperccel hosszabbítja meg a dalt.
 * Az összes elkészített metódus legyen publikus láthatóságú!
 */
public class Dal {
    /**
     * A dal címét reprezentáló szöveg. Generálás után meg lehet változtatni.
     */
    private String cim;
    /**
     * A dal hosszát reprezentáló egész szám másodpercben. SlickClips284 hónapokat töltött el, mire rájött, hogy a Suno
     * mi alapján dönt a dalok hosszáról.
     */
    private final int hossz;
    /**
     * A dal címkéi. Halmazként reprezentálható.
     */
    private final Set<String> cimkek;
    /**
     * A dal szövege. Minden listaelem egy versszaknak felel meg.
     */
    private final List<String> dalszoveg;

    /**
     * Ezt a konstruktort nem kell használnod, csak azért van itt, hogy ne legyen tele hibákkal a fájl. Nem is érdemes
     * erre a konstruktorra hivatkozni a feladatban.
     */
    public Dal() {
        this.cim = "";
        this.hossz = 0;
        this.cimkek = null;
        this.dalszoveg = null;
    }

    public String getCim() {
        return cim;
    }

    public int getHossz() {
        return hossz;
    }

    public List<String> getDalszoveg() {
        return dalszoveg;
    }

    /**
     * toString metódus, hogy segítsen a dal kiíratásában.
     * Az egyszerűség kedvéért csak a címet és a hosszt írja ki, ha a címkéket is szeretnéd kiíratni, használd az alatta
     * lévő metódust, a dalszöveget pedig a getter segítségével írasd ki!
     */
    @Override
    public String toString() {
        return cim + " (" + hossz + " mp)";
    }

    public String getCimkek() {
        return cimkek.toString();
    }
}
