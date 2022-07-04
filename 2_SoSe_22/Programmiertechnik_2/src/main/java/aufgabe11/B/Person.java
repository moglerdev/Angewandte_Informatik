package aufgabe11.B;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.Comparator;

public class Person implements Comparable<Person> {
    private String firstname;
    private String lastname;
    private LocalDate birthday;

    public Person(String _firstname, String _lastname, LocalDate _birthday) {
        this.firstname = _firstname;
        this.lastname = _lastname;
        this.birthday = _birthday;
    }


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }


    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s hat Geburtstag am %s", this.firstname, this.lastname, this.birthday.toString());
    }

    @Override
    public int compareTo(@NotNull Person o) {
        return this.birthday.compareTo(o.birthday);
    }
}
