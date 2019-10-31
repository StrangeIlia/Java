package ru.bstu.iitus.vt41.BI.Implementation;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import ru.bstu.iitus.vt41.BI.Enums.ObjectType;
import ru.bstu.iitus.vt41.BI.Enums.SportType;
import ru.bstu.iitus.vt41.BI.SportsEquipment;
import ru.bstu.iitus.vt41.BI.Utils.TypeInfo;

import java.io.PrintStream;
import java.util.Scanner;

@Data
public final class ThrowingSpear extends SportsEquipment {
    /*
    Чтобы объект хранящий данные о типе был уникален, мы создаем static переменную,
    к которой имеют доступ все объекты данного класса
    */
    @Getter(AccessLevel.NONE)
    private static final TypeInfo typeInfo;

    static {
        typeInfo = new TypeInfo();
        typeInfo.setObjectType(ObjectType.TROWINGSPEAR);
        typeInfo.setSportType(SportType.JAVELINTHROWING);
    }

    double weight = -1;

    public ThrowingSpear() {
        super(typeInfo);
    }

    @Override
    public boolean isInit() {
        return weight > 0;
    }

    void checkValue() throws IllegalArgumentException {
        if (weight <= 0)
            throw new IllegalArgumentException();
    }

    // Метод, чтобы не засорять консоль
    public void init(Scanner scanner) {
        weight = scanner.nextDouble();
        checkValue();
    }

    // Метод, для ручного ввода значений
    public void init(Scanner scanner, PrintStream out) {
        out.print("Введите вес метательного копья: ");
        weight = scanner.nextDouble();
        checkValue();
    }

    @Override
    public String toString() {
        return "Это метательное копье с весом " + weight;
    }
}
