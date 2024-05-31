package ru.itmo.lab5.command;

import ru.itmo.lab5.Application;
import ru.itmo.lab5.util.CommandExecutor;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Класс команды 'execute_script'.
 */
public class ExecuteScript implements Executable {

    private final Application application;

    private final CommandExecutor commandExecutor;

    public ExecuteScript(Application application, CommandExecutor commandExecutor) {
        this.application = application;
        this.commandExecutor = commandExecutor;
    }

    @Override
    public void execute(String command, Scanner scanner) {
        String[] commandParts = command.split(" ");
        if (commandParts.length < 2) {
            System.out.println("Не указано имя файла скрипта.");
        }
        executeScript(commandParts[1]);
    }

    private void executeScript(String scriptFileName) {
        try (FileInputStream inputStream = new FileInputStream(scriptFileName);
             Scanner scanner = new Scanner(inputStream)) {
            while (scanner.hasNextLine() && !application.isExit()) {
                String command = scanner.nextLine();
                commandExecutor.executeCommand(command, scanner);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла скрипта: " + e.getMessage());
        }
    }
}
