package assign3.parser ;

import assign3.visitor.* ;

public class DeclarStatementNode extends Node {

    public TypeNode  type  ;
    public IdentifierNode id ;

    public DeclarStatementNode () {
        
    }
    public DeclarStatementNode (TypeNode type, IdentifierNode id) {

        this.type  = type  ;
        this.id = id ;
    }

    public void accept(ASTVisitor v) {

        v.visit(this);
    }
}
