package ru.itmo.lab5.command;

import java.util.Deque;
import java.util.Scanner;

/**
 * Класс команды 'history'.
 */
public class History implements Executable {

    private final Deque<String> commandHistory;

    public History(Deque<String> commandHistory) {
        this.commandHistory = commandHistory;
    }

    @Override
    public void execute(String command, Scanner scanner) {
        history();
    }

    public void history() {
        for (String command : commandHistory) {
            System.out.println(command);
        }
    }
}
