package TALN;

import java.io.IOException;
import static java.lang.Integer.parseInt;

public class generateur_morphologique {
    public static void main(String[] args) throws IOException {
        if(args.length != 3){
            System.out.println("Usage");
            System.out.println("You must have 3 argument which are: word tense person");
            return;
        }

        Analysator.getInstance().generate(args[0], args[1], parseInt(args[2]));

    }
}
