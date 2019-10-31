package ru.bstu.iitus.vt41.BI.Implementation;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import ru.bstu.iitus.vt41.BI.Enums.ObjectType;
import ru.bstu.iitus.vt41.BI.Enums.SportType;
import ru.bstu.iitus.vt41.BI.TrainingEquipment;
import ru.bstu.iitus.vt41.BI.Utils.TypeInfo;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

@Data
public final class Weight extends TrainingEquipment {
    /*
    Чтобы объект хранящий данные о типе был уникален, мы создаем static переменную,
    к которой имеют доступ все объекты данного класса
    */
    @Getter(AccessLevel.NONE)
    private static final TypeInfo typeInfo;

    static {
        typeInfo = new TypeInfo();
        typeInfo.setObjectType(ObjectType.WEIGHT);
        typeInfo.setSportType(SportType.WEIGHT);
    }

    double weight = -1;

    public Weight() {
        super(typeInfo);
    }

    void checkValue() throws IllegalArgumentException {
        if (weight <= 0)
            throw new IllegalArgumentException();
    }

    // Метод, чтобы не засорять консоль
    public void init(Scanner scanner) {
        super.init(scanner);
        weight = scanner.nextDouble();
        checkValue();
    }

    // Метод, для ручного ввода значений
    public void init(Scanner scanner, PrintStream out) {
        super.init(scanner, out);
        out.print("Введите вес гири: ");
        weight = scanner.nextDouble();
        checkValue();
    }

    @Override
    public boolean isInit() {
        return weight > 0 && super.isInit();
    }

    @Override
    public String toString() {
        return "Это гиря весом " + weight + ", которой владеет " + owner;
    }
}
