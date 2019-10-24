package assign3.parser ;

import assign3.visitor.* ;
import assign3.lexer.* ;
import assign3.pretty.* ;

import java.io.* ;
import java.util.* ;

public class Parser extends ASTVisitor {

    public CompilationUnit cu = null ;
    public Lexer lexer        = null ;
    
    private Token look = null ;
    private PrettyPrinter p = new PrettyPrinter() ;

    public Parser (Lexer lexer) { 

        this.lexer = lexer ;
        cu = new CompilationUnit() ;
        move();
        visit(cu) ;
    }
    
    public Parser () {

        cu = new CompilationUnit() ;
        move();

        visit(cu) ;
    }
    
    void error(String s) { 
        throw new Error("near line "+lexer.line+": "+s); 
    }

   void match(int t) {
      if( look.tag == t ) {
        move();
    }
      else 
        error("syntax");
    }


    public void visit (CompilationUnit n) {

        //n.assign = new AssignmentNode() ;
        n.block = new BlockNode();
        n.block.accept(this) ;
    }
    
    public void visit (BlockNode n){
 
        match('{') ; 
        List<DeclarationNode> list = new LinkedList<DeclarationNode>();
        while(look.tag == Tag.BASIC) {
            DeclarationNode decl = new DeclarationNode();
            decl.accept(this);
            list.add(decl);
        }
        
        n.decls = list;
        
        List<StatementNode> stmts = new LinkedList<StatementNode>();
        while(look.tag == Tag.ID){
            StatementNode stmt = new StatementNode();
            stmt.accept(this);
            stmts.add(stmt);
        }
        
        n.stmts = stmts ;
    }
    
    public void visit(DeclarationNode n){
        n.type = new TypeNode((Type) look);
        match(Tag.BASIC);
        n.type.accept(this);
        
        n.id = new IdentifierNode((Word) look);
        match(Tag.ID);
        n.id.accept(this);
        match(';');
    }
    
    public void visit(TypeNode n){
        
    }
    
    public void visit(IdentifierNode n){
    
    }
    
    public void visit(StatementNode n){
        n.assign = new AssignmentNode();
        match(Tag.ID);
        n.assign.accept(this);
        match(';');
        
    }
    
   
    public void visit (AssignmentNode n) {
        n.expNode = new ExpressionNode();
        n.expNode.accept(this);
        
    }
    public void visit (ExpressionNode n){
    
        n.left = new LiteralNode() ;
        n.left.accept(this) ;
        
        move();
        n.right = new BinaryExpressionNode() ;
        n.right.accept(this) ;
       // move();
    }
    public void visit (AdditionNode n) {
        n.left = new LiteralNode() ;
        n.left.accept(this) ;
        
        move();
        
        n.right = new LiteralNode() ;
        n.right.accept(this) ;
    }
    
    public void visit (SubtractionNode n) {
        n.left = new LiteralNode() ;
        n.left.accept(this) ;
        
        move();
        
        n.right = new LiteralNode() ;
        n.right.accept(this) ;
    }
    
    public void visit (MultiplicationNode n) {
        n.left = new LiteralNode() ;
        n.left.accept(this) ;
        
        move();
        
        n.right = new LiteralNode() ;
        n.right.accept(this) ;
    }
    
    public void visit (DivisionNode n) {
        n.left = new LiteralNode() ;
        n.left.accept(this) ;
        
        move();
        
        n.right = new LiteralNode() ;
        n.right.accept(this) ;
    }
    
    public void visit (ModulousNode n) {
       
        n.left = new LiteralNode() ;
       
        n.left.accept(this) ;
        
        move();
        
        n.right = new LiteralNode() ;
        n.right.accept(this) ;
      
    }
    
    public void visit (BinaryExpressionNode n) {
        
        Token t = look ;
        move();
       
        if(look.toString().equals(";")){
        
           n.litNode = new LiteralNode(look.toString());
           n.litNode.accept(this);
        }else{
        
        
        if(look.toString().equals("+")){
            look = t ;
            n.addNode = new AdditionNode() ;
            n.addNode.accept(this) ;
          
        }
        else if(look.toString().equals("-")){
            look = t ;
            n.subNode = new SubtractionNode() ;
            n.subNode.accept(this) ;
           
        }
        else if(look.toString().equals("*")){
            look = t ;
            n.mulNode = new MultiplicationNode() ;
            n.mulNode.accept(this) ;
           
        }
        else if(look.toString().equals("/")){
            look = t ;
            n.divNode = new DivisionNode() ;
            n.divNode.accept(this) ;
            
        }
        else if(look.toString().equals("%")){
            look = t ;
            n.modNode = new ModulousNode() ;
            n.modNode.accept(this) ;
            
        }
          move();
        }
     
    }

    public void visit (LiteralNode n) {

        // What should visit(LiteralNode) do? 
        // One part of the next assignment.
        
        
    }

    public Token move () {

        try {
            look = lexer.scan() ;
            //System.out.print(look + " ");
            p.prettyPrint(look);
        }
        catch (IOException e) {

            System.out.println("IO Error") ;
        }

        return look ;
    }

}
