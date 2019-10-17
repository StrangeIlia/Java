package ru.bstu.iitus.vt41.BI;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InvalidClassException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

public class Factory {
    private interface FactoryObjects {
        public SportsEquipment create(Scanner scanner);
    }

    private enum Factorys implements FactoryObjects {
        FACTORYSBARBELL {
            @Override
            public SportsEquipment create(Scanner scanner) {
                System.out.print("Введите вес штанги: ");
                SportsEquipment result = new Barbell();
                result.init(scanner);
                return result;
            }
        },
        FACTORYSTENNISBALL {
            @Override
            public SportsEquipment create(Scanner scanner) {
                System.out.print("Введите производителя теннисного мяча: ");
                SportsEquipment result = new TennisBall();
                result.init(scanner);
                return result;
            }
        },
        FACTORYSRACQUET {
            @Override
            public SportsEquipment create(Scanner scanner) {
                System.out.print("Введите производителя ракетки: ");
                SportsEquipment result = new Racquet();
                result.init(scanner);
                return result;
            }
        },
        FACTORYSTHROWINGSPEAR {
            @Override
            public SportsEquipment create(Scanner scanner) {
                System.out.print("Введите вес метательного копья: ");
                SportsEquipment result = new ThrowingSpear();
                result.init(scanner);
                return result;
            }
        },
        FACTORYSVOLLEYBALL {
            public SportsEquipment create(Scanner scanner) {
                System.out.print("Введите стоимость волейбольного мяча: ");
                SportsEquipment result = new VolleyBall();
                result.init(scanner);
                return result;
            }
        },
        FACTORYSWEIGHT {
            @Override
            public SportsEquipment create(Scanner scanner) {
                System.out.print("Введите вес гири: ");
                SportsEquipment result = new Weight();
                result.init(scanner);
                return result;
            }
        }
    }

    Dictionary<Integer, FactoryObjects> set = new Hashtable<Integer, FactoryObjects>();

    public Factory() {
        set.put(Barbell.code.getIndex(), Factorys.FACTORYSBARBELL);
        set.put(Racquet.code.getIndex(), Factorys.FACTORYSRACQUET);
        set.put(ThrowingSpear.code.getIndex(), Factorys.FACTORYSTHROWINGSPEAR);
        set.put(VolleyBall.code.getIndex(), Factorys.FACTORYSVOLLEYBALL);
        set.put(Weight.code.getIndex(), Factorys.FACTORYSWEIGHT);
        set.put(TennisBall.code.getIndex(), Factorys.FACTORYSTENNISBALL);
    }

    public SportsEquipment create(int code, Scanner scanner) {
        FactoryObjects factory = set.get(code);
        if (factory != null)
            return factory.create(scanner);
        else return null;
    }

    public SportsEquipment create(int code) {
        return create(code, new Scanner(System.in));
    }
}
