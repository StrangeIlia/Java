package ru.bstu.iitus.vt41.BI.implementation;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import ru.bstu.iitus.vt41.BI.Ball;
import ru.bstu.iitus.vt41.BI.enums.TypeObjects;
import ru.bstu.iitus.vt41.BI.enums.SportType;
import ru.bstu.iitus.vt41.BI.utils.TypeInfo;

import java.io.PrintStream;
import java.util.Scanner;

@Getter
@EqualsAndHashCode
public final class VolleyBall extends Ball {
    /*
    Чтобы объект хранящий данные о типе был уникален, мы создаем static переменную,
    к которой имеют доступ все объекты данного класса
    */
    @Getter(AccessLevel.NONE)
    private static final TypeInfo typeInfo;

    static {
        typeInfo = new TypeInfo();
        typeInfo.setTypeObjects(TypeObjects.VOLLEYBALL);
        typeInfo.setSportType(SportType.VOLLEYBALL);
    }

    double cost = 0;

    public VolleyBall() {
        super(typeInfo);
    }

    void checkValue() throws IllegalArgumentException {
        if (cost <= 0)
            throw new IllegalArgumentException();
    }

    // Метод, чтобы не засорять консоль
    public void init(Scanner scanner) {
        super.init(scanner);
        cost = scanner.nextDouble();
        checkValue();
    }

    // Метод, для ручного ввода значений
    public void init(Scanner scanner, PrintStream out) {
        super.init(scanner, out);
        out.print("Введите стоимость волейбольного мяча: ");
        cost = scanner.nextDouble();
        checkValue();
    }

    @Override
    public boolean isInit() {
        return cost > 0 && super.isInit();
    }

    @Override
    public String toString() {
        return "Это волейбольный мяч стоимостью " + cost + " и радиусом " + radius;
    }
}
