import java.util.Scanner;
import java.util.InputMismatchException;
 
public class MainClass 
{
    public static void main(String args[])
    {
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
				
				while (value <= number*number)
				{
					if(clock == 1)
					{
						for (int i = startingCol; i <= endingCol; i++)
						{
							spiral[startingRow][i] = value;		 
							value++;
						}
						for (int i = startingRow+1; i <= endingRow; i++) 
						{ 
							spiral[i][endingCol] = value;  
							value++; 
						} 
						for (int i = endingCol-1; i >= startingCol; i--)
						{
							spiral[endingRow][i] = value;				 
							value++;
						}
						for (int i = endingRow-1; i >= startingRow+1; i--) 
						{
							spiral[i][startingCol] = value;	 
							value++;
						}
						startingCol++;
						startingRow++;
						endingCol--;	 
						endingRow--;
					}
					else if(clock == 2)
					{
						for (int i = endingCol; i >= startingCol; i--)
						{
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
					}
					else
					{
						msg = "-----Invalid Choice-----\n";
						throw new IllegalArgumentException(msg);
					}
				}
				for (int i = 0; i < spiral.length; i++)
				{
					for (int j = 0; j < spiral.length; j++)
					{
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