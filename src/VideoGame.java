// Jason Curcio
// TODO: Auto-generated Javadoc
/*
 * The Class VideoGame.
 */
public class VideoGame extends Media {

	/**
	 * Instantiates a new video game.
	 *
	 * @param artist the artist
	 * @param title the title
	 * @param format the format
	 * @param location the location
	 * @param notes the notes
	 */
	public VideoGame(String title, String format, String location, String notes) {
		super(title, format, location, notes);
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return "Type: " + this.getClass().getName()
				+ "\nTitle: " + this.getTitle()
				+ "\nFormat: " + this.getFormat()
				+ "\nLocation: " + this.getLocation()
				+ "\nNotes: " + this.getNotes();
	}

}
