// Jason Curcio
// TODO: Auto-generated Javadoc
/*
 * The Class Song.
 */
public class Song extends Media {

	/** The artist. */
	private String artist;
	
	/** The genre. */
	private String genre;
	
	/**
	 * Instantiates a new song.
	 *
	 * @param artist the artist
	 * @param title the title
	 * @param format the format
	 * @param location the location
	 * @param notes the notes
	 */
	public Song(String artist, String title, String genre, String format, String location, String notes) {
		super(title, format, location, notes);
		this.artist = artist;
		this.genre = genre;
	}
	
	/**
	 * Gets the artist.
	 *
	 * @return the artist
	 */
	public String getArtist() {
		return this.artist;
	}
	
	/**
	 * Sets the artist.
	 *
	 * @param artist the new artist
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	/**
	 * Gets the genre.
	 *
	 * @return the genre
	 */
	public String getGenre() {
		return this.genre;
	}
	
	/**
	 * Sets the genre.
	 *
	 * @param genre the new genre
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return "Type: " + this.getClass().getName()
				+ "\nArtist: " + this.artist
				+ "\nSong Title: " + this.getTitle()
				+ "\nGenre: " + this.getGenre()
				+ "\nFormat: " + this.getFormat()
				+ "\nLocation: " + this.getLocation()
				+ "\nNotes: " + this.getNotes();
	}
}
