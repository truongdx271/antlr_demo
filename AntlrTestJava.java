/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antlrtestjava;

import com.google.gson.Gson;
import domain.Class;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import javalanguage.JavaLexer;
import javalanguage.JavaParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import parser.ExtractInterfaceListerner;
import parser.ListenerOrientedParser;

/**
 *
 * @author vm-sv04
 */
public class AntlrTestJava {

    /**
     * @param args the command line arguments
     */
    
    private static final String someLangSourceCode =
            "class SomeClass {\n"+
                    "    fun1 {\n"+
                    "        instruction11\n"+
                    "        instruction12\n"+
                    "    }\n"+
                    "    fun2 {\n"+
                    "        instruction21\n"+
                    "        instruction22\n"+
                    "    }\n"+
                    "}";
    
    public static void main(String[] args) throws IOException {
//        File file = new File("C:\\Users\\hieuhx1\\Documents\\NetBeansProjects\\AntlrTestJava\\src\\parser\\ListenerOrientedParser.java");
//        String code = readFile(file, Charset.forName("UTF-8"));
//        final Class result = new ListenerOrientedParser().parse(code);
//        Gson gson = new Gson();
//        final String json = gson.toJson(result);
//        System.out.printf("code below: %n '%s' %n has been parsed to object: %n '%s'%n",code,json);
        
        String pathFile = "C:\\Users\\hieuhx1\\Documents\\NetBeansProjects\\QuanLySach2\\src\\java\\dao\\BookDAO.java";
        File file = new File(pathFile);
        String code = readFile(file, Charset.forName("UTF-8"));
        
        JavaLexer lexer = new JavaLexer(new ANTLRInputStream(code));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JavaParser parser = new JavaParser(tokens);
                
        ParseTree tree = parser.compilationUnit();
        ParseTreeWalker walker = new ParseTreeWalker();
        ExtractInterfaceListerner listener = new ExtractInterfaceListerner(parser);
        
        walker.walk(listener, tree);
        
    }
    
    private static String readFile(File file, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(file.toPath());
        return new String(encoded, encoding);
    }
    
}
