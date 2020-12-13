package com.lonely.wolf.note.design.pattern.delegate.impl;

import com.lonely.wolf.note.design.pattern.delegate.IEmployee;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/3/8
 * @since jdk1.8
 */
public class EmployeeB implements IEmployee {
    @Override
    public void work(String taskCommand) {
        System.out.println("我是员工B，我正在工作:" + taskCommand);
    }
}
