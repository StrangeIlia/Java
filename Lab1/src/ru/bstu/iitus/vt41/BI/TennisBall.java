package ru.bstu.iitus.vt41.BI;

import java.util.Scanner;

// Теннисный мяч
public final class TennisBall extends Ball {
    public static final int code = 1;

    String  producer = "";

    public TennisBall(){
        super("теннисный мяч");
        codeTypeSport = 1;
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
