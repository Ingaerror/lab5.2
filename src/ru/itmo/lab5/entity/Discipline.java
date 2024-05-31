package ru.itmo.lab5.entity;

/**
 * Класс дисциплин.
 */
public class Discipline {
    private final String name; //Поле не может быть null, Строка не может быть пустой
    private final Long practiceHours; //Поле не может быть null

    public Discipline(String name, Long practiceHours) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть null или пустым");
        }
        if (practiceHours == null) {
            throw new IllegalArgumentException("Количество часов занятий не может быть нулевым");
        }
        this.name = name;
        this.practiceHours = practiceHours;
    }

    public String getName() {
        return name;
    }

    public Long getPracticeHours() {
        return practiceHours;
    }

    @Override
    public String toString() {
        return "Discipline{" +
                "name='" + name + '\'' +
                ", practiceHours=" + practiceHours +
                '}';
    }
}
