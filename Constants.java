
public final class Constants {

    // File name
    public static final String FILE_NAME = "students.txt";

    // Command arguments
    public static final String ADD_COMMAND = "a";
    public static final String RANDOM_COMMAND = "r";
    public static final String COUNT_COMMAND = "c";
    public static final String ADD_PREFIX = "+";
    public static final String SEARCH_PREFIX = "?";

    // Output messages
    public static final String LOADING_MESSAGE = "Loading data ...";
    public static final String LOADED_MESSAGE = "Data Loaded.";
    public static final String INVALID_ARGUMENT_MESSAGE =
            "Please provide exactly one argument.";
    public static final String SEARCH_SUCCESS_MESSAGE = "We found it!";
    public static final String COUNT_MESSAGE = " word(s) found ";
    public static final String UPDATE_MESSAGE =
            "\nList last updated on ";

    // Data separators
    public static final String COMMA_SEPARATOR = ",";
    public static final String STUDENT_SEPARATOR = ", ";

    // Date format
    public static final String DATE_PATTERN = "dd/mm/yyyy-hh:mm:ss a";

    // Private constructor
    private Constants() {
    }
}
