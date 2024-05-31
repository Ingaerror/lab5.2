package ru.itmo.lab5.command;

import static ru.itmo.lab5.util.ConsoleUtil.readLabWorkFromConsole;

import ru.itmo.lab5.entity.LabWork;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Scanner;

/**
 * Класс команды 'update'.
 */
public class Update implements Executable {

    private final LinkedHashSet<LabWork> labWorks;

    public Update(final LinkedHashSet<LabWork> labWorks) {
        this.labWorks = labWorks;
    }

    @Override
    public void execute(String command, Scanner scanner) {
        String[] commandParts = command.split(" ");
        if (commandParts.length < 2) {
            System.out.println("Не указан id элемента для обновления.");
            return;
        }
        try {
            int id = Integer.parseInt(commandParts[1]);
            update(id, scanner);
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат id. Попробуйте еще раз.");
        }
    }

    private void update(int id, Scanner scanner) {
        Optional<LabWork> labWorkOptional = labWorks.stream()
                .filter(labWork -> labWork.getId() == id)
                .findFirst();
        if (labWorkOptional.isPresent()) {
            LabWork existingLabWork = labWorkOptional.get();
            System.out.println("Текущие значения полей элемента: ");
            System.out.println(existingLabWork);

            System.out.println("Введите новые значения полей. Поля с автоматической генерацией будут пропущены.");
            LabWork updatedLabWork = readLabWorkFromConsole(existingLabWork, scanner);

            // Обновляем элемент в коллекции
            labWorks.remove(existingLabWork);
            labWorks.add(updatedLabWork);

            System.out.println("Элемент успешно обновлен.");
        } else {
            System.out.println("Элемент с id " + id + " не найден.");
        }
    }

}
