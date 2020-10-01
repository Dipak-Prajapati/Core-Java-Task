/*
*	Write a program which convert number to binary , octal , hexadecimal and any base.
*/
import java.util.Scanner;
import java.util.InputMismatchException;
 
public class InextureTaskFirst{
	/* Decimal To Any Base Conversion */
   public void decimalToAny(int number,int base){									  
		try {
			/*declare an array for reminder*/
			int rem[] = new int[20];
			int temp_no=number;
			int i=0;
			/*for less than 9 base conversion*/
			if(base<9){
				/*while loop for diviosn of decimal upto end*/
				while(temp_no>0) {
					rem[i]=temp_no%base;
					i++;
					temp_no=temp_no/base;
				}
				System.out.print("-----Conversion Number is:");
				/* Display the Conversion */
				for(i= i-1;i>=0;i--){
					System.out.print(rem[i]);
				}
				System.out.println();
			} else {  /*for greater than 9 conversion*/   			               
				String value="";
				char c;
				while(temp_no>0) {
					int reminder=temp_no%base;
					if(reminder>=0 && reminder<=9) {
						c = (char)(reminder+48);	
					} else {
						c = (char)(reminder - 10 + 65);					
					}
					value=Character.toString(c)+value;			
					temp_no=temp_no/base;	
				}	
				System.out.println("-----Converted  Conversion is:"+value+"\n");		
			}
		}
		/*try close*/
		catch(Exception msg) {
			System.out.println("only integers numbers are allowed");
		}
	}
	public static void main(String args[]){
		boolean flag = true; 
		InextureTaskFirst obj = new InextureTaskFirst();
		while(flag){ 
			try{		//try block 
				Scanner sc = new Scanner(System.in);
				int choice = 0;		//take the value from user then decide which statement execute  
				int number , base;
				System.out.println("\nEnter to do following. ");
				System.out.println("Enter 1 to Convert Decimal To Binary. ");
				System.out.println("Enter 2 to Convert Decimal To Octal. ");
				System.out.println("Enter 3 to Convert Decimal To HexaDecimal.");
				System.out.println("Enter 4 to Convert Decimal To Any Base. ");
				System.out.println("Enter 5 to Exit. ");
				System.out.print("Please Enter Choice :");
			
				choice = sc.nextInt();
				
				switch(choice){
					/* Decimal To Binary Conversion */
					case 1 :System.out.print("\n-----Enter The Decimal Number : ");
							number = sc.nextInt();
							System.out.println("------Decimal Number To Binary Base Conversion------");
							obj.decimalToAny(number,2);
							break;
					
					/* Decimal To Octal Conversion */					
					case 2 :System.out.print("\n-----Enter The Decimal Number : ");
							number = sc.nextInt();
							System.out.println("------Decimal Number To Octal Base Conversion------");
							obj.decimalToAny(number,8);
							System.out.println();
							break; 
					
					/* Decimal To HexaDecimal Conversion */
					case 3 :System.out.print("\n-----Enter The Decimal Number : ");
							number = sc.nextInt();
							System.out.println("------Decimal Number To HexaDecimal Base Conversion------");
							obj.decimalToAny(number,16);
							System.out.println();
							break;
					
					/* Decimal To Any Base Conversion */
					case 4 :System.out.print("\n-----Enter The Decimal number:");
							number=sc.nextInt();  
							String msg;
							if (number < 1) {   			/* if less Number */
								msg = "\npostive and greater than 0 numbers are allowed\n";
								throw new IllegalArgumentException(msg);
							}
							
							System.out.print("\n-----Enter The base:");
							base=sc.nextInt();
							if (base < 2) {              /*if less base*/
								msg = "\npostive and greater than 1 base are allowed\n";
								throw new IllegalArgumentException(msg);
							}
							System.out.println("------Decimal Number To "+base+" Base Conversion------");
							obj.decimalToAny(number,base);
							break;
					
					/* Exit */
					case 5 :flag=false;
							sc.close();
							break;	  
							 			 
					default :System.out.println("\n-----Invalid choice enter choice again-----\n");
				}
			}
			catch(IllegalArgumentException msg) {
				System.out.print(msg);
			}
			catch(InputMismatchException e){
				System.out.println("\n-----Please Insert Only Number Not Allowed Character-----\n");
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}