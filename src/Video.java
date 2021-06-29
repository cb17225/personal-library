
// Jason Curcio
// TODO: Auto-generated Javadoc
/*
 * The Class Video.
 */
public class Video extends Media {

	/** The star. */
	private String star;
	
	/**
	 * Instantiates a new video.
	 *
	 * @param artist the artist
	 * @param title the title
	 * @param format the format
	 * @param location the location
	 * @param notes the notes
	 */
	public Video(String title, String star, String format, String location, String notes) {
		super(title, format, location, notes);
		this.star = star;
	}

	/**
	 * Gets the star.
	 *
	 * @return the star
	 */
	public String getStar() {
		return this.star;
	}
	
	/**
	 * Sets the star.
	 *
	 * @param star the new star
	 */
	public void setStar(String star) {
		this.star = star;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return "Type: " + this.getClass().getName()
				+ "\nTitle: " + this.getTitle()
				+ "\nStars: " + this.getStar()
				+ "\nFormat: " + this.getFormat()
				+ "\nLocation: " + this.getLocation()
				+ "\nNotes: " + this.getNotes();
	}
	
}
