package TALN;

import java.io.*;
import java.util.ArrayList;

public class TerminationTree {
    private char root;
    // contient l'ensemble des types de mots : verbe premier groupe, nom, etc
    private ArrayList<String> definition;
    private ArrayList<TerminationTree> children;

    public TerminationTree(){
        this.root='#';
        this.children = new ArrayList<TerminationTree>();
        this.definition = new ArrayList<String>();
    }

    public TerminationTree(char l){
        this.root = l;
        this.children = new ArrayList<TerminationTree>();
        this.definition = new ArrayList<String>();
    }

    public boolean hasChild(){
        return this.children != null && this.children.size() > 0;
    }

    public static TerminationTree loadTerminationTree() throws IOException {
        InputStream ips = new FileInputStream("./src/TALN/terminationFile.txt");
        InputStreamReader ipsr = new InputStreamReader(ips);
        BufferedReader br = new BufferedReader(ipsr);
        String line;
        TerminationTree toReturn = new TerminationTree();
        // Pour chaque ligne de notre fichier, nous voulons:
        // 1 - récupérer toutes les terminaisons et les inscrire dans l'arbre
        // 2 - flaguer la feuille comme terminaison d'un groupe ( nom féminin, nom singulier, verbe du premier groupe, etc )
        while ((line = br.readLine()) != null){
            String[] split = line.split(",");
            String group = split[0];
            String[] terminations = new String[split.length - 1];
            System.arraycopy(split, 1, terminations, 0, split.length - 1);
            for(String termination: terminations){
                // - Vérifier si l'un des fils correspond à la dernière lettre de la terminaison
                InsertTermination(toReturn, termination, group);
            }
        }

        return toReturn;
    }

    private static void InsertTermination(TerminationTree currentLeaf, String termination, String group) {
        // Si ma récursion est terminée je m'arrête;
        if(termination.equals("")){
            currentLeaf.definition.add(group);
            return;
        }
        // S'il y a un fils qui est le même que la dernière lettre je continue sur ce fils
        char lastChar = termination.charAt(termination.length() - 1);
        if(currentLeaf.checkChild(lastChar)){
            InsertTermination(currentLeaf.getChild(lastChar), termination.substring(0, termination.length() - 1), group);
        }
        //sinon j'ajoute le noeud et je continue
        else{
            TerminationTree nextNode = new TerminationTree(lastChar);
            currentLeaf.children.add(nextNode);
            InsertTermination(nextNode, termination.substring(0, termination.length() - 1), group);
        }
    }

    private boolean checkChild(char c) {
        for(TerminationTree child : this.children){
            if(child.root == c){
                return true;
            }
        }
        return false;
    }

    private TerminationTree getChild(char root){
        for(TerminationTree child : this.children){
            if(child.root == root){
                return child;
            }
        }
        return null;
    }
}
