package TALN;

import java.util.ArrayList;

public class Word {
    public String getTypeString() {return this.Type;}
    public String getWordString() {return this.Word;}
    public String getRootString() {return this.Root;}
    public int getNumRoot(){return this.numRoot;}
    private String Word;
    private String Type;
    private String Root;
    private int numRoot;


    public Word(String word,String type,String root,int numRoot) {
        this.Word = word;
        this.Type = type;
        this.Root = root;
        this.numRoot=numRoot;
    }

    public void getWordTermination(){
        String word= this.getWordString();
        for (int i = word.length(); i < 0  ; i++) {
            // word.charAt();
        }
    }
    public void getWordroot(){

    }
    public void analyzeWord(){

    }

    public String toString(){
        if (Type.equals("verbe")) {
            return this.getWordString() + ":" + this.getTypeString() + "\t" + "(" + this.numRoot + ")" + this.getRootString();
        } else if (Type.equals("nom")) {
            return this.getWordString() + ":" + this.getTypeString() + "\t";
        } else {
            return "erreur de type";
        }

    }

}
