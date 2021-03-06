import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * View interface for the phone book application
 *   A simple line command interface is implemented
 */

public class PhoneBookView {

	// phonebookcontroller and phonebookmodel are generated by RSA
	// to represent the association relationship
	private PhoneBookController phonebookcontroller;
	private PhoneBookModel phonebookmodel;
	private boolean finish_flag;

	// The following are some questions to be asked to user
	// via the line command interface
	public static String ADD_NAME_Q = "Please enter the exact person name";
	public static String ADD_NUMBER_Q = "Please enter the phone number";
	public static String SEARCH_Q = "Please enter the exact person name.";
	public static String DELETE_Q = "Please enter the exact person name.";
	public static String MODIFY_NAME_Q = "Please enter the exact person name.";
	public static String MODIFY_NUMBER_Q = "Please enter the phone number";
	public static String IDLE_Q =
		"Please enter your choice of action, \""
		+ PhoneBookController.ADD_COMMAND
		+ "\" to add a phone entry or \""
		+ PhoneBookController.SEARCH_COMMAND
		+ "\" to search for a phone number or \""
		+ PhoneBookController.DELETE_COMMAND
		+ "\" to delete a phone entry or \""
		+ PhoneBookController.MODIFY_COMMAND
		+ "\" to modify a phone entry or \""
		+ PhoneBookController.QUIT_COMMAND
		+ "\" to end the application.";
	public static String SEARCH_RESULT_Q =
		" - This is the located phone number. Enter \""
		+ PhoneBookController.START_COMMAND
		+ "\" to do more with the application or \""
		+ PhoneBookController.QUIT_COMMAND
		+ "\" to end the application.";
	public static String DELETE_RESULT_Q =
		"Phone entry has been deleted. Enter \""
		+ PhoneBookController.START_COMMAND
		+ "\" to do more with the application or \""
		+ PhoneBookController.QUIT_COMMAND
		+ "\" to end the application.";
	public static String MODIFY_RESULT_Q =
		"Phone entry has been modified. Enter \""
		+ PhoneBookController.START_COMMAND
		+ "\" to do more with the application or \""
		+ PhoneBookController.QUIT_COMMAND
		+ "\" to end the application.";
	public static String SEARCH_NOT_FOUND_Q =
		"Phone number not found. Enter \""
		+ PhoneBookController.START_COMMAND
		+ "\" to do more with the application or \""
		+ PhoneBookController.QUIT_COMMAND
		+ "\" to end the application.";
	public static String DELETE_NOT_FOUND_Q =
		"Phone entry not found. Enter \""
		+ PhoneBookController.START_COMMAND
		+ "\" to do more with the application or \""
		+ PhoneBookController.QUIT_COMMAND
		+ "\" to end the application.";
	public static String MODIFY_NOT_FOUND_Q =
		"Phone entry not found. Enter \""
		+ PhoneBookController.START_COMMAND
		+ "\" to do more with the application or \""
		+ PhoneBookController.QUIT_COMMAND
		+ "\" to end the application.";
	public static String ERROR_Q =
		"You've entered an invalid choice. Enter \""
		+ PhoneBookController.START_COMMAND
		+ "\" to do more with the application or \""
		+ PhoneBookController.QUIT_COMMAND
		+ "\" to end the application.";

	public PhoneBookView() {
		finish_flag = false;
	}
	public boolean finish() {
		return finish_flag;
	}

	/**
	 * get called when the state has been changed
	 * @param newState
	 */
	public void stateHasChanged(PhoneBookModel model, String newState) {
		phonebookmodel = model;
		changeView(newState);
	}

	/**
	 * change the view based on the new state

	 * @param newState
	 */
	public void changeView(String newState) {
		if (newState.equals(PhoneBookModel.IDLE_STATE)) {
			System.out.println(IDLE_Q);
		}
		else if (newState.equals(PhoneBookModel.ADD_NAME_STATE)) {
			System.out.println(ADD_NAME_Q);
		}
		else if (newState.equals(PhoneBookModel.ADD_NUMBER_STATE)) {
			System.out.println(ADD_NUMBER_Q);
		}
		else if (newState.equals(PhoneBookModel.SEARCH_STATE)) {
			System.out.println(SEARCH_Q);
		}
		else if (newState.equals(PhoneBookModel.DELETE_STATE)) {
			System.out.println(DELETE_Q);
		}
		else if (newState.equals(PhoneBookModel.MODIFY_NAME_STATE)) {
			System.out.println(MODIFY_NAME_Q);
		}
		else if (newState.equals(PhoneBookModel.MODIFY_NUMBER_STATE)) {
			System.out.println(MODIFY_NUMBER_Q);
		}
		else if (newState.equals(PhoneBookModel.SEARCH_RESULT_STATE)) {
			String result = phonebookmodel.getSearchResult();
			if (result == null || result.length() == 0) {
				System.out.println(SEARCH_NOT_FOUND_Q);
			}
			else {
				System.out.println(result + SEARCH_RESULT_Q);
			}
		}
		else if (newState.equals(PhoneBookModel.DELETE_RESULT_STATE)) {
			String result = phonebookmodel.getDeleteResult();
			if (result == null || result.length() == 0) {
				System.out.println(DELETE_NOT_FOUND_Q);
			}
			else {
				System.out.println(DELETE_RESULT_Q);
			}
		}
		else if (newState.equals(PhoneBookModel.MODIFY_RESULT_STATE)) {
			String result = phonebookmodel.getModifyResult();
			if (result == null || result.length() == 0) {
				System.out.println(MODIFY_NOT_FOUND_Q);
			}
			else {
				System.out.println(MODIFY_RESULT_Q);
			}
		}
		else if (newState.equals(PhoneBookModel.ERROR_STATE)) {
			System.out.println(ERROR_Q);
		}
		else if (newState.equals(PhoneBookModel.EXIT_STATE)) {
			System.out.println("Bye Bye");
			finish_flag = true ;
		}
	}

	/**
	 * get user input based on question

	 * @param question
	 */

	public void getUserInput() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			String answer = in.readLine().trim();
			phonebookcontroller.userHasInput(answer);
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	public PhoneBookView(PhoneBookController controller) {
		phonebookcontroller = controller;
	}
}
