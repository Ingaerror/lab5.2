package ru.itmo.lab5.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * Класс, объекты которого хранятся в коллекции.
 */
public class LabWork implements Comparable<LabWork> {
    private static int idCounter = 1;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private final int id; //Значение этого поля должно генерироваться автоматически
    private final String name; //Поле не может быть null, Строка не может быть пустой
    private final Coordinates coordinates; //Поле не может быть null
    private final Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private final int minimalPoint; //Значение поля должно быть больше 0
    private final Double averagePoint; //Поле не может быть null, Значение поля должно быть больше 0
    private final Difficulty difficulty; //Поле может быть null
    private final Discipline discipline; //Поле не может быть null

    public LabWork(Integer id, String name, Coordinates coordinates, Date creationDate, int minimalPoint,
                   Double averagePoint, Difficulty difficulty, Discipline discipline) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть null или пустым");
        }
        if (coordinates == null) {
            throw new IllegalArgumentException("Координаты не могут быть null");
        }
        if (minimalPoint <= 0) {
            throw new IllegalArgumentException("Значение minimalPoint должно быть больше 0");
        }
        if (averagePoint == null || averagePoint <= 0) {
            throw new IllegalArgumentException("Значение averagePoint должно быть больше 0");
        }
        if (discipline == null) {
            throw new IllegalArgumentException("Дисциплина не может быть null");
        }

        if (id == null) {
            this.id = idCounter++;
        } else {
            this.id = id;
            idCounter = Math.max(LabWork.idCounter, id + 1);
        }
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = Objects.requireNonNullElseGet(creationDate, Date::new);
        this.minimalPoint = minimalPoint;
        this.averagePoint = averagePoint;
        this.difficulty = difficulty;
        this.discipline = discipline;
    }

    public LabWork(String name, Coordinates coordinates, int minimalPoint, Double averagePoint,
                   Difficulty difficulty, Discipline discipline) {
        this(null, name, coordinates, null, minimalPoint, averagePoint, difficulty, discipline);
    }

    public static LabWork fromCsv(String csv) throws ParseException {
        String[] fields = csv.split(",");
        int id = Integer.parseInt(fields[0]);
        String name = fields[1];
        Coordinates coordinates = new Coordinates(Long.parseLong(fields[2]), Float.parseFloat(fields[3]));
        Date creationDate = dateFormat.parse(fields[4]);
        int minimalPoint = Integer.parseInt(fields[5]);
        Double averagePoint = Double.parseDouble(fields[6]);
        Difficulty difficulty = Difficulty.valueOf(fields[7]);
        Discipline discipline = new Discipline(fields[8], Long.parseLong(fields[9]));

        return new LabWork(id, name, coordinates, creationDate, minimalPoint, averagePoint, difficulty, discipline);
    }

    public String toCsv() {
        return id + "," + name + "," + coordinates.getX() + "," + coordinates.getY() + "," + dateFormat.format(creationDate) + "," +
                minimalPoint + "," + averagePoint + "," + difficulty + "," + discipline.getName() + "," + discipline.getPracticeHours();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public int getMinimalPoint() {
        return minimalPoint;
    }

    public Double getAveragePoint() {
        return averagePoint;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    @Override
    public String toString() {
        return "LabWork{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", minimalPoint=" + minimalPoint +
                ", averagePoint=" + averagePoint +
                ", difficulty=" + difficulty +
                ", discipline=" + discipline +
                '}';
    }

    @Override
    public int compareTo(LabWork o) {
        return Double.compare(this.averagePoint, o.averagePoint);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LabWork labWork = (LabWork) o;
        return id == labWork.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
