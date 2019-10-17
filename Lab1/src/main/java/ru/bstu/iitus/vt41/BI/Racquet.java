package ru.bstu.iitus.vt41.BI;

import java.util.Scanner;

// Теннисная ракетка
public final class Racquet extends SportsEquipment {
    public static final ObjectType code = ObjectType.Racquet;

    String producer = "";

    public Racquet(){
        typeSport = TypeSport.Tennis;
    }

    @Override
    public void init(Scanner scanner){
        producer = scanner.next();
    }

    @Override
    public String toString() {
        return "Это теннисная ракетка, которую производит фирма " + producer;
    }
}
