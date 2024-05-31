package ru.itmo.lab5.command;

import ru.itmo.lab5.entity.Discipline;
import ru.itmo.lab5.entity.LabWork;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * Класс команды 'print_field_ascending_discipline'.
 */
public class PrintFieldAscendingDiscipline implements Executable{

    private final LinkedHashSet<LabWork> labWorks;

    public PrintFieldAscendingDiscipline(LinkedHashSet<LabWork> labWorks) {
        this.labWorks = labWorks;
    }

    @Override
    public void execute(String command, Scanner scanner) {
        System.out.println("Дисциплины в порядке возрастания:");
        printFieldAscendingDiscipline();
    }

    private void printFieldAscendingDiscipline() {
        labWorks.stream()
                .map(LabWork::getDiscipline)
                .sorted(Comparator.comparing(Discipline::getName))
                .forEach(System.out::println);
    }
}
