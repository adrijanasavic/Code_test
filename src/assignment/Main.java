package assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static ArrayList<Person> persons = new ArrayList<>();

    public static void main(String[] args) {

        String header1 = "gender then lastname ascending";
        String divider = "--------------------------";

        readFromFile(" \\| ", "pipe.txt");
        readFromFile(" ", "space.txt");
        readFromFile(", ", "comma.txt");

        System.out.println(header1);
        System.out.println(divider);

        sortByGenderThenLastName();

        for (Person p : persons) {
            System.out.printf("%-15s %-15s %-15s %-15s %-15s %n",
                    p.getLastName(), p.getFirstName(), p.getGender(),
                    p.getDateOfBirth(), p.getFavoriteColor());
        }
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

    public static void sortByGenderThenLastName() {

        int i;

        for (int j = 1; j < persons.size(); j++) {

            Person key = persons.get(j);
            i = j - 1;

            while (i >= 0) {

                if (persons.get(i).getGender().compareTo(key.getGender()) > 0) {
                    persons.set(i + 1, persons.get(i));

                    i--;
                } else if (persons.get(i).getGender().compareTo(key.getGender()) == 0 &&
                        persons.get(i).getLastName().compareTo(key.getLastName()) > 0) {
                    persons.set(i + 1, persons.get(i));

                    i--;
                } else {
                    break;
                }
            }

            persons.set(i + 1, key);
        }
    }
}
