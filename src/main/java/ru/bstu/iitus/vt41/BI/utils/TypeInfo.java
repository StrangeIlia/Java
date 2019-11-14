package ru.bstu.iitus.vt41.BI.utils;

import lombok.Data;
import ru.bstu.iitus.vt41.BI.enums.TypeObjects;
import ru.bstu.iitus.vt41.BI.enums.SportType;

/*
Пришлось выносить данный класс за SportEquipment поскольку Idea утверждал,
что при инициализации static поля используется this (Почему, я так и не понял)
 */

@Data
public class TypeInfo {
    private TypeObjects typeObjects;
    private SportType sportType;

    public TypeInfo() {
        typeObjects = TypeObjects.UNDEFINED;
        sportType = SportType.UNDEFINED;
    }
}
