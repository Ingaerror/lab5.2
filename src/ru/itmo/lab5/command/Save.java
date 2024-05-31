package ru.itmo.lab5.command;

import ru.itmo.lab5.entity.LabWork;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * Класс команды 'save'.
 */
public class Save implements Executable {

    private final LinkedHashSet<LabWork> labWorks;
    private final String fileName;

    public Save(LinkedHashSet<LabWork> labWorks, String fileName) {
        this.labWorks = labWorks;
        this.fileName = fileName;
    }

    @Override
    public void execute(String command, Scanner scanner) {
        saveToFile();
        System.out.println("Коллекция успешно сохранена в файл.");
    }

    private void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (LabWork labWork : labWorks) {
                writer.println(labWork.toCsv());
            }
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
        }
    }
}
