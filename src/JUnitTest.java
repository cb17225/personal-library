import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JUnitTest {

	private PersonalLibraryController controller = new PersonalLibraryController();
	private String[] array;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {

		String[] results, real;
		Book book = new Book("a", "b", "c", "d", "e");
		Song song = new Song("a", "d", "c", "b", "e", "f");
		Video video = new Video("e", "b", "c", "d", "a");
		VideoGame videoGame = new VideoGame("a", "c", "b", "d");
		
		// Case 1

		// Do not have to test failed deletion (GUI-related)

		// Successful addition

		controller.addBook("a", "b", "c", "d", "e");
		controller.addSong("a", "d", "c", "b", "e", "f");
		controller.addVideo("e", "b", "c", "d", "a");
		controller.addVideoGame("a", "c", "b", "d");
		array = new String[] {book.toString(), song.toString(), 
				video.toString(), videoGame.toString()};

		results = controller.getMediaList();
		for (int i = 0; i < results.length; i++) {
			assertTrue(results[i].equals(array[i]));
		}

		// Case 3
		
		real = new String[] {book.toString(), video.toString()};
		results = controller.searchByTitle("b");
		for (int i = 0; i < results.length; i++) {
			assertTrue(results[i].equals(real[i]));
		}
		
		assertTrue(controller.searchByTitle("bc").length == 0);
		
		// Do not have to test flags (GUI-related)

		// Case 4

		results = controller.searchByType("book");
		for (int i = 0; i < results.length; i++) {
			assertTrue(book.toString().equals(results[i]));
		}
		
		assertTrue(controller.searchByType("Test").length == 0);
		
		// Do not have to test flags (GUI-related)

		// Case 5
		
		controller.addBook("a", "c", "b", "d", "e");
		
		results = controller.searchByTitleAndType("c", "book");
		for (int i = 0; i < results.length; i++) {
			assertTrue((new Book("a", "c", "b", "d", "e")).toString().equals(results[i]));
		}
		
		assertTrue(controller.searchByTitleAndType("bc", "Test").length == 0);
		
		// Do not have to test flags (GUI-related)

		// Case 6
		controller.clearMediaList();
		
		controller.addBook("a", "b", "c", "d", "e");
        controller.addSong("a", "b", "c", "d", "e", "f");
        real = controller.searchByTitle("b");
        System.out.println(real[0]);
        real = controller.requestDeleteMedia(0);
        System.out.println(real[0]);
        String[] test = new String[2];
        test[0] = new Song("a", "b", "c", "d", "e", "f").toString();
        assertTrue(real[0].equals(test[0]));
        assertTrue(controller.requestDeleteMedia(0).length == 0);


	}

}
