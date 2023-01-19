package Assignment5;

public class Test {

	public static void main(String[] args) {
		{
	        {
	            int[] marks = { 125, 132, 95, 116, 110 };
	              
	            int highest_marks = maximum(marks);
	            System.out.println("The highest score is " + highest_marks);
	        }}
	    }
	    public static int maximum(int[] numbers)
	    { 
	        int maxSoFar = numbers[0];
	          
	        // for each loop
	        for (int num : numbers) 
	        {
	            if (num > maxSoFar)
	            {
	                maxSoFar = num;
	                System.out.println(maxSoFar);
	            }
	        }
	    return maxSoFar;
	    }

}
