package ru.bstu.iitus.vt41.BI;
import java.util.Scanner;

public final class VolleyBall extends Ball {
    int cost = 0;

    public VolleyBall() {
        super("волейбольный мяч");
        codeTypeSport = 0;
    }

    @Override
    public void init(Scanner scanner){
        cost = scanner.nextInt();
    }

    @Override
    public String toString() {
        return "Это волейбольный мяч стоимостью " + cost;
    }
}
