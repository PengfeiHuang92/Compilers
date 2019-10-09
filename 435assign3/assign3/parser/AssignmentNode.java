package assign3.parser ;

import assign3.visitor.* ;

public class AssignmentNode extends Node {

    public LiteralNode  left  ;
    public ExpressionNode right ;
    //ExpressionNode right;

    public AssignmentNode () {
        
    }
    public AssignmentNode (LiteralNode left, ExpressionNode right) {

        this.left  = left  ;
        this.right = right ;
    }

    public void accept(ASTVisitor v) {

        v.visit(this);
    }
}
