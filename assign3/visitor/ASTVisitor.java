package assign3.visitor ;

import assign3.parser.* ;

public class ASTVisitor {

    public void visit (CompilationUnit n) {

        n.block.accept(this) ;
    }
    
    public void visit (BlockNode n) {
       // n.assign.accept(this)
        for(int i=0; i<n.decls.size(); i++)
            n.decls.get(i).accept(this);
            
    }
    
    public void visit(DeclarationNode n){
        n.type.accept(this);
        n.id.accept(this);
    }
    
    public void visit(TypeNode n){
        
    }
    
    public void visit(IdentifierNode n){
    
    }
    
    public void visit(StatementNode n){
        n.assign.accept(this) ;
    }

    public void visit (AssignmentNode n) {
        n.expNode.accept(this);
       
    }
    public void visit (ExpressionNode n){
         n.left.accept(this) ;
         n.right.accept(this) ;
    }

    public void visit (AdditionNode n) {

        n.left.accept(this) ;
        n.right.accept(this) ;
    }
    
    public void visit (SubtractionNode n) {

        n.left.accept(this) ;
        n.right.accept(this) ;
    }
    
    public void visit (MultiplicationNode n) {

        n.left.accept(this) ;
        n.right.accept(this) ;
    }
    
    public void visit (DivisionNode n) {

        n.left.accept(this) ;
        n.right.accept(this) ;
    }
    
    public void visit (ModulousNode n) {

        n.left.accept(this) ;
        n.right.accept(this) ;
    }
    
    public void visit (BinaryExpressionNode n){
        n.addNode.accept(this) ;
        n.subNode.accept(this) ;
        n.mulNode.accept(this) ;
        n.divNode.accept(this) ;
        n.modNode.accept(this) ;
    }

    public void visit (LiteralNode n) {
        n.accept(this); //?
    }
}
