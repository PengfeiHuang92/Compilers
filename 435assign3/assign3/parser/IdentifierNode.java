package assign3.parser ;

import assign3.lexer.* ;
import assign3.visitor.* ;

public class IdentifierNode extends Node {

    public String id;
    
    public IdentifierNode(){
    
    }
    
    public IdentifierNode(Word word){
        this.id = word.lexeme;
    }
    public void accept(ASTVisitor v) {

        v.visit(this);
    }
    
    void printNode () {

        System.out.println(id) ;
    }
}
