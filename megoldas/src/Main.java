import java.util.*;

public class Main {
    public static void main(String[] args) {
        // tipp a teszteléshez: hívd meg a saját függvényeidet az enyéim mellett a példa inputokra, és hasonlíts össze, hogy mit adnak vissza
        koviFeladat();

        System.out.println(feladat1a());

        koviFeladat();

        System.out.println(feladat1b());

        koviFeladat();

        ArrayList<String> szurnivalo = new ArrayList<>(Arrays.asList("435435453", "true", "trualma", "435345n34535", "hamis", "igaz", "9223372036854775807", "false", "nulla"));
        List<?>[] szurt = feladat2(szurnivalo);
        for(List<?> l : szurt) {
            System.out.println(l);
        }

        koviFeladat();

        List<Integer> peldaLista = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println(feladat3(peldaLista));

        koviFeladat();

        feladat4();

        koviFeladat();

        Map<String, String> szavak = new HashMap<>();
        szavak.put("zöld", "alma");
        szavak.put("kék", "autó");
        szavak.put("prog1", "zöld");
        szavak.put("autó", "piros");
        System.out.println(feladat5(szavak));

        koviFeladat();

        Map<String, Map<String, Integer>> jegyek = new HashMap<>() {{
            put("Kovács Béla", new HashMap<>() {{
                put("matematika", 5);
                put("magyar", 4);
                put("történelem", 1);
            }});
            put("Nagy Áron", new HashMap<>() {{
                put("matematika", 5);
                put("magyar", 5);
                put("történelem", 5);
            }});
            put("Kiss János", new HashMap<>() {{
                put("matematika", 1);
                put("magyar", 5);
                put("történelem", 5);
            }});
            put("Kovács János", new HashMap<>() {{
                put("matematika", 5);
                put("magyar", 5);
                put("történelem", 2);
            }});
            put("Kiss Béla", new HashMap<>() {{
                put("matematika", 1);
                put("magyar", 1);
                put("történelem", 1);
            }});
        }};
        System.out.println(feladat6(jegyek));

        koviFeladat();

        Map<Integer, Integer> KarcsiLekepezese = new HashMap<>() {{
            put(1, 2);
            put(2, 6);
            put(-33000, -66000);
            put(-812, -2436);
            put(5, 6);
            put(0, 7);
            put(Integer.MAX_VALUE / 3, Integer.MAX_VALUE / 3 * 3);
            put(8, 9);
        }};
        feladat7(KarcsiLekepezese);
        System.out.println(KarcsiLekepezese);

        koviFeladat();

        List<Map.Entry<String, String>> ViviFeljegyzesei = new ArrayList<>();
        ViviFeljegyzesei.add(new AbstractMap.SimpleEntry<>("2022. december 16.", "A mai nagyon jó nap volt. Ettem sok csokit. Finom volt."));
        ViviFeljegyzesei.add(new AbstractMap.SimpleEntry<>("2022. december 24.", "Karácsonyra rengeteg ajándékot kaptam. Nagyon boldog vagyok."));
        ViviFeljegyzesei.add(new AbstractMap.SimpleEntry<>("2023. január 1.", "Elmentem szilveszteri buliba barátnőmékhez. Hihetetlenül kínos dolgokat csináltam..."));
        ViviFeljegyzesei.add(new AbstractMap.SimpleEntry<>("2023. január 23.", "Megnéztem egy anime epizódot. Nagyon tetszett. De ha bárki megtudja..."));
        ViviFeljegyzesei.add(new AbstractMap.SimpleEntry<>("2023. március 14.", "Ma ismét elmentem egy buliba barátnőmékhez. Szuperül éreztem magam!!"));
        ViviFeljegyzesei.add(new AbstractMap.SimpleEntry<>("2023. március 15.", "Úgy fáj a fejem, meghalok..."));
        for(Map.Entry<String, String> e: feladat8(ViviFeljegyzesei).entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }

        koviFeladat();

        List<Set<Integer>> halmazok = new ArrayList<>() {{
            add(new HashSet<>(Arrays.asList(1, 2, 3)));
            add(new HashSet<>(Arrays.asList(1, -2, 3, -4)));
            add(new HashSet<>(Arrays.asList(-1, 2, -3, 4, -5)));
            add(new HashSet<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        }};
        Map<HalmazOsztalyozas, Integer> osztalyozo = feladat9();
        for(Set<Integer> h: halmazok) {
            System.out.println(h + " halmaz osztalya: " + osztalyozo.get(new HalmazOsztalyozas(h)));
        }

        koviFeladat();

        String[] megold = feladat10(new String[] {"piros", "kék", "zöld"}, new String[0], new String[] {"sárga", "lila"}, new String[] {"narancs", "fekete", "fehér"});
        System.out.println(Arrays.toString(megold));

        koviFeladat();

        List<Jatek> JanoskaLevele = new ArrayList<>();
        JanoskaLevele.add(new Jatek("Minecraft", 33));
        JanoskaLevele.add(new Jatek("Szabó Tamás és Fülöp Vanda kalkulus feladatgyűjteménye", 1));
        JanoskaLevele.add(new Jatek("Fortnite", 100));
        JanoskaLevele.add(new Jatek("Gercsós puzzle", 12));
        System.out.println(feladat11(JanoskaLevele, 2));
        System.out.println(feladat11(JanoskaLevele, 20));
    }

    /**
     * Írj egy függvényt, ami nem vár paramétert, és egy olyan kollekcióval tér vissza, ami megvalósít a
     * {0, 1, 2, 3, 4} és {3, 5, -10, -625, 4910752992, 0} halmazok között egy injektív, de nem szürjektív leképezést!
     * @return a leképezés
     */
    public static List<Long> feladat1a() {
        /* a listákat fel lehet fogni olyan leképezésekként, amik az első N természetes számhoz egy tetszőleges halmazból rendelnek elemeket
        (ez a tetszőleges halmaz jelenleg a Long-ok, hiszen a 4910752992 nem férne bele egy Integer típusú változóba) */
        // injektív: minden érkezési halmazbeli elemet legfeljebb egyszer tartalmaz
        // szürjektív: minden érkezési halmazbeli elemet legalább egyszer tartalmaz
        // (leegyszerűsítve)
        /* elég úgy hozzárendelni az első halmaz elemeihez a második elemeit, hogy semelyik kettőhöz sem rendeljük ugyanazt
        (mivel a második halmazban több elem van, mint az elsőben, a szürjektivitás könnyen teljesül) */
        return new ArrayList<>(Arrays.asList(3L, 5L, 10L, 625L, 4910752992L));
        /* a feladat megoldható tömbökkel is, hiszen ott is az első N természetes szám az indexek halmaza (azaz az indulási halmaz)
        de a feladatsor a kollekciókról szól, úgyhogy inkább gondolkozzunk azokban, hacsak a feladat mást nem mond */
    }

    /**
     * Írj egy függvényt, ami nem vár paramétert, és egy olyan kollekcióval tér vissza, ami megvalósít a
     * {0, 2, 4, 6, 8} és {"alma", "körte", "szilva", "barack", "narancs"} halmazok között egy bijektív leképezést!
     * @return a leképezés
     */
    public static Map<Integer, String> feladat1b() {
        /* a Map-eket (leképezéseket, asszociatív tömböket) is (nem túl meglepő módon) el lehet képzelni dimat1-ről ismerős leképezésekként,
        csakhogy ezek már tetszőleges halmaz (jelen esetben: Integerek) elemeihez tetszőleges halmaz (jelen esetben: Stringek) elemeit tudják rendelni */
        // bijektív: injektív és szürjektív
        return new HashMap<>() {{
            put(0, "alma");
            put(2, "körte");
            put(4, "szilva");
            put(6, "barack");
            put(8, "narancs");
        }};
        // természetesen az előző feladatot is meg lehet csinálni Map segítségével, viszont ha az első N természetes számhoz kell rendelnünk, akkor a lista is tökéletesen megfelel
        // ennek a feladatnak a megoldása nem jó listával, mert az az 1, 3, 5 és 7 értékekhez is rendelne valamilyen (null) értéket, az pedig más leképezés lenne, mint amit a feladat kér
    }

    /**
     * Valaki összekeverte az értékeket: mindet szöveggé alakította, és beledobálta egy listába.
     * A feladatod, hogy szétválogasd őket típus szerint: igazságérték, egész szám, szöveg.
     * Ha az adott szöveg a "true" vagy "igaz", vagy "false" vagy "hamis", akkor legyen belőle megfelelő igazságérték.
     * Ha az adott szöveg egy egész szám, akkor legyen belőle egy ilyen szám. Figyelj arra, hogy akár 15 jegyű egészeket is kellhet eltárolni!
     * Amelyik szöveg nem esik bele egyik kategóriába sem, az maradjon szöveg.
     * Az igazságértékek, számok és szövegek listáját rakd bele egy tömbbe, és ezt adja vissza a függvény!
     * A szűrés tartsa meg az azonos kategóriába eső elemek sorrendjét!
     * @param szurnivalo a szűrni kívánt lista
     * @return a szűrt listák tömbje
     */
    public static List<?>[] feladat2(List<String> szurnivalo) {
        // létrehozzuk a három listát, amikbe majd beletesszük a szűrt elemeket
        // általános tipp: ha egy változó típusa nem egy konkrét osztály, hanem egy absztrakt osztály vagy interface (esetünkben List), akkor a konkrét osztályok példányait is tárolhatja (ArrayList, LinkedList, Vector, Stack), érdemes ezt használni
        List<Boolean> igazsagertekek = new ArrayList<>();
        List<Long> szamok = new ArrayList<>();
        List<String> szovegek = new ArrayList<>();
        // for-each ciklussal végignézzük az elemeket (nagyon hasznos, ha csak olvasni akarjuk a kollekció elemeit, nem írni vagy törölni)
        for (String str: szurnivalo) {
            // boolean értékek hozzáadása, egyszerű equals metódusokkal
            // azért a szöveg literálnak (konkrét szövegnek) hívom meg az equals metódusát, nem az str-nek, mert ha az null, akkor exception-t kapunk
            if ("true".equals(str) || "igaz".equals(str)) {
                igazsagertekek.add(true);
                continue;
            }
            if ("false".equals(str) || "hamis".equals(str)) {
                igazsagertekek.add(false);
                continue;
            }
            /* ha nem boolean-t kaptunk, adjuk hozzá számként a megfelelő listához
            de mi van, ha nem szám?
            akkor kapunk egy NumberFormatException-t (ki lehet puskázni a parseLong metódus leírásából), amit elkapunk, és abban az esetben szövegként tároljuk el az eredményt */
            // fontos, hogy Long típust használjunk, hiszen a 15 jegyű egészek nem férnek bele az Integer-be
            try {
                szamok.add(Long.parseLong(str));
            } catch (NumberFormatException e) {
                szovegek.add(str);
            }
            // úgy is meg lehet csinálni a számok felismerését, hogy karakterenként végigmegyünk a szövegen, és megnézzük, hogy minden karaktere szám-e
        }
        return new List<?>[]{igazsagertekek, szamok, szovegek}; // List[]{...} is tökéletes
        /* itt látunk valami izgalmasat (a szemfüles a fejlécben is láthatott): a generikus típusnál ?-t (ún. wildcard-ot) használuk, ha nem tudjuk, hogy milyen típusú lesz a lista
        alapvetően egy tömbben csak egyféle értéket tárolhatunk, és bár mindhárom értékünk lista, nem ugyanolyan listák, ezért nem rakhatjuk őket pl egy List<Integer>[]-be
        használhatjuk ez esetben a raw lista típust, az is működik, de a wildcard-okkal való megvalósítás sokkal szebb, és az IDEA sem panaszkodik miatta */
        // a wildcard-ok nem részei a prog1 anyagnak, de akit érdekel, a következő linken bővebben utánuk olvashat: https://okt.inf.szte.hu/alkfejl1/gyakorlat/misc/generics/#wildcards
    }

    /**
     * Írj egy függvényt, ami egy egész számokból álló listát vár paraméterként.
     * A függvény adjon vissza egy új listát, amelyben az eredeti lista páros elemei duplázva szerepelnek.
     * @param lista a lista, amelyből egy újat szeretnénk készíteni
     * @return a duplázott páros számokat tartalmazó lista
     */
    public static List<Integer> feladat3(List<Integer> lista) {
        // egy új listát kell létrehoznunk: ezt megtehetjük az egyparaméteres konstruktorral, ami egy másik kollekciót vár
        List<Integer> ujLista = new ArrayList<>(lista);
        // for ciklusokkal is elvégezhetnénk a törlést és a duplázást (kivéve for-each ciklussal!!!), de a removeIf és a replaceAll metódusokkal sokkal egyszerűbb és gyorsabb (és szebb is tőlük a kód)
        ujLista.removeIf(i -> i % 2 == 1);
        ujLista.replaceAll(i -> i * 2);
        /* a két metódus paraméterében lévő lambda-kifejezésekről a prog1 anyagban is olvashattok
        (https://okt.inf.szte.hu/prog1/gyakorlat/gyakorlat/fajlkezeles/#lambda-kifejezesek),
        de aki bővebb leírást akar róluk, az az alkfejl1 anyagot is böngészheti:
        https://okt.inf.szte.hu/alkfejl1/gyakorlat/misc/lambda/ */
        return ujLista;
        // ha nem hoztunk létre új listát, hanem a paraméterben kapottat módosítottuk, az rossz megoldás! (nem az volt a feladat)
    }

    /**
     * Elméleti feladat: hány különböző igazságértékeket tartalmazó halmazt kell létrehozni (és valahogyan feltölteni elemekkel),
     * hogy biztosan legyen köztük kettő egyenlő?
     */
    public static void feladat4() {
        // egy igazságértékeket tároló halmaz, mivel kollekció, nem primitív értékeket, hanem referencia típusúakat tud tárolni: ezért Boolean halmazt kell létrehoznunk
        // a Boolean típusú változónak 3 féle értéke lehet: true, false és null (null is, mivel referencia típusú)
        /* mind a három féle értéket vagy bevehetjük a halmazba, vagy nem (mivel a sorrendiség nem számít, csak hogy tartalmazza-e)
        ez 2 lehetőség minden értékre, összesen 2^3=8 lehetőség
        a következő kódrészlet ezt szimulálja: ha a megfelelő változó értéke 0, nem vesszük bele, ha 1, akkor meg igen */
        List<Set<Boolean>> halmazok = new ArrayList<>();
        for(int vanTrue = 0; vanTrue <= 1; vanTrue++) {
            for(int vanFalse = 0; vanFalse <= 1; vanFalse++) {
                for(int vanNull = 0; vanNull <= 1; vanNull++) {
                    Set<Boolean> halmaz = new HashSet<>();
                    if(vanTrue == 1) halmaz.add(true);
                    if(vanFalse == 1) halmaz.add(false);
                    if(vanNull == 1) halmaz.add(null);
                    // hozzáadjuk a halmazt a listához
                    halmazok.add(halmaz);
                    System.out.println(halmaz);
                }
            }
        }
        System.out.println(halmazok.size() + " db");
        // ez a 8 féle Boolean Set létezik, ha bármilyen más halmazt létrehozunk, akkor biztosan egyenlő lesz valamelyikkel
        System.out.println("Egyelo-e a 7. halmaz egy ujjal: " + halmazok.get(7).equals(new HashSet<>(Arrays.asList(true, false, false, null, true, null, true, true, null, false, null, true, false, true))));
        // látszik, hogy a tömbbe rakott halmazok egyike sem egyenlő egyik másikkal sem
        boolean vanEgyenlo = false;
        // ne feledkezzünk meg a Java-ban használható, igen hasznos label-ekről (címkékről)
        halmazOsszehasonlito:
        for(int i = 0; i < halmazok.size(); i++) {
            for(int j = i + 1; j < halmazok.size(); j++) {
                if(halmazok.get(i).equals(halmazok.get(j))) {
                    vanEgyenlo = true;
                    break halmazOsszehasonlito;
                }
            }
        }
        System.out.println("Van ket egyenlo halmaz: " + vanEgyenlo);
        // tehát ha 9 igazságértékeket tároló halmazt létrehozunk, akkor már biztosan lesz köztük 2 olyan, ami egyenlő
    }

    /**
     * Írj egy függvényt, ami megszámolja, hogy a paraméterként kapott szöveg-szöveg leképezés kulcsai és értékei között hány különböző 4 betűs szó van!
     * @param map a vizsgálandó Map
     * @return a szavak száma
     */
    public static int feladat5(Map<String, String> map) {
        // érdemes egy halmazba gyűjteni a szavakat, mert így nem lesznek benne duplikátumok (tehát össze tudjuk számolni a különböző szavakat)
        // a Map-ek keySet és values metódusai visszaadják a kulcsokat és értékeket tartalmazó halmazokat
        // a halmazunk egyparaméteres konstruktora egy kollekciót vár, adjuk oda neki az egyik halmazt!
        Set<String> szavak = new HashSet<>(map.keySet());
        // a másik halmaz elemeit az addAll metódussal adhatjuk hozzá a halmazhoz (ez is bármilyen kollekciót kaphat paraméterben)
        szavak.addAll(map.values());
        // ahogy a listáknál is, a halmazoknál is van egy removeIf metódus, amivel a feltételnek megfelelő elemeket eltávolíthatjuk
        szavak.removeIf(s -> s.length() != 4);
        // a kérdés az, hogy hány különböző ilyen szó van, ezért a halmaz elemszámát adjuk vissza
        return szavak.size();
    }

    /**
     * Magdi néni szeretne utánajárni, hogy a 3.A nebulói közül kik buknak meg.
     * Egy leképezésben a diákok neveihez újabb leképezéseket rendelt, amik a tantárgy nevéhez az érdemjegyet (1-5) rendelték.
     * Írj egy függvényt, ami ilyen formában várja az adatokat, és térjen vissza azoknak a diákoknak (csak a nevüknek) a listájával, akik megbuknak, azaz legalább egy tantárgyból 1-est szereztek!
     * A lista legyen névsor szerint rendezve!
     * @param diakok a diákok és az érdemjegyeik
     * @return a diákok nevei, akik megbuktak
     */
    public static List<String> feladat6(Map<String, Map<String, Integer>> diakok) {
        // a fejlécben látszik a kacifántosan megfogalmazott függvényparaméter típusa
        // létrehozzuk a listát a bukott diákok nevei (Stringek) számára
        ArrayList<String> bukottDiakok = new ArrayList<>();
        // végigiterálunk a diákokon, Entry-kként kezelve őket
        for (Map.Entry<String, Map<String, Integer>> diak : diakok.entrySet()) {
            // végigiterálunk az egyes diákokhoz tartozó tárgyakon is
            for (Map.Entry<String, Integer> tantargy : diak.getValue().entrySet()) {
                if (tantargy.getValue() == 1) {
                    // ha az illető valamelyik tárgyból egyest kapott, hozzáadjuk a nevét a listához
                    bukottDiakok.add(diak.getKey());
                    // break-elünk, mert nem akarunk duplikált neveket abban az esetben, ha valaki több tárgyból is bukik
                    break;
                }
            }
            // egy másik megoldás, belső for ciklus nélkül:
            // a Map-ek containsKey és containsValue metódusai sokat egyszerűsíthetnek az életünkön
            /*if(diak.getValue().containsValue(1)) {
                bukottDiakok.add(diak.getKey());
            }*/
        }
        // még kétféle módon nézhettük volna végig a Map-eket: iterátorral, vagy olyan foreach ciklussal, ami a Map-ek keySet-jén iterál végig, és így a kulcs alapján kérjük le az értéket
        // rendezzük a nevek listáját abc sorrendben
        // ha null-t írunk, az az adott adattípuson értelmezett alapvető rendezés (Stringeknél abc sorrend, saját típusnál nekünk kellene megadnunk a Comparable interface segítségével)
        bukottDiakok.sort(null);
        // a következő megoldás ugyanezt csinálja:
        //bukottDiakok.sort(Comparator.naturalOrder());
        // meg is adhatjuk azt a metódust, amivel szeretnénk elvégezni két elem összehasonlítását a rendezéshez; ez a String osztályban lévő compareTo metódus
        //bukottDiakok.sort(String::compareTo);
        // negyedik megoldásként a Collections osztály statikus rendezőmetódusát is használhatjuk
        //Collections.sort(bukottDiakok);
        return bukottDiakok;
    }

    /**
     * Péter kedvenc száma a 3, így természetesen megszállottja a 3-mal való szorzásnak.
     * Nem is szereti, amikor egy egész-egész leképezésben, ami nem az övé, az N kulcshoz tartozó érték N*3.
     * Amíg Karcsi nem figyelt, ellopta a leképezését, és most ki akarja törölni azokat a kulcs-érték párokat, amikre a fenti szabály igaz.
     * De sietnie kell! Valósítsd meg a fenti működést mindössze egyetlen sorban! (1 sor vagy 1 egysoros ciklus lehet benne.)
     * @param lekepezes Karcsi szeretett leképezése
     */
    public static void feladat7(Map<Integer, Integer> lekepezes) {
        // az első megoldás egy eléggé brute-force módszer: végigmegyünk az összes lehetséges kulcson, aminek a 3-szorosa szerepelhet értékként, és töröljük ezeket az elemeket
        /*for(int i = Integer.MIN_VALUE / 3; i <= Integer.MAX_VALUE / 3; i++)
            // érdemes megjegyezni, hogy a Map-ek remove metódusa tud konkrét kulcs-érték párt is törölni, és amennyiben nincs ilyen kulcs-érték páros, nem csinál semmit
            lekepezes.remove(i, i * 3);*/
        // a második megoldás sokkal kifinomultabb (és látványosan gyorsabb, érdemes kipróbálni!), ez a Map-ek removeIf metódusát használja (itt a lambda-kifejezésünkben e egy entry)
        lekepezes.entrySet().removeIf(e -> e.getKey() * 3 == e.getValue());
    }

    /**
     * Vivi hónapok óta feljegyzi, ami vele történt, most azonban megelégelte a sok papírt, és össze akarja gyűjteni a feljegyzéseket egyetlen naplóba.
     * Egy feljegyzést egyértelműen beazonosít egy dátum (szöveg), és tartozik még hozzá maga a feljegyzés szövege.
     * Vivi azonban nem akarja beleírni az összes feljegyzést a naplójába. Vannak köztük kínosak és nagyon rövidek, amiket felesleges átírnia.
     * Írd át a feljegyzések listáját a naplóba, de csak olyan feljegyzéseket, amelyeknek a szövege több mint 5 szó hosszú, és nem tartalmazza a "kínos", "szerelmes" és "anime" szavak egyikét sem.
     * @param feljegyzesek a feljegyzések: Entry-k listája
     * @return a napló, egy asszociatív tömb
     */
    public static Map<String, String> feladat8(List<Map.Entry<String, String>> feljegyzesek) {
        // a feladat lényegében egy Entry lista Entry halmazzá (azaz Map-pé) alakítása, néhány elem kiszűrésével
        // egy új Map létrehozása, amire tekinthetünk Entry Set-ként
        Map<String, String> naplo = new HashMap<>();
        // enhanced for ciklussal (for-each) a legegyszerűbb (és leggyorsabb) végigmenni a listán
        for (Map.Entry<String, String> feljegyzes : feljegyzesek) {
            /* minden feljegyzés szövegére megnézzük, hogy a szavak száma nagyobb-e 5-nél (feldaraboljuk a szöveget szóközök mentén, és ennek a tömbnek az elemszáma a szavak száma),
            majd megnézzük, hogy az eredeti szöveg tartalmazza-e valamelyik szót a megadottak közül, és ha nem, hozzáadjuk a feljegyzést a Map-hez */
            if (feljegyzes.getValue().split(" ").length > 5 && !feljegyzes.getValue().contains("kínos") && !feljegyzes.getValue().contains("szerelmes") && !feljegyzes.getValue().contains("anime")) {
                naplo.put(feljegyzes.getKey(), feljegyzes.getValue());
                // másik megoldásnak gondolhatjuk a következő sort, ahol közvetlenül a Map Entry Set-jéhez adjuk hozzá a feljegyzést:
                //naplo.entrySet().add(feljegyzes);
                /* ez nem fog működni, az entrySet metódus leírását olvasva a következő sort láthatjuk:
                "It does not support the add or addAll operations."
                ha egy olyan metódust használunk, aminek nem ismerjük pontosan a működését, érdemes átfutni a leírást, különben kellemetlen meglepetésekbe (pl. UnsupportedOperationException) futhatunk */
            }
        }
        return naplo;
    }

    /**
     * Készítsük el Integer halmazok egy osztályozását egy osztály és egy Map segítségével!
     * Akkor tartozzon két halmaz egy osztályba, ha az elemeik szorzatának előjele ugyanaz. (-1, 0, 1, ez legyen a három osztály neve is.)
     * Készítsd el a HalmazOsztalyozas osztályt, egy függvényt, ami visszaad egy olyan Map-et, amire a map.get(new HalmazOsztalyozas(halmaz))
     * hívás visszaadja az osztályt, amelyhez tartozik a halmaz.
     * @return a halmazok osztályozását megvalósító Map
     */
    public static Map<HalmazOsztalyozas, Integer> feladat9() {
        /* ahogy a feladatleírásban lévő példa függvényhívásból látszik, a Map kulcsa egy HalmazOsztalyozas, értéke pedig egy Integer
        (lehet az osztály neve egy String is, ez igazából csak elnevezésbeli különbség) */
        Map<HalmazOsztalyozas, Integer> osztalyozas = new HashMap<>();
        // a Map-hez egyszerűen hozzá kell adnunk három kulcs-érték párt, ahol a kulcs egy HalmazOsztalyozas (paraméterben egy példa halmazzal az adott osztályban), az érték pedig az osztály
        osztalyozas.put(new HalmazOsztalyozas(new HashSet<>(List.of(1))), 1);
        osztalyozas.put(new HalmazOsztalyozas(new HashSet<>(List.of(-1))), -1);
        osztalyozas.put(new HalmazOsztalyozas(new HashSet<>(List.of(0))), 0);
        // további magyarázatért nézd meg a példa HalmazOsztalyozas megoldást
        return osztalyozas;
    }

    /**
     * Áronkának anyukája mossa ki a ruháját. Minden nap valamennyi pólót kimos, amit utána odarak Áronka szekrényébe.
     * Áronka mindig a legfelső pólót veszi fel, minden reggel egyet.
     * Az anyukája délután mos ruhákat, akkor rakja az újakat a szekrénybe, a korábban kimosott pólók tetejére.
     * Írj egy függvényt, ami tetszőlegesen sok szövegtömböt vár paraméterként. Ezekben a tömbökben az adott napon kimosott pólók színei vannak.
     * A függvény adjon vissza egy tömböt. A tömb i. indexén az i. napon felvett póló színe szerepeljen.
     * Olyan hosszú legyen a tömb, ahány napig lesz pólója Áronkának a paraméterben kapott adatok alapján.
     * Az első, paraméterben kapott tömb lentről felfelé, az alapból szekrényben lévő pólók színeit tartalmazza.
     * @param napok a napok, a kimosott pólók színeivel
     * @return az Áronka által felvett pólók színei (sorrendben)
     */
    public static String[] feladat10(String[]... napok) {
        // Áronka anyukája egy kupacba, egymás tetejére pakolja a ruhákat, így a legkézenfekvőbb kollekció a Stack
        Stack<String> szekreny = new Stack<>();
        // kezdetben hozzáadjuk az alapból szekrényben lévő pólókat
        szekreny.addAll(Arrays.asList(napok[0]));
        ArrayList<String> felvetettPolok = new ArrayList<>();
        // addig megy a ciklus, amíg a szekrény nem lesz üres
        for(int nap = 1; !szekreny.isEmpty(); nap++) {
            // Áronka reggel veszi fel a pólóját
            // a Stack osztály pop metódusa visszatér a kupacon legfelül lévő elemmel, és el is távolítja azt róla
            felvetettPolok.add(szekreny.pop());

            // Áronka anyukája délután mossa ki a ruhákat
            // ellenőrizni kell, hogy az adott napon lettek-e mosva pólók
            if(nap < napok.length && napok[nap] != null) {
                // tömb elemeit nem tudjuk hozzáadni a Stackhez, csak egy unalmas for ciklus segítségével, viszont ha előtte átalakítjuk listává, akkor már használhatjuk az addAll metódust
                szekreny.addAll(Arrays.asList(napok[nap]));
            }
        }
        /* a listát át tudjuk alakítani tömbbé (mert a feladat tömbben kérte a végeredmény) a List interface toArray metódusával
        paraméterben egy tömböt kell neki átadni, amibe bele akarjuk másolni a listát
        ha nincs elég hely a tömbben, akkor automatikusan új tömböt hoz létre a megfelelő típussal */
        return felvetettPolok.toArray(new String[0]);
        // természetesen a Stack használata nélkül is megoldható a feladat, de így talán a legkézenfekvőbb
    }

    /**
     * Jánoska játékokat szeretne Karácsonyra. Sokat. Éppen ezért levelet ír a Jézuskának, arról, hogy milyen játékokat kér.
     * Használd fel az előre elkészített Jatek osztályt, és egészítsd ki a megfelelő módon!
     * Írj egy függvényt, ami várja Jánoska levelét (egy listát a játékokról), és egy egész számot, hogy hány játékot tud megvenni neki a Jézuska.
     * A függvény térjen vissza azon játékok nevének a halmazával, amiket a Jézuska megvásárol.
     * Mivel a Jézuska nagyon aranyos, ezért a legfontosabb N játékot veszi meg Jánoskának.
     * (Egy játék minél fontosabb, annál nagyobb a prioritas adattagjának az értéke.)
     * @param level Jánoska levele
     * @param n hány játékot tud megvenni Jézuska
     * @return a megvásárolt játékok
     */
    public static Set<String> feladat11(List<Jatek> level, int n) {
        // érdemes prioritási sort használni, ha már van a játékoknak prioritása (lásd a Jatek osztály megvalósítását)
        // a prioritási sor az objektumok compareTo metódusa segítségével rendezi sorba az elemeket
        PriorityQueue<Jatek> jatekok = new PriorityQueue<>(level);
        Set<String> megvasaroltJatekok = new HashSet<>();
        // a ciklust legfeljebb annyiszor ismételjük, amennyi játékot meg tud venni a Jézuska
        for (int i = 0; i < n; i++) {
            // a peek metódussal meg tudjuk nézni a sor következő elemét, és ha az null (azaz elfogytak a játékok), akkor kilépünk a ciklusból
            if(jatekok.peek() == null) {
                break;
            }
            /* különben hozzáadjuk a megvásárolt játékokhoz a következő játék nevét
            a poll metódus nem csak visszatér a sorban következő elemmel, hanem ki is veszi a sorból, így több dolgunk nincs vele */
            megvasaroltJatekok.add(jatekok.poll().getNev());
        }
        return megvasaroltJatekok;
        // természetesen máshogyan is meg lehet oldani a feladatot, de az érdekesség kedvéért egy órán nem tárgyalt kollekcióval, a prioritási sorral mutattam meg
    }

    // pár apróság a tesztelés fancy kiírásához ------------------------------------------------------------------------

    public static int feladatSzam = 0;

    public static void koviFeladat() {
        System.out.println(System.lineSeparator() + "----------------------------------------");
        String sorSzam = switch(feladatSzam) {
            case 0 -> "1.a";
            case 1 -> "1.b";
            default -> String.valueOf(feladatSzam);
        };
        feladatSzam++;
        System.out.println(sorSzam + ". feladat" + System.lineSeparator());
    }
}