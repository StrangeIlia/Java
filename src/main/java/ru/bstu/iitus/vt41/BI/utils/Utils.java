package ru.bstu.iitus.vt41.BI.utils;


import ru.bstu.iitus.vt41.BI.enums.SportType;
import ru.bstu.iitus.vt41.BI.exceptions.ObjectsNoFound;
import ru.bstu.iitus.vt41.BI.SportsEquipment;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    static public List<SportsEquipment> Find(List<SportsEquipment> list, SportType type) throws ObjectsNoFound {
        List<SportsEquipment> result = new ArrayList<SportsEquipment>(list.size());
        for (SportsEquipment obj : list) {
            if (obj.getTypeInfo().getSportType() == type)
                result.add(obj);
        }
        if (result.size() == 0)
            throw new ObjectsNoFound(type);
        return result;
    }
}
