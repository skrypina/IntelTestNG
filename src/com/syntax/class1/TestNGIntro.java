package com.syntax.class1;


import org.testng.annotations.Test;

public class TestNGIntro {
    @Test(groups = "smoke")
    public void hello(){
        System.out.println("Hello");
    }

    @Test(groups = "smoke")
    public void sayBye(){
        System.out.println("Bye");
    }

    @Test(groups = "smoke")
    public void anotherMethod(){
        System.out.println("How are you today?");
    }
}