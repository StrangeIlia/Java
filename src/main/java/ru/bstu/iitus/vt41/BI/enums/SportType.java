package ru.bstu.iitus.vt41.BI.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SportType {
    UNDEFINED(-1, "Не определен"), //не определен
    VOLLEYBALL(0, "Волейбол"), //волейбол
    TENNIS(1, "Теннис"), //теннис
    JAVELINTHROWING(2, "Метание копья"), //метание копья
    BARBELL(3, "Штанга"), //Штанга
    WEIGHT(4, "Гиря"); //Гиря

    private final int index;
    private final String typeName;

    public static SportType valueOf(int v) {
        for (SportType type : SportType.values()) {
            if(type.getIndex() == v)
                return  type;
        }
        return  SportType.UNDEFINED;
    }
}