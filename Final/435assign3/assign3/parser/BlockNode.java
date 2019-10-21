package assign3.parser ;

import assign3.visitor.* ;
import java.util.* ;

public class BlockNode extends Node {
   
    public List<DeclarationNode> decls ;
    public List<StatementNode> stmts ;

    public BlockNode () {
        
    }

    public void accept(ASTVisitor v) {

        v.visit(this);
    }
}
