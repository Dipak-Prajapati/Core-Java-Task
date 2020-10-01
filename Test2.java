import java.util.Scanner;
import java.util.InputMismatchException;

public class Test2{
	public static void main(String []args){
		
		boolean flag = true;
		while (flag) {
			try {
				Scanner sc = new Scanner(System.in);
				int number;
				System.out.print("\n-----Enter The Number : ");
				number = sc.nextInt();
				if (number<=0) { 
							throw new IllegalArgumentException();
				}
				System.out.println();
				int row=0 , col = number , lowerLimit = number , upperLimit = 0; 
				int startValue = 1;
				int maxValue = number;
				int[][] storeValue = new int[number][number];
				
				while(startValue <= maxValue){ 
					while(col > upperLimit && startValue <= maxValue){ 
						col--;					
						storeValue[row][col] = startValue++;
					}
					//col++;
					row++;
				
					while(row < lowerLimit && startValue <= maxValue){   
						row++;
						storeValue[row][col] = startValue++;	
					}
					row--;
					col++;
				
				/*	while(col <= lowerLimit && startValue <= maxValue){   
						storeValue[row][col] = startValue++;
						col++;
					}
					col--;
					row--;
					while(row > upperLimit && startValue <= maxValue){  
						storeValue[row][col] = startValue++;
						row--;
					}
					row++;
					col--;
					lowerLimit--;
					upperLimit++;
				*/}
				
				for(int i = 0; i < number; i++){
					for(int j = 0; j < number; j++){
						System.out.print(storeValue[i][j] + "\t");
					}
					System.out.println();
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
				System.out.println("only positive  numbes are allowed\n");/*printing message*/
			}/*catch close*/
			catch(InputMismatchException e){
				System.out.println("-----Please Insert Only Number Not Allower Character-----");
			}
			/*catch(Exception msg) {					 
				System.out.println("only positive integers numbes are allowed\n");
			}*/
			
		}
	}
}
