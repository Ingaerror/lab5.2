package ru.itmo.lab5.command;

import java.util.Scanner;

/**
 * Класс команды 'help'.
 */
public class Help implements Executable {

    @Override
    public void execute(String command, Scanner scanner) {
        help();
    }

    private void help() {
        System.out.println("Available commands:");
        System.out.println("help : вывести справку по доступным командам");
        System.out.println("info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        System.out.println("show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        System.out.println("add {element} : добавить новый элемент в коллекцию");
        System.out.println("update id {element} : обновить значение элемента коллекции, id которого равен заданному");
        System.out.println("remove_by_id id : удалить элемент из коллекции по его id");
        System.out.println("clear : очистить коллекцию");
        System.out.println("save : сохранить коллекцию в файл");
        System.out.println("execute_script file_name : считать и исполнить скрипт из указанного файла");
        System.out.println("exit : завершить программу (без сохранения в файл)");
        System.out.println("add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции");
        System.out.println("remove_greater {element} : удалить из коллекции все элементы, превышающие заданный");
        System.out.println("history : вывести последние 11 команд (без их аргументов)");
        System.out.println("remove_any_by_difficulty difficulty : удалить из коллекции один элемент, значение поля difficulty которого эквивалентно заданному");
        System.out.println("print_unique_difficulty : вывести уникальные значения поля difficulty всех элементов в коллекции");
        System.out.println("print_field_ascending_discipline : вывести значения поля discipline всех элементов в порядке возрастания");
    }
}
