package ru.bstu.iitus.vt41.BI;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

public class Factory {
    private interface FactoryObjects {
        public abstract SportsEquipment create(Scanner scanner);
    }

    private enum Factorys implements FactoryObjects{
        FACTORYSBARBELL{
            @Override
            public SportsEquipment create(Scanner scanner){
                System.out.print("Введите вес штанги: ");
                SportsEquipment result = new Barbell();
                result.init(scanner);
                return result;
            }
        },
        FACTORYSTENNISBALL{
            @Override
            public SportsEquipment create(Scanner scanner) {
                System.out.print("Введите производителя теннисного мяча: ");
                SportsEquipment result = new TennisBall();
                result.init(scanner);
                return result;
            }
        },
        FACTORYSRACQUET{
            @Override
            public SportsEquipment create(Scanner scanner){
                System.out.print("Введите производителя ракетки: ");
                SportsEquipment result = new Racquet();
                result.init(scanner);
                return result;
            }
        },
        FACTORYSTHROWINGSPEAR{
            @Override
            public SportsEquipment create(Scanner scanner) {
                System.out.print("Введите вес метательного копья: ");
                SportsEquipment result = new ThrowingSpear();
                result.init(scanner);
                return result;
            }
        },
        FACTORYSVOLLEYBALL{
            public SportsEquipment create(Scanner scanner){
                System.out.print("Введите стоимость волейбольного мяча: ");
                SportsEquipment result = new VolleyBall();
                result.init(scanner);
                return result;
            }
        },
        FACTORYSWEIGHT{
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

    public Factory(){
        set.put(Barbell.code, Factorys.FACTORYSBARBELL);
        set.put(Racquet.code, Factorys.FACTORYSRACQUET);
        set.put(ThrowingSpear.code, Factorys.FACTORYSTHROWINGSPEAR);
        set.put(VolleyBall.code, Factorys.FACTORYSVOLLEYBALL);
        set.put(Weight.code, Factorys.FACTORYSWEIGHT);
        set.put(TennisBall.code, Factorys.FACTORYSTENNISBALL);
    }

    public SportsEquipment create(int code, Scanner scanner){
        FactoryObjects factory = set.get(code);
        if(factory != null)
            return factory.create(scanner);
        else return  null;
    }

    public SportsEquipment create(int code){
        return create(code, new Scanner(System.in));
    }
}
