package ru.itmo.lab5.util;

import ru.itmo.lab5.entity.Coordinates;
import ru.itmo.lab5.entity.Difficulty;
import ru.itmo.lab5.entity.Discipline;
import ru.itmo.lab5.entity.LabWork;

import java.util.Scanner;

/**
 * Вспомогательный класс для чтения из консоли/файла.
 */
public class ConsoleUtil {

    public static LabWork readLabWorkFromConsole(LabWork existingLabWork, Scanner scanner) {

        String name = null;
        while (name == null || name.isEmpty()) {
            System.out.print("Введите имя: ");
            name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Имя не может быть пустым. Попробуйте еще раз.");
            }
        }

        Coordinates coordinates = null;
        while (coordinates == null) {
            try {
                System.out.print("Введите координату x (максимальное значение 337): ");
                long x = Long.parseLong(scanner.nextLine().trim());
                System.out.print("Введите координату y: ");
                float y = Float.parseFloat(scanner.nextLine().trim());
                coordinates = new Coordinates(x, y);
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод. Попробуйте еще раз.");
            }
        }

        int minimalPoint = -1;
        while (minimalPoint <= 0) {
            try {
                System.out.print("Введите минимальный балл (больше 0): ");
                minimalPoint = Integer.parseInt(scanner.nextLine().trim());
                if (minimalPoint <= 0) {
                    System.out.println("Минимальный балл должен быть больше 0. Попробуйте еще раз.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод. Попробуйте еще раз.");
            }
        }

        Double averagePoint = null;
        while (averagePoint == null || averagePoint <= 0) {
            try {
                System.out.print("Введите средний балл (больше 0): ");
                averagePoint = Double.parseDouble(scanner.nextLine().trim());
                if (averagePoint <= 0) {
                    System.out.println("Средний балл должен быть больше 0. Попробуйте еще раз.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод. Попробуйте еще раз.");
            }
        }

        Difficulty difficulty = null;
        while (difficulty == null) {
            System.out.print("Введите сложность (VERY_EASY, NORMAL, VERY_HARD, INSANE, HOPELESS): ");
            String difficultyInput = scanner.nextLine().trim();
            if (difficultyInput.isBlank()) {
                // Значение может быть null
                break;
            }
            try {
                difficulty = Difficulty.valueOf(difficultyInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Неверная сложность. Попробуйте еще раз.");
            }
        }

        Discipline discipline = null;
        while (discipline == null) {
            try {
                System.out.print("Введите название дисциплины: ");
                String disciplineName = scanner.nextLine().trim();
                if (disciplineName.isEmpty()) {
                    System.out.println("Название дисциплины не может быть пустым. Попробуйте еще раз.");
                    continue;
                }
                System.out.print("Введите количество часов практики: ");
                Long practiceHours = Long.parseLong(scanner.nextLine().trim());
                discipline = new Discipline(disciplineName, practiceHours);
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод. Попробуйте еще раз.");
            }
        }

        if (existingLabWork != null) {
            return new LabWork(existingLabWork.getId(), name, coordinates, existingLabWork.getCreationDate(),
                    minimalPoint, averagePoint, difficulty, discipline);
        }

        return new LabWork(name, coordinates, minimalPoint, averagePoint, difficulty, discipline);
    }

}
