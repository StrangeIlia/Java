package ru.bstu.iitus.vt41.BI;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import ru.bstu.iitus.vt41.BI.utils.TypeInfo;

import java.io.PrintStream;
import java.util.Scanner;

@Getter
@EqualsAndHashCode
public abstract class TrainingEquipment extends SportsEquipment {
    @Setter
    protected String owner = "";

    public TrainingEquipment(TypeInfo info) {
        super(info);
    }

    @Override
    public boolean isInit() {
        return owner != "";
    }

    void checkValue() throws IllegalArgumentException {
        if (owner.equals(""))
            throw new IllegalArgumentException();
    }

    // Метод, чтобы не засорять консоль
    public void init(Scanner scanner) {
        owner = scanner.next();
        checkValue();
    }

    // Метод, для ручного ввода значений
    public void init(Scanner scanner, PrintStream out) {
        out.print("Введите владельца спорт. инвенторя: ");
        owner = scanner.next();
        checkValue();
    }

    @Override
    public String toString() {
        if (owner == "")
            return "Этим спортивным интвентарем никто не владеет";
        else
            return "Этим спортивным интвентарем владеет " + owner;
    }
}
