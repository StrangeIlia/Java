package ru.bstu.iitus.vt41.BI;

import java.util.Scanner;

public class Barbell extends TrainingEquipment {
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
