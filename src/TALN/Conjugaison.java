package TALN;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Created by jdeveaux on 02/03/2015.
 */
public class Conjugaison {
    private Map<String,Map<String,String[]>> conjugaison;
    private static Conjugaison _instance;
    private static String uri;

    private Conjugaison(Map<String, Map<String, String[]>> conjugaison) {
        this.conjugaison = conjugaison;
    }

    public final static  Conjugaison getInstance() throws IOException {
        if(_instance == null){
            synchronized(Analysator.class){
                if(Conjugaison._instance == null) {
                    Conjugaison._instance = Conjugaison.loadConjugaison();
                }
            }
        }
        return _instance;
    }

    private static Conjugaison loadConjugaison() {
        // Chargement du fichier de conjugaison dans le gros map
        return new Conjugaison(new HashMap<String, Map<String, String[]>>(50));
    }


    public boolean checkRoot(String wordString, String tense, int numPerson, String root) {
        return true;
        //return conjugaison.get(wordString).get(tense)[numPerson].equals(root);
    }
}
