// osztályunknak implementálnia kell a Comparable interface-t, hogy sorba lehessen rendezni (hiszen prioritási sort akarunk használni)
// a Comparable interface neve után meg lehet adni diamond operátorok között, hogy milyen típusú objektumokkal akarjuk összehasonlítani (ilyen típusú lesz a compareTo metódus paramétere)
public class Jatek implements Comparable<Jatek> {
    private String nev;
    private int prioritas;

    public Jatek(String nev, int prioritas) {
        this.nev = nev;
        this.prioritas = prioritas;
    }

    // egyetlen megvalósítandó metódusunk a compareTo, ami összehasonlítja az adott játékot egy másik játékkal
    @Override
    public int compareTo(Jatek j) {
        // én lekezeltem azt az esetet, amikor a paraméterben érkező játék null, de ezt egy annotációval is meg lehet oldani (és talán érdemesebb is azzal)
        if(j == null) return 1;
        // így nézne ki a metódus fejléce annotációval:
    //public int compareTo(@NotNull Jatek j) {
        // a metódus egy számmal tér vissza, ami pozitív, ha a jelenlegi játékot előrébb akarjuk rakni a sorban, mint a paraméterben érkezőt
        return j.prioritas - prioritas;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getPrioritas() {
        return prioritas;
    }

    public void setPrioritas(int prioritas) {
        this.prioritas = prioritas;
    }
}
