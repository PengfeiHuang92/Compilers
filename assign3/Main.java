package assign3 ;

import assign3.lexer.* ;
import assign3.parser.* ;
    
public class Main {

    public static void main (String[] args) {

        Lexer lexer = new Lexer() ;
        Parser parser = new Parser(lexer) ;
        // PrettyPrinter pretty = new PrettyPrinter(parser) ;

    }
}
