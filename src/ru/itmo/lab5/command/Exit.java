package ru.itmo.lab5.command;

import ru.itmo.lab5.Application;

import java.util.Scanner;

/**
 * Класс команды 'exit'.
 */
public class Exit implements Executable {

    private final Application application;

    public Exit(Application application) {
        this.application = application;
    }

    @Override
    public void execute(String command, Scanner scanner) {
        System.out.println("Программа завершена.");
        this.application.exit();
    }
}
