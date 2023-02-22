package Assignment4;

import java.util.ArrayList;
import java.util.List;

public class Task4 {
    public static void main(String args[]){
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> filteredList1 = new ArrayList<Integer>();
        list1.add(10);
        list1.add(45);
        list1.add(90);
        list1.add(45);
        list1.add(23);
        list1.add(90);
        list1.add(44);

        filteredList1.add(list1.get(1));
        filteredList1.add(list1.get(5));
        System.out.println(filteredList1);
 
    
    

    }
    
    
}
