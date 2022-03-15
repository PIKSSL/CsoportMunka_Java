package csoportmunka_java;

import java.util.Random;
import java.util.Scanner;

public class CsoportMunka_Java {
    //FIGYELEM!!! Amennyiben észlelsz bármilyen hibát, amely akadályozza a te kódrészleted lefutását és netán a már megírt metódusokban van a hiba, megpróbálhatod javítani is, de biztos ami biztos, szólj előtte. Krisz.
    public static void main(String[] args) {
        //Bekérés metódusban  || menü
        menu();
//        szorzas(); TESZT
    }
    private static void menu() { //Menü
        System.out.println("A program segítségével elvégezhet egyszerü összeadási/kivonási/szorzási/osztási műveleteket.\nAz alábbi menüpontok közül választhat:");
        boolean ciklus = false;
        while(!ciklus){
            int valasztas = bekeres("1|Összeadás[NEM MŰKÖDIK]\n2|Kivonás[NEM MŰKÖDIK]\n3|Szorzás\n4|Osztás[NEM MŰKÖDIK]\n5|Kilépés");
            //Négy fő metódus 
            while(!(valasztas > 1 && valasztas < 6))
                valasztas = bekeres("HIBA:Ilyen opció nem szerepel a menüpontok között!\n1|Összeadás\n2|Kivonás\n3|Szorzás\n4|Osztás\n5|Kilépés");
            if (valasztas == 1){
                osszeadas();
            }else if(valasztas == 2){
                kivonas();
            }else if(valasztas == 3){
                szorzas();
            }else if(valasztas == 4){
                osztas();
            }else if(valasztas == 5){
                System.out.println("Viszlát!");
                ciklus = true;
            }
        }
    }
    static int bekeres(String szoveg){  //HASZNÁLATA:paraméterként adjuk meg neki a kiiratni kivánt szöveget
        Scanner be = new Scanner(System.in);
        System.out.println(szoveg);
        String bekeres = be.nextLine();
        while(!ellenorzo(bekeres)){
            bekeres = be.nextLine();
        }
        return Integer.parseInt(bekeres);
        
    }
    static boolean ellenorzo(String adat){ //Szöveg/szám ellenőrzés
        if(adat.equals("")){
            System.out.println("HIBA:üres mező");
            return false;
        }
        for (int i = 0; i < adat.length(); i++)
            if (!Character.isDigit(adat.charAt(i))){
                System.out.println("HIBA:csak számokat adhat meg");
                return false;}
        return true; 
    } //Hagyd figyelmen kívül, be van építve a .bekeres(). metódusba ||Ez a kódrészlet annyit csinál, hogy leellenőriz egy bevitt adatot és ha az szám, nem üres mező, igaz értékkel tér vissza

    static void osszeadas() {
        boolean ciklus2 = false;
        while(!ciklus2){
            int[] szamz = general("+");
            while(!(szamz[0] > 1 && szamz[0] < 100)){
                szamz = general("+");
            }
            System.out.printf("Mennyi %d + %d ?\n", szamz[1],szamz[2]);
            int eredmeny = bekeres("Végeredmény:\n>>");
            helyes_helytelen(eredmeny, szamz[0]);
            int folytat = bekeres("Szeretnél még egy példát?\n[1]Igen\n[2]Nem");
            if (folytat !=1){
                ciklus2 = true;
            }else{
                System.out.println("Itt a következő példa...");
            }
        }
    }

    static void kivonas() {
        boolean ciklus1 = false;
        while(!ciklus1){
            int[] szamt = general("-");
            while(!(szamt[0] > 1 && szamt[0] < 100)){
                szamt = general("-");
            }
            System.out.printf("Mennyi %d - %d ?\n", szamt[1],szamt[2]);
            int eredmeny = bekeres("Végeredmény:\n>>");
            helyes_helytelen(eredmeny, szamt[0]);
            int folytat = bekeres("Szeretnél még egy példát?\n[1]Igen\n[2]Nem");
            if (folytat !=1){
                ciklus1 = true;
            }else{
                System.out.println("Itt a következő példa...");
            }
        }
    }

    static void szorzas() {
        boolean ciklus3 = false;
        while(!ciklus3){
            int[] szam = general("*");
            while(!(szam[0] > 1 && szam[0] < 100)){
                szam = general("*");
            }
            System.out.printf("Mennyi %d x %d ?\n", szam[1],szam[2]);
            int eredmeny = bekeres("Végeredmény:\n>>");
            helyes_helytelen(eredmeny, szam[0]);
            int folytat = bekeres("Szeretnél még egy példát?\n[1]Igen\n[2]Nem");
            if (folytat !=1){
                ciklus3 = true;
            }else{
                System.out.println("Itt a következő példa...");
            }
        }
        
    } //03.14 elkészült || nem tökéletes de rottyon vagyok egy betegség miatt

    static void osztas() {
        boolean osztas = false;
        while(!osztas){
            int[] szamaim = general("/");
            while (!(szamaim[0] > 1 && szamaim[0] < 100)){
                szamaim = general("/");
            }
        System.out.println("Mennyi "+szamaim[1]+" / "+szamaim[2]+" ?\n");
        int eredmeny = bekeres("Eredmény: \n");
        helyes_helytelen(eredmeny, szamaim[0]);
        int folytatas = bekeres("Szeretnél egy újabb példát?\n[1] = Igen\n[2] = Nem");
        if (folytatas !=1){
            osztas = true;
        }
        else{
            System.out.println("Egy következő példa..");
            }
        }
    }
    static int[] general( String muvelet){ 
        Random rnd = new Random();
        int[] lista1 = new int[3];
        int osszeg = 0;
        int random1 = rnd.nextInt(100-1)+1;
        int random2 = rnd.nextInt(100-1)+1;
        if(muvelet == "+" ){
            osszeg = random1 + random2;
        }else if(muvelet == "-"){
            osszeg = random1 - random2;
        }else if(muvelet == "*"){
            osszeg = random1 * random2;
        }else if(muvelet == "/"){
            osszeg = random1 / random2;
        }
        lista1[0] = osszeg; lista1[1] = random1; lista1[2] = random2;
        return lista1;
    } //HASZNÁLAT: paraméterként csak add meg "" jelek között a kívánt müvelet jelét és general 2 random számbók egy példát. A végösszeget és a két számot is eltárolja. 0. indexen az végösszeg található, 1 indexen a random1 2. indexen a random2
    static void helyes_helytelen(int adat1, int adat2){
        if (adat1 == adat2){
            System.out.println("A válasz helyes!");
        }else{
            System.out.println("A válasz helytelen!");
            System.out.println("A helyes megfejtés: "+adat2);
        }
    } //Eldönti, hogy helyes-e a megadott eredmény. adat1 a felhasználó által beirt összeg, adat2 a 0. indexen található gép által kiszámolt összeg.
}
