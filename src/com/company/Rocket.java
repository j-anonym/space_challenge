package com.company;

public class Rocket implements SpaceShipInterface {

    int cost;
    int rocket_weight;
    int max_weight;
    int actual_weight;

    public boolean launch() {
        return true;
    }

    public boolean land() {
        return true;
    }

    public boolean canCarry(Item item) {
        return (actual_weight + item.getWeight()) <= max_weight;
    }

    public void carry(Item item) {
        setActualWeight(actual_weight + item.getWeight());
    }

    public void setActualWeight(int actual_weight) {
        this.actual_weight = actual_weight;
    }
}
