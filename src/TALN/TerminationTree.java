package TALN;

import java.io.*;

public class TerminationTree {
    public char root='!';
    public TerminationTree child;
    public TerminationTree brother;

    public TerminationTree subTree;

    public TerminationTree(){
        this.root='#';
    }
    public void setRoot(char c){
        this.root=c;
    }
    public void makeTerminationTree(){
        try {
            InputStream ips = new FileInputStream("/home/drydge/Documents/S6/Langage Naturel /TALN/src/TALN/terminationFile.txt");
            InputStreamReader ipsr = new InputStreamReader(ips);
            BufferedReader br = new BufferedReader(ipsr);
            String ligne;
            // try to put termination in TerminationTree
            while ((ligne = br.readLine()) != null) {
                // split all inline entry in an entry table
                String[] entry =ligne.split(",");
                for(int i = 1; i < entry.length; i++) {
                    this.subTree=this;

                    // each termination in table of char
                    char[] termination = entry[i].toCharArray();
                    int j = termination.length-1;
                    while (j <=0) {
                        if (this.subTree.root=='#'){
                            this.subTree.setRoot(termination[j]);
                            this.subTree.child=new TerminationTree();
                            this.subTree.brother=new TerminationTree();
                        }else if (termination[j]== this.subTree.root) {
                           this.subTree=this.subTree.child;
                        }else if (this.subTree.brother.root !='#'){
                            this.subTree=this.subTree.brother;
                        }else {
                            this.subTree.setRoot(termination[j]);
                            this.subTree=this.subTree.child;
                            j--;
                        }
                    }
                }
            }
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void ShowTerminationTree(){
        System.out.println("<- TERMINATION TREE ->");
        this.ShowTerminationTreeRec(this,1);
        System.out.println("\n>--------------------<");
    }

    private void addChild(){

    }
    private void addBrother(){

    }

    private void ShowTerminationTreeRec(TerminationTree tree,int n ) {
        for (int i = 0; i < n; i++) {
            System.out.print('\t');
        }
        if (tree.root!='!'){
            System.out.println(tree.root);
            tree.ShowTerminationTreeRec(tree.child,n+1);
            tree.ShowTerminationTreeRec(tree.brother, n + 1);
        }
    }

}
