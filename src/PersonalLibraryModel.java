// Matvey Volkov

import java.util.*;
import java.util.stream.IntStream;

// TODO: Auto-generated Javadoc
/**
 * The Class PersonalLibraryModel.
 */
public class PersonalLibraryModel {

	/** The media list. */
	private List<Media> mediaList, mostRecentSearchResults;

	/**
	 * Instantiates a new personal library model.
	 */
	public PersonalLibraryModel() {
		mediaList = new ArrayList<>();
		mostRecentSearchResults = new ArrayList<>();
	}

	/**
	 * Adds the media.
	 *
	 * @param m the m
	 * @return true, if successful
	 */
	public void addMedia(Media m) {
		mediaList.add(m);
		this.sortByTypeAndTitle();
	}

	/**
	 * Sort by type and title.
	 */
	public void sortByTypeAndTitle() {
		if (mediaList.size() <= 1) {
			return;
		}

		Media newestElement = mediaList.get(mediaList.size() - 1);

		for (int i = 0; i < mediaList.size(); i++) {
			if (newestElement.compareTo(mediaList.get(i)) >= 0 
					&& !newestElement.equals(mediaList.get(i))) {

				mediaList.add(i, newestElement);
				mediaList.remove(mediaList.size() - 1);
				return;
			}
		}
	}

	/**
	 * Creates string array of the Media list.
	 *
	 * @return the string[]
	 */
	public String[] toStringArray() {
		String[] list = IntStream.range(0, mediaList.size())
				.mapToObj(i -> mediaList.get(i).toString())
				.toArray(String[]::new);
		return list;
	}

	/**
	 * Gets the all with title.
	 *
	 * @param title the title
	 * @return the all with title
	 */
	public String[] getAllWithTitle(String title) {
		mostRecentSearchResults.clear();
		for (int i = 0; i < mediaList.size(); i++) {
			if (mediaList.get(i).getTitle().equalsIgnoreCase(title)) {
				mostRecentSearchResults.add(mediaList.get(i));
			}
		}

		return convertSearchToArray();

	}
	
	/**
	 * Gets the all of type.
	 *
	 * @param type the type
	 * @return the all of type
	 */
	public String[] getAllOfType(String type) {
		mostRecentSearchResults.clear();
		for (int i = 0; i < mediaList.size(); i++) {
			if (mediaList.get(i).getClass().getName().equalsIgnoreCase(type)) {
				mostRecentSearchResults.add(mediaList.get(i));
			}
		}

		return convertSearchToArray();
	}

	/**
	 * Gets the all with title and type.
	 *
	 * @param title the title
	 * @param type the type
	 * @return the all with title and type
	 */
	public String[] getAllWithTitleAndType(String title, String type) {
		mostRecentSearchResults.clear();
		for (int i = 0; i < mediaList.size(); i++) {
			if (mediaList.get(i).getTitle().equalsIgnoreCase(title) &&
				mediaList.get(i).getClass().getName().equalsIgnoreCase(type)) {
				
				mostRecentSearchResults.add(mediaList.get(i));
			}
		}

		return convertSearchToArray();
	}

	/**
	 * Delete media.
	 *
	 * @param index the index
	 * @return the string[]
	 */
	public String[] deleteMedia(int index) {
		Media removedItem = mostRecentSearchResults.remove(index);
		mediaList.remove(removedItem);
		
		return convertSearchToArray();
	}

	/**
	 * Convert search to array.
	 *
	 * @return the string[]
	 */
	private String[] convertSearchToArray() {
		String[] stringArrayOfSearchResults = IntStream.range(0, mostRecentSearchResults.size())
				.mapToObj(i -> mostRecentSearchResults.get(i).toString())
				.toArray(String[]::new);
		return stringArrayOfSearchResults; 
	}
	
	/**
	 * Clear.
	 */
	public void clear() {
		mediaList.clear();
	}
}
