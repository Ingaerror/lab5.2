package ru.itmo.lab5.command;

import ru.itmo.lab5.entity.Difficulty;
import ru.itmo.lab5.entity.LabWork;

import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * Класс команды 'remove_any_by_difficulty'.
 */
public class RemoveAnyByDifficulty implements Executable {

    private final LinkedHashSet<LabWork> labWorks;

    public RemoveAnyByDifficulty(LinkedHashSet<LabWork> labWorks) {
        this.labWorks = labWorks;
    }

    @Override
    public void execute(String command, Scanner scanner) {
        String[] commandParts = command.split(" ");
        if (commandParts.length < 2) {
            System.out.println("Не указана сложность для удаления.");
            return;
        }
        try {
            Difficulty difficulty = Difficulty.valueOf(commandParts[1]);
            removeAnyByDifficulty(difficulty);
        } catch (IllegalArgumentException e) {
            System.out.println("Неверная сложность. Попробуйте еще раз.");
        }
    }

    private void removeAnyByDifficulty(Difficulty difficulty) {
        for (LabWork labWork : labWorks) {
            if (labWork.getDifficulty() == difficulty) {
                labWorks.remove(labWork);
                break;
            }
        }
    }
}
