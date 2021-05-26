package com.sytoss.domain;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
    private boolean isMoving;
    private int floor;
    private Direction direction;
    private boolean isOverload;
    private List<Integer> points;

    enum Direction {
        UP("Вверх"), DOWN("Вниз"), STOP("Остановлен");

        private String name;

        Direction(String name) {
            this.name = name;
        }
    }

    public Elevator() {
        points = new ArrayList<>();
        direction = Direction.STOP;
    }

    public void addPoint(Integer point){
        points.add(point);
    }

    public void emergencyStop(){
        points.clear();
        isMoving = false;
        callOperator();
        direction = Direction.STOP;
    }

    public void openDoor() {
        System.out.println("Открытие дверей");
    }

    public void closeDoor() {
        System.out.println("Закрытие дверей");
    }

    public void callOperator() {
        System.out.println("Вызов оператора");
    }

    public List<Integer> getPoints() {
        return points;
    }

    public void setPoints(List<Integer> points) {
        this.points = points;
    }

    public String getInformation() {
        StringBuilder sb = new StringBuilder();
        sb.append("Статус движения: ");
        if (isMoving) {
            sb.append("В движении");
        } else {
            sb.append("Остановлен");
        }
        sb.append(" Этаж: ").append(floor).append(" Направление джвижения: ").append(direction);
        return sb.toString();
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isOverload() {
        return isOverload;
    }

    public void setOverload(boolean overload) {
        isOverload = overload;
    }
}