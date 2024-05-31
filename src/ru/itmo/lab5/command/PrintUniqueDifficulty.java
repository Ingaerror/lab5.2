package ru.itmo.lab5.command;

import ru.itmo.lab5.entity.LabWork;

import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * Класс команды 'print_unique_difficulty'.
 */
public class PrintUniqueDifficulty implements Executable {

    private final LinkedHashSet<LabWork> labWorks;

    public PrintUniqueDifficulty(LinkedHashSet<LabWork> labWorks) {
        this.labWorks = labWorks;
    }

    @Override
    public void execute(String command, Scanner scanner) {
        System.out.println("Уникальные значения сложности:");
        printUniqueDifficulty();
    }

    private void printUniqueDifficulty() {
        labWorks.stream()
                .map(LabWork::getDifficulty)
                .distinct()
                .forEach(System.out::println);
    }

}
