package ru.bstu.iitus.vt41.BI;

import java.util.Scanner;

// Теннисный мяч
public final class TennisBall extends Ball {
    public static final ObjectType code = ObjectType.TennisBall;

    String producer = "";

    public TennisBall(){
        super("теннисный мяч");
        typeSport = TypeSport.Tennis;
    }

    @Override
    public void init(Scanner scanner){
        producer = scanner.next();
    }

    @Override
    public String toString() {
        return "Это теннисный мяч, который произведен фирмой " + producer;
    }
}
