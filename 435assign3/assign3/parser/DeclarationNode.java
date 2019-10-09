package assign3.parser ;

import assign3.visitor.* ;

public class DeclarationNode extends Node {
    public TypeNode type;
    public IdentifierNode id;
    
    public DeclarationNode () {
    
    }
    
    public DeclarationNode(TypeNode type, IdentifierNode id){
        this.type = type;
        this.id = id;
    }
    
    public void accept(ASTVisitor v) {

        v.visit(this);
    }
    
    void printNode () {

        System.out.println("TYPE: ");
        type.printNode() ;
        System.out.println("ID: ");
        id.printNode() ;
    }
}
