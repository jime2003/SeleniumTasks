package Assignment4;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String args[]){
        List<String> list1 = new ArrayList<String>();
        List<String> revValues = new ArrayList<String>(); // create a new list that appends reverse order
        list1.add("Git");
        list1.add("Github");
        list1.add("GitLab");
        list1.add("GitBash");
        list1.add("Selenium");
        list1.add("Java");
        list1.add("Maven");

        for(String s:list1){
            if(s.contains("Git")){
                revValues.add(s);
            }
        }
        System.out.println(revValues);
 
    
    

    }
    
    
}
