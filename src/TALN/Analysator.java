package TALN;

import java.io.IOException;
import java.util.ArrayList;

public class Analysator {
    private TerminationTree TTree;
    private RootTree RTree;
    private static Analysator _instance;

    private Analysator() throws IOException {
        this.TTree =TerminationTree.loadTerminationTree();
        this.RTree =RootTree.loadRootTree();
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

    public String analyze(String word){
        ArrayList<String> wordRoot= this.RTree.getWordRoot("mangerais");
        ArrayList<Grammaire>wordTerm=this.TTree.getWordTermination("mangerais");
        System.out.println(wordRoot);

        return "";
    }

}
