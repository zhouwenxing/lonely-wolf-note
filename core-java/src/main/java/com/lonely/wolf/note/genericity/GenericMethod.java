package com.lonely.wolf.note.genericity;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/8
 * @since jdk1.8
 */
public class GenericMethod {
    public <T> T test(T...arg){
        System.out.println("generic method");
        return null;
    }

    public static void main(String[] args) {
        GenericMethod genericMethod = new GenericMethod();
        genericMethod.<String>test("1");
    }
}
