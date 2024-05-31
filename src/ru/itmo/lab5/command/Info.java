package ru.itmo.lab5.command;

import ru.itmo.lab5.entity.LabWork;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * Класс команды 'info'.
 */
public class Info implements Executable {

    private final LinkedHashSet<LabWork> labWorks;
    private final Date initDate;

    public Info(LinkedHashSet<LabWork> labWorks, Date initDate) {
        this.labWorks = labWorks;
        this.initDate = initDate;
    }

    @Override
    public void execute(String command, Scanner scanner) {
        info();
    }

    private void info() {
        System.out.println("Тип коллекции: " + labWorks.getClass().getName());
        System.out.println("Дата инициализации: " + initDate);
        System.out.println("Количество элементов: " + labWorks.size());
    }
}
