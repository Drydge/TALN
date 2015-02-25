package TALN;

/**
 * Created by Utilisateur on 25/02/2015.
 */
public class Grammaire {

    private final String group;
    private final int person;

    public Grammaire(String group, int index) {
        this.group = group;
        this.person = index;
    }

    public WordType getWordType() throws Exception {
        switch (this.group.charAt(0)){
            case 'v': return WordType.VERBE;
            case 'n': return WordType.NOM;
            case 'p': return WordType.PRONOM;
            case 'a': return WordType.ADJECTIF;
            case 'w': return WordType.ADVERB;
            default: throw new Exception("bad word type");
        }
    }

    public int getConjugaison(){
        try {
            if(this.getWordType() == WordType.VERBE){
                return this.person;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public String toString(){
        return(this.group+" "+this.person);
    }
}
