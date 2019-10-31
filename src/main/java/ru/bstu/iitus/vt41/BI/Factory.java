package ru.bstu.iitus.vt41.BI;

import lombok.Getter;
import org.apache.log4j.Logger;
import ru.bstu.iitus.vt41.BI.Enums.ObjectType;
import ru.bstu.iitus.vt41.BI.Exceptions.FactoryNotFound;
import ru.bstu.iitus.vt41.BI.Implementation.*;

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

    Dictionary<ObjectType, FactoryObjects> set = new Hashtable<ObjectType, FactoryObjects>();

    public Factory() {
        set.put(ObjectType.BARBELL, Factorys.FACTORYSBARBELL);
        set.put(ObjectType.RACQUET, Factorys.FACTORYSRACQUET);
        set.put(ObjectType.TROWINGSPEAR, Factorys.FACTORYSTHROWINGSPEAR);
        set.put(ObjectType.VOLLEYBALL, Factorys.FACTORYSVOLLEYBALL);
        set.put(ObjectType.WEIGHT, Factorys.FACTORYSWEIGHT);
        set.put(ObjectType.TENNISBALL, Factorys.FACTORYSTENNISBALL);
        // Ball.getTypeInfo().getObjectType() - подобного вызова вы никогда не увидете
        // ибо java перегрузает, блин, не статические методы статическими
    }

    public SportsEquipment create(ObjectType type, Scanner scanner) throws Exception {
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

    public SportsEquipment create(ObjectType type, Scanner scanner, PrintStream out) throws Exception {
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

    public SportsEquipment create(ObjectType code) throws Exception {
        return create(code, new Scanner(System.in));
    }
}
