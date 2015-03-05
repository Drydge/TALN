package TALN;

import java.io.*;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

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

    private static Conjugaison loadConjugaison() throws IOException {
        // Chargement du fichier de conjugaison dans le gros map
        InputStream ips = new FileInputStream("./src/TALN/conjugaison.txt");
        InputStreamReader ipsr = new InputStreamReader(ips);
        BufferedReader br = new BufferedReader(ipsr);
        String line;
        Conjugaison toReturn = new Conjugaison(new HashMap<String, Map<String, String[]>>(50));
        while((line=br.readLine())!=null){
            String[] split=line.split(",");
            String firstSplit=split[0];
            String word=firstSplit;
            if (firstSplit.charAt(0)=='-'){
                String tense=firstSplit.substring(1,firstSplit.length()-1);
                //rajouter un temps au verbe courant
                String[] tabPerson;
                toReturn.conjugaison.put(word, ));
            else{
                //nouveau mot

            }
        }
        return toReturn;
    }

    private String[] SubArray(String[] array, int first, int length){

        String[] subarray = new String[0];
        for (int i = 0; i <= length; i++) {
            subarray[i]=array[first+i];
        }
        return subarray;
    }
    
    public boolean checkRoot(String wordString, String tense, int numPerson, String root) {
        return true;
        //return conjugaison.get(wordString).get(tense)[numPerson].equals(root);
    }
}
