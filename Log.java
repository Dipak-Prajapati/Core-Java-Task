/*import java.lang.*;
import java.util.*;

public class Log {

   public static void main(String[] args) {
   try{
	Scanner sc = new Scanner(System.in);
    int number;
    number = sc.nextInt();
   
    //int length=(int)(Math.log10(number));
      int length = String.valueOf(number).length();
	  System.out.println(length);
   }
   catch(Exception e)
   {
	   System.out.println(e);
   }
   }
}*/
   
   
/*import java.util.Scanner;
import java.util.Arrays;

class InextureTaskFourth {
    public static void main(String args[]){
        int size = 5;
		int f1=0 , f2 = 1 , ans;
		for(int rowNumber = -size +1 ; rowNumber < size ; rowNumber++){
            char row[] = new char[2*size - Math.abs(rowNumber) - 1];
            Arrays.fill(row,0,Math.abs(rowNumber),' ');
			
            Arrays.fill(row,Math.abs(rowNumber), row.length,'*');
			ans = f1 + f2; 
			f1 = f2; 
			f2 = ans;
            System.out.println(String.valueOf(row));
        }
    }
}*/

import java.util.Scanner;

class Log {
	static int counter;
	public int fib(int number)
		{
			int next[] = new int[number*number];
			int f1 = 0, f2 = 1;
			int length;
			
			next[counter] = f1 + f2; 
			f1 = f2; 
			f2 = next[counter];
			counter++;
			int last_no = next[next.length-1];
		//	System.out.print("last_no"+last_no);
			length = String.valueOf(last_no).length();
		//	System.out.print("length"+length);
			return(f2,length);
		}
		
    public static void main(String[] args)  
    { 
		Log obj = new Log();
		Scanner sc = new Scanner(System.in);
		int number;
		System.out.print("Enter The Number : ");
		number = sc.nextInt();
		int space = number - 1;
		
		
		for(int i = 0; i < number ; i++)
		{
			for(int j = 0 ; j < space ; j++)
			{
				System.out.print(" ");
			}
			for(int k = 0 ; k <= i; k++)
			{
				int x = obj.fib(number);
				//System.out.print(x);
				//System.out.print(" "+x); 
			}
			System.out.println();
			space--;
		}
		/*space = 0;
		for(int i = number-1; i > 0 ; i--)
		{
			for(int j = 0 ; j <= space; j++)
			{
				System.out.print(" ");
			}
			for(int k = 0 ; k < i; k++)
			{
				System.out.print(f2+" ");
			}
			System.out.println();
			space++;
		}*/
	}
}




