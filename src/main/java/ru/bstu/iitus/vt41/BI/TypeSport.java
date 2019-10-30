package ru.bstu.iitus.vt41.BI;

public enum TypeSport {
    Undefined(-1), //не определен
    Volleyball(0), //волейбол
    Tennis(1), //теннис
    JavelinThrowing(2), //метание копья
    Barbell(3), //Штанга
    Wieght(4 ); //Гиря

    private final int index;

    TypeSport(int value){
        this.index = value;
    }

    public int getIndex() {
        return index;
    }

    public static TypeSport valueOf(int v){
        switch (v){
            case 0: return Volleyball;
            case 1: return Tennis;
            case 2: return JavelinThrowing;
            case 3: return Barbell;
            case 4: return Wieght;
            default: return Undefined;
        }
    }
}