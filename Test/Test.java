import java.util.ArrayList;

public class Test {
    
    private StavTestu stav;
    private ArrayList<Otazka> otazky;
    private int pocetBodov;
    
    public Test() {
        this.otazky = new ArrayList<Otazka>();
        this.stav = StavTestu.PRIPRAVA;
    }
    
    public void zmenStav(StavTestu novyStav) {
        
        switch (novyStav) {
            case PREBIEHA: 
                if (this.stav == StavTestu.PRIPRAVA) {
                    this.stav = novyStav;
                } else {
                    System.out.println("Nie je mozne zmenit stav.");
                }
                break;
            case VYHODNOTENIE: 
                if (this.stav == StavTestu.PREBIEHA) {
                    this.stav = novyStav;
                } else {
                    System.out.println("Nie je mozne zmenit stav.");
                }
                break;
            default:
                System.out.println("Nie je mozne zmenit stav.");
        }
        /*
        if (novyStav == StavTestu.PREBIEHA && this.stav == StavTestu.PRIPRAVA) {
            this.stav = novyStav;
        } else {
            System.out.println("Nie je mozne zmenit stav.");
        }
        
        if (novyStav == StavTestu.VYHODNOTENIE && this.stav == StavTestu.PREBIEHA) {
            this.stav = novyStav;
        } else {
            System.out.println("Nie je mozne zmenit stav.");
        }
        */
    }
    
    public void pridajOtazku(Otazka otazka) {
        if (this.stav == StavTestu.PRIPRAVA) {
            this.otazky.add(otazka);
        }
    }
    
    public void vypis() {
        if (this.stav == StavTestu.PRIPRAVA || this.stav == StavTestu.PREBIEHA) {
            for (int i = 0; i < this.otazky.size(); i++) {
                System.out.print((i+1) + ") ");
                this.otazky.get(i).vypis();
            }
        } else {
            for (int i = 0; i < this.otazky.size(); i++) {
                System.out.print((i+1) + ") " + "(body: " + this.otazky.get(i).getHodnotenie() + ")");
                this.otazky.get(i).vypis();
                System.out.println("body z testu: " + this.pocetBodov);
            }
        }
    }
    
    public void zmenVolbu(int cisloOtazky, int cisloOdpovede) {
        if (cisloOtazky <= this.otazky.size() && cisloOtazky > 0) {
            for (int i = 0; i < this.otazky.size(); i++) {
                if(i == cisloOtazky - 1) {
                    this.otazky.get(i).zmenVolbu(cisloOdpovede);
                    this.pocetBodov = this.pocetBodov + this.otazky.get(i).getHodnotenie();
                }
            }
        }
    }
}
