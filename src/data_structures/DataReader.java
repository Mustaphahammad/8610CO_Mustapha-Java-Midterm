package data_structures;

import databases.SharedStepsDatabase;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

public class DataReader {

    /**
     * INSTRUCTIONS
     * <p>
     * Create an API to read the .txt file and print it to the console.
     * HINT: Use BufferedReader class
     * Use try-catch block to handle any exceptions
     * <p>
     * Store and retrieve the file to/from a database table.
     * <p>
     * After reading from file using BufferedReader API, store each word, first into a LinkedList. Each word
     * should construct a node in LinkedList. Second, do the same, but with a Stack.
     * Finally, traverse through the list\stack & retrieve each item in `FIFO` order and `FILO` order, respectively
     * <p>
     * Demonstrate how to use a stack using push, peek, search & pop methods.
     * Use For-Each & While-loop with Iterator to retrieve/print data.
     **/

    public static void main(String[] args) {
        String textFilePath = System.getProperty("user.dir") + "/src/data_structures/data/self-driving-car.txt";

        File file = new File(textFilePath);

        try (
                FileInputStream fis = new FileInputStream(file);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr)) {
            String line;
            String wholeText = "";
            while ((line = br.readLine()) != null) {
                // printing self-driving-car to the console and store it to the String wholeText.
                // System.out.println(line);
                wholeText = wholeText + line;

            }
            // split the string wholeText into word and store it in a string array
            String[] arrText = wholeText.split(" ");
            System.out.println("****************LinkedList*******************");
            // create a linkedList and store each word of arrText inside it.
            List<Object> linkedList = new LinkedList<>(Arrays.asList(arrText));
            //removing an element from a linked list
            linkedList.remove(0);
            // retrieving data using for each loop
            for (Object w : linkedList
            ) {
                System.out.print(w + " ");
            }
            System.out.println("\n****************Stack*******************");
            // we store each word into a stack with different method
            //1. create a stack
            Stack<Object> stack = new Stack<>();
            //2. loop through arrText and push each word to the stack
            for (int i = 0; i < arrText.length; i++) {
                stack.push(arrText[i]);
            }

            // iterate over stack using the iterator()
            Iterator it = stack.iterator();
            while (it.hasNext()) {
                System.out.print(it.next() + " ");
            }
            // searching for an element
            System.out.println(stack.search("the"));
            // removing element from a stack
            stack.remove("right");

            System.out.println("*****************Database*****************");

            // connecting to DB

            SharedStepsDatabase sql = new SharedStepsDatabase();

            // storing data into DB
            String tableName = "self_driving_car", colName = "word";
            sql.insertList(tableName, colName, linkedList);

            // retriving data from DB
            System.out.println("**************Reading from DB***************");
            String queryReadAll = "select * from " + tableName;
            List dataFromDB = sql.executeQueryReadAll(queryReadAll);
            for (Object list : dataFromDB) {
                System.out.print(list + " ");
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }


    }
}