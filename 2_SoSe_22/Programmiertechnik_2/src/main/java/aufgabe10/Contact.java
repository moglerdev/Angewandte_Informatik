package aufgabe10;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class Contact implements Comparable<Contact> {

    public Contact(String line) {
        var v = line.split(";");
        if (v.length < 3) {
            v = line.split(" ");
        }
        this.name = v[0];
        this.addOn = v[1];
        this.phoneNr = v[2];
    }

    public Contact(String name, String addOn, String phoneNr) {
        this.name = name;
        this.addOn = addOn;
        this.phoneNr = phoneNr;
    }

    private final String name;
    public String getName() { return this.name; }
    private final String addOn;
    public String getAddOn() { return this.addOn; }
    private final String phoneNr;
    public String getPhoneNrs() { return this.name; }

    @Override
    public int compareTo(@NotNull Contact o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        return Objects.equals(name, contact.name);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (addOn != null ? addOn.hashCode() : 0);
        result = 31 * result + (phoneNr != null ? phoneNr.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s\t%s\t%s", this.name, this.addOn, this.phoneNr);
    }

    public String toString(String separator) {
        return String.format("%s%s%s%s%s",
                this.name,
                separator,
                this.addOn,
                separator,
                this.phoneNr);
    }
}
