package ru.bstu.iitus.vt41.BI;

public enum ObjectType {
    Undefined(-1), //не определен
    VolleyBall(0), // волейбольный мяч
    TennisBall(1), // теннисный мяч
    Racquet(2), //ракетка
    TrowingSpear(3), //метательное копье
    Barbell(4), //Штанга
    Weight(5); //гиря

    private final int index;

    ObjectType(int value){
        this.index = value;
    }

    public int getIndex() {
        return index;
    }

    public static ObjectType valueOf(int v){
        switch (v){
            case 0: return VolleyBall;
            case 1: return TennisBall;
            case 2: return Racquet;
            case 3: return TrowingSpear;
            case 4: return Barbell;
            case 5: return Weight;
            default: return Undefined;
        }
    }
}
