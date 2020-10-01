/*
*	Write a program which print the following pattern. It displays the n x n square for input 'n'.

For eg.

1  2  3  4  5		Or		5  4  3  2  1	

16 17 18 19 6				6  19 18 17 16

15 24 25 20 7				7  20 25 24 15

14 23 22 21 8				8  21 22 23 14

13 12 11 10 9     			9  10 11 12 13
*/

import java.util.Scanner;
import java.util.InputMismatchException;
 
public class InextureTaskThird {
    public static void main(String args[]){
		boolean flag = true;
		while(flag){
			try{
				System.out.println("Enter The Value :");         
				Scanner sc = new Scanner(System.in);
				String msg;
				int number = sc.nextInt();
				if (number<=0) { /*if negative number*/
					msg = "only positive numbers are allowed\n";
					throw new IllegalArgumentException(msg);
				}
				System.out.println();
				int[][] spiral = new int[number][number];
				int value = 1;
				int startingCol = 0;
				int endingCol = number-1;
				int startingRow = 0;
				int endingRow = number-1;
				
				System.out.print("Press 1 For Clock Wise || Press 2 For AntiClock Wise :");
				int clock;
				clock = sc.nextInt();
				
				while (value <= number*number){
					if(clock == 1){
						for (int i = startingCol; i <= endingCol; i++){
							spiral[startingRow][i] = value;		 
							value++;
						}
						for (int i = startingRow+1; i <= endingRow; i++) { 
							spiral[i][endingCol] = value;  
							value++; 
						} 
						for (int i = endingCol-1; i >= startingCol; i--){
							spiral[endingRow][i] = value;				 
							value++;
						}
						for (int i = endingRow-1; i >= startingRow+1; i--) {
							spiral[i][startingCol] = value;	 
							value++;
						}
						startingCol++;
						startingRow++;
						endingCol--;	 
						endingRow--;
					}else if(clock == 2){
						for (int i = endingCol; i >= startingCol; i--){
							spiral[startingRow][i] = value++;
						} 
							//print left row
						for (int i = startingRow+1; i <= endingRow; i++){ 
							spiral[i][startingCol] = value++;
						} 
							//print bottom row
						for (int i = startingCol+1; i <= endingCol; i++){
							spiral[endingRow][i] = value++;
						}
							//print right row
						for (int i = endingRow-1; i >= startingRow+1; i--){
							spiral[i][endingCol] = value++;
						}
						startingCol++;
						startingRow++;
						endingCol--;
						endingRow--;
					}else{
						msg = "-----Invalid Choice-----\n";
						throw new IllegalArgumentException(msg);
					}
				}
				for (int i = 0; i < spiral.length; i++){
					for (int j = 0; j < spiral.length; j++){
						System.out.print(spiral[i][j]+ "\t");
					} 
					System.out.println();
				}
				System.out.print("\n\nDo you Want To Continue Yes Or No ? :");
				String choice = sc.next();
				if(choice.equals("Yes") || choice.equals("yes")){
					flag = true;
				}else{
					flag = false;
					sc.close();
				}
			}
			catch(IllegalArgumentException msg) {					 
				System.out.println(msg);/*printing message*/
			}/*catch close*/
			catch(InputMismatchException e){
				System.out.println("-----Please Insert Only Number Not Allower Character-----");
			}
			catch(Exception msg) {					 
				System.out.println("only positive integers numbes are allowed\n");/*printing message*/
			}/*catch close*/
		}
    }
}