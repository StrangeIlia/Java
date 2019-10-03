package ru.bstu.iitus.vt41.BI;

import java.util.Scanner;

public final class Racquet extends SportsEquipment {
    String  producer = "";

    public Racquet(){
        codeTypeSport = 1;
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
