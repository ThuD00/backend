package c22.listhandling.domain;

//konstruktori
public class Student {
    private String firstName;
    private String lastName;

    //Parametrillinen
    public Student(String firstname, String lastName) {
        this.firstName = firstname;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
