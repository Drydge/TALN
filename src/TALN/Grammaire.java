package TALN;

public class Grammaire {

    private final String group;
    private final int person;
    private final String term;

    public Grammaire(String group,String term, int index) {
        this.group = group;
        this.person = index;
        this.term= term;
    }

    public int getNumPerson() {return this.person;}
    public String getGroup() {return this.group;}
    public String getTerm() {return this.term;}
    public String getPerson() throws Exception {
        switch (this.getWordType()){
            case VERBE:
                switch (this.person){
                    case 1: return "(je)1ère personne du singulier";
                    case 2: return "(tu)2ème personne du singulier";
                    case 3: return "(il/elle)3ème personne du singulier";
                    case 4: return "(nous)1ère personne du pluriel";
                    case 5: return "(vous)2ème personne du pluriel";
                    case 6: return "(ils/elles)3ème personne du pluriel";
                    default: throw new Exception("wrong person");
                }

            case NOM:
                switch (this.person){
                    case 1: return "nom masculin singulier";
                    case 2: return "nom feminin singulier";
                    case 3: return "nom masculin pluriel";
                    case 4: return "nom feminin pluriel";
                    default: throw new Exception("wrong person");
                }
            case PRONOM:
                switch (this.person){
                    case 1: return "pronon masculin singulier";
                    case 2: return "pronon feminin singulier";
                    case 3: return "pronon masculin pluriel";
                    case 4: return "pronon feminin pluriel";
                    default: throw new Exception("wrong person");
                }
            case ADJECTIF:
                switch (this.person){
                    case 1: return "adjectif masculin singulier";
                    case 2: return "adjectif feminin singulier";
                    case 3: return "adjectif masculin pluriel";
                    case 4: return "adjectif feminin pluriel";
                    default: throw new Exception("wrong person");
                }
            case ADVERB:
                return "adverbe invariable";
            default:throw new Exception("wrong type");
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
