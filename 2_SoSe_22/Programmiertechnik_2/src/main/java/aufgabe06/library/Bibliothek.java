// O. Bittel
// 9.3.2018

package aufgabe06.library;

public class Bibliothek {

	public static void main(String[] args) {
		Book b1 = new Book("Tod auf dem Nil");
		Book b2 = new Book("Alibi");
		Book b3 = new Book("Mord im Orientexpress");
		Person p1 = new Person("Peter");
		Person p2 = new Person("Maria");
		
		System.out.println(p1.borrow(b1));				// true
		System.out.println(b2.borrowedBy(p1));			// true
		
		p1.print();	// Peter
					// Tod auf dem Nil
		
		System.out.println(p2.borrow(b1));				// false
		System.out.println(p1.returningBook(b1));		// true
		System.out.println(p2.borrow(b1));				// true
		System.out.println(b3.borrowedBy(p2));			// true
		
		p1.print();
		p2.print();
		b1.print();
		b2.print();
		b3.print();
		
		System.out.println(p1.returningBook(b1));		// false
		System.out.println(b2.giveBack());				// true
		System.out.println(p2.returningBook(b1));		// true
		System.out.println(b3.giveBack());				// true
		
		p1.print();
		p2.print();
		b1.print();
		b2.print();
		b3.print();
	}
	
}
