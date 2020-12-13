package com.lonely.wolf.note.design.pattern.command;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/2
 * @since jdk1.8
 */
public class LinuxSystem {

    public void cd(){
        System.out.println("已经切换到主目录");
    }

    public void ls(){
        System.out.println("已经列举出当前目录下所有文件");
    }

    public void restart(){
        System.out.println("开始重启系统");
    }

}
