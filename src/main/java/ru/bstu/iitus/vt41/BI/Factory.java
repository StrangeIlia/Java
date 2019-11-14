package ru.bstu.iitus.vt41.BI;

import lombok.Getter;
import org.apache.log4j.Logger;
import ru.bstu.iitus.vt41.BI.enums.TypeObjects;
import ru.bstu.iitus.vt41.BI.exceptions.FactoryNotFound;
import ru.bstu.iitus.vt41.BI.implementation.*;

import java.io.PrintStream;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

public class Factory {
    @Getter
    static  final Logger logger = Logger.getLogger(Factory.class);

    private interface FactoryObjects {
        SportsEquipment create();
    }

    private enum Factorys implements FactoryObjects {
        FACTORYSBARBELL {
            @Override
            public SportsEquipment create() {
                return new Barbell();
            }
        },
        FACTORYSTENNISBALL {
            @Override
            public SportsEquipment create() {
                return new TennisBall();
            }
        },
        FACTORYSRACQUET {
            @Override
            public SportsEquipment create() {
                return new Racquet();
            }
        },
        FACTORYSTHROWINGSPEAR {
            @Override
            public SportsEquipment create() {
                return new ThrowingSpear();
            }
        },
        FACTORYSVOLLEYBALL {
            public SportsEquipment create() {
                return new VolleyBall();
            }
        },
        FACTORYSWEIGHT {
            @Override
            public SportsEquipment create() {
                return new Weight();
            }
        }
    }

    Dictionary<TypeObjects, FactoryObjects> set = new Hashtable<TypeObjects, FactoryObjects>();

    public Factory() {
        set.put(TypeObjects.BARBELL, Factorys.FACTORYSBARBELL);
        set.put(TypeObjects.RACQUET, Factorys.FACTORYSRACQUET);
        set.put(TypeObjects.TROWINGSPEAR, Factorys.FACTORYSTHROWINGSPEAR);
        set.put(TypeObjects.VOLLEYBALL, Factorys.FACTORYSVOLLEYBALL);
        set.put(TypeObjects.WEIGHT, Factorys.FACTORYSWEIGHT);
        set.put(TypeObjects.TENNISBALL, Factorys.FACTORYSTENNISBALL);
        // Ball.getTypeInfo().getObjectType() - подобного вызова вы никогда не увидете
        // ибо java перегрузает, блин, не статические методы статическими
    }

    public SportsEquipment create(TypeObjects type, Scanner scanner) throws Exception {
        FactoryObjects factory = set.get(type);
        if (factory == null)
            throw new FactoryNotFound(type);
        SportsEquipment equipment = factory.create();
        try {
            equipment.init(scanner);
        } catch (Exception ex) {
            logger.error("Ошибка при инициализации объекта");
            throw ex;
        }
        return equipment;
    }

    public SportsEquipment create(TypeObjects type, Scanner scanner, PrintStream out) throws Exception {
        FactoryObjects factory = set.get(type);
        if (factory == null)
            throw new FactoryNotFound(type);
        SportsEquipment equipment = factory.create();
        try {
            equipment.init(scanner, out);
        } catch (Exception ex) {
            logger.error("Ошибка при инициализации объекта");
            throw ex;
        }
        return equipment;
    }

    public SportsEquipment create(TypeObjects code) throws Exception {
        return create(code, new Scanner(System.in));
    }
}
