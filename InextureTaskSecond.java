/*
* Write a program which display following pattern. The user is expected to input a number and

if the user puts in 3 it will display pattern as follows:

1       1

1 2   2 1

1 2 3 2 1
*/
import java.util.Scanner;
import java.util.InputMismatchException;

public class InextureTaskSecond{ 
    
	public static void main(String[] args){ 
	
		boolean flag = true;
		while (flag) {
			int number;
			Scanner sc=new Scanner(System.in);

			try {
				System.out.print("\n------Enter The Number:");
				number=sc.nextInt();
				if (number<=0) { /*if negative number*/
		        	throw new IllegalArgumentException();
		    	}
				System.out.println();
				int length = String.valueOf(number).length();/*for counting length of number*/
				int temp = number;			
				/*for loop For printing */

				for (int count = 1; count <= number; count++) { /*1st loop for line*/
					for (int left = 1; left <= count; left++) {/*second loop for printing value left side*/
						if(left>9) 
							System.out.print(" " +left);
						 else 
							System.out.print("  "+left);
					}
					for (int space = (temp * 2) - 3; space >= 1; space--) {/*third loop for spacing*/
						if(length>2)
							System.out.print("    ");
						else 
						  	System.out.print("   ");					
					}	
					temp--;
					for (int right = count ; right >= 1; right--) {/*fourth loop for printing right value*/
						if ( right == number )
							continue;
						if(right>9) 
							System.out.print(" "+ right);
					 	else 
							System.out.print("  "+ right);				
					}

					System.out.println();
				}/*first loop close*/
				System.out.print("\n\nDo you Want To Continue Yes Or No ? :");
				String choice = sc.next();
				if(choice.equals("Yes") || choice.equals("yes"))
					flag = true;
				else{
					flag = false;
					sc.close();
				}
			}/*try close*/

			catch(IllegalArgumentException msg) {					 
				System.out.println("only positive  numbes are allowed\n");/*printing message*/
			}/*catch close*/
			catch(InputMismatchException e){
				System.out.println("-----Please Insert Only Number Not Allower Character-----");
			}
			catch(Exception msg) {					 
				msg.printStackTrace();
			}/*catch close*/
		}
	} 
}
















				/*for(int z=2;z<row;z++){
					space=space+2;
				}
				for(int i=0;i<row;i++){
					for(int j=0;j<=i;j++){
						if(j<9){
							System.out.print(" "+(j+1)+" ");
						}else{
								System.out.print(j+1+" ");
						}
					}
					if(i<9){
						for(int k=0;k<space-11;k++){
							System.out.print("   ");
						}
					}else{
						for(int k=0;k<space;k++){
							System.out.print("   ");
						}
					}
					if(row>10){
						if(i<9){
							for(int x=0;x<11;x++){
								System.out.print("   ");
							}
						}
					}
					space=space-2;
					for(int l=i;l>=0;l--){
						if(i==(row-1) && l==(row-1)){
							continue;
						}
						if(l<9){
								System.out.print(" "+(l+1)+" ");
						}else{
							System.out.print(l+1+" ");
						}
					}
					System.out.println();
				}
			}*/