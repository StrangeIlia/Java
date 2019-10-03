package ru.bstu.iitus.vt41.BI;
import java.util.Scanner;

// codeTypeSport (Вид спорта) :
// -1 - не определен
// 0 - волейбол
// 1 - теннис
// 2 - метание копья
// 3 - штанга
// 4 - гиря

// code (Тип объекта)
// 0 - волейбольный мяч
// 1 - теннисный мяч
// 2 - ракетка
// 3 - метательное копье
// 4 - штанга
// 5 - гиря

public abstract class SportsEquipment {
    // Код вида спорта
    protected int codeTypeSport = -1;
    public abstract void init(Scanner scanner);
    public int getSportType(){
        return codeTypeSport;
    }
}
