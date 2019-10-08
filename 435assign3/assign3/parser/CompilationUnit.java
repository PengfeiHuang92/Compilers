package assign3.parser ;

import assign3.visitor.* ;

public class CompilationUnit extends Node {

    //Node ast ;
    public BlockNode block ;

    public CompilationUnit () {

    }

    public CompilationUnit (BlockNode assign) {

        this.block = assign ;
    }

    public void accept(ASTVisitor v) {

        v.visit(this);
    }
}
