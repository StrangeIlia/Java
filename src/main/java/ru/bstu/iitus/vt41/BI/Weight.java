package ru.bstu.iitus.vt41.BI;

import java.util.Scanner;

public final class Weight extends TrainingEquipment {
    public static final ObjectType code = ObjectType.Weight;

    double weight = 0;

    public Weight(){
        typeSport = TypeSport.Wieght;
    }

    @Override
    public void init(Scanner scanner) {
        weight = scanner.nextDouble();
    }

    @Override
    public String toString() {
        return "Это гиря весом " + weight;
    }
}
