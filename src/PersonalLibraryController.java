// TODO: Auto-generated Javadoc
// Matvey Volkov

/**
 * The Class PersonalLibraryController.
 */
public class PersonalLibraryController {

	/** The model. */
	private PersonalLibraryModel model;

	/**
	 * Instantiates a new personal library controller.
	 */
	public PersonalLibraryController() {
		model = new PersonalLibraryModel();
	}

	/**
	 * Adds the book.
	 *
	 * @param author the author
	 * @param title the title
	 * @param format the format
	 * @param location the location
	 * @param notes the notes
	 * @return true, if successful
	 */
	public void addBook(String author, String title, String format, String location, String notes) {
		Book newBook = new Book(author, title, format, location, notes);
		model.addMedia(newBook);
	}

	/**
	 * Adds the song.
	 *
	 * @param artist the artist
	 * @param title the title
	 * @param genre the genre
	 * @param format the format
	 * @param location the location
	 * @param notes the notes
	 * @return true, if successful
	 */
	public void addSong(String artist, String title, String genre, String format, String location, String notes) {
		Song newSong = new Song(artist, title, genre, format, location, notes);
		model.addMedia(newSong);
	}

	/**
	 * Adds the video.
	 *
	 * @param title the title
	 * @param star the star
	 * @param format the format
	 * @param location the location
	 * @param notes the notes
	 * @return true, if successful
	 */
	public void addVideo(String title, String star, String format, String location, String notes) {
		Video newVideo = new Video(title, star, format, location, notes);
		model.addMedia(newVideo);
	}

	/**
	 * Adds the video game.
	 *
	 * @param title the title
	 * @param format the format
	 * @param location the location
	 * @param notes the notes
	 * @return true, if successful
	 */
	public void addVideoGame(String title, String format, String location, String notes) {
		VideoGame newVideoGame = new VideoGame(title, format, location, notes);
		model.addMedia(newVideoGame);
	}

	/**
	 * Gets the media list.
	 *
	 * @return the media list
	 */
	public String[] getMediaList() {
		return model.toStringArray();
	}

	/**
	 * Search by title.
	 *
	 * @param title the title
	 * @return the string[]
	 */
	public String[] searchByTitle(String title) {
		return model.getAllWithTitle(title);
	}

	/**
	 * Search by type.
	 *
	 * @param type the type
	 * @return the string[]
	 */
	public String[] searchByType(String type) {
		return model.getAllOfType(type);
	}

	/**
	 * Search by title and type.
	 *
	 * @param title the title
	 * @param type the type
	 * @return the string[]
	 */
	public String[] searchByTitleAndType(String title, String type) {
		return model.getAllWithTitleAndType(title, type);
	}

	/**
	 * Request delete media.
	 *
	 * @param index the index
	 * @return the string[]
	 */
	public String[] requestDeleteMedia(int index) {
		return model.deleteMedia(index);
	}
	
	/**
	 * Clear media list.
	 */
	public void clearMediaList() {
		model.clear();
	}
}
