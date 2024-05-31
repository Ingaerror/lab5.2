package ru.itmo.lab5.command;

import ru.itmo.lab5.entity.LabWork;

import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * Класс команды 'clear'.
 */
public class Clear implements Executable {

    private final LinkedHashSet<LabWork> labWorks;

    public Clear(LinkedHashSet<LabWork> labWorks) {
        this.labWorks = labWorks;
    }

    @Override
    public void execute(String command, Scanner scanner) {
        clear();
        System.out.println("Коллекция успешно очищена.");
    }

    private void clear() {
        labWorks.clear();
    }
}
