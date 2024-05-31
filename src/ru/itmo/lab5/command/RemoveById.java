package ru.itmo.lab5.command;

import ru.itmo.lab5.entity.LabWork;

import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * Класс команды 'remove_by_id'.
 */
public class RemoveById implements Executable {

    private final LinkedHashSet<LabWork> labWorks;

    public RemoveById(LinkedHashSet<LabWork> labWorks) {
        this.labWorks = labWorks;
    }

    @Override
    public void execute(String command, Scanner scanner) {
        String[] commandParts = command.split(" ");
        if (commandParts.length < 2) {
            System.out.println("Не указан id элемента для удаления.");
            return;
        }
        try {
            int id = Integer.parseInt(commandParts[1]);
            removeById(id);
            System.out.println("Элемент с id " + id + " успешно удален.");
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат id. Попробуйте еще раз.");
        }
    }

    private void removeById(int id) {
        labWorks.removeIf(labWork -> labWork.getId() == id);
    }
}
