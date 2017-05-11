/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Collection;

/**
 *
 * @author vm-sv04
 */
public class Method {

    private String name;
    private Collection<Instruction> instructions;

//    public Method(String name, Collection<Instruction> instructions) {
    public Method(String name) {
        this.name = name;
//        this.instructions = instructions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Method method = (Method) o;

        if (name != null ? !name.equals(method.name) : method.name != null) {
            return false;
        }
        return instructions != null ? instructions.equals(method.instructions) : method.instructions == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (instructions != null ? instructions.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Method{"
                + "\nname='" + name  + '\'' 
                + '}';
//                + "\nname='" + name + '\''
//                + "\ninstructions=" + instructions
//                + '}';
    }

}
