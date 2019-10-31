package ru.bstu.iitus.vt41.BI.Utils;

import lombok.Data;
import lombok.Setter;
import ru.bstu.iitus.vt41.BI.Enums.ObjectType;
import ru.bstu.iitus.vt41.BI.Enums.SportType;

/*
Пришлось выносить данный класс за SportEquipment поскольку Idea утверждал,
что при инициализации static поля используется this (Почему, я так и не понял)
 */

@Data
public class TypeInfo {
    private ObjectType objectType;
    private SportType sportType;

    public TypeInfo() {
        objectType = ObjectType.UNDEFINED;
        sportType = SportType.UNDEFINED;
    }
}
