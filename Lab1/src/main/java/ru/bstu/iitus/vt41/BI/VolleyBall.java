package ru.bstu.iitus.vt41.BI;
import java.util.Scanner;

public final class VolleyBall extends Ball {
    public static final ObjectType code = ObjectType.VolleyBall;

    double cost = 0;

    public VolleyBall() {
        super("волейбольный мяч");
        typeSport = TypeSport.Volleyball;
    }

    @Override
    public void init(Scanner scanner){
        cost = scanner.nextDouble();
    }

    @Override
    public String toString() {
        return "Это волейбольный мяч стоимостью " + cost;
    }
}
