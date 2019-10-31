package ru.bstu.iitus.vt41.BI;

import lombok.Data;
import ru.bstu.iitus.vt41.BI.Enums.ObjectType;
import ru.bstu.iitus.vt41.BI.Enums.SportType;
import ru.bstu.iitus.vt41.BI.Implementation.Barbell;
import ru.bstu.iitus.vt41.BI.Utils.TypeInfo;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

@Data
public abstract class SportsEquipment {
    /*
    Вся информация о свойствах, характерных ТИПУ (ПОДТИПУ) объекта вынесена за класс.
    Каждый объект, имеющий тип Спортивный инвентарь, знает о своем подтипе
    и чтобы не нарушать правила ООП, каждый объект при инициализации указывает информацию
    о своем подтипе
     */
    private TypeInfo typeInfo;

    public SportsEquipment(TypeInfo typeInfo) {
        this.typeInfo = typeInfo;
    }

    // Метод проверки инициализации
    public abstract boolean isInit();

    // Метод, чтобы не засорять консоль
    public abstract void init(Scanner scanner);

    // Метод, для ручного ввода значений
    public abstract void init(Scanner scanner, PrintStream out);
}
