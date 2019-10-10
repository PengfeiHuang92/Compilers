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
    
    public void visit(StatementNode n){
        n.assign.accept(this);
       // n.id.accept(this);
    }
    
    public void visit(TypeNode n){
        //n.type.accept(this);
       // System.out.println(n.type);
       n.accept(this);
    }
    
    public void visit(IdentifierNode n){
        //n.id.accept(this);
       // System.out.println(n.id);
       n.accept(this);

    }
    

    public void visit (AssignmentNode n) {

        n.left.accept(this) ;
        n.right.accept(this) ;
    }
    
    public void visit (ExpressionNode n) {

        if(n.classLiteral == null)
            n.bin.accept(this);
        else
            n.classLiteral.accept(this);
    }
    
    public void visit (BinaryExpressionNode n) {

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

    public void visit (LiteralNode n) {
        n.accept(this); //?
    }
}
