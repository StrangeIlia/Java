package ru.bstu.iitus.vt41.BI;

import java.util.Scanner;

public final class ThrowingSpear extends SportsEquipment{
    public static final ObjectType code = ObjectType.TrowingSpear;

    double weight = -1;

    public ThrowingSpear(){
        typeSport = TypeSport.JavelinThrowing;
    }

    @Override
    public void init(Scanner scanner){
        weight = scanner.nextDouble();
    }

    @Override
    public String toString() {
        return "Это метательное копье с весом " + weight;
    }
}
