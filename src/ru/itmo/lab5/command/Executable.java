package ru.itmo.lab5.command;

import java.util.Scanner;

/**
 * Интерфейс команд.
 */
public interface Executable {

    void execute(String command, Scanner scanner);

}
