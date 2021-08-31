import java.util.Scanner;

public class Tester {
    
    public static void main(String[] parametre) {
        Scanner skener = new Scanner(System.in);
        Test test = new Test();
        
        Otazka otazka1 = new Otazka("Objekty spolu komunikujú pomocou");
        
        otazka1.pridajOdpoved("správ", true);
        otazka1.pridajOdpoved("atribútov", false);
        otazka1.pridajOdpoved("metód", false);
        otazka1.pridajOdpoved("parametrov", false);
        
        Otazka otazka2 = new Otazka("Čo je časťou správ?");
        
        otazka2.pridajOdpoved("adresát", true);
        otazka2.pridajOdpoved("selektor", true);
        otazka2.pridajOdpoved("atribút", false);
        otazka2.pridajOdpoved("metóda", false);
        
        test.pridajOtazku(otazka1);
        test.pridajOtazku(otazka2);
        
        test.vypis();
        test.zmenStav(StavTestu.PREBIEHA);
        
        int cisloOtazky = 0;
        int cisloOdpovede = 0;
        boolean hracSkoncil = false;
        
        do {
            System.out.print("Zadaj cislo otazky a odpovede (alebo 0 0 pre koniec): ");
            cisloOtazky = skener.nextInt();
            cisloOdpovede = skener.nextInt();
            
            if (cisloOtazky == 0 && cisloOdpovede == 0) {
                hracSkoncil = true;
            } else {
                test.zmenVolbu(cisloOtazky, cisloOdpovede);
                test.vypis();
            }
        
        } while (!hracSkoncil);
        
        test.zmenStav(StavTestu.VYHODNOTENIE);
        test.vypis();
        System.exit(0);
    }
}
