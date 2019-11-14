package ru.bstu.iitus.vt41.BI.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum TypeObjects {
    UNDEFINED(-1, "Не определен"),
    VOLLEYBALL(0, "Волейбольный мяч"),
    TENNISBALL(1, "Теннисный мяч"),
    RACQUET(2, "Ракетка"),
    TROWINGSPEAR(3, "Метательное копье"),
    BARBELL(4, "Штанга"),
    WEIGHT(5, "Гиря");

    private final int index;
    private final String typeName;

    public static TypeObjects valueOf(int v) {
        for (TypeObjects type : TypeObjects.values()) {
            if(type.getIndex() == v)
                return  type;
        }
        return UNDEFINED;
    }
}
