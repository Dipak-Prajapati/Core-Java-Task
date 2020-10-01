/*
*	Write a program which implement the 'Insertion Sort.' It allows to add/remove number at any position and 
	after add/remove operation all the numbers should be displayed in as sorted.
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;
import java.util.InputMismatchException;

public class InextureTaskFifth{ 
	public void insertData(List<Integer> ls,int data,Scanner sc){
		System.out.print("\n-----Enter data : ");
		data = sc.nextInt();
		ls.add(data);
	}
	/* Delete Data */
	public void deleteData(List<Integer> ls,Integer data,Scanner sc){
		if(ls.size() <1){
			System.out.println("\n-----There is no data to delete-----\n");
		}else{
			System.out.print("\n-----Which data would you like to delete : ");
			data = sc.nextInt();
			boolean found=false;
			for(int i=0;i<ls.size();i++){
				if(ls.get(i) == data){
					ls.remove(i);
					found=true;
					System.out.println("\n-----Data succesfully removed-----\n");
				}
			}
			if(found==false){
				System.out.println("\n-----Data is not found(Not deleted!)-----\n");
			}
		}
	}
	/* Which position in insert to data */
	public void insertPosition(List<Integer> ls,int position , int data,Scanner sc){
		System.out.print("\n-----Enter at which position would you like to enter data : ");
		position = sc.nextInt();
		if(position<1 || position>ls.size()+1){
			System.out.println("\n-----Invalid position-----\n");
		}else{
			System.out.print("\n-----Enter data : ");
			data = sc.nextInt();
			ls.add((position-1),data);
			System.out.println("\n-----Data is entered at inserted position-----\n");
		}
	}
	/* Which position from delete to data */
	public void deletePosition(List<Integer> ls,int position,Scanner sc){
		if(ls.size() <1){
			System.out.println("\n-----There is no data to delete-----\n");
		}else{			
			System.out.print("\n-----Enter at which position would you like to delete : ");
			position = sc.nextInt();
			if(position<1 || position>ls.size()){
				System.out.println("\n-----Invalid position-----\n");
			}else{
				ls.remove(position-1);
				System.out.println("\n-----Data is deleted at inserted position-----\n");		
			}
		}
	}
	/* Display Data */
	public void displayData(List<Integer> ls,Scanner sc){
		System.out.println("\nUnSorted Dats is : "+ls);
		int count =1,j;
    	while(count < ls.size()) {
        	int value = ls.get(count);
        	j = count;
        	while((j > 0) && (ls.get(j - 1)> value)) {
            	ls.set(j,ls.get(j - 1));
            	j--;
        	}
        	ls.set(j,value);
			count++;
   	 	}
		System.out.println("Sorted Data Is : "+ls);
	} 

	public static void main(String[] args) { /* main method */
		InextureTaskFifth obj = new InextureTaskFifth();
		ArrayList<Integer> ls = new ArrayList<Integer>(); //ArrayList for Storing Data
		boolean flag = true; 
		
		while(flag){		
			try{		//try block 
				Scanner sc = new Scanner(System.in);
				int choice = 0;		
				int position = 0;   
				Integer data=0;
			
				System.out.println("\nEnter to do following. ");
				System.out.println("Enter 1 to insert data. ");
				System.out.println("Enter 2 to delete data. ");
				System.out.println("Enter 3 to insert data at position.");
				System.out.println("Enter 4 to delete data at position. ");
				System.out.println("Enter 5 to print data. ");
				System.out.println("Enter 6 to exit. ");
				System.out.print("Please Enter Choice :");
		
				choice = sc.nextInt(); //take the value from user then decide which statement execute
				
				switch(choice){
					/* Insert Data */
					case 1 :obj.insertData(ls,data,sc);
							break;
					/* Delete Data */			
					case 2 :obj.deleteData(ls,data,sc);
							break;
					/* Insert Data At Any Position */		 
					case 3 :obj.insertPosition(ls,position,data,sc);
							break;
					/* Delete Data At Any Position */						
					case 4 :obj.deletePosition(ls,position,sc);
							break;
					/* Display Data From Array List */ 
					case 5 :obj.displayData(ls,sc); 
							break;
					/* Exit */			
					case 6 :flag = false;
							sc.close(); 
							break;
							 
					default :System.out.println("\n-----Invalid choice enter choice again-----\n");
				}
			}
			catch(InputMismatchException e){
				System.out.println("-----Please Insert Only Number Not Allowed Character-----");
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
    } 
}