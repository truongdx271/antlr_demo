/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import domain.Class;
import domain.Instruction;
import domain.Method;
import java.util.ArrayList;
import java.util.Collection;
import javalanguage.JavaBaseListener;
import javalanguage.JavaLexer;
import javalanguage.JavaParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.NotNull;

/**
 *
 * @author vm-sv04
 */
public class JavaListenerParser implements Parser{

    @Override
    public Class parse(String code) {
        CharStream charStream = new ANTLRInputStream(code);
        JavaLexer lexer = new JavaLexer(charStream);
        TokenStream tokens = new CommonTokenStream(lexer);
        JavaParser parser = new JavaParser(tokens);

        ClassListener classListener = new ClassListener();
        parser.classDeclaration().enterRule(classListener);
        return classListener.getParsedClass();
        
    }
    
    class ClassListener extends JavaBaseListener {

        private Class parsedClass;

        @Override
        public void enterClassDeclaration(@NotNull JavaParser.ClassDeclarationContext ctx) {
            String className = ctx.getText();
            MethodListener methodListener = new MethodListener();
//            ctx.method().forEach(method -> method.enterRule(methodListener));
//            ctx.
//            Collection<Method> methods = methodListener.getMethods();
//            parsedClass = new Class(className,methods);
        }

        public Class getParsedClass() {
            return parsedClass;
        }
    }

    class MethodListener extends JavaBaseListener {

        private Collection<Method> methods;

        public MethodListener() {
            methods = new ArrayList<>();
        }

        @Override
        public void enterMethodDeclaration(@NotNull JavaParser.MethodDeclarationContext ctx) {
            String methodName = ctx.getText();
//            InstructionListener instructionListener = new InstructionListener();
//            ctx.instruction().forEach(instruction -> instruction.enterRule(instructionListener));
//            Collection<Instruction> instructions = instructionListener.getInstructions();
            methods.add(new Method(methodName));
        }

        public Collection<Method> getMethods() {
            return methods;
        }
    }

//    class InstructionListener extends JavaBaseListener {
//
//        private Collection<Instruction> instructions;
//
//        public InstructionListener() {
//            instructions = new ArrayList<>();
//        }
//
//        @Override
//        public void enterInstruction(@NotNull JavaParser.InstructionContext ctx) {
//            String instructionName = ctx.getText();
//            instructions.add(new Instruction(instructionName));
//        }
//
//        public Collection<Instruction> getInstructions() {
//            return instructions;
//        }
//    }
    
        class ParameterListener extends JavaBaseListener {

        private Collection<Instruction> parameters;

        public ParameterListener() {
            parameters = new ArrayList<>();
        }

//        @Override
//        public void enterInstruction(@NotNull JavaParser.InstructionContext ctx) {
//            String instructionName = ctx.getText();
//            instructions.add(new Instruction(instructionName));
//        }

        public Collection<Instruction> getParameters() {
            return parameters;
        }
    }
    
}
