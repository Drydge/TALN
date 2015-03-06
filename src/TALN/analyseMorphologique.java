package TALN;

import java.io.IOException;

public class analyseMorphologique {

    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("Usage");
            System.out.println("You must at least have 1 argument which is a filepath or a real word");
            return;
        }
        try {
            //si j'ai un fichier du nom args[0] => je lance analyzeSRC
            //sinon j'analise le mot.
            Analysator.getInstance().analyze(args[0]);
            Analysator.getInstance().analyzeSRC("./src/TALN/src.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }


        // firstly we're gonna implement the word only implementation
        // Word.Interpretation(args[0]);
    }
}
