package ru.netology.data;

import com.github.javafaker.Faker;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;


public class DataGenerator {
    private static final Faker faker = new Faker(new Locale("ru"));
    static String city;

    public static String generateCity() throws IOException {
        ArrayList<String> arrayList = new ArrayList<String>();
        File file = new File("city.txt");
        InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line = br.readLine()) != null) {
            arrayList.add(line);
        }
        int size = arrayList.size();
        int randomCityNum = new Random().nextInt(size);
        return String.valueOf(arrayList.get(randomCityNum));
    }

    public static String generateName() {
        String name = faker.name().name();
        String newName = name.replace("ё", "е");
        return newName;
    }

    public static String generatePhone() {
        return faker.number().digits(11);
    }
}