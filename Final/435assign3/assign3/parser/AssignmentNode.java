package assign3.parser ;

import assign3.visitor.* ;

public class AssignmentNode extends Node {

    public LiteralNode  left  ;
    public BinaryExpressionNode right ;
    //ExpressionNode right;

    public AssignmentNode () {
        
    }
    public AssignmentNode (LiteralNode left, BinaryExpressionNode right) {
                                            //ExpressionNode

        this.left  = left  ;
        this.right = right ;
    }

    public void accept(ASTVisitor v) {

        v.visit(this);
    }
}
