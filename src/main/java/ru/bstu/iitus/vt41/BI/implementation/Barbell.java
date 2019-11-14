package ru.bstu.iitus.vt41.BI.implementation;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import ru.bstu.iitus.vt41.BI.enums.TypeObjects;
import ru.bstu.iitus.vt41.BI.TrainingEquipment;
import ru.bstu.iitus.vt41.BI.enums.SportType;
import ru.bstu.iitus.vt41.BI.utils.TypeInfo;

import java.io.PrintStream;
import java.util.Scanner;

// Штанга
@Getter
@EqualsAndHashCode
public final class Barbell extends TrainingEquipment {
    /*
    Чтобы объект хранящий данные о типе был уникален, мы создаем static переменную,
    к которой имеют доступ все объекты данного класса
    */
    @Getter(AccessLevel.NONE)
    private static final TypeInfo typeInfo;

    static {
        typeInfo = new TypeInfo();
        typeInfo.setTypeObjects(TypeObjects.BARBELL);
        typeInfo.setSportType(SportType.BARBELL);
    }

    double weight = -1;

    public Barbell() {
        super(typeInfo);
    }

    @Override
    public boolean isInit() {
        return weight > 0 && super.isInit();
    }

    void checkValue() throws  IllegalArgumentException{
        if(weight <= 0)
            throw new IllegalArgumentException();
    }

    @Override
    public void init(Scanner scanner) {
        super.init(scanner);
        weight = scanner.nextDouble();
        checkValue();
    }

    @Override
    public void init(Scanner scanner, PrintStream out) {
        super.init(scanner, out);
        out.print("Введите вес штанги: ");
        weight = scanner.nextDouble();
        checkValue();
    }

    @Override
    public String toString() {
        return "Это штанга весом " + weight + ", которой владеет " + owner;
    }
}
