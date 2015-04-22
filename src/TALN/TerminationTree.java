package TALN;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class TerminationTree {
    private char root;
    // contient l'ensemble des types de mots : verbe premier groupe, nom, etc
    private ArrayList<Grammaire> definition;
    private ArrayList<TerminationTree> children;


    public TerminationTree(){
        this.root='#';
        this.children = new ArrayList<TerminationTree>();
        this.definition = new ArrayList<Grammaire>();
    }

    public TerminationTree(char l){
        this.root = l;
        this.children = new ArrayList<TerminationTree>();
        this.definition = new ArrayList<Grammaire>();
    }

    public boolean hasChild(){
        return this.children != null && this.children.size() > 0;
    }

    public static TerminationTree loadTerminationTree() throws IOException {
        BufferedReader br = Utils.getBufferedReaderFromStringPath("./src/TALN/terminationFile.txt");
        String line;
        TerminationTree toReturn = new TerminationTree();
        // Pour chaque ligne de notre fichier, nous voulons:
        // 1 - récupérer toutes les terminaisons et les inscrire dans l'arbre
        // 2 - flaguer la feuille comme terminaison d'un groupe ( nom féminin, nom singulier, verbe du premier groupe, etc )
        while ((line = br.readLine()) != null){
            line=line.replaceAll("\t","");
            line=line.replaceAll(" ","");
            if (!line.isEmpty()&&line.charAt(0)!='#'){
                String[] split = line.split(",");
                String group = split[0];
                String[] terminations = new String[split.length - 1];
                System.arraycopy(split, 1, terminations, 0, split.length - 1);
                int index = 1;
                for(String termination: terminations){
                    // - Vérifier si l'un des fils correspond à la dernière lettre de la terminaison
                    Grammaire grammar = new Grammaire(group,termination ,index);
                    InsertTermination(toReturn, '-'+termination, grammar);
                    index ++;
                }
            }
        }

        return toReturn;
    }

    private static void InsertTermination(TerminationTree currentLeaf, String termination, Grammaire grammar) {
        // Si ma récursion est terminée je m'arrête;
        if(termination.equals("")){
            currentLeaf.definition.add(grammar);
            return;
        }
        // S'il y a un fils qui est le même que la dernière lettre je continue sur ce fils
        char lastChar = termination.charAt(termination.length() - 1);
        if(currentLeaf.checkChild(lastChar)){
            InsertTermination(currentLeaf.getChild(lastChar), termination.substring(0, termination.length() - 1), grammar);
        }
        //sinon j'ajoute le noeud et je continue
        else{
            TerminationTree nextNode = new TerminationTree(lastChar);
            currentLeaf.children.add(nextNode);
            InsertTermination(nextNode, termination.substring(0, termination.length() - 1), grammar);
        }
    }
    private boolean haveChildren() {
        if (this.children.isEmpty()){return false;}
        return true;
    }
    private boolean checkChild(char c) {
        // verification dans les child le noeud de racine 'c' existe
        for(TerminationTree child : this.children)
            if(child.root == c)
                return true;
        return false;
    }

    private TerminationTree getChild(char root){
        // renvoie le child de racine 'root'
        for(TerminationTree child : this.children)
            if(child.root == root)
                return child;
        return null;
    }

    public ArrayList<Grammaire> getWordTermination(String word) {

        char firstLetter =word.charAt(word.length()-1);
        // initialisation de la list a retourner
        ArrayList<Grammaire> toReturn = new ArrayList<Grammaire>();
        if(this.checkChild('-'))toReturn.addAll(this.getChild('-').definition);
        // cas d'arret s'il n'y a plus de child correspondant
        if(!this.checkChild(firstLetter)) return toReturn;
        // remplissage récursif de la list toReturn
        toReturn.addAll(this.getChild(firstLetter).getWordTermination(word.substring(0, word.length() - 1)));

        return toReturn;
    }

    private ArrayList<Grammaire> getAllGrammaire(){
        ArrayList<Grammaire> allGram=new ArrayList<Grammaire>();

        if (this.haveChildren()){
            if(this.checkChild('-'))allGram.addAll(this.getChild('-').definition);
            for (int i = 0; i < this.children.size(); i++) {
                allGram.addAll(this.children.get(i).getAllGrammaire());
            }
        }
        return allGram;
    }
    public String getOneTerm(String type, String tense,int personNumber){
        ArrayList<Grammaire> allGram = this.getAllGrammaire();
        String term="";
        if(!type.contains("verbe")){
            for (Grammaire gram : allGram){
                String gramGroup = gram.getGroup();
                    if (gram.getNumPerson()==personNumber && gramGroup.contains(type)){
                        if (tense.contains("masculin")&&gram.getGroup().contains("feminin"))
                            System.out.println("erreur :le mot est feminin generation pour le feminin");
                        if (tense.contains("feminin")&&gram.getGroup().contains("masculin"))
                            System.out.println("erreur :le mot est masculin generation pour le masculin");
                        term=gram.getTerm();
                        return term;
                    }
            }
        }else{
            for (Grammaire gram : allGram){
                String gramGroup = gram.getGroup();
                if (gram.getNumPerson()==personNumber && gramGroup.contains(tense) && gramGroup.contains(type)){
                    term=gram.getTerm();
                    return term;
                }
            }
        }
        return term;
    }
}


