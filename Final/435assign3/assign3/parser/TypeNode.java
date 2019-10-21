package assign3.parser ;

import assign3.lexer.* ;
import assign3.visitor.* ;

public class TypeNode extends Node {

   //public String string;
   public Type type;
   
   public TypeNode(){
   
   }
   
   public TypeNode(Type type) {
    //this.string = string;
    this.type = type;
    }
    
    public void accept(ASTVisitor v) {

        v.visit(this);
    }
    
    //visit
}
