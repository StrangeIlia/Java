package ru.bstu.iitus.vt41.BI.Exceptions;

import lombok.Getter;
import ru.bstu.iitus.vt41.BI.Enums.ObjectType;

public class FactoryNotFound extends Exception {
    @Getter
    private ObjectType type;

    public FactoryNotFound(ObjectType type) {
        super("Не найдена фабрика для класса \"" + type.typeName() + "\"");
        this.type = type;
    }
}
