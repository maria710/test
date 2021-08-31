public class Odpoved {
    private String textOdpovede;
    private boolean spravna;
    private boolean jeOznacena;
    
    public Odpoved(String textOdpovede, boolean spravna) {
        this.textOdpovede = textOdpovede;
        this.spravna = spravna;
        this.jeOznacena = false;
    }
    
    public void vypis() {
        if (jeOznacena) {
            System.out.println(this.textOdpovede + " *");
        } else {
            System.out.println(this.textOdpovede);
        }
    }
    
    public void zmenVolbu() {
        if (jeOznacena) {
            this.jeOznacena = false;
        } else {
            this.jeOznacena = true;
        }
    }
    
    public int getHodnotenie() {
        if (this.jeOznacena) {
            if (this.spravna) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return 0;
        }
    }
}
