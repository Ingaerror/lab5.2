package ru.itmo.lab5.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CsvGenerator {
    public static void main(String[] args) {
        String csvFile = "labworks.csv";
        try (PrintWriter writer = new PrintWriter(new FileWriter(csvFile))) {
            writer.println("1,LabWork1,100,200.0,2023-01-01,10,50.0,NORMAL,Discipline1,1000");
            writer.println("2,LabWork2,150,250.0,2023-01-02,20,60.0,VERY_HARD,Discipline2,2000");
            writer.println("3,LabWork3,200,300.0,2023-01-03,30,70.0,INSANE,Discipline3,3000");
            writer.println("4,LabWork4,250,350.0,2023-01-04,40,80.0,HOPELESS,Discipline4,4000");
            writer.println("5,LabWork5,300,400.0,2023-01-05,50,90.0,VERY_EASY,Discipline5,5000");
        } catch (IOException e) {
            System.out.println("Ошибка при создании CSV-файла: " + e.getMessage());
        }
    }
}