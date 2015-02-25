package TALN;

import java.io.*;
import java.util.ArrayList;

public class RootTree {
    private char root;
    private ArrayList<RootTree> children;
    private ArrayList<Word> definition;
    public RootTree(){
        this.root='#';
        this.children=new ArrayList<RootTree>();
    }

    public RootTree(char c){
        this.root=c;
        this.children=new ArrayList<RootTree>();
    }

    public static RootTree loadRootTree()throws IOException {
        InputStream ips = new FileInputStream("./src/TALN/wordFile.txt");
        InputStreamReader ipsr = new InputStreamReader(ips);
        BufferedReader br = new BufferedReader(ipsr);
        String line;
        RootTree toReturn=new RootTree();
        while ((line = br.readLine()) != null){
            String[] split = line.split(",");
            String[] roots = new String[split.length - 2];
            System.arraycopy(split, 2, roots, 0, split.length-2);
            for(String root: roots){
                Word word = new Word(split[0],split[1],root);
                InsertRoot(toReturn, root+"-",word);
            }
        }
        return toReturn;
    }

    private static void InsertRoot(RootTree currentLeaf, String root, Word word) {
        // Si ma récursion est terminée je m'arrête;
        if(root.equals("")){
            currentLeaf.definition=new ArrayList<Word>();
            currentLeaf.definition.add(word);
            return;
        }
        // S'il y a un fils qui est le même que la dernière lettre je continue sur ce fils
        char lastChar = root.charAt(0);
        if(currentLeaf.checkChild(lastChar)){
            InsertRoot(currentLeaf.getChild(lastChar), root.substring(1, root.length()), word);
        }
        //sinon j'ajoute le noeud et je continue
        else{
            RootTree nextNode = new RootTree(lastChar);
            currentLeaf.children.add(nextNode);
            InsertRoot(nextNode, root.substring(1, root.length()), word);
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

    public ArrayList<Word> getWordRoot(String word) {
        ArrayList<Word> toReturn = new ArrayList<Word>();
        if (!word.equals("")){
            char firstLetter =word.charAt(0);


            if(this.checkChild('-')){
                toReturn.addAll(this.getChild('-').definition);
            }
            if(!this.checkChild(firstLetter)) return toReturn;

            toReturn.addAll(this.getChild(firstLetter).getWordRoot(word.substring(1, word.length())));
        }

        return toReturn;
    }

}
