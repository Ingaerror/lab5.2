package ru.itmo.lab5.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ScriptGenerator {
    public static void main(String[] args) {
        String scriptFile = "script.txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(scriptFile))) {
            // Добавление нового элемента LabWork
            writer.println("add");
            writer.println("LabWork6");
            writer.println("50");
            writer.println("150.0");
            writer.println("15");
            writer.println("55.0");
            writer.println("NORMAL");
            writer.println("Discipline6");
            writer.println("1500");

            // Добавление ещё одного нового элемента LabWork
            writer.println("add");
            writer.println("LabWork7");
            writer.println("60");
            writer.println("160.0");
            writer.println("25");
            writer.println("65.0");
            writer.println("VERY_HARD");
            writer.println("Discipline7");
            writer.println("2500");

            // Обновление существующего элемента LabWork с id 1
            writer.println("update 1");
            writer.println("LabWork1Updated");
            writer.println("110");
            writer.println("210.0");
            writer.println("12");
            writer.println("52.0");
            writer.println("NORMAL");
            writer.println("Discipline1Updated");
            writer.println("1100");

            // Удаление элемента LabWork по id
            writer.println("remove_by_id 3");

            // Очистка всех элементов из коллекции
            writer.println("clear");

            // Добавление ещё одного нового элемента LabWork
            writer.println("add");
            writer.println("LabWork8");
            writer.println("70");
            writer.println("170.0");
            writer.println("35");
            writer.println("75.0");
            writer.println("INSANE");
            writer.println("Discipline8");
            writer.println("3500");

            // Сохранение текущего состояния коллекции в файл
            writer.println("save");

            // Завершение программы
            writer.println("exit");
        } catch (IOException e) {
            System.out.println("Ошибка при создании скрипт-файла: " + e.getMessage());
        }
    }
}