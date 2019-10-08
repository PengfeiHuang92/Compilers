package assign3.parser ;

import assign3.visitor.* ;
import assign3.lexer.* ;

import java.io.* ;

public class Parser extends ASTVisitor {

    public CompilationUnit cu = null ;
    public Lexer lexer        = null ;       

    public Parser (Lexer lexer) { 

        this.lexer = lexer ;
        cu = new CompilationUnit() ;
        visit(cu) ;
    }
    
    public Parser () {

        cu = new CompilationUnit() ;
        visit(cu) ;
    }
    void move(){
        try{
            look = lexer.scan();
        } catch(IOException ex){
            System.err.println(ex);
        }
    }
    void match(int t) throws IOException {
      if( look.tag == t ) move();
      else error("syntax error");
   }

    public void visit (CompilationUnit n) {
     
        n.blocks = new BlockStatementNode() ;
        n.blocks.accept(this) ;
    }
	
    public void visit (BlockStatementNode n){
        match("{");
        System.out.println("look" + look);
        
        List<DeclarStatementNode> list = new 
        while(look.tag == Tag.BASIC){
            DeclarStatementNode decl = BEW DeclarStatementNode();
            decl.accept(this));
            list.add(decl);
        }
        match("}");
    }
    public void visit (DeclarStatementNode n){
        n.type = new TypeNode();
        match(Tag.BASIC);
        n.type.accept(this);
        Token tok = look;
        n.id = new IdentifierNode(Word w);
        match(Tag.ID);
        n.id.accept(this);
        match(";");
        
    }
    public void visit (AssignmentNode n) {

        n.left = new LiteralNode() ;
        n.left.accept(this) ;
        move(); // this should read operatiors and do nothing
        n.right = new AdditionNode() ;
        n.right.accept(this) ;
    }

    public void visit (AdditionNode n) {

        n.left = new LiteralNode() ;
        n.left.accept(this) ;
        
        n.right = new LiteralNode() ;
        n.right.accept(this) ;
    }

    public void visit (LiteralNode n) {

        // What should visit(LiteralNode) do? 
        // One part of the next assignment.
    }

    public Token readLexem () {

        Token t = null ;

        try {
            
            t = lexer.scan() ;
        }
        catch (IOException e) {

            System.out.println("IO Error") ;
        }

        return t ;
    }
    
    

}
