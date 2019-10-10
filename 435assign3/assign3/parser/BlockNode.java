package assign3.parser ;

import assign3.visitor.* ;
import java.util.*;

public class BlockNode extends Node {

    //Node ast ;
    //public AssignmentNode assign ;
    //Something like
   
    public List<DeclarationNode> decls ;
    public List<StatementNode> stmts ;

  // public StatementNode[] stmts ;

    public BlockNode () {
        
    }

 

    public void accept(ASTVisitor v) {

        v.visit(this);
    }
}
