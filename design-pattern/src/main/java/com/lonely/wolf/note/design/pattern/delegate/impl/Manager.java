package com.lonely.wolf.note.design.pattern.delegate.impl;

import com.lonely.wolf.note.design.pattern.delegate.IEmployee;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/3/8
 * @since jdk1.8
 */
public class Manager implements IEmployee {
    private Map<String,IEmployee> workTargetMap = new HashMap<>();

    public Manager() {
        workTargetMap.put("部署项目",new EmployeeA());
        workTargetMap.put("修复BUG",new EmployeeB());
    }

    @Override
    public void work(String taskCommand) {
        IEmployee employee = workTargetMap.get(taskCommand);
        if(null == employee){
            System.out.println("未找到可以执行任务的员工");
            return;
        }
        employee.work(taskCommand);
    }
}
