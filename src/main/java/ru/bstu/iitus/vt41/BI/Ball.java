package ru.bstu.iitus.vt41.BI;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import ru.bstu.iitus.vt41.BI.utils.TypeInfo;

import java.io.PrintStream;
import java.util.Scanner;

@Getter
@EqualsAndHashCode
public abstract class Ball extends SportsEquipment {
    protected double radius = -1;

    public Ball(TypeInfo typeInfo) {
        super(typeInfo);
    }

    @Override
    public boolean isInit() {
        return radius > 0;
    }

    void checkValue() throws IllegalArgumentException {
        if (radius <= 0)
            throw new IllegalArgumentException();
    }

    // Метод, чтобы не засорять консоль
    public void init(Scanner scanner) {
        radius = scanner.nextDouble();
        checkValue();
    }

    // Метод, для ручного ввода значений
    public void init(Scanner scanner, PrintStream out) {
        out.print("Введите радиус мяча: ");
        radius = scanner.nextDouble();
        checkValue();
    }

    @Override
    public String toString() {
        return "Это мяч типа " + getTypeInfo().getTypeObjects().getTypeName() + " радиусом в " + radius;
    }
}
