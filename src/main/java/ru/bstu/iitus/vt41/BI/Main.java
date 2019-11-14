package ru.bstu.iitus.vt41.BI;

import lombok.Getter;
import org.apache.log4j.Logger;
import ru.bstu.iitus.vt41.BI.enums.TypeObjects;
import ru.bstu.iitus.vt41.BI.enums.SportType;
import ru.bstu.iitus.vt41.BI.exceptions.FactoryNotFound;
import ru.bstu.iitus.vt41.BI.exceptions.ObjectsNoFound;
import ru.bstu.iitus.vt41.BI.utils.Utils;

import java.util.*;

public class Main {
    @Getter
    static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Factory factory = new Factory();

        int inventorySize;
        System.out.print("Введите количество предметов в инвентаре: ");
        while (true) {
            inventorySize = scanner.nextInt();
            if (inventorySize <= 0) {
                System.out.println("Указан неверный размер инвентаря, введите его заново");
                logger.error("Ошибка: не верно введен размер инвенторя");
            } else break;
        }

        List<SportsEquipment> inventory = new ArrayList<SportsEquipment>(inventorySize);

        System.out.println("Id предметов: ");
        Collection<TypeObjects> types = Arrays.asList(TypeObjects.values());
        for (TypeObjects type : types)
            System.out.println("    " + type.getIndex() + ") " + type.getTypeName());


        for (int i = 0; i != inventorySize; ++i) {
            System.out.print("Введите id предмета: ");
            while (true) {
                int id;
                SportsEquipment newEq = null;
                try {
                    id = scanner.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println("Пожалуйста, введите целое число ");
                    logger.warn("Пользователь не знает, чего он хочет");
                    continue;
                }
                if (TypeObjects.valueOf(id) == TypeObjects.UNDEFINED) {
                    System.out.println("Неверный код предмета, введите код снова: ");
                    logger.warn("Пользователь ввел неверный код объекта (" + id + ")");
                    continue;
                }
                while (true) {
                    try {
                        newEq = factory.create(TypeObjects.valueOf(id), scanner, System.out);
                        break;
                    } catch (FactoryNotFound notFound) {
                        System.out.println("Ошибка, не был найден конструктор объекта."
                                + " Выберите другой тип или обратитесь к разработчику за исправлениями.");
                        logger.error("Ошибка: не была найдена фабрика для объекта типа \""
                                + notFound.getType().getTypeName() + "\"");
                        break;
                    } catch (Exception ex) {
                        System.out.println("Ошибка при инициализации объекта. Введите данные повторно.");
                        logger.warn("Пользователь не верно ввел данные при инициализации объекта типа \""
                                + TypeObjects.valueOf(id).getTypeName() + "\"");
                        if (ex instanceof InputMismatchException)
                            scanner.next();
                    }
                }
                if (newEq != null) {
                    inventory.add(newEq);
                    break;
                }
            }
        }

        System.out.println("Хотите ли получить информацию по объектам относящимся к определенному виду спорта? (да/нет): ");
        while (true) {
            String string = scanner.next();
            if (string.equals("да"))
                break;
            else if (string.equals("нет"))
                return;
            else {
                System.out.println("Не корректный ответ. Пожалуйста повторите (да/нет): ");
                logger.warn("Пользователь не корректно ответил на вопрос");
            }
        }

        Collection<SportType> sportTypes = Arrays.asList(SportType.values());
        System.out.print("Возможные id вида спорта: ");
        for (SportType sportType : sportTypes)
            System.out.println("    " + sportType.getIndex() + ") " + sportType.getTypeName());


        SportType type = SportType.UNDEFINED;
        System.out.println("Введите id типа спорта: ");
        while (true) {
            int id;
            try {
                id = scanner.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Пожалуйста, введите целое число ");
                logger.warn("Пользователь не знает, чего он хочет");
                continue;
            }

            if (SportType.valueOf(id) == SportType.UNDEFINED) {
                System.out.println("Неверный id типа спорта, введите id снова");
                logger.warn("Пользователь ввел неверный код типа спорта (" + id + ")");
            } else {
                type = SportType.valueOf(id);
                break;
            }
        }

        try {
            List<SportsEquipment> result = Utils.Find(inventory, type);
            for (SportsEquipment e : result)
                System.out.println(e.toString());
        } catch (ObjectsNoFound noFound) {
            System.out.println("Не было найдено объектов, относящихся к типу спорта " + noFound.getSportType().getTypeName());
            logger.info(noFound.getMessage());
        }
    }
}
