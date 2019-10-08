package assign3.parser ;

import assign3.visitor.* ;

public class CompilationUnit extends Node {

    //Node ast ;
    //public AssignmentNode assign ;
    public BlockStatementNode blocks;
    public CompilationUnit () {

    }

   // public CompilationUnit (AssignmentNode assign) {

     //   this.assign = assign ;
   // }

    public CompilationUnit (BlockStatementNode blocks) {

        this.blocks = blocks ;
    }
    public void accept(ASTVisitor v) {

        v.visit(this);
    }
}
