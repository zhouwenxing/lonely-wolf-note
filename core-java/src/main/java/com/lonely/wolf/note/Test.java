package com.lonely.wolf.note;

import java.util.Arrays;
import java.util.Map;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/3/2
 * @since jdk1.8
 */
public class Test {
    public static void main(String[] args) {
//        boolean s = Character.isJavaIdentifierStart('%');
////        boolean s2 = Character.isJavaIdentifierPart('(');
////        System.out.println(s);
////        System.out.println(s2);
//        List<String> list = new ArrayList<>();
//        list.e
//        BigDecimal b = new BigDecimal(1.1);
//        System.out.println(b);
//        long a = 24 * 60 * 60 * 1000 * 1000l;
//        System.out.println(a);
//        long b = 24 * 60 * 60 *  1000l;
//        System.out.println(b);
//        System.out.println(a/b);
//        System.out.println((int)(char)(byte)-1);

//        int x=1984;
//        int y=2001;
//        y^=x^=y;
//        System.out.println(x);
//        System.out.println(y);

//        char x = 'X';
//        int i=0;
//        char c = (char)0;
//        System.out.println(c);
//        System.out.println((char)i);
//        System.out.println(false ? x : 0);
//        System.out.println(false ? i : x);
//        Object x = new Object();
//        String y = "B";
//        int i=5;int j=1;
//        x=x+y;
//        y +=x;
//        System.out.println(y +=x);


//        lableName:
//        for (int m=0;m<5;m++){
//            System.out.println("m=" + m);
//            for (int i=0;i<10;i++){
//                System.out.println("i=" + i);
//                for (int j=0;j<10;j++){
//                    System.out.println("j=" + j);
//                    if(j <10){
//                        continue lableName;
//                    }
//                }
//            }
//        }

//        String letters = "ABC";
//        char[] numbers = {'1','2','3'};
//        System.out.println(letters + " easy as " + numbers);//ABC easy as [C@4554617c
//        System.out.println(letters + " easy as " + String.valueOf(numbers));//ABC easy as 123
//        System.out.println(letters + " easy as " + Arrays.toString(numbers));//ABC easy as [1, 2, 3]
//        Throwable t = new Throwable();
//        StackTraceElement[] stackTraceElementArr = t.getStackTrace();
//        for (StackTraceElement stackTraceElement : stackTraceElementArr){
//            System.out.println(stackTraceElement);
//        }
        Map<Thread,StackTraceElement[]> map = Thread.getAllStackTraces();
        for (Thread t1 : map.keySet()){
            StackTraceElement[] elements = map.get(t1);
            System.out.println(Arrays.toString(elements));
        }


        try {
            int a = 3/0;
        }catch (Exception e){
//            e.addSuppressed(e);
            System.out.println(e);
            e.getSuppressed();
        }finally {
            System.out.println(222);
        }


    }
}
