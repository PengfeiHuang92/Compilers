package assign3.parser ;

import assign3.visitor.* ;

public class BlockNode extends Node {

    //Node ast ;
    //public AssignmentNode assign ;
    //Something like
   
    public DeclarationNode[] decls ;
  // public StatementNode[] stmts ;

    public BlockNode () {
        
    }

 

    public void accept(ASTVisitor v) {

        v.visit(this);
    }
}
