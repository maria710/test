import java.util.ArrayList;

public class Otazka {

    private String text;
    private ArrayList<Odpoved> odpovede;

    public Otazka(String text) {
        this.text = text;
        this.odpovede = new ArrayList<Odpoved>();
    }

    public void pridajOdpoved(String textOdpovede, boolean spravna) {
        Odpoved odpoved = new Odpoved(textOdpovede, spravna);
        this.odpovede.add(odpoved);
    }

    public void vypis() {
        System.out.println(this.text);
        for (int i = 0; i < this.odpovede.size(); i++) {
            System.out.print("   " + (i + 1) + ") ");
            this.odpovede.get(i).vypis();
        }
    }

    public void zmenVolbu(int cisloOdpovede) {
        if (cisloOdpovede <= this.odpovede.size() && cisloOdpovede > 0) {
            for (int i = 0; i < this.odpovede.size(); i++) {
                if (i == cisloOdpovede - 1) {
                    this.odpovede.get(i).zmenVolbu();
                }
            }
        }
    }

    public int getHodnotenie() {
        int pocetBodov = 0;
        for (Odpoved odp : this.odpovede) {
            pocetBodov = odp.getHodnotenie();
        }
        return pocetBodov;
    }
}
