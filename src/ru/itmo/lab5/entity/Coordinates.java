package ru.itmo.lab5.entity;

/**
 * Класс координат.
 */
public class Coordinates {
    private final long x; //Максимальное значение поля: 337
    private final float y;

    public Coordinates(long x, float y) {
        if (x > 337) {
            throw new IllegalArgumentException("x должно быть меньше или равно 337");
        }
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
