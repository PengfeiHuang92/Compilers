package assign3.parser ;

import assign3.visitor.* ;
import assign3.lexer.* ;

import java.io.* ;
import java.util.* ;

public class Parser extends ASTVisitor {

    public CompilationUnit cu = null ;
    public Lexer lexer        = null ;
    
    private Token look = null ;

    public Parser (Lexer lexer) { 

        this.lexer = lexer ;
        cu = new CompilationUnit() ;
        readLexem();
        visit(cu) ;
    }
    
    public Parser () {

        cu = new CompilationUnit() ;
        readLexem();

        visit(cu) ;
    }
    
    ////USEFUL//////
    
    void error(String s) { 
        throw new Error("near line "+lexer.line+": "+s); 
    }

   void match(int t) {
      if( look.tag == t ) readLexem();
      else error("syntax error");
   }
    ////USEFUL//////


    public void visit (CompilationUnit n) {

        //n.assign = new AssignmentNode() ;
        n.block = new BlockNode();
        n.block.accept(this) ;
    }
    
    public void visit (BlockNode n){

     
        System.out.println("look: "+look);  
        match('{') ;
        System.out.println("{ got matched"); 
        
        List<DeclarationNode> list = new LinkedList<DeclarationNode>();
        System.out.println("Look: "+look); 
        System.out.println("Look's tag: "+look.tag);
        System.out.println("BASIC Tag: "+Tag.BASIC);
        while(look.tag == Tag.BASIC) {
            System.out.println("YOOOO");
            DeclarationNode decl = new DeclarationNode();
            decl.accept(this);
            list.add(decl);

        }
        
       // System.out.println("out of while: ");
        //for(int i=0; i<n.decls.length; i++)
          //    n.decls[i].accept(this);
        match('}') ;
    }
    
    public void visit(DeclarationNode n){
        n.type = new TypeNode();
        match(Tag.BASIC);
        n.type.accept(this);
        
        Token t = look;
        
        n.id = new IdentifierNode((Word) t);
        match(Tag.ID);
        n.id.accept(this);
        
        match(';');
    }
    
    public void visit(TypeNode n){
        
    }
    
    public void visit(IdentifierNode n){
    
    }
    

    public void visit (AssignmentNode n) {

        n.left = new LiteralNode() ;
        n.left.accept(this) ;
        
        readLexem(); //reads =
        
        n.right = new AdditionNode() ;
      //  n.right = new ExpressionNode() ;
        n.right.accept(this) ;
    }

    public void visit (AdditionNode n) {

        n.left = new LiteralNode() ;
        n.left.accept(this) ;
        
        readLexem();//reads +
        
        n.right = new LiteralNode() ;
        n.right.accept(this) ;
    }

    public void visit (LiteralNode n) {

        // What should visit(LiteralNode) do? 
        // One part of the next assignment.
        //?????????
        
        n.literal = readLexem().toString();
        n.printNode();
        
    }

    public Token readLexem () {

        try {
            
            look = lexer.scan() ;
        }
        catch (IOException e) {

            System.out.println("IO Error") ;
        }

        return look ;
    }

}
