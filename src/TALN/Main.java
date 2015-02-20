package TALN;

public class Main {

    public static void main(String[] args) {
        TerminationTree tree= new TerminationTree();
        tree.makeTerminationTree();
        try {
            tree.ShowTerminationTree();
        }
        catch (Exception ignored){

        }
        if(args.length != 1){
            System.out.println("Usage");
            System.out.println("You must at least have 1 argument which is a filepath or a real word");
        }
        // firstly we're gonna implement the word only implementation
        // Word.Interpretation(args[0]);
    }
}
