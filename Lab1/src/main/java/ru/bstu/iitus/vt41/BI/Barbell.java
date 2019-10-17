package ru.bstu.iitus.vt41.BI;

import java.util.Scanner;

// Штанга
public final class Barbell extends TrainingEquipment {
    // Код предмета
    public static final ObjectType code = ObjectType.Barbell;

    double weight = -1;

    public Barbell(){
        typeSport = TypeSport.Barbell;
    }

    @Override
    public void init(Scanner scanner) {
        //owner = scanner.next();
        weight = scanner.nextDouble();
    }

    @Override
    public String toString() {
        return "Это штанга весом " + weight;
    }
}
