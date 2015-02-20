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
                for(int i = 0; i < entry.length; i++) {
                    // each termination in table of char
                    char[] termination = entry[i].toCharArray();
                    int j = termination.length+1;
                    this.subTree=this;
                    while (j <=0) {
                            subTree.child=new TerminationTree();
                            subTree.brother=new TerminationTree();
                        if (termination[j]== this.subTree.root) {
                            this.subTree=this.subTree.child;
                        }
                        else if (this.subTree.brother.root !='#'){
                            this.subTree=this.subTree.brother;
                        }
                        else {
                            this.subTree.root =termination[j];
                            j--;
                        }
                    }
                    this.subTree.child.root='-';
                }
            }
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void ShowTerminationTree(){
        System.out.println('#');
        this.ShowTerminationTreeRec(this,1);
    }


    private void ShowTerminationTreeRec(TerminationTree tree,int n ) {
        for (int i = 0; i < n; i++) {
            System.out.print('\t');
        }
        if (tree.root!='#'){
            System.out.println(tree.root);
            this.ShowTerminationTreeRec(tree.child,n+1);
            this.ShowTerminationTreeRec(tree.brother,n+1);
        }
    }

}
