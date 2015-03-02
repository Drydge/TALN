package TALN;

/**
 * Created by Utilisateur on 25/02/2015.
 */
public class Grammaire {


    private final String tense;
    private final String group;
    private final int person;
    private final String term;

    public Grammaire(String group,String term, int index) {
        this.group = group;
        this.tense = group.split("_",2)[1];
        this.person = index;
        this.term= term;
    }

    public String getTense() {
        return tense;
    }
    public int getNumPerson() {return this.person;}
    public String getGroup() {return this.group;}
    public String getTerm() {return this.term;}
    public String getPerson() throws Exception {
        switch (this.person){
            case 1: return "(je)1ère personne du singulier";
            case 2: return "(tu)2ème personne du singulier";
            case 3: return "(il/elle)3ème personne du singulier";
            case 4: return "(nous)1ère personne du pluriel";
            case 5: return "(vous)2ème personne du pluriel";
            case 6: return "(ils/elles)3ème personne du pluriel";
            default: throw new Exception("wrong person");
        }
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
        try {
            return(getPerson()+","+getGroup());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
