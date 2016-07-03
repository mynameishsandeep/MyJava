package com.sample.basics;

class SuperClass{
    static void method(){
           System.out.println("superClass method");
    }
}
 
class SubClass extends SuperClass{
    public static void method(){
           System.out.println("SubClass method");
    }
}

public class StaticInheritenceTest {
    public static void main(String[] args) {
           SuperClass obj=new SubClass();
           obj.method();
    }
}
