package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Function;

public class Simulation {
    final String filename_1 = "phase-1.txt";
    final String filename_2 = "phase-2.txt";
    private int item_weight;

    ArrayList<Item> loadItems2() {
        return loadItemsFromFile(filename_2);
    }

    ArrayList<Item> loadItemsFromFile(String filename) {
        File file = new File(filename);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (Exception e) {
            System.err.println("ERROR: Can't open file.");
            System.exit(1);
        }

        scanner.useDelimiter("\n");
        ArrayList<Item> item_list = new ArrayList<>();
        while (scanner.hasNext()) {
            String line = scanner.next();
            int delimiter_index = line.indexOf('=');
            int item_weight = 0;
            try {
                item_weight = Integer.parseInt(line.substring(delimiter_index + 1));
            } catch (NumberFormatException e) {
                System.err.println("Wrong format, Item will be ignored");
            }

            String item_name = line.substring(0, delimiter_index);

            item_list.add(new Item(item_name, item_weight / 1000));
        }
        return item_list;


    }
    ArrayList<Item> loadItems1() {
        return loadItemsFromFile(filename_1);
        }

    ArrayList<Rocket> loadU1(ArrayList<Item> items) {
        return loadRocket(items, TypesOfRocket.ROCKET_1);
    }

    ArrayList<Rocket> loadU2(ArrayList<Item> items) {
        return loadRocket(items, TypesOfRocket.ROCKET_2);
    }

    private ArrayList<Rocket> loadRocket(ArrayList<Item> items, TypesOfRocket type) {
        ArrayList<Rocket> rockets_list = new ArrayList<>();

        addNewRocket(type, rockets_list);

        int i = 0;

        for (Item item : items) {

            if (rockets_list.get(i).canCarry(item)) {
                rockets_list.get(i).carry(item);
            } else {
                i++;

                addNewRocket(type, rockets_list);
                //every item has to weight less than space's carrying capacity
                rockets_list.get(i).carry(item);
            }

        }
        return rockets_list;
    }

    private void addNewRocket(TypesOfRocket type, ArrayList<Rocket> rockets_list) {
        if (type == TypesOfRocket.ROCKET_1) {
            rockets_list.add(new Rocket_1());
        } else {
            rockets_list.add(new Rocket_2());
        }
    }

    int runSimulation(ArrayList<Rocket> rockets_list) {
        int budget = 0;

        budget = simulateAction(rockets_list, budget, Rocket::launch);
        budget = simulateAction(rockets_list, budget, Rocket::land);

        return budget;
    }

    private int simulateAction(ArrayList<Rocket> rockets_list, int budget, Function<Rocket, Boolean> action) {
        for (Rocket rocket : rockets_list) {
            if (!action.apply(rocket)) {
                budget += rocket.cost;
                while (!action.apply(rocket)) {
                    budget += rocket.cost;
                }
            }
            budget += rocket.cost;
        }
        return budget;
    }

}
