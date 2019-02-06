package com.company;

public class Rocket_2 extends Rocket {

    public Rocket_2() {
        cost = 120;
        rocket_weight = 18;
        max_weight = 29;
        actual_weight =rocket_weight;
    }

    @Override
    public boolean launch() {
        double fail_probability = 0.04 * (actual_weight -rocket_weight) / (max_weight -rocket_weight);
        double random = Math.random();
        return fail_probability < random;
    }

    @Override
    public boolean land() {
        double fail_probability = 0.08 * (actual_weight - rocket_weight) / (max_weight - rocket_weight);
        double random = Math.random();
        return fail_probability < random;
    }
}
