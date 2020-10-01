import java.util.Scanner;
import java.util.InputMismatchException;

public class Test{	
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
				
				int next[] = new int[number*number];
				int f1 = 0, f2 = 1 , f3;
				int last_no;
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