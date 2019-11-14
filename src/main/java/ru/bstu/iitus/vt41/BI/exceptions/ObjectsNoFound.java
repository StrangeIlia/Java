package ru.bstu.iitus.vt41.BI.exceptions;

import lombok.Getter;
import ru.bstu.iitus.vt41.BI.enums.TypeObjects;
import ru.bstu.iitus.vt41.BI.enums.SportType;

@Getter
public class ObjectsNoFound extends Exception {
    private TypeObjects typeObjects = TypeObjects.UNDEFINED;
    private SportType sportType = SportType.UNDEFINED;

    public ObjectsNoFound(TypeObjects type) {
        super("В коллекции не найден объекты типа \"" + type.getTypeName() + "\"");
        typeObjects = type;
    }

    public ObjectsNoFound(SportType type) {
        super("В коллекции не найден объекты, относящийся к виду спорта \"" + type.getTypeName() + "\"");
        sportType = type;
    }

    public ObjectsNoFound(TypeObjects typeObjects, SportType sportType) {
        super("В коллекции не найден объекта типа \"" + typeObjects.getTypeName() +
                "\" относящийся к виду спорта \"" + sportType.getTypeName() + "\"");
        this.typeObjects = typeObjects;
        this.sportType = sportType;
    }
}
