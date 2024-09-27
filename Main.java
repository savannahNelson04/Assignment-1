import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        Stack<String> stack = new Stack<>();
        List list = new List(100);

        int infoCount = 0;
        int warnCount = 0;
        int errorCount = 0;
        int memoryWarningCount = 0;


        try {
            File file = new File("/Users/savannahnelson/Downloads/log-data.csv");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                queue.enqueue(line);
            }

            while (!queue.isEmpty()) {
                String line = queue.dequeue();

                if (line.contains("INFO")){
                    infoCount++;
                }
                else if (line.contains("WARN")){
                    warnCount++;
                    if (line.contains("Memory")){
                        memoryWarningCount++;
                    }
                }
                else if (line.contains("ERROR")){
                    errorCount++;
                    //Adding last 100 Errors onto list
                        list.addError(line);
                }

            }

            System.out.println();
            System.out.println("Counts");
            System.out.println("Info: " + infoCount);
            System.out.println("Warn: " + warnCount);
            System.out.println("Error: " + errorCount);
            System.out.println("Memory Warning: " + memoryWarningCount);
            System.out.println();

            System.out.println("Error List");
            list.printErrors();


            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }




    }
}