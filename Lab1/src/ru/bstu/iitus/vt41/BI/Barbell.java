package ru.bstu.iitus.vt41.BI;

import java.util.Scanner;

// Штанга
public final class Barbell extends TrainingEquipment {
    // Код предмета
    public static final int code = 4;

    int weight = -1;

    public Barbell(){
        codeTypeSport = 3;
    }

    @Override
    public void init(Scanner scanner) {
        //owner = scanner.next();
        weight = scanner.nextInt();
    }

    @Override
    public String toString() {
        return "Это штанга весом " + weight;
    }
}
