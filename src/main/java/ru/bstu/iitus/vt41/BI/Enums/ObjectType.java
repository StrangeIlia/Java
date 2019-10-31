package ru.bstu.iitus.vt41.BI.Enums;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public enum ObjectType {
    UNDEFINED(-1), //не определен
    VOLLEYBALL(0), // волейбольный мяч
    TENNISBALL(1), // теннисный мяч
    RACQUET(2), //ракетка
    TROWINGSPEAR(3), //метательное копье
    BARBELL(4), //Штанга
    WEIGHT(5);

    private final int index;

    ObjectType(int value) {
        this.index = value;
    }

    public int getIndex() {
        return index;
    }

    public static ObjectType valueOf(int v) {
        switch (v) {
            case 0:
                return VOLLEYBALL;
            case 1:
                return TENNISBALL;
            case 2:
                return RACQUET;
            case 3:
                return TROWINGSPEAR;
            case 4:
                return BARBELL;
            case 5:
                return WEIGHT;
            default:
                return UNDEFINED;
        }
    }

    public String typeName() {
        switch (index) {
            case 0:
                return "Волейбольный мяч";
            case 1:
                return "Теннисный мяч";
            case 2:
                return "Теннисная ракетка";
            case 3:
                return "Метательное копье";
            case 4:
                return "Штанга";
            case 5:
                return "Гиря";
            default:
                return "UNDEFINED";
        }
    }

    public static Collection<ObjectType> getAllEnums() {
        List<ObjectType> result = new ArrayList<ObjectType>();
        result.add(VOLLEYBALL);
        result.add(TENNISBALL);
        result.add(RACQUET);
        result.add(TROWINGSPEAR);
        result.add(BARBELL);
        result.add(WEIGHT);
        return result;
    }
}
