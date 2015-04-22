package TALN;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

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
                    String[] tabPerson = Arrays.copyOfRange(split, 1, split.length);
                    toReturn.conjugaison.get(word).put(tense, Utils.convertStringArrayToIntArray(tabPerson));
                }

            }
        }
        return toReturn;
    }



    public boolean checkRoot(String wordString, String tense, int personNumber, int rootIndex) {
        try{
            return conjugaison.get(wordString).get(tense)[personNumber] == rootIndex;
        }
        catch(NullPointerException e){
            return false;
        }
    }

    public int getRootNumber(String wordRoot, String tense, int personNumber ){
        HashMap wordMap = (HashMap) this.conjugaison.get(wordRoot);
        if(tense.equals("masculin") || tense.equals("feminin")) {
            return 1;
        }
        else {
            Set<String> tenses = wordMap.keySet();

            Iterator iterator = tenses.iterator();
            while (iterator.hasNext()) {
                String key = iterator.next().toString();
                if (key.contains(tense)) {
                    return ((int[]) wordMap.get(key))[personNumber - 1];
                }
            }
        }
        return -1;
    }
}
