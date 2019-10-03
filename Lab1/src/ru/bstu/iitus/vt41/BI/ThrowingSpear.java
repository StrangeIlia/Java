package ru.bstu.iitus.vt41.BI;

import java.util.Scanner;

public final class ThrowingSpear extends SportsEquipment{
    public static final int code = 3;

    int weight = -1;

    public ThrowingSpear(){
        codeTypeSport = 2;
    }

    @Override
    public void init(Scanner scanner){
        weight = scanner.nextInt();
    }

    @Override
    public String toString() {
        return "Это метательное копье с весом " + weight;
    }
}
