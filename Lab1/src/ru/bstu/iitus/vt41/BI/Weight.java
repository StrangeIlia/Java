package ru.bstu.iitus.vt41.BI;

import java.util.Scanner;

public final class Weight extends TrainingEquipment {
    int weight = 0;

    public Weight(){
        codeTypeSport = 4;
    }

    @Override
    public void init(Scanner scanner) {
        weight = scanner.nextInt();
    }

    @Override
    public String toString() {
        return "Это гиря весом " + weight;
    }
}
