package TALN;

public class Word {
    public String getWordString() {
        return Word;
    }

    private String Word;


    public Word(String word) {
        this.Word = word;
    }

    public void getWordTermination(){
        String word= this.getWordString();
        for (int i = 0; i < word.length() ; i++) {
            // word.charAt();
        }
    }
    public void getWordroot(){

    }
    public void analyzeWord(){

    }

    public static void Interpretation(String word) {
         Word wordToAnalyze = new Word(word);
        // Do Stuff

        // Print result

    }
}
