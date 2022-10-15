package data_structures;

import databases.SharedStepsDatabase;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UseQueue {

    /** INSTRUCTIONS
     *
     * Demonstrate how to use Queue that includes add, peek, remove & poll methods.
     * Use For-Each loop and While-Loop with Iterator to retrieve data.
     *
     * Store and retrieve data from/to a database table.
     */


    public static void main(String[] args) {
        // declare a queue
        Queue myQueue = new LinkedList<Object>();
        // Initialize the queue using add() method.
        myQueue.add("value-0");
        myQueue.add("value-1");
        myQueue.add("value-2");
        myQueue.add("value-3");
        myQueue.add("value-4");
        myQueue.add("value-5");
        // Return all elements of the queue
        System.out.println("Elements in the queue: "+ myQueue);
        //The method size()	Returns the size or number of elements in the queue.
        System.out.println("size or number of elements in the queue: "+ myQueue.size());
        //remove () method =>removes first element from the queue
        System.out.println("Element removed from the queue: "+myQueue.remove());
        //element() => returns head of the queue
        System.out.println("Head of the queue: "+myQueue.element());
        //poll () => removes and returns the head
        System.out.println("Poll():Returned Head of the queue: "+myQueue.poll());
        //returns head of the queue
        System.out.println("peek():Head of the queue: "+myQueue.peek());
        //print the contents of the Queue
        System.out.println("Final Queue:"+myQueue);

        //Iterate Using For-Each loop
        System.out.println("--------------ForEach loop--------------");
        myQueue.forEach((value) -> System.out.println(value));

        //Iterate Using While-Loop with Iterator to retrieve data.
        System.out.println("---------------While-loop with Iterator--------------");
        Iterator itr = myQueue.iterator();

        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        //Store and retrieve data from/to a database table.

       //Connect to DB
        SharedStepsDatabase myDB = new SharedStepsDatabase();
       String tableName = "Queue";
       //Inserting data into DB
       myDB.insertList(tableName,"myValues", (List<Object>) myQueue);
        List dB_data = null;
       //Handling the exception while executing query
        try {
            dB_data = myDB.executeQueryReadAll("select * from " + tableName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //Using While-loop with Iterator to retrieve data
        Iterator it = dB_data.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
        myDB.closeResources();


    }

}
