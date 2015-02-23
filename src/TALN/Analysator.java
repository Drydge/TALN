package TALN;

import java.io.IOException;

public class Analysator {
    private TerminationTree TT;
    private RootTree RT;
    public Analysator() throws IOException {
        this.TT=new TerminationTree();
        TT.loadTerminationTree();
        this.RT=new RootTree();
        RT.loadRootTree();
    }
}
