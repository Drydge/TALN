package TALN;

import java.util.ArrayList;

public class Word {
    public String getTypeString() {return this.Type;}
    public String getWordString() {return Word;}
    public String getRootString() {return Root;}
    private String Word;
    private String Type;
    private String Root;


    public Word(String word,String type,String root) {
        this.Word = word;
        this.Type = type;
        this.Root = root;
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
        return this.getWordString()+" "+this.getTypeString()+" "+this.getRootString();
    }

}
