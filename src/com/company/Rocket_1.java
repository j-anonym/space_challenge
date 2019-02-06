package com.company;

public class Rocket_1 extends Rocket {

    public Rocket_1() {
        cost = 100;
        rocket_weight = 10;
        max_weight = 18;
        actual_weight =rocket_weight;
    }

    @Override
    public boolean launch() {
        double fail_probability = 0.05 * (actual_weight -rocket_weight) / (max_weight -rocket_weight);
        double random = Math.random();
        return fail_probability < random;
    }

    @Override
    public boolean land() {
        double fail_probability = 0.01 * (actual_weight - rocket_weight) / (max_weight - rocket_weight);
        double random = Math.random();
        return fail_probability < random;
    }
}
