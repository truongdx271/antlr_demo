/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import javalanguage.JavaBaseListener;
import javalanguage.JavaParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;


/**
 *
 * @author longnt39
 */
public class ExtractInterfaceListerner extends JavaBaseListener {
    JavaParser parser;
    
    public ExtractInterfaceListerner (JavaParser parser){
        this.parser = parser;
    }
    
    @Override
    public void enterClassDeclaration(JavaParser.ClassDeclarationContext ctx){
        System.out.println("Interface: " + ctx.Identifier());
    }
    
    @Override
    public void enterMethodDeclaration(JavaParser.MethodDeclarationContext ctx){
        TokenStream tokens = parser.getTokenStream();
        String type = "void";
        if (ctx.type() != null){
            type = tokens.getText(ctx.type().getSourceInterval());
        }
        String args = tokens.getText(ctx.formalParameters());
        System.out.println("\t" + type + " " + ctx.Identifier() + " " + args + ";");
    }
    
    @Override
    public void enterTypeDeclaration(JavaParser.TypeDeclarationContext ctx){
        ParserRuleContext parrentRule =  ctx.getParent();
        if (!parrentRule.getRuleContext().getClass().getSimpleName().equals("BlockStatementContext")){
            return;
        }
        System.out.println("Rule context: " + parrentRule.getClass().toString() + "\n");
        System.out.println(parrentRule.getRuleContext().getClass().getSimpleName());
        int childCount = ctx.getChildCount();
        for (int i = 0; i < childCount; i ++){
            ParseTree childTree = ctx.getChild(i);
            System.out.println("Tree: " + childTree.getText() + "\n");
        }
    }
    
    @Override
    public void enterLocalVariableDeclarationStatement(JavaParser.LocalVariableDeclarationStatementContext ctx){
        ParserRuleContext parrentRule =  ctx.getParent();
        //System.out.println(parrentRule.getRuleContext().getClass().getSimpleName());
        if (!parrentRule.getRuleContext().getClass().getSimpleName().equals("BlockStatementContext")){
            return;
        }
        
        System.out.println(ctx.getText());
    }
    
    @Override
    public void enterImportDeclaration(JavaParser.ImportDeclarationContext ctx){
        int childCount = ctx.getChildCount();
        System.out.println(childCount);
        System.out.println(ctx.getText());
        for (int i = 0; i < childCount; i++){
            System.out.println(ctx.getChild(i).getText());
        }
        
    }
}
