package assignment;

public class Person {

    private String lastName;
    private String firstName;
    private String gender;
    private String dateOfBirth;
    private String favoriteColor;


    public Person(String lastName, String firstName, String gender, String dateOfBirth, String color) {
        super();
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.favoriteColor = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFavoriteColor() {
        return favoriteColor;
    }

    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }

    @Override
    public String toString() {

        return "" + lastName + ", " + firstName + " " + gender + " " + dateOfBirth + " " + favoriteColor;
    }
}
