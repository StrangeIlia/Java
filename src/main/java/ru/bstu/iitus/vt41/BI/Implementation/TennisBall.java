package ru.bstu.iitus.vt41.BI.Implementation;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.bstu.iitus.vt41.BI.Ball;
import ru.bstu.iitus.vt41.BI.Enums.ObjectType;
import ru.bstu.iitus.vt41.BI.Enums.SportType;
import ru.bstu.iitus.vt41.BI.Utils.TypeInfo;

import java.io.PrintStream;
import java.util.Scanner;

// Теннисный мяч
@Data
public final class TennisBall extends Ball {
    /*
    Чтобы объект хранящий данные о типе был уникален, мы создаем static переменную,
    к которой имеют доступ все объекты данного класса
    */
    @Getter(AccessLevel.NONE)
    private static final TypeInfo typeInfo;

    static {
        typeInfo = new TypeInfo();
        typeInfo.setObjectType(ObjectType.TENNISBALL);
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
