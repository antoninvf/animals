package com.company;

import java.io.*;
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
            br_animals.close();

            while (nextLine_animaltypes != null) {
                String[] row = nextLine_animaltypes.split(";");
                animal_types.add(row);
                nextLine_animaltypes = br_animaltypes.readLine();
            }
            br_animaltypes.close();

            while (nextLine_people != null) {
                String[] row = nextLine_people.split(";");
                people.add(row);
                nextLine_people = br_people.readLine();
            }
            br_people.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("ANIMAL_NAME;ANIMAL_TYPE;GENDER");
        AnimalInfo animalInfo = new AnimalInfo();
        for (int i = 1; i < animals.size(); i++) {
            animalInfo.id = Integer.parseInt(animals.get(i)[0]);
            animalInfo.type = Integer.parseInt(animals.get(i)[1]);
            animalInfo.name = animals.get(i)[2];
            animalInfo.age = Integer.parseInt(animals.get(i)[3]);
            animalInfo.gender = animals.get(i)[4];
            animalInfo.is_agressive = animals.get(i)[5];

            for (int j = 1; j < animal_types.size(); j++) {
                animalInfo.type_id = Integer.parseInt(animal_types.get(j)[0]);
                animalInfo.animal = animal_types.get(j)[1];
            }

            for (int k = 1; k < people.size(); k++) {
                animalInfo.people_id = Integer.parseInt(people.get(k)[0]);
                animalInfo.full_name = people.get(k)[1];
                animalInfo.people_age = Integer.parseInt(people.get(k)[2]);
                animalInfo.people_gender = people.get(k)[3];
            }

            String currentAnimal = animal_types.get(animalInfo.type+1)[1];

            System.out.println(animalInfo.name + "; " + currentAnimal + "; " + animalInfo.gender);
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter("ukol1.txt", true));
                bw.write(animalInfo.name + ";" + currentAnimal + ";" + animalInfo.gender);
                bw.newLine();
                bw.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
