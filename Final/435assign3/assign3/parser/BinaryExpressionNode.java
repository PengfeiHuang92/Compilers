package assign3.parser ;

import assign3.visitor.* ;

public class BinaryExpressionNode extends Node {

    public AdditionNode addNode;
    public SubtractionNode subNode;
    public MultiplicationNode mulNode;
    public DivisionNode divNode;
    public ModulousNode modNode;
    public LiteralNode litNode;

    public BinaryExpressionNode () {

    }

    public void accept(ASTVisitor v) {

        v.visit(this);
    }
}
