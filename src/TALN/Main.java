package TALN;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("Usage");
            System.out.println("You must at least have 1 argument which is a filepath or a real word");
            return;
        }
        try {
            Analysator.getInstance().analyze("ve");

        } catch (IOException e) {
            e.printStackTrace();
        }


        // firstly we're gonna implement the word only implementation
        // Word.Interpretation(args[0]);
    }
}
