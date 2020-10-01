public class Test3
{
	public static void main(String []args)
	{
		int number = 5;
		int row=0 , col = number , lowerLimit = 0 , upperLimit = 0; 
		int startValue = 1;
		int maxValue = number*number;
		int[][] storeValue = new int[number][number];
		
		while(startValue <= maxValue){ 
			while(col > upperLimit && startValue <= maxValue){ 
				col--;
				storeValue[row][col] = startValue++;
			}
			col--;
			row++;
		
		/*	while(row < upperLimit && startValue <= maxValue){   
				storeValue[row][col] = startValue++;
				row++;
			}
			row--;
			col--;
		
			while(col > lowerLimit && startValue <= maxValue){   
				storeValue[row][col] = startValue++;
				col--;
			}
		
			while(row > lowerLimit && startValue <= maxValue){   
				storeValue[row][col] = startValue++;
				row--;
			}
			row++;
			col++;
			lowerLimit++;
			upperLimit--;*/
		}
		for(int i = 0; i < number; i++){
			for(int j = 0; j < number; j++){
				System.out.print(storeValue[i][j] + "\t");
			}
			System.out.println();
		}
	}
}