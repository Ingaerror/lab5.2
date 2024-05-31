package ru.itmo.lab5.command;

import static ru.itmo.lab5.util.ConsoleUtil.readLabWorkFromConsole;

import ru.itmo.lab5.entity.LabWork;

import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * Класс команды 'remove_greater'.
 */
public class RemoveGreater implements Executable {

    private final LinkedHashSet<LabWork> labWorks;

    public RemoveGreater(LinkedHashSet<LabWork> labWorks) {
        this.labWorks = labWorks;
    }

    @Override
    public void execute(String command, Scanner scanner) {
        LabWork labWorkGreater = readLabWorkFromConsole(null, scanner);
        removeGreater(labWorkGreater);
    }

    private void removeGreater(LabWork labWork) {
        labWorks.removeIf(existingLabWork -> existingLabWork.compareTo(labWork) > 0);
    }
}
