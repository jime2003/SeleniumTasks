package Assignment4;

import java.util.ArrayList;
import java.util.List;

public class Task3 {
    public static void main(String args[]){
        List<String> list1 = new ArrayList<String>();
        list1.add("Java");
        list1.add("TestNG");
        list1.add("Maven");
        list1.add("Java");

        for (int i = 0; i < list1.size(); i++) {
            for (int j = i + 1; j < list1.size(); j++) {
                if (list1.get(i).equalsIgnoreCase(list1.get(j))) {
                    list1.remove(j);

                }

            }

        }
        System.out.println(list1);
 
    
    

    }
    
    
}
