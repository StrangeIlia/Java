package ru.bstu.iitus.vt41.BI;

public abstract class Ball extends SportsEquipment {
    private String ballType = "";

    public Ball(String ball) {
        ballType = ball;
    }

    String getBallType(){
        return ballType;
    }

    @Override
    public String toString() {
        return "Это мяч типа " + ballType;
    }
}
