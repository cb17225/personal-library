// Jason Curcio

import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// TODO: Auto-generated Javadoc
/**
 * The Class PersonalLibraryGUI.
 */
public class PersonalLibraryGUI extends Application {
	
	/** The main. */
	private BorderPane main = new BorderPane();
	
	/** The book entry. */
	private BorderPane bookEntry = new BorderPane();
	
	/** The song entry. */
	private BorderPane songEntry = new BorderPane();
	
	/** The video entry. */
	private BorderPane videoEntry = new BorderPane();
	
	/** The videogame entry. */
	private BorderPane videogameEntry = new BorderPane();
	
	/** The lib data. */
	private BorderPane libData = new BorderPane();
	
	/** The search data. */
	private BorderPane searchData = new BorderPane();
	
	/** The controller. */
	private static PersonalLibraryController controller = new PersonalLibraryController();

	/** The book. */
	private Button book;
	
	/** The song. */
	private Button song;
	
	/** The video. */
	private Button video;
	
	/** The videogame. */
	private Button videogame;
	
	/** The view lib. */
	private Button viewLib;

	/** The tf author. */
	private TextField tfAuthor;
	
	/** The tf song title. */
	private TextField tfSongTitle;
	
	/** The tf book title. */
	private TextField tfBookTitle;
	
	/** The tf video title. */
	private TextField tfVideoTitle;
	
	/** The tf videogame title. */
	private TextField tfVideogameTitle;
	
	/** The tf artist. */
	private TextField tfArtist;
	
	/** The tf genre. */
	private TextField tfGenre;
	
	/** The tf star. */
	private TextField tfStar;
	
	/** The tf book format. */
	private TextField tfBookFormat;
	
	/** The tf song format. */
	private TextField tfSongFormat;
	
	/** The tf video format. */
	private TextField tfVideoFormat;
	
	/** The tf videogame format. */
	private TextField tfVideogameFormat;
	
	/** The tf book location. */
	private TextField tfBookLocation;
	
	/** The tf song location. */
	private TextField tfSongLocation;
	
	/** The tf video location. */
	private TextField tfVideoLocation;
	
	/** The tf videogame location. */
	private TextField tfVideogameLocation;
	
	/** The tf book notes. */
	private TextField tfBookNotes;
	
	/** The tf song notes. */
	private TextField tfSongNotes;
	
	/** The tf video notes. */
	private TextField tfVideoNotes;
	
	/** The tf videogame notes. */
	private TextField tfVideogameNotes;
	
	/** The tf search type. */
	private TextField tfSearchType;
	
	/** The tf search title. */
	private TextField tfSearchTitle;

	/** The lv. */
	private ListView<String> lv;

	/**
	 * Start.
	 *
	 * @param primaryStage the primary stage
	 * @throws Exception the exception
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(main, 400, 500);
		Scene scene2 = new Scene(bookEntry, 400, 500);
		Scene scene3 = new Scene(songEntry, 400, 500);
		Scene scene4 = new Scene(videoEntry, 400, 500);
		Scene scene5 = new Scene(videogameEntry, 400, 500);
		Scene scene6 = new Scene(libData, 400, 500);
		Scene scene7 = new Scene(searchData, 400, 500);

		main.setTop(new Label("Personal Library Entry Selection"));


		book = new Button("Enter for book");
		book.setOnAction(e -> primaryStage.setScene(scene2));

		song = new Button("Enter for song");
		song.setOnAction(e -> primaryStage.setScene(scene3));

		video = new Button("Enter for video");
		video.setOnAction(e -> primaryStage.setScene(scene4));

		videogame = new Button("Enter for videogame");
		videogame.setOnAction(e -> primaryStage.setScene(scene5));

		viewLib = new Button("View Library");
		viewLib.setOnAction(e -> {
			if (viewLibraryDB()) {
				primaryStage.setScene(scene6);
			}	
		});


		VBox btnBox = new VBox(15);
		btnBox.getChildren().addAll(book, song, video, videogame, viewLib);
		main.setLeft(btnBox);


		// setting scene 2
		bookEntry.setTop(new Label("Book Entry"));
		createAndAddBookGridPane();
		HBox bookBtnBox = new HBox(15);

		Button back1 = new Button("Back");
		back1.setOnAction(e -> primaryStage.setScene(scene));

		Button addBookMedia = new Button("Add Book");
		addBookMedia.setOnAction(e -> checkDataAddBookMedia());

		bookBtnBox.getChildren().addAll(back1, addBookMedia);
		bookEntry.setBottom(bookBtnBox);


		// setting scene 3
		songEntry.setTop(new Label("Song Entry"));
		createAndAddSongGridPane();
		HBox songBtnBox = new HBox(15);

		Button back2 = new Button("Back");
		back2.setOnAction(e -> primaryStage.setScene(scene));

		Button addSongMedia = new Button("Add Song");
		addSongMedia.setOnAction(e -> checkDataAddSongMedia());

		songBtnBox.getChildren().addAll(back2, addSongMedia);
		songEntry.setBottom(songBtnBox);


		// setting scene 4
		videoEntry.setTop(new Label("Video Entry"));
		createAndAddVideoGridPane();
		HBox videoBtnBox = new HBox(15);

		Button back3 = new Button("Back");
		back3.setOnAction(e -> primaryStage.setScene(scene));

		Button addVideoMedia = new Button("Add Video");
		addVideoMedia.setOnAction(e -> checkDataAddVideoMedia());

		videoBtnBox.getChildren().addAll(back3, addVideoMedia);
		videoEntry.setBottom(videoBtnBox);


		// setting scene 5
		videogameEntry.setTop(new Label("Videogame Entry"));
		createAndAddVideogameGridPane();
		HBox videogameBtnBox = new HBox(15);

		Button back4 = new Button("Back");
		back4.setOnAction(e -> primaryStage.setScene(scene));

		Button addVideogameMedia = new Button("Add Videogame");
		addVideogameMedia.setOnAction(e -> checkDataAddVideogameMedia());

		videogameBtnBox.getChildren().addAll(back4, addVideogameMedia);
		videogameEntry.setBottom(videogameBtnBox);


		// setting scene 6
		Button back5 = new Button("Back");
		back5.setOnAction(e -> primaryStage.setScene(scene));

		Button openSearchWindow = new Button("Search");
		openSearchWindow.setOnAction(e -> {createAndAddSearchGridPane();
		primaryStage.setScene(scene7);
		});


		HBox viewBtnBox = new HBox(15);
		viewBtnBox.getChildren().addAll(back5, openSearchWindow);
		libData.setBottom(viewBtnBox);


		// setting scene 7
		searchData.setTop(new Label("Search Library Entries"));
		createAndAddSearchGridPane();
		HBox searchDataBtnBox = new HBox(15);

		Button delete = new Button("Delete");
		delete.setVisible(false);
		delete.setOnAction(e -> {
			if (lv.getSelectionModel().getSelectedIndex() == -1) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setHeaderText("Delete Media Failed!");
				alert.setContentText("No elements were selected");
				alert.showAndWait();
			} else {
				lv = new ListView<>(FXCollections.observableArrayList(controller.requestDeleteMedia(lv.getSelectionModel().getSelectedIndex())));
				lv.setPrefWidth(400);
				searchData.setCenter(new ScrollPane(lv));
			}
		});

		Button search = new Button("Search");
		search.setOnAction(e -> {
			if (checkDataSearchMedia()) {
				primaryStage.setScene(scene7);
				search.setVisible(false);
				delete.setVisible(true);
			}		
		});

		Button back6 = new Button("Back");
		back6.setOnAction(e -> {
			primaryStage.setScene(scene6);
			String[] libDataStr = controller.getMediaList();
			lv = new ListView<>(FXCollections.observableArrayList(libDataStr));
			lv.setPrefWidth(400);
			libData.setCenter(new ScrollPane(lv));
			search.setVisible(true);
			delete.setVisible(false);
		});

		searchDataBtnBox.getChildren().addAll(back6, search, delete);
		searchData.setBottom(searchDataBtnBox);




		// show
		primaryStage.setTitle("Personal Library");
		primaryStage.setScene(scene);
		primaryStage.show();
	}


	/**
	 * Creates the and add book grid pane.
	 */
	private void createAndAddBookGridPane() {
		GridPane gp = new GridPane();

		Label lblAuthor = new Label("Author: ");
		Label lblTitle = new Label("Title: ");
		Label lblFormat = new Label("Format: ");
		Label lblLocation = new Label("Location: ");
		Label lblNotes = new Label("Notes: ");

		tfAuthor = new TextField();
		tfBookTitle = new TextField();
		tfBookFormat = new TextField();
		tfBookLocation = new TextField();
		tfBookNotes = new TextField();

		gp.add(lblAuthor,0, 0);
		gp.add(lblTitle,0,1);
		gp.add(lblFormat,0, 2);
		gp.add(lblLocation,0,3);
		gp.add(lblNotes,0,4);

		gp.add(tfAuthor,1, 0);
		gp.add(tfBookTitle,1, 1);
		gp.add(tfBookFormat,1, 2);
		gp.add(tfBookLocation,1,3);
		gp.add(tfBookNotes,1,4);
		bookEntry.setCenter(gp);
	}

	/**
	 * Check data add book media.
	 */
	private void checkDataAddBookMedia() {
		if (tfBookTitle.getText().isEmpty()) {
			// something is blank
			Alert alert = new Alert(AlertType.WARNING);
			alert.setHeaderText("Add Media Failed!");
			alert.setContentText("Make sure that the title field is populated");
			alert.showAndWait();
		}
		else {
			controller.addBook(tfAuthor.getText(), tfBookTitle.getText(), tfBookFormat.getText(), tfBookLocation.getText(), tfBookNotes.getText());
			clearTextFields();
		}
	}

	/**
	 * Creates the and add song grid pane.
	 */
	private void createAndAddSongGridPane() {
		GridPane gp = new GridPane();

		Label lblArtist = new Label("Artist: ");
		Label lblTitle = new Label("Song Title: ");
		Label lblGenre = new Label("Genre: ");
		Label lblFormat = new Label("Format: ");
		Label lblLocation = new Label("Location: ");
		Label lblNotes = new Label("Notes: ");

		tfArtist = new TextField();
		tfSongTitle = new TextField();
		tfGenre = new TextField();
		tfSongFormat = new TextField();
		tfSongLocation = new TextField();
		tfSongNotes = new TextField();

		gp.add(lblArtist,0, 0);
		gp.add(lblTitle,0,1);
		gp.add(lblGenre, 0, 2);
		gp.add(lblFormat,0, 3);
		gp.add(lblLocation,0,4);
		gp.add(lblNotes,0,5);

		gp.add(tfArtist,1, 0);
		gp.add(tfSongTitle,1, 1);
		gp.add(tfGenre, 1, 2);
		gp.add(tfSongFormat,1, 3);
		gp.add(tfSongLocation,1,4);
		gp.add(tfSongNotes,1,5);
		songEntry.setCenter(gp);
	}

	/**
	 * Check data add song media.
	 */
	private void checkDataAddSongMedia() {
		if (tfSongTitle.getText().isEmpty()) {
			// something is blank
			Alert alert = new Alert(AlertType.WARNING);
			alert.setHeaderText("Add Media Failed!");
			alert.setContentText("Make sure that the title field is populated");
			alert.showAndWait();
		} else {
			controller.addSong(tfArtist.getText(), tfSongTitle.getText(), tfGenre.getText(), tfSongFormat.getText(), tfSongLocation.getText(),
					tfSongNotes.getText());
			clearTextFields();
		}
	}

	/**
	 * Creates the and add video grid pane.
	 */
	private void createAndAddVideoGridPane() {
		GridPane gp = new GridPane();

		Label lblTitle = new Label("Video Title: ");
		Label lblStar = new Label("Star: ");
		Label lblFormat = new Label("Format: ");
		Label lblLocation = new Label("Location: ");
		Label lblNotes = new Label("Notes: ");

		tfVideoTitle = new TextField();
		tfStar = new TextField();
		tfVideoFormat = new TextField();
		tfVideoLocation = new TextField();
		tfVideoNotes = new TextField();

		gp.add(lblTitle,0, 0);
		gp.add(lblStar,0,1);
		gp.add(lblFormat,0, 2);
		gp.add(lblLocation,0,3);
		gp.add(lblNotes,0,4);

		gp.add(tfVideoTitle,1, 0);
		gp.add(tfStar,1, 1);
		gp.add(tfVideoFormat,1, 2);
		gp.add(tfVideoLocation,1,3);
		gp.add(tfVideoNotes,1,4);
		videoEntry.setCenter(gp);
	}

	/**
	 * Check data add video media.
	 */
	private void checkDataAddVideoMedia() {
		if (tfVideoTitle.getText().isEmpty()) {
			// something is blank
			Alert alert = new Alert(AlertType.WARNING);
			alert.setHeaderText("Add Media Failed!");
			alert.setContentText("Make sure that the title field is populated");
			alert.showAndWait();
		} 
		else {
			controller.addVideo(tfVideoTitle.getText(), tfStar.getText(), tfVideoFormat.getText(), tfVideoLocation.getText(),
					tfVideoNotes.getText());
			clearTextFields();
		}
	}

	/**
	 * Creates the and add videogame grid pane.
	 */
	private void createAndAddVideogameGridPane() {
		GridPane gp = new GridPane();

		Label lblTitle = new Label("Videogame Title: ");
		Label lblFormat = new Label("Format: ");
		Label lblLocation = new Label("Location: ");
		Label lblNotes = new Label("Notes: ");

		tfVideogameTitle = new TextField();
		tfVideogameFormat = new TextField();
		tfVideogameLocation = new TextField();
		tfVideogameNotes = new TextField();

		gp.add(lblTitle,0, 0);
		gp.add(lblFormat,0, 1);
		gp.add(lblLocation,0, 2);
		gp.add(lblNotes,0, 3);

		gp.add(tfVideogameTitle,1, 0);
		gp.add(tfVideogameFormat,1, 1);
		gp.add(tfVideogameLocation,1, 2);
		gp.add(tfVideogameNotes,1, 3);
		videogameEntry.setCenter(gp);
	}

	/**
	 * Check data add videogame media.
	 */
	private void checkDataAddVideogameMedia() {
		if (tfVideogameTitle.getText().isEmpty()) {
			// something is blank
			Alert alert = new Alert(AlertType.WARNING);
			alert.setHeaderText("Add Media Failed!");
			alert.setContentText("Make sure that the title field is populated");
			alert.showAndWait();
		} else {
			controller.addVideoGame(tfVideogameTitle.getText(), tfVideogameFormat.getText(), tfVideogameLocation.getText(),
					tfVideogameNotes.getText());
			clearTextFields();
		}
	}


	/**
	 * Creates the and add search grid pane.
	 */
	private void createAndAddSearchGridPane() {
		GridPane gp = new GridPane();
		gp.setVgap(10);

		Label lblSearchType = new Label("Search by type: ");
		Label lblSearchTitle = new Label("Search by title: ");

		tfSearchType = new TextField();
		tfSearchTitle = new TextField();

		gp.add(lblSearchType,0, 0);
		gp.add(lblSearchTitle,0, 1);

		gp.add(tfSearchType,1, 0);
		gp.add(tfSearchTitle,1, 1);
		searchData.setCenter(gp);
	}

	/**
	 * Check data search media.
	 *
	 * @return true, if successful
	 */
	private boolean checkDataSearchMedia() {
		if (tfSearchTitle.getText().isEmpty() && !tfSearchType.getText().isEmpty()) {
			if (!viewLibraryDBTypeSearchResults(tfSearchType.getText())) {
				return false;
			}
			
			clearTextFields();
			return true;
		}

		else if (!tfSearchTitle.getText().isEmpty() && tfSearchType.getText().isEmpty()) {
			if (!viewLibraryDBTitleSearchResults(tfSearchTitle.getText())) {
				return false;
			}
			clearTextFields();
			return true;
		}

		else if (!tfSearchTitle.getText().isEmpty() && !tfSearchType.getText().isEmpty()) {
			if (!viewLibraryDVTitleTypeSearchResults(tfSearchTitle.getText(), tfSearchType.getText())) {
				return false;
			}
			clearTextFields();
			return true;
		}

		else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setHeaderText("Search Failed!");
			alert.setContentText("Make sure that at least one field is populated");
			alert.showAndWait();
			return false;
		}
	}


	/**
	 * View library DB.
	 *
	 * @return true, if successful
	 */
	private boolean viewLibraryDB() {
		if (controller.getMediaList().length == 0) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setHeaderText("Cannot View Library");
			alert.setContentText("Make sure at least one entry exists");
			alert.showAndWait();
			return false;
		}

		else {
			String[] libDataStr = controller.getMediaList();
			lv = new ListView<>(FXCollections.observableArrayList(libDataStr));
			lv.setPrefWidth(400);
			libData.setCenter(new ScrollPane(lv));
			return true;
		}


	}

	/**
	 * View library DB type search results.
	 *
	 * @param type the type
	 * @return true, if successful
	 */
	private boolean viewLibraryDBTypeSearchResults(String type) {
		String[] libDataStr = controller.searchByType(type);
		if (libDataStr.length == 0) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setHeaderText("Search Failed!");
			alert.setContentText("No items were present with the specified characteristics");
			alert.showAndWait();
			return false;
		} else {
			lv = new ListView<>(FXCollections.observableArrayList(libDataStr));
			lv.setPrefWidth(400);
			searchData.setCenter(new ScrollPane(lv));
			return true;
		}
	}

	/**
	 * View library DB title search results.
	 *
	 * @param title the title
	 * @return true, if successful
	 */
	private boolean viewLibraryDBTitleSearchResults(String title) {
		String[] libDataStr = controller.searchByTitle(title);
		if (libDataStr.length == 0) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setHeaderText("Search Failed!");
			alert.setContentText("No items were present with the specified characteristics");
			alert.showAndWait();
			return false;
		} else {
			lv = new ListView<>(FXCollections.observableArrayList(libDataStr));
			lv.setPrefWidth(400);
			searchData.setCenter(new ScrollPane(lv));
			return true;
		}
	}

	/**
	 * View library DV title type search results.
	 *
	 * @param title the title
	 * @param type the type
	 * @return true, if successful
	 */
	private boolean viewLibraryDVTitleTypeSearchResults(String title, String type) {
		String[] libDataStr = controller.searchByTitleAndType(title, type);
		if (libDataStr.length == 0) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setHeaderText("Search Failed!");
			alert.setContentText("No items were present with the specified characteristics");
			alert.showAndWait();
			return false;
		} else {
			lv = new ListView<>(FXCollections.observableArrayList(libDataStr));
			lv.setPrefWidth(400);
			searchData.setCenter(new ScrollPane(lv));
			return true;
		}
	}


	/**
	 * Clear text fields.
	 */
	private void clearTextFields() {
		tfAuthor.clear();
		tfBookTitle.clear();
		tfSongTitle.clear();
		tfVideoTitle.clear();
		tfVideogameTitle.clear();
		tfArtist.clear();
		tfGenre.clear();
		tfStar.clear();
		tfBookFormat.clear();
		tfSongFormat.clear();
		tfVideoFormat.clear();
		tfVideogameFormat.clear();
		tfBookLocation.clear();
		tfSongLocation.clear();
		tfVideoLocation.clear();
		tfVideogameLocation.clear();
		tfBookNotes.clear();
		tfSongNotes.clear();
		tfVideoNotes.clear();
		tfVideogameNotes.clear();
		tfSearchType.clear();
		tfSearchTitle.clear();
	}


	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}

}
