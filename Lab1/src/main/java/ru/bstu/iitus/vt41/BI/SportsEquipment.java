package ru.bstu.iitus.vt41.BI;
import java.util.Scanner;

public abstract class SportsEquipment {
    // Код вида спорта
    protected TypeSport typeSport = TypeSport.Undefined;

    public abstract void init(Scanner scanner);
    public int getSportType(){
        return typeSport.getIndex();
    }
}
