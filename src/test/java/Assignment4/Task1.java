package Assignment4;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String args[]){
        List<String> values = new ArrayList<String>();
        List<String> revValues = new ArrayList<String>(); // create a new list that appends reverse order
        values.add("Java");
        values.add("Selenium");
        values.add("TestNG");
        values.add("Git");
        values.add("Github");
    
        for(int i=values.size()-1;i>=0;i--){
            revValues.add(values.get(i));            
    }
        for(int i=0;i<values.size();i++){
            System.out.print(revValues.get(i) + " ");
        }
        
    }
    
}
