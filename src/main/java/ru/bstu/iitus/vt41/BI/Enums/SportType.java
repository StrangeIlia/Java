package ru.bstu.iitus.vt41.BI.Enums;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public enum SportType {
    UNDEFINED(-1), //не определен
    VOLLEYBALL(0), //волейбол
    TENNIS(1), //теннис
    JAVELINTHROWING(2), //метание копья
    BARBELL(3), //Штанга
    WEIGHT(4); //Гиря

    private final int index;

    SportType(int value) {
        this.index = value;
    }

    public int getIndex() {
        return index;
    }

    public static SportType valueOf(int v) {
        switch (v) {
            case 0:
                return VOLLEYBALL;
            case 1:
                return TENNIS;
            case 2:
                return JAVELINTHROWING;
            case 3:
                return BARBELL;
            case 4:
                return WEIGHT;
            default:
                return UNDEFINED;
        }
    }

    public String typeName() {
        switch (index) {
            case 0:
                return "Волейбол";
            case 1:
                return "Теннис";
            case 2:
                return "Метание копья";
            case 3:
                return "Жим штанги";
            case 4:
                return "Подъем гири";
            default:
                return "UNDEFINED";
        }
    }

    public static Collection<SportType> getAllEnums() {
        List<SportType> result = new ArrayList<SportType>();
        result.add(VOLLEYBALL);
        result.add(TENNIS);
        result.add(JAVELINTHROWING);
        result.add(BARBELL);
        result.add(WEIGHT);
        return result;
    }
}