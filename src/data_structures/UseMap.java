package data_structures;

import com.fasterxml.jackson.databind.MappingIterator;
import databases.SharedStepsDatabase;

import java.util.*;

public class UseMap {

    /**
     * INSTRUCTIONS
     * <p>
     * Implement code to demonstrate how to interact with a database connection, using a Map
     * You must insert the map into a table, and then you must submit & execute a query to retrieve
     * all the submitted data (retrieval does not need to be stored as a map - you can use any data structure)
     * <p>
     * Use For-Each loop and While-loop with Iterator to retrieve data.
     */

    public static void main(String[] args) throws Exception {

        HashMap<Object, Object> map = new HashMap<>();
        map.put(8454, "lamia");
        map.put(4567, "azar");
        map.put(7898, "rahim");

        // Retrieving "Keys" & "Values" using an Iterator
        Iterator<Object> mapIter = map.keySet().iterator();
        Object key;
        while (mapIter.hasNext()) {
            key = mapIter.next();
            System.out.println("KEY: " + key);
            System.out.println("VALUE: " + map.get(key));
        }

        String tableName = "`test_hash_map`";
        SharedStepsDatabase sql = new SharedStepsDatabase();

        // IMPLEMENT HERE

        //Using For-Each loop  to retrieve data.
        System.out.println("-------------For-Each loop--------------");
        map.forEach((k,v) -> System.out.println("key: "+k+" value:"+v));

        //Using While-loop with Iterator to retrieve data.
        System.out.println("--------------While-loop with Iterator---------------");

        // Inserting data into DB
          sql.insertMap(tableName, map);

        // Execute the query to retrieve data
        List dB_data = sql.executeQueryReadAll("select * from " + tableName);

        Iterator it = dB_data.iterator();

        //Using While-loop with Iterator to retrieve data
        while (it.hasNext()) {
            System.out.println(it.next());
        }
      sql.closeResources();
}
}
