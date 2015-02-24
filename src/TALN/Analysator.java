package TALN;

import java.io.IOException;

public class Analysator {
    private TerminationTree TT;
    private RootTree RT;
    public Analysator() throws IOException {
        this.TT=TerminationTree.loadTerminationTree();
        this.RT=RootTree.loadRootTree();
    }
}
