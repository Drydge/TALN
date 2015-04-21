package TALN;

import java.io.IOException;
import static java.lang.Integer.parseInt;

/**
 * Created by jdeveaux on 06/03/2015.
 */
public class generateur_morphologique {
    public static void main(String[] args) throws IOException {
        if(args.length != 3){
            System.out.println("Usage");
            System.out.println("You must have 3 argument which are: word tense person");
            return;
        }

        Analysator.getInstance().generate(args[0], args[1], parseInt(args[2]));



        // 1- Trouver la racine
        // 2- Trouver la terminaison
        // 3- Concat des deux
    }
}
