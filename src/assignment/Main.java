package assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static ArrayList<Person> persons = new ArrayList<>();

    public static void main(String[] args) {

        readFromFile(" \\| ", "pipe.txt");
        readFromFile(" ", "space.txt");
        readFromFile(", ", "comma.txt");
    }

    public static void readFromFile(String separator, String fileName) {

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line;

        try {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(separator);

                switch (separator) {
                    case " \\| ": // pipe.txt
                        // LastName | FirstName | MiddleInitial | Gender | FavoriteColor | DateOfBirth
                        //0LastName 1FirstName 2Gender 3DateOfBirth 4FavoriteColor
                        persons.add(new Person(values[0], values[1], values[3], values[5], values[4]));
                        break;

                    case " ": // space.txt
                        // LastName FirstName MiddleInitial Gender DateOfBirth FavoriteColor
                        //0LastName 1FirstName 2Gender 3DateOfBirth 4FavoriteColor
                        persons.add(new Person(values[0], values[1], values[3], values[4], values[5]));
                        break;
                    case ", ": // comma.txt
                        // LastName, FirstName, Gender, FavoriteColor, DateOfBirth
                        //0LastName 1FirstName 2Gender 3DateOfBirth 4FavoriteColor
                        persons.add(new Person(values[0], values[1], values[2], values[4], values[3]));
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
