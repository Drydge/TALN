package TALN;

import java.io.*;
import java.util.ArrayList;

public class RootTree {
    private char root;
    private ArrayList<RootTree> children;
    private ArrayList<String> definition;
    public RootTree(){
        this.root='#';
        this.children=new ArrayList<RootTree>();
    }

    public RootTree(char c){
        this.root=c;
        this.children=new ArrayList<RootTree>();
    }

    public RootTree loadRootTree()throws IOException {
        InputStream ips = new FileInputStream("./src/TALN/wordFile.txt");
        InputStreamReader ipsr = new InputStreamReader(ips);
        BufferedReader br = new BufferedReader(ipsr);
        String line;
        RootTree toReturn=new RootTree();
        while ((line = br.readLine()) != null){
            String[] split = line.split(",");
            String word = split[0];
            String type = split[1];
            String[] roots = new String[split.length - 1];
            System.arraycopy(split, 2, roots, 1, split.length);
            for(String root: roots){
                // - Vérifier si l'un des fils correspond à la dernière lettre de la terminaison
                InsertRoot(toReturn, root,word);
            }
        }
        return toReturn;
    }

    private void InsertRoot(RootTree currentLeaf, String root, String word) {
        // Si ma récursion est terminée je m'arrête;
        if(root.equals("")){
            currentLeaf.definition.add(word);
            return;
        }
        // S'il y a un fils qui est le même que la dernière lettre je continue sur ce fils
        char lastChar = root.charAt(root.length() - 1);
        if(currentLeaf.checkChild(lastChar)){
            InsertRoot(currentLeaf.getChild(lastChar), root.substring(0, root.length() - 1), word);
        }
        //sinon j'ajoute le noeud et je continue
        else{
            RootTree nextNode = new RootTree(lastChar);
            currentLeaf.children.add(nextNode);
            InsertRoot(nextNode, root.substring(0, root.length() - 1), word);
        }
    }
    private boolean checkChild(char c) {
        for(RootTree child : this.children){
            if(child.root == c){
                return true;
            }
        }
        return false;
    }
    private RootTree getChild(char root){
        for(RootTree child : this.children){
            if(child.root == root){
                return child;
            }
        }
        return null;
    }

}
