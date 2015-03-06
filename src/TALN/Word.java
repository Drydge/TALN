package TALN;

public class Word {
    public String getType() {return this.Type;}
    public String getWord() {return this.Word;}
    public String getRoot() {return this.Root;}
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
        String word= this.getWord();
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
            return this.getWord() + ":" + this.getType() + "\t" + "(" + this.numRoot + ")" + this.getRoot();
        } else if (Type.equals("nom")) {
            return this.getWord() + ":" + this.getType() + "\t";
        } else {
            return "erreur de type";
        }

    }

}
