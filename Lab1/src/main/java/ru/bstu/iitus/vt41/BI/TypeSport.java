package ru.bstu.iitus.vt41.BI;

public enum TypeSport {
    Undefined(-1), //не определен
    Volleyball(0), //волейбол
    Tennis(2), //теннис
    JavelinThrowing(3), //метание копья
    Barbell(4), //Штанга
    Wieght(5); //Гиря

    private final int index;

    TypeSport(int value){
        this.index = value;
    }

    public int getIndex() {
        return index;
    }
}