package ru.bstu.iitus.vt41.BI.implementation;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import ru.bstu.iitus.vt41.BI.SportsEquipment;
import ru.bstu.iitus.vt41.BI.enums.SportType;
import ru.bstu.iitus.vt41.BI.enums.TypeObjects;
import ru.bstu.iitus.vt41.BI.utils.TypeInfo;

import java.io.PrintStream;
import java.util.Scanner;

// Теннисная ракетка
@Getter
@EqualsAndHashCode
public final class Racquet extends SportsEquipment {
    /*
    Чтобы объект хранящий данные о типе был уникален, мы создаем static переменную,
    к которой имеют доступ все объекты данного класса
    */
    @Getter(AccessLevel.NONE)
    private static final TypeInfo typeInfo;

    static {
        typeInfo = new TypeInfo();
        typeInfo.setTypeObjects(TypeObjects.RACQUET);
        typeInfo.setSportType(SportType.TENNIS);
    }

    String producer = "";

    public Racquet() {
        super(typeInfo);
    }

    @Override
    public boolean isInit() {
        return producer != "";
    }

    void checkValue() throws IllegalArgumentException {
        if (producer.equals(""))
            throw new IllegalArgumentException();
    }

    // Метод, чтобы не засорять консоль
    public void init(Scanner scanner) {
        producer = scanner.next();
        checkValue();
    }

    // Метод, для ручного ввода значений
    public void init(Scanner scanner, PrintStream out) {
        out.print("Введите производителя ракетки: ");
        producer = scanner.next();
        checkValue();
    }

    @Override
    public String toString() {
        return "Это теннисная ракетка, которую производит фирма " + producer;
    }
}
