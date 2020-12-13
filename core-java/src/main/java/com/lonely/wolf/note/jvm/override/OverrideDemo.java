package com.lonely.wolf.note.jvm.override;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/8/13
 * @since jdk1.8
 */
public class OverrideDemo {
    static class Human {
        public void hello(Human human) {
            System.out.println("Hi,Human");
        }
    }

    static class Man extends Human {
        @Override
        public void hello(Human human) {
            System.out.println("Hi,Man");
        }
    }

    static class WoMan extends Human {
        @Override
        public void hello(Human human) {
            System.out.println("Hi,Women");
        }
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new WoMan();

        man.hello(man);
        man.hello(woman);
        woman.hello(woman);
        woman.hello(man);
    }
}
