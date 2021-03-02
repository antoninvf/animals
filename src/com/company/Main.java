package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<String[]> animals = new ArrayList<>();
        ArrayList<String[]> animal_types = new ArrayList<>();
        ArrayList<String[]> people = new ArrayList<>();

        //Reading
        try {
            BufferedReader br_animals = new BufferedReader(new FileReader("animals.csv"));
            BufferedReader br_animaltypes = new BufferedReader(new FileReader("animal_types.csv"));
            BufferedReader br_people = new BufferedReader(new FileReader("people.csv"));

            String nextLine_animals = br_animals.readLine();
            String nextLine_animaltypes = br_animaltypes.readLine();
            String nextLine_people = br_people.readLine();

            while (nextLine_animals != null) {
                String[] row = nextLine_animals.split(";");
                animals.add(row);
                nextLine_animals = br_animals.readLine();
            }

            while (nextLine_animaltypes != null) {
                String[] row = nextLine_animaltypes.split(";");
                animals.add(row);
                nextLine_animaltypes = br_animaltypes.readLine();
            }

            while (nextLine_people != null) {
                String[] row = nextLine_people.split(";");
                animals.add(row);
                nextLine_people = br_people.readLine();
            }

            br_animals.close();
            br_animaltypes.close();
            br_people.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        AnimalInfo animalInfo = new AnimalInfo();
        for (int i = 0; i < animals.size(); i++) {
            animalInfo.id = Integer.parseInt(animals.get(i)[0]);
            animalInfo.type = animals.get(i)[1];
        }
    }
}
