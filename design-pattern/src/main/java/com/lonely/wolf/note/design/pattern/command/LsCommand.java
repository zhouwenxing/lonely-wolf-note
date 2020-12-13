package com.lonely.wolf.note.design.pattern.command;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/3
 * @since jdk1.8
 */
public class LsCommand implements ICommand {
    private LinuxSystem linuxSystem;

    public LsCommand(LinuxSystem linuxSystem) {
        this.linuxSystem = linuxSystem;
    }

    @Override
    public void execute() {
        linuxSystem.ls();
    }
}
