package ru.bstu.iitus.vt41.BI;
import java.util.Scanner;

// codeTypeSport :
// -1 - не определен
// 0 - волейбол
// 1 - теннис
// 2 - метание копья
// 3 - штанга
// 4 - гиря

public abstract class SportsEquipment {
    protected int codeTypeSport = -1;
    public abstract void init(Scanner scanner);
    public int getSportType(){
        return codeTypeSport;
    }
}
