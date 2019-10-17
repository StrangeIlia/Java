package ru.bstu.iitus.vt41.BI;

import java.util.Scanner;

public abstract class TrainingEquipment extends SportsEquipment {
    protected String owner = "";

    public TrainingEquipment(){

    }

    @Override
    public String toString() {
        if(owner == "")
            return "Этим спортивным интвентарем никто не владеет";
        else
            return "Этим спортивным интвентарем владеет " + owner;
    }
}
