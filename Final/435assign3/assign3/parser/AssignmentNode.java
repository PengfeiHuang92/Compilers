package assign3.parser ;

import assign3.visitor.* ;

public class AssignmentNode extends Node {

    public ExpressionNode expNode;

    public AssignmentNode () {
        
    }
    public AssignmentNode ( ExpressionNode expNode) {
                                            //ExpressionNode

        this.expNode  = expNode  ;
    
    }

    public void accept(ASTVisitor v) {

        v.visit(this);
    }
}
