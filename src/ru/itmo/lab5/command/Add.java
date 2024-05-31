package ru.itmo.lab5.command;

import static ru.itmo.lab5.util.ConsoleUtil.readLabWorkFromConsole;

import ru.itmo.lab5.entity.LabWork;

import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * Класс команды 'add'.
 */
public class Add implements Executable {

    private final LinkedHashSet<LabWork> labWorks;

    public Add(LinkedHashSet<LabWork> labWorks) {
        this.labWorks = labWorks;
    }

    @Override
    public void execute(String command, Scanner scanner) {
        LabWork newLabWork = readLabWorkFromConsole(null, scanner);
        add(newLabWork);
        System.out.println("Новый элемент успешно добавлен.");
    }

    private void add(LabWork labWork) {
        labWorks.add(labWork);
    }
}
