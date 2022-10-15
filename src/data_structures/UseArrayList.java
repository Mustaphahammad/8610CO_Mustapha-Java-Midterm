package data_structures;

import databases.SharedStepsDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class UseArrayList extends SharedStepsDatabase {

    /**
     * INSTRUCTIONS
     * <p>
     * Demonstrate how to use an ArrayList that includes using the add, peek, remove & retrieve methods.
     * Use For-Each loop and While-loop with Iterator to retrieve the data.
     * <p>
     * Store and retrieve the data from/to a database table.
     */

    public static void main(String[] args) {
        ArrayList<Object> name = new ArrayList<>();
        // Using add() method we can add elements into our ArrayList
        name.add("Matt");
        name.add("John");
        name.add("Patrick");
        name.add("Maria");
        name.add("simon");

        // Using get() method we can retrieve data from our ArrayList passing the Index in arg.
        name.get(0);
        // printing out
        System.out.println(name.get(0));//output:Matt

        //Using remove method we can remove an element from ArrayList passing the proper Index to be removed.
        name.remove(3);
        System.out.println(name); // output:[Matt, John, Patrick, simon]

        // Using For-Each loop
        System.out.println("\n ------for each loop-------");
        for (Object str : name) {
            System.out.print(str + " \n");
        }
        // Using While-loop with Iterator to retrieve the data.
        System.out.println("------while-loop with iterator-------");

        Iterator itr = name.iterator();

        while (itr.hasNext()) {
            System.out.print(itr.next() + " \n");
        }
        //Store and retrieve the data from/to a database table.
        SharedStepsDatabase myDB = new SharedStepsDatabase();

        String tableName = "myList";
        myDB.insertList(tableName, "first_name", name);

        try {
            List dB_Data = myDB.executeQueryReadAll("select * from " + tableName);

            Iterator it = dB_Data.iterator();

            while (it.hasNext()) {
                System.out.println(it.next());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        myDB.closeResources();
    }


}
