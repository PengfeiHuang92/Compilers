package assign3.parser ;

import assign3.visitor.* ;

public class ModulousNode extends Node {

    public LiteralNode left  ;
    public LiteralNode right ;

    public ModulousNode () {

    }
    
    public ModulousNode (LiteralNode left, LiteralNode right) {

        this.left  = left  ;
        this.right = right ;
    }

    public void accept(ASTVisitor v) {

        v.visit(this);
    }
}
