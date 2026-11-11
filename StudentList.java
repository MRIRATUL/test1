
import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {

    public static void main(String[] args) {

        // Check arguments
        if (args.length != 1) {
            System.out.println(Constants.INVALID_ARGUMENT_MESSAGE);
            return;
        }

        if (args[0].equals(Constants.ADD_COMMAND)) {
            System.out.println(Constants.LOADING_MESSAGE);

            try {
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream(Constants.FILE_NAME)
                    )
                );

                String studentData = reader.readLine();
                String[] studentNames =
                    studentData.split(Constants.COMMA_SEPARATOR);

                for (String studentName : studentNames) {
                    System.out.println(studentName);
                }

                reader.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println(Constants.LOADED_MESSAGE);
        }

        else if (args[0].equals(Constants.RANDOM_COMMAND)) {
            System.out.println(Constants.LOADING_MESSAGE);

            try {
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream(Constants.FILE_NAME)
                    )
                );

                String studentData = reader.readLine();
                System.out.println(studentData);

                String[] studentNames =
                    studentData.split(Constants.COMMA_SEPARATOR);

                Random random = new Random();
                int randomIndex = random.nextInt();

                System.out.println(studentNames[randomIndex]);

                reader.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println(Constants.LOADED_MESSAGE);
        }

        else if (args[0].contains(Constants.ADD_PREFIX)) {
            System.out.println(Constants.LOADING_MESSAGE);

            try {
                BufferedWriter writer = new BufferedWriter(
                    new FileWriter(Constants.FILE_NAME, true)
                );

                String newStudent = args[0].substring(1);

                Date currentDate = new Date();
                DateFormat formatter =
                    new SimpleDateFormat(Constants.DATE_PATTERN);

                String formattedDate = formatter.format(currentDate);

                writer.write(
                    Constants.STUDENT_SEPARATOR + newStudent
                    + Constants.UPDATE_MESSAGE + formattedDate
                );

                writer.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println(Constants.LOADED_MESSAGE);
        }

        else if (args[0].contains(Constants.SEARCH_PREFIX)) {
            System.out.println(Constants.LOADING_MESSAGE);

            try {
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream(Constants.FILE_NAME)
                    )
                );

                String studentData = reader.readLine();
                String[] studentNames =
                    studentData.split(Constants.COMMA_SEPARATOR);

                boolean done = false;
                String searchName = args[0].substring(1);

                for (int index = 0;
                     index < studentNames.length && !done;
                     index++) {

                    if (studentNames[index].equals(searchName)) {
                        System.out.println(Constants.SEARCH_SUCCESS_MESSAGE);
                        done = true;
                    }
                }

                reader.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println(Constants.LOADED_MESSAGE);
        }

        else if (args[0].contains(Constants.COUNT_COMMAND)) {
            System.out.println(Constants.LOADING_MESSAGE);

            try {
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream(Constants.FILE_NAME)
                    )
                );

                String studentData = reader.readLine();
                char[] characters = studentData.toCharArray();

                boolean inWord = false;
                int wordCount = 0;

                for (char character : characters) {
                    if (character == ' ') {
                        if (!inWord) {
                            wordCount++;
                            inWord = true;
                        } else {
                            inWord = false;
                        }
                    }
                }

                System.out.println(
                    wordCount + Constants.COUNT_MESSAGE + characters.length
                );

                reader.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println(Constants.LOADED_MESSAGE);
        }
    }
}
