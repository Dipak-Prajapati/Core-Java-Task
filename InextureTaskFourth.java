/*
*	Write a program which displays Fibonacci series in 'Diamond' Pattern.

                        1
                  2           3
            5           8           13
      21          34          55          89
144         233         377         610         987
      1597        2584        4181        6765
            10946       17711       28657
                  46368       75025
                        121393

*/
import java.util.Scanner;
import java.util.InputMismatchException;

public class InextureTaskFourth{	
	public static void main(String []args){	
		boolean flag = true;
		while(flag){
			try{
				Scanner sc = new Scanner(System.in);
				int number;
				System.out.print("Enter The Number : ");
				number = sc.nextInt();
				if (number<=0) { /*if negative number*/
		        	throw new IllegalArgumentException();
		    	}
				int space = number - 1;	
				long next[] = new long[number*number];
				long f1 = 0, f2 = 1 , f3;
				long last_no;
				int length=0;
				int counter=0;

				for(int iterate=1;iterate<=(number*number);iterate++){  /*generating fibonaci series*/
					f3=f1+f2;
					next[counter] = f3;
					f1=f2;
					f2=f3;
					counter++;
				}
				last_no = next[next.length-1];
				System.out.println("last_no"+last_no);
				while(last_no != 0) {
						last_no = last_no/10;
						length++;
				}
				System.out.println("length"+length);
				int line = 0;
				
				/* Upper */
				for(int i = 0; i < number ; i++){
					for(int j = 0 ; j < space ; j++){
						System.out.format("%"+length+"s","");
					}
					for(int k = 0 ; k <= i; k++){
						f1 = next[line];
						int len = (int)(Math.log10(f1) + 1);
						System.out.print(next[line]); /*printing array value*/
						line++;
						while(len<length) {			/*set space after element*/
							System.out.print(" ");
							len++;
						}
						System.out.format("%"+length+"s","");/*space after element*/
					}
					System.out.println();
					space--;
				}
				/* Lower */
				space = 0;
				for(int i = number-1; i > 0 ; i--){
					for(int j = 0 ; j <=space ; j++){
						System.out.format("%"+length+"s","");
					}
					for(int k = 0 ; k < i; k++){
						f1 = next[line];
						int len = (int)(Math.log10(f1) + 1);
						System.out.print(next[line]); /*printing array value*/
						line++;
						while(len<length){			/*set space after element*/
							System.out.print(" ");
							len++;
						}
						System.out.format("%"+length+"s","");/*space after element*/
					}
					System.out.println();
					space++;
				}
				System.out.print("\n\nDo you Want To Continue Yes Or No ? :");
				String choice = sc.next();
				if(choice.equals("Yes") || choice.equals("yes")){
					flag = true;
				}else{
					sc.close();
					flag = false;
				}
			}
			catch(IllegalArgumentException msg) {					 
				System.out.println("only positive numbers are allowed\n");/*printing message*/
			}/*catch close*/
			catch(InputMismatchException e){
				System.out.println("-----Please Insert Only Number Not Allowed Character-----");
			}
			catch(Exception e){
				//System.out.println("\n-----Please Insert Only Number-----\n");
				e.printStackTrace();
			}
		}
	}
}