package com.lonely.wolf.note.design.pattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/3
 * @since jdk1.8
 */
public class XshellInvoker {
    private List<ICommand> commandList = new ArrayList<>();

    public XshellInvoker(List<ICommand> commandList) {
        this.commandList = commandList;
    }

    /**
     * 执行指定命令
     * @param command
     */
    public void execute(ICommand command){
        command.execute();
    }

    /**
     * 执行命令宏
     */
    public void executeCdAndLs(){
        for (ICommand command : commandList){
            if (command instanceof LsCommand || command instanceof CdCommand){
                command.execute();
            }
        }
    }

    public void executeAll(){
        for (ICommand command : commandList){
            command.execute();
        }
    }
}
