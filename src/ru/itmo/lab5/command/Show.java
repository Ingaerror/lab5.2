package ru.itmo.lab5.command;

import ru.itmo.lab5.entity.LabWork;

import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * Класс команды 'show'.
 */
public class Show implements Executable {

    private final LinkedHashSet<LabWork> labWorks;

    public Show(LinkedHashSet<LabWork> labWorks) {
        this.labWorks = labWorks;
    }

    @Override
    public void execute(String command, Scanner scanner) {
        show();
    }

    private void show() {
        for (LabWork labWork : labWorks) {
            System.out.println(labWork);
        }
    }
}
