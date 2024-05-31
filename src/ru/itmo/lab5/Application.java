package ru.itmo.lab5;

import ru.itmo.lab5.command.Add;
import ru.itmo.lab5.command.AddIfMax;
import ru.itmo.lab5.command.Clear;
import ru.itmo.lab5.command.Executable;
import ru.itmo.lab5.command.ExecuteScript;
import ru.itmo.lab5.command.Exit;
import ru.itmo.lab5.command.Help;
import ru.itmo.lab5.command.History;
import ru.itmo.lab5.command.Info;
import ru.itmo.lab5.command.PrintFieldAscendingDiscipline;
import ru.itmo.lab5.command.PrintUniqueDifficulty;
import ru.itmo.lab5.command.RemoveAnyByDifficulty;
import ru.itmo.lab5.command.RemoveById;
import ru.itmo.lab5.command.RemoveGreater;
import ru.itmo.lab5.command.Save;
import ru.itmo.lab5.command.Show;
import ru.itmo.lab5.command.Update;
import ru.itmo.lab5.entity.LabWork;
import ru.itmo.lab5.util.CommandExecutor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Date;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 * Главный класс.
 */
public class Application {
    private final LinkedHashSet<LabWork> labWorks;
    private final String fileName;
    private final Deque<String> commandHistory;
    private final Date initDate;
    private boolean exit = false;
    private Map<String, Executable> commands = new HashMap<>();
    private final CommandExecutor commandExecutor;

    public Application(String fileName) {
        this.labWorks = new LinkedHashSet<>();
        this.fileName = fileName;
        this.commandHistory = new LinkedList<>();
        this.initDate = new Date();
        this.commandExecutor = new CommandExecutor(commands, commandHistory);
        loadFromFile();
        initCommands();
    }

    private void initCommands() {
        commands.put("add", new Add(labWorks));
        commands.put("add_if_max", new AddIfMax(labWorks));
        commands.put("clear", new Clear(labWorks));
        commands.put("execute_script", new ExecuteScript(this, commandExecutor));
        commands.put("exit", new Exit(this));
        commands.put("help", new Help());
        commands.put("history", new History(commandHistory));
        commands.put("info", new Info(labWorks, initDate));
        commands.put("print_field_ascending_discipline", new PrintFieldAscendingDiscipline(labWorks));
        commands.put("print_unique_difficulty", new PrintUniqueDifficulty(labWorks));
        commands.put("remove_any_by_difficulty", new RemoveAnyByDifficulty(labWorks));
        commands.put("remove_by_id", new RemoveById(labWorks));
        commands.put("remove_greater", new RemoveGreater(labWorks));
        commands.put("save", new Save(labWorks, fileName));
        commands.put("show", new Show(labWorks));
        commands.put("update", new Update(labWorks));
    }

    public void exit() {
        this.exit = true;
    }

    public boolean isExit() {
        return exit;
    }

    private void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                final LabWork labWork = LabWork.fromCsv(line);
                labWorks.add(labWork);
            }
        } catch (IOException | ParseException e) {
            System.err.println("Ошибка при чтении CSV-файла: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Запуск: java Application <имя_файла>");
            return;
        }

        Application app = new Application(args[0]);
        Scanner scanner = new Scanner(System.in);

        while (!app.exit) {
            System.out.print("Введите команду: ");
            String command = scanner.nextLine().trim();
            app.commandExecutor.executeCommand(command, scanner);
        }

        scanner.close();
    }
}
