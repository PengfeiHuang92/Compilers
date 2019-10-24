package assign3.pretty ;

import assign3.lexer.*;

public class PrettyPrinter {

    private Token look;

    public PrettyPrinter () {
        
    }
    
    public void prettyPrint(Token look){
        this.look = look;
        if(look.toString().equals("{")){
            System.out.print("{\n\n   ");
        }
        else if(look.toString().equals(";")){
            System.out.print(";\n   ");
        }
        else if(look.toString().equals("}")){
            System.out.println("\n}");
        }
        else{
            System.out.print(look + " ");
        }
    }
}
