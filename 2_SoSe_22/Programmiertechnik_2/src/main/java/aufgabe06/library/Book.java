package aufgabe06.library;

public class Book {

    private String title;
    private Person borrower = null;


    public Book(String title) {
        this.title = title;
    }

    public String getName() {
        return this.title;
    }

    public Person getBorrower(){
        return this.borrower;
    }

    public boolean borrowedBy(Person person){
        if (this.borrower == null) {
            this.borrower = person;
            person.borrow(this);
            return true;
        }
        return false;
    }

    public boolean giveBack(){
        if (borrower != null) {
            borrower = null;
            return true;
        }
        return false;
    }

    public void print() {
        System.out.printf("%s%n", title);
    }
}
