package ru.bstu.iitus.vt41.BI.exceptions;

import lombok.Getter;
import ru.bstu.iitus.vt41.BI.enums.TypeObjects;

public class FactoryNotFound extends Exception {
    @Getter
    private TypeObjects type;

    public FactoryNotFound(TypeObjects type) {
        super("Не найдена фабрика для класса \"" + type.getTypeName() + "\"");
        this.type = type;
    }
}
