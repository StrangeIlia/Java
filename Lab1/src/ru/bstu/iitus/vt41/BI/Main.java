package ru.bstu.iitus.vt41.BI;
import java.lang.reflect.Method;
import java.util.Dictionary;
import java.util.Scanner;

// codeTypeSport (Вид спорта) :
// -1 - не определен
// 0 - волейбол
// 1 - теннис
// 2 - метание копья
// 3 - штанги
// 4 - гиря

// code (Тип объекта)
// 0 - волейбольный мяч
// 1 - теннисный мяч
// 2 - ракетка
// 3 - метательное копье
// 4 - штанга
// 5 - гиря

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Factory factory = new Factory();

        System.out.println("Id предметов: ");
        System.out.println("    0) Волейбольный мяч ");
        System.out.println("    1) Теннисный мяч ");
        System.out.println("    2) Ракетка ");
        System.out.println("    3) Метательное копье ");
        System.out.println("    4) Штанга ");
        System.out.println("    5) Гиря ");

        SportsEquipment[] inventory = null;
        System.out.print("Введите количество предметов в инвентаре: ");
        while (true){
            int length = scanner.nextInt();
            if(length <= 0)
                System.out.println("Указан неверный размер инвентаря, введите его заново");
            else{
                inventory = new SportsEquipment[length];
                break;
            }
        }

        for (int i = 0; i != inventory.length; ++i){
            while(true){
                System.out.print("Введите id предмета: ");
                inventory[i] = factory.create(scanner.nextInt(), scanner);
                if(inventory[i] == null)
                    System.out.println("Неверный код предмета, введите код снова");
                else break;
            }
        }

        System.out.println("Информация о всех предметах, относящихся к теннису: ");
        for ( SportsEquipment e: inventory )
            if( e.getSportType() == 1 )
                System.out.println(e.toString());
    }
}
