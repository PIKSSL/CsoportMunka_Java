package csoportmunka_java;

import java.util.Random;
import java.util.Scanner;

public class CsoportMunka_Java {
    
    public static void main(String[] args) {
        //Bekérés metódusban  || menü
        menu();
    }
    private static void menu() { //Menü
        System.out.println("A program segítségével elvégezhet egyszerü összeadási/kivonási/szorzási/osztási műveleteket.\nAz alábbi menüpontok közül választhat:");
        boolean ciklus = false;
        while(!ciklus){
            int valasztas = bekeres("1|Összeadás\n2|Kivonás\n3|Szorzás\n4|Osztás\n5|Kilépés");
            //Négy fő megtódus 
            
            osszeadas();
            kivonas();
            szorzas();
            osztas();
            
        }
    }
    static int bekeres(String szoveg){ 
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
    }

    static void osszeadas() {
        boolean ciklus2 = false;
        while(!ciklus2){
            //asd
            System.out.println("Mennyi");
        }
    }

    static void kivonas() {
        
    }

    static void szorzas() {
        boolean ciklus3 = false;
        while(!ciklus3){
            
            System.out.printf("Mennyi %d x %d ?\n") ;
        }
        
    }

    static void osztas() {
        
    }
    //HIBÁS!!! NE HASZNÁLD!
    static int general( String muvelet){
        Random rnd = new Random();
        int osszeg = 0;
        
        if(muvelet == "+" ){
            osszeg = rnd.nextInt(100-1)+1 + rnd.nextInt(100-1)+1;
            return osszeg;
        }else if(muvelet == "-"){
            osszeg = rnd.nextInt(100-1)+1 - rnd.nextInt(100-1)+1;
            return osszeg;
        }else if(muvelet == "*"){
            osszeg = rnd.nextInt(100-1)+1 * rnd.nextInt(100-1)+1;
            return osszeg;
        }else if(muvelet == "/"){
            osszeg = rnd.nextInt(100-1)+1 / rnd.nextInt(100-1)+1;
            return osszeg;
        }
        return 0;
    }
    
}
