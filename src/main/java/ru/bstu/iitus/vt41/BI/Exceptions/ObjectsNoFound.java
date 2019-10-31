package ru.bstu.iitus.vt41.BI.Exceptions;

import lombok.Getter;
import ru.bstu.iitus.vt41.BI.Enums.ObjectType;
import ru.bstu.iitus.vt41.BI.Enums.SportType;

public class ObjectsNoFound extends Exception {
    @Getter
    private ObjectType objectType = ObjectType.UNDEFINED;
    @Getter
    private SportType sportType = SportType.UNDEFINED;

    public ObjectsNoFound(ObjectType type) {
        super("В коллекции не найден объекты типа \"" + type.typeName() + "\"");
        objectType = type;
    }

    public ObjectsNoFound(SportType type) {
        super("В коллекции не найден объекты, относящийся к виду спорта \"" + type.typeName() + "\"");
        sportType = type;
    }

    public ObjectsNoFound(ObjectType objectType, SportType sportType) {
        super("В коллекции не найден объекта типа \"" + objectType.typeName() +
                "\" относящийся к виду спорта \"" + sportType.typeName() + "\"");
        this.objectType = objectType;
        this.sportType = sportType;
    }
}
