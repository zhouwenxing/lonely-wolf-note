package com.lonely.wolf.note.design.pattern.proxy.dynamicProxy.jdkProxy;

import com.lonely.wolf.note.design.pattern.proxy.Travel;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/7/11
 * @since jdk1.8
 */
public class TestJdkProxy {
    public static void main(String[] args){
        Travel travel = (Travel) new JdkTravelAgency().getInstance(new JdkTravelPerson());
        travel.buyTrainTickey();

//        try{
//            byte[] bytes = ProxyGenerator.generateProxyClass("$proxy0",new Class[]{Travel.class});
//            FileOutputStream out = new FileOutputStream("G:\\$proxy0.class");
//            out.write(bytes);
//            out.flush();
//            out.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }

    }
}
