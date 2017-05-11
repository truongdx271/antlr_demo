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
public class Class {
//    private String name;
//    private Collection<Method> methods;
//
//    public Class(String name, Collection<Method> methods) {
//        this.name = name;
//        this.methods = methods;
//    }
//    
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Class aClass = (Class) o;
//
//        if (name != null ? !name.equals(aClass.name) : aClass.name != null) return false;
//        return methods != null ? methods.equals(aClass.methods) : aClass.methods == null;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = name != null ? name.hashCode() : 0;
//        result = 31 * result + (methods != null ? methods.hashCode() : 0);
//        return result;
//    }
//
//    @Override
//    public String toString() {
//        return "Class{" +
//                "\nname='" + name + '\'' +
//                "\nparameters=" + methods +
//                '}';
//    }

    private String name;
    private Collection<Parameter> parameters;

    public Class(String name, Collection<Parameter> parameters) {
        this.name = name;
        this.parameters = parameters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Class aClass = (Class) o;

        if (name != null ? !name.equals(aClass.name) : aClass.name != null) {
            return false;
        }
        return parameters != null ? parameters.equals(aClass.parameters) : aClass.parameters == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (parameters != null ? parameters.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Class{"
                + "\nname='" + name + '\''
                + "\nparameters=" + parameters
                + '}';
    }

}
