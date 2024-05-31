package ru.itmo.lab5.command;

import static ru.itmo.lab5.util.ConsoleUtil.readLabWorkFromConsole;

import ru.itmo.lab5.entity.LabWork;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Scanner;

/**
 * Класс команды 'add_if_max'.
 */
public class AddIfMax implements Executable {

    private final LinkedHashSet<LabWork> labWorks;

    public AddIfMax(LinkedHashSet<LabWork> labWorks) {
        this.labWorks = labWorks;
    }

    @Override
    public void execute(String command, Scanner scanner) {
        LabWork labWork = readLabWorkFromConsole(null, scanner);
        addIfMax(labWork);
    }

    private void addIfMax(LabWork labWork) {
        Optional<LabWork> max = labWorks.stream().max(Comparator.naturalOrder());
        if (max.isPresent() && labWork.compareTo(max.get()) > 0) {
            labWorks.add(labWork);
        }
    }
}
