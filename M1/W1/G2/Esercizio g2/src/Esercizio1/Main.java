package Esercizio1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static boolean stringaPariStringaDispari(String str) {
        int lunghezza = str.length();

        if (lunghezza % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean annoBisestile(int anno) {
        if ((anno % 4 == 0 && anno % 100 != 0) || (anno % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }



    public static void main(String[] args) {

        String stringaPari = "ciao";
        String stringaDispari = "hello";
        System.out.println(stringaPariStringaDispari(stringaPari));
        System.out.println(stringaPariStringaDispari(stringaDispari));


        int anno1 = 2024;
        int anno2 = 2023;
        System.out.println(anno1 + " è bisestile? " + annoBisestile(anno1));
        System.out.println(anno2 + " è bisestile? " + annoBisestile(anno2));
    }

}
