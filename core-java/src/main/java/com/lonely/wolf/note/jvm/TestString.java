package com.lonely.wolf.note.jvm;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/8/5
 * @since jdk1.8
 */
public class TestString {
    public static void main(String[] args) {
//        String str1 = new StringBuilder("lonelyWolf wolf").append("11").toString();
//        String str2 = new String("lonelyWolf wolf") + new String("22");
//        String str1 = new String("lonelyWolf wolf");//
//        String str2 = "lonelyWolf wolf";//
//        System.out.println(str1==str1.intern());
//        System.out.println(str2==str2.intern());
//        System.out.println(str2==str1.intern());
//        String str2 = new String("str1231231231231");
//        System.out.println(str2==str2.intern());
//
//        String str1 = new StringBuilder("lonelyWolf wolf").toString();
//        System.out.println(str1==str1.intern());

//        String str3 = new String("str");//strstr
        String a = "";
        String str3 = "str" + a + "str";
        String str = "strstr";
        System.out.println(str3==str3.intern());
        System.out.println(str==str3.intern());
    }
}
