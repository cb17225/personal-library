// Matvey Volkov

// TODO: Auto-generated Javadoc
/*
 * The Class Book.
 */
public class Book extends Media {

	/** The notes. */
	private String author;

	/**
	 * Instantiates a new book.
	 *
	 * @param author the author
	 * @param title the title
	 * @param format the format
	 * @param location the location
	 * @param notes the notes
	 */
	public Book(String author, String title, String format, String location, String notes) {
		super(title, format, location, notes);
		this.author = author;
	}

	/**
	 * Gets the author.
	 *
	 * @return the author
	 */
	public String getAuthor() {
		return this.author;
	}

	/**
	 * Sets the author.
	 *
	 * @param author the new author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}


	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return "Type: " + this.getClass().getName()
				+ "\nAuthor: " + this.author
				+ "\nTitle: " + this.getTitle()
				+ "\nFormat: " + this.getFormat()
				+ "\nLocation: " + this.getLocation()
				+ "\nNotes: " + this.getNotes();
	}

}
