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
            this.setRoot('^');
            this.child=new TerminationTree();
            this.brother=new TerminationTree();
            // try to put termination in TerminationTree
            while ((ligne = br.readLine()) != null) {
                // split all inline entry in an entry table
                String[] entry =ligne.split(",");
                char[] termination;
                for(int i = 1; i < entry.length; i++) {
                    this.subTree=this.child;

                    // each termination in table of char
                    termination = entry[i].toCharArray();
                    int j = termination.length-1;
                    if (termination[j]!=' '){
                        while (j >=0) {
                            if (this.subTree.root=='#'){
                                this.subTree.setRoot(termination[j]);
                                this.subTree.child=new TerminationTree();
                                this.subTree.brother=new TerminationTree();
                                System.out.println("tree-r--" + termination[j]);
                                this.subTree=this.subTree.child;
                                j--;
                            }else if (this.subTree.root==termination[j]) {
                                System.out.println("tree-c--" + termination[j]);
                                this.subTree=this.subTree.child;
                                j--;
                            }else{
                                this.subTree=this.subTree.brother;
                            }
                        }
                        this.addChild('*');
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

    private void addChild(char c){
        if (this.root=='#') {
            this.brother=new TerminationTree();
            this.child=new TerminationTree();
            this.root=c;
        }
        else this.brother.addChild(c);
    }

    private void ShowTerminationTreeRec(TerminationTree tree,int n ) {
        for (int i = 1; i < n; i++) {
            System.out.print(' ');
        }
        if (tree.root!='#'){
            System.out.println(tree.root);
            tree.ShowTerminationTreeRec(tree.child, n + 1);
            if (tree.brother.root!='#'){
                System.out.println();
                tree.ShowTerminationTreeRec(tree.brother,n);
            }
        }
    }

}
