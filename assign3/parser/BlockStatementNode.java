package assign3.parser ;

import assign3.visitor.* ;

public class BlockStatementNode extends Node {

    public BlockStatementNode  type  ;


    public BlockStatementNode () {
        
    }
    public BlockStatementNode (TypeNode type, LiteralNode id) {

        this.type  = type  ;
        this.id = id ;
    }

    public void accept(ASTVisitor v) {

        v.visit(this);
    }
}
