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
        throw new Error("near line "); 
    }

   void match(int t) {
      if( look.tag == t ) move();
      else error("syntax error");
   }
   
   void move() {
        try{
            look = lexer.scan(); 
        } catch (IOException er){
            System.out.println("Error");
            }
            }
    ////USEFUL//////


    public void visit (CompilationUnit n) {

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
           
        List<StatementNode> stmtList = new LinkedList<StatementNode>();

        while(look.tag == Tag.ID) {
            StatementNode stmt = new StatementNode();
            stmt.accept(this);
            stmtList.add(stmt);

        }
        n.stmts = stmtList;
        
        /*
        for(int i=0; i<n.decls.size(); i++)
           n.decls.get(i).printNode();
      
        for(int i=0; i<n.stmts.size(); i++)
           n.stmts.get(i).printNode();
        */
        match('}') ;
        System.out.println();
    }
    
    public void visit(DeclarationNode n){
        
        n.type = new TypeNode((Type) look);
        match(Tag.BASIC);
        n.type.accept(this);
        
        Token t = look;
        
        n.id = new IdentifierNode((Word) t);
        match(Tag.ID);
        n.id.accept(this);
        
        match(';');
        
    }
    
    public void visit(StatementNode n){
        n.assign = new AssignmentNode();
        n.assign.accept(this);
        
        match(';');
       // System.out.println();
    }
    
    public void visit(TypeNode n){
        
        
    }
    
    public void visit(IdentifierNode n){
    
    }
    

    public void visit (AssignmentNode n) {
        n.left = new LiteralNode() ;
        n.left.accept(this) ;
        
        System.out.print(look+" ");
        match('='); //reads =
        LiteralNode expLeft = new LiteralNode(look.toString());
        String operator = readLexem().toString();
        LiteralNode expRight;
        switch(operator)
        {
            case "+":
                match('+');
                expRight = new LiteralNode(look.toString());
                n.right = new AdditionNode(expLeft, expRight) ;
            /*case "-":
                match('-');
                //LiteralNode expRight = new LiteralNode(look.toString());
                n.right = new SubtractionNode(expLeft, expRight) ;*/
                
        }
        n.right.accept(this) ;
        readLexem();
    }
    
    public void visit (BinaryExpressionNode n) {
        
    }

    public void visit (AdditionNode n) {
    

        //n.left = new LiteralNode() ;
        n.left.accept(this) ;
        
       // readLexem();//reads +
        System.out.print("+ ");
       
        
       // n.right = new LiteralNode() ;
        n.right.accept(this) ;
    }
    
    public void visit (SubtractionNode n) {
    

        //n.left = new LiteralNode() ;
        n.left.accept(this) ;
        
       // readLexem();//reads +
        System.out.print("- ");
       
        
       // n.right = new LiteralNode() ;
        n.right.accept(this) ;
    }

    public void visit (LiteralNode n) {
       if(n.literal==null){
            n.literal = look.toString();
            readLexem();
        }
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
