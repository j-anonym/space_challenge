package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Simulation simulation = new Simulation();

        ArrayList<Item> items_1 = simulation.loadItems1();
        ArrayList<Item> items_2 = simulation.loadItems2();

        int budget;
        System.out.println("------------SIMULATION OF EXPEDITION TO MARS------------");
        budget = simulation.runSimulation(simulation.loadU1(items_1));
        System.out.println("::::::::::FIRST ROCKET::::COSTS OF FIRST CARGO\n" + budget);
        budget = simulation.runSimulation(simulation.loadU1(items_2));
        System.out.println("::::::::::FIRST ROCKET::::COSTS OF SECOND CARGO\n" + budget);

        budget = simulation.runSimulation(simulation.loadU2(items_1));
        System.out.println("::::::::::SECOND ROCKET::::COSTS OF FIRST CARGO\n" + budget);

        budget = simulation.runSimulation(simulation.loadU2(items_2));
        System.out.println("::::::::::SECOND ROCKET::::COSTS OF SECOND CARGO\n" + budget);

    }
}
