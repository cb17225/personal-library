// Matvey Volkov
import java.util.Comparator;

/**
 * The Class Media.
 */
public class Media implements Comparable<Media>, Comparator<Media> {
	
/** The notes. */
private String title, format, location, notes;
	
	/**
	 * Instantiates a new media.
	 *
	 * @param title the title
	 * @param format the format
	 * @param location the location
	 * @param notes the notes
	 */
	public Media(String title, String format, String location, String notes) {
		this.title = title;
		this.format = format;
		this.location = location;
		this.notes = notes;
	}

	// These may be helpful for use cases 3-5...
	/**
	 * Compare.
	 *
	 * @param o1 the o 1
	 * @param o2 the o 2
	 * @return the int
	 */
	// Ignore for use cases 1,2
	@Override
	public int compare(Media o1, Media o2) {
		int priorityValue = o1.getClass().getName().compareTo(o2.getClass().getName()) * -1;
		if (priorityValue == 0) {	
			return o1.getTitle().compareToIgnoreCase(o2.getTitle()) * -1;
		} else {
			return priorityValue;
		}
	}

	/**
	 * Compare to.
	 *
	 * @param o the o
	 * @return the int
	 */
	@Override
	public int compareTo(Media o) {
		return this.compare(this, o);
	}
	
	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return this.title;
	}


	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * Gets the format.
	 *
	 * @return the format
	 */
	public String getFormat() {
		return this.format;
	}


	/**
	 * Sets the format.
	 *
	 * @param format the new format
	 */
	public void setFormat(String format) {
		this.format = format;
	}


	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public String getLocation() {
		return this.location;
	}


	/**
	 * Sets the location.
	 *
	 * @param location the new location
	 */
	public void setLocation(String location) {
		this.location = location;
	}


	/**
	 * Gets the notes.
	 *
	 * @return the notes
	 */
	public String getNotes() {
		return this.notes;
	}


	/**
	 * Sets the notes.
	 *
	 * @param notes the new notes
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

}
