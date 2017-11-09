import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Hashtable;

/*
 * Model data for the phone book application.
 */

public class PhoneBookModel {

	private PhoneBookView phonebookview;

	// The following are various states captured by the model
	public static String ADD_NAME_STATE = "ADD_NAME";
	public static String ADD_NUMBER_STATE = "ADD_NUMBER";
	public static String SEARCH_STATE = "SEARCH";
	public static String DELETE_STATE = "DELETE";
	public static String MODIFY_NAME_STATE = "MODIFY_NAME";
	public static String MODIFY_NUMBER_STATE = "MODIFY_NUMBER";
	public static String MODIFY_RESULT_STATE = "MODIFY_RESULT";
	public static String IDLE_STATE = "IDLE";
	public static String SEARCH_RESULT_STATE = "SEARCH_RESULT";
	public static String DELETE_RESULT_STATE = "DELETE_RESULT";
	public static String ERROR_STATE = "ERROR";
	public static String EXIT_STATE = "EXIT";

	// Private fields used to track various model data
	private String state = IDLE_STATE;
	private String searchResult = null;
	private String deleteResult = null;
	private String modifyResult = null;
	private Hashtable<String,String> phoneBook = null;

	/**
	 * set the state
	 * @param aState
	 */
	public void setState(String aState) {
		state = aState;
		phonebookview.stateHasChanged(this, state);
	}

	/**
	 * add a phone entry
	 * @param name
	 * @param number
	 */
	public void addAnEntry(String name, String number) {
		phoneBook.put(name, number);
	}

	/**
	 * search the phone number and set the searchResult field
	 * @param name
	 */
	public void searchPhoneNumber(String name) {
		searchResult = (String)phoneBook.get(name);
	}

	/**
	 * return the search result
	 */
	public String getSearchResult() {
		return searchResult;
	}

	/**
	 * search the phone number that want to be delete
	 * @param name
	 */
	public void deletePhoneNumber(String name) {
		deleteResult = (String)phoneBook.remove(name);
	}

	/**
	 * return the delete result
	 */
	public String getDeleteResult() {
		return deleteResult;
	}

	/**
	 * modify a phone entry
	 * @param name
	 * @param number
	 */
	public void modifyAnEntry(String name, String number) {
		modifyResult = (String)phoneBook.get(name);
		if (modifyResult != null && modifyResult.length() != 0) {
			phoneBook.put(name, number);
		}
	}

	/**
	 * return the modify result
	 */
	public String getModifyResult() {
		return modifyResult;
	}

	/**
	 * get the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * constructor
	 * @param view
	 */
	public PhoneBookModel(PhoneBookView view) {
		phonebookview = view;
		phoneBook = new Hashtable<String,String>();
	}
}
