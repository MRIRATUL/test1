
import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {

    public static void main(String[] args) {

        // Check arguments
        if (args.length != 1) {
            System.out.println("Please provide exactly one argument.");
            return;
        }

        if (args[0].equals("a")) {
            System.out.println("Loading data ...");

            try {
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream("students.txt")
                    )
                );

                String studentData = reader.readLine();
                String[] studentNames = studentData.split(",");

                for (String studentName : studentNames) {
                    System.out.println(studentName);
                }

            } catch (Exception e) {
            }

            System.out.println("Data Loaded.");
        }

        else if (args[0].equals("r")) {
            System.out.println("Loading data ...");

            try {
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream("students.txt")
                    )
                );

                String studentData = reader.readLine();
                System.out.println(studentData);

                String[] studentNames = studentData.split(",");

                Random random = new Random();
                int randomIndex = random.nextInt();

                System.out.println(studentNames[randomIndex]);

            } catch (Exception e) {
            }

            System.out.println("Data Loaded.");
        }

        else if (args[0].contains("+")) {
            System.out.println("Loading data ...");

            try {
                BufferedWriter writer = new BufferedWriter(
                    new FileWriter("students.txt", true)
                );

                String newStudent = args[0].substring(1);

                Date currentDate = new Date();
                String datePattern = "dd/mm/yyyy-hh:mm:ss a";

                DateFormat formatter = new SimpleDateFormat(datePattern);
                String formattedDate = formatter.format(currentDate);

                writer.write(", " + newStudent +
                    "\nList last updated on " + formattedDate);

                writer.close();

            } catch (Exception e) {
            }

            System.out.println("Data Loaded.");
        }

        else if (args[0].contains("?")) {
            System.out.println("Loading data ...");

            try {
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream("students.txt")
                    )
                );

                String studentData = reader.readLine();
                String[] studentNames = studentData.split(",");

                boolean done = false;
                String searchName = args[0].substring(1);

                for (int index = 0;
                     index < studentNames.length && !done;
                     index++) {

                    if (studentNames[index].equals(searchName)) {
                        System.out.println("We found it!");
                        done = true;
                    }
                }

            } catch (Exception e) {
            }

            System.out.println("Data Loaded.");
        }

        else if (args[0].contains("c")) {
            System.out.println("Loading data ...");

            try {
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream("students.txt")
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

                System.out.println(wordCount + " word(s) found " +
                    characters.length);

            } catch (Exception e) {
            }

            System.out.println("Data Loaded.");
        }
    }
}
