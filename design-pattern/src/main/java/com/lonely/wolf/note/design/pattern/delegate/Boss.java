package com.lonely.wolf.note.design.pattern.delegate;

import com.lonely.wolf.note.design.pattern.delegate.impl.Manager;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/3/8
 * @since jdk1.8
 */
public class Boss {

    public void startWork(String taskCommand, Manager manager){
        manager.work(taskCommand);
    }
}
