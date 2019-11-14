package ru.bstu.iitus.vt41.BI;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import ru.bstu.iitus.vt41.BI.utils.TypeInfo;

import java.io.PrintStream;
import java.util.Scanner;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public abstract class SportsEquipment {
    /*
    Вся информация о свойствах, характерных ТИПУ (ПОДТИПУ) объекта вынесена за класс.
    Каждый объект, имеющий тип Спортивный инвентарь, знает о своем подтипе
    и чтобы не нарушать правила ООП, каждый объект при инициализации указывает информацию
    о своем подтипе
     */
    private TypeInfo typeInfo;

    // Метод проверки инициализации
    public abstract boolean isInit();

    // Метод, чтобы не засорять консоль
    public abstract void init(Scanner scanner);

    // Метод, для ручного ввода значений
    public abstract void init(Scanner scanner, PrintStream out);
}
