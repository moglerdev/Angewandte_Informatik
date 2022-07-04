package aufgabe06.library;

import java.util.ArrayList;
import java.util.Objects;

public class Person {
    public String name;
    private ArrayList<Book> borrowedBooks = new ArrayList<Book>();

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public boolean borrow(Book book) {
        if (book.getBorrower() == null || book.getBorrower().equals(this) && borrowedBooks.contains(book) == false) {
            borrowedBooks.add(book);
            return book.borrowedBy(this);
        }
        return false;
    }

    public boolean returningBook(Book book) {
        if (book.getBorrower().equals(this)) {
            borrowedBooks.remove(book);
            return book.giveBack();
        }
        return false;
    }

    public void print() {
        System.out.printf("%s%n", name);
        for(Book book : borrowedBooks) {
            book.print();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Person person = (Person) obj;

        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
