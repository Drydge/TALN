package TALN;

import java.io.*;
import java.util.ArrayList;

public class Analysator {
    private TerminationTree TTree;
    private RootTree RTree;
    private static Analysator _instance;
    private Conjugaison c;
    private Analysator() throws IOException {
        this.TTree =TerminationTree.loadTerminationTree();
        this.RTree =RootTree.loadRootTree();
        this.c = Conjugaison.getInstance();
    }

    public final static  Analysator getInstance() throws IOException {
        if(_instance == null){
            synchronized(Analysator.class){
                if(Analysator._instance == null) {
                    Analysator._instance = new Analysator();
                }
            }
        }
        return _instance;
    }
    public void analyzeSRC(String src) throws IOException {
        BufferedReader br = Utils.getBufferedReaderFromStringPath(src);
        String line;
        while ((line = br.readLine()) != null){
            String[] split = line.split(" ");
            for(String word:split){
                analyze(word);
            }
        }
    }

    public void analyze(String word){
        ArrayList<Word> wordRoots= this.RTree.getWordRoot(word);
        ArrayList<Grammaire>wordTerms=this.TTree.getWordTermination(word);
        for (Word wroot:wordRoots){
            String root=wroot.getRoot();
            for (Grammaire wterm:wordTerms){
                String term=wterm.getTerm();
                String rootterm=root+term;
                // Tester fichier de conjugaison ici pour vérifier que la racine correspond au temps utilisé
                if(rootterm.equals(word) && c.checkRoot(wroot.getWord(),wterm.getGroup(),wterm.getNumPerson(),wroot.getNumRoot())){
                    System.out.println("("+word+")"+wroot.getWord()+"=>"+wterm);
                }
            }
        }
    }

}
