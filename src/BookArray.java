import java.util.ArrayList;

public class BookArray {
	private static ArrayList<Book> libraryBooks;
	public static void main(String[] args) {
		libraryBooks = new ArrayList<>();
		addBook(new Book("Fahrenheit 451"));
		addBook(new Book("The Thorn Birds"), 1);
		addBook(new Book("The Art of Computer Programming"), 1);
		
		System.out.println(findByTitle("The Thorn Birds"));
		swapBook("The Thorn Birds", new Book("Dandelion Wine"));
		
		System.out.println(libraryBooks.toString());
	}
	
	// Adding to the beginning
	public static void addBook(Book book) {
		libraryBooks.add(0, book);
	}
	// Adding to a set position
	public static void addBook(Book book, int index) {
		try{
			libraryBooks.add(index, book);
		}catch(IndexOutOfBoundsException e) {
			System.err.println("There is no such place for the book!");
		}
	}
	// Changing the title
	public static void updateTitle(String newTitle, int index) {
		try {
			libraryBooks.get(index).setTitle(newTitle);
		}catch(IndexOutOfBoundsException e) {
			System.err.println("ELEMENT WITH INDEX "+ index + " DOESN'T EXIST!");
		}	
	}
	
	// Deleting the book
	public static void deleteBook(int index) {
		try{
			libraryBooks.remove(index);
		}catch(IndexOutOfBoundsException e) {
			System.err.println("ELEMENT WITH INDEX "+ index + " DOESN'T EXIST!");
		}
	}

	//Finding by title
	public static int findByTitle(String title) {
		
		for( Book i : libraryBooks) {
			if(i.getTitle().equals(title))
				return libraryBooks.indexOf(i);			
		}
		System.err.println("Boook wasn't found!");
		return -1;
	}
	
	// Swap two books
	public static void swapBook(String title, Book newBook) {
		int i = findByTitle(title);
		if(i != -1)
			libraryBooks.set(i, newBook);
	}	
}
	

