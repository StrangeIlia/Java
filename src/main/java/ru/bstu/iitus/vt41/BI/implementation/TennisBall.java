package ru.bstu.iitus.vt41.BI.implementation;

import lombok.*;
import ru.bstu.iitus.vt41.BI.Ball;
import ru.bstu.iitus.vt41.BI.enums.TypeObjects;
import ru.bstu.iitus.vt41.BI.enums.SportType;
import ru.bstu.iitus.vt41.BI.utils.TypeInfo;

import java.io.PrintStream;
import java.util.Scanner;

// Теннисный мяч
@Getter
@EqualsAndHashCode
public final class TennisBall extends Ball {
    /*
    Чтобы объект хранящий данные о типе был уникален, мы создаем static переменную,
    к которой имеют доступ все объекты данного класса
    */
    @Getter(AccessLevel.NONE)
    private static final TypeInfo typeInfo;

    static {
        typeInfo = new TypeInfo();
        typeInfo.setTypeObjects(TypeObjects.TENNISBALL);
        typeInfo.setSportType(SportType.TENNIS);
    }

    @Setter
    String producer = "";

    public TennisBall() {
        super(typeInfo);
    }

    void checkValue() throws IllegalArgumentException {
        if (producer.equals(""))
            throw new IllegalArgumentException();
    }

    // Метод, чтобы не засорять консоль
    public void init(Scanner scanner) {
        super.init(scanner);
        producer = scanner.next();
        checkValue();
    }

    // Метод, для ручного ввода значений
    public void init(Scanner scanner, PrintStream out) {
        super.init(scanner, out);
        out.print("Введите производителя тенисного шарика: ");
        producer = scanner.next();
        checkValue();
    }

    @Override
    public boolean isInit() {
        return producer != "" && super.isInit();
    }

    @Override
    public String toString() {
        return "Это теннисный мяч радиусом в " + radius + ", который произведен фирмой " + producer;
    }
}
