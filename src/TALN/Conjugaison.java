package TALN;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class Conjugaison {
    private Map<String,Map<String,int[]>> conjugaison;
    private static Conjugaison _instance;
    private static String uri;

    private Conjugaison(Map<String, Map<String, int[]>> conjugaison) {
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

    private static Conjugaison loadConjugaison() throws IOException {
        // Chargement du fichier de conjugaison dans le gros map
        BufferedReader br = Utils.getBufferedReaderFromStringPath("./src/TALN/conjugaison.txt");
        String line;
        String word="";
        Conjugaison toReturn = new Conjugaison(new HashMap<String, Map<String, int[]>>(50));
        while((line=br.readLine())!=null){
            line=line.replaceAll("\t","");
            line=line.replaceAll(" ","");
            if (!line.isEmpty()&&line.charAt(0)!='#')
            {

                String[] split = line.split(",");
                String firstSplit = split[0];

                if (!(firstSplit.charAt(0) == '-')) {
                    word = firstSplit;
                    HashMap<String, int[]> hashMap = new HashMap<String, int[]>(10);
                    if (split.length > 1) {
                        hashMap.put(split[1], Utils.convertStringArrayToIntArray(Arrays.copyOfRange(split, 2, split.length)));
                    }
                    toReturn.conjugaison.put(word, hashMap);
                } else {
                    String tense = firstSplit.substring(1, firstSplit.length());
                    //rajouter un temps au verbe courant
                    String[] tabPerson = Arrays.copyOfRange(split, 1, split.length - 1);
                    toReturn.conjugaison.get(word).put(tense, Utils.convertStringArrayToIntArray(tabPerson));
                }

            }
        }
        return toReturn;
    }



    public boolean checkRoot(String wordString, String tense, int numPerson, int rootIndex) {
        try{
            return conjugaison.get(wordString).get(tense)[numPerson] == rootIndex;
        }
        catch(NullPointerException e){
            return false;
        }
    }
}
