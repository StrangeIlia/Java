package ru.bstu.iitus.vt41.BI.Exceptions;

import lombok.Getter;
import ru.bstu.iitus.vt41.BI.SportsEquipment;

public class ObjectNotInitialized extends Exception {
    @Getter
    private SportsEquipment equipment;

    public ObjectNotInitialized(SportsEquipment equipment) {
        super("Объект был создан, но не инициализирован");
        this.equipment = equipment;
    }
}
