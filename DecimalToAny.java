import java.util.Scanner;


public class DecimalToAny
{
	public static void decimalToAny()
	{
		int number=0;
		int base=0;										  
		Scanner sc=new Scanner(System.in);
		try {
			System.out.print("-----Enter The Decimal number:");
			number=sc.nextInt(); 
			if (number< 1) {            /*if negative number*/
				throw new IllegalArgumentException();
			}
			System.out.print("-----Enter The base:");
			base=sc.nextInt();
			if (base< 2) {              /*if less base*/
				throw new ArrayIndexOutOfBoundsException();
			}	                       
		}
		/*try close*/
		catch(IllegalArgumentException msg) {
			System.out.println("only postive and greater than 0 numbers are allowed\n");	
		}
		catch(ArrayIndexOutOfBoundsException msg) {
			System.out.println("only postive and greater than 2 base are allowed\n");	
		}
		catch(Exception msg) {
			System.out.println("only integers numbers are allowed");
		}

		/*declare an array for remainder*/		 
		System.out.println("------Decimal Number To Any Base Conversion------");
		int rem[] = new int[20];
		/*while loop for diviosn of decimal upto end*/
		int temp_no=number;
		int i=0;
		/*for less than 9 base conversion*/

		if(base<9) {
			while(temp_no>0) {
				rem[i]=temp_no%base;
				i++;
				temp_no=temp_no/base;
			}
			System.out.print("-----Conversion Number is:");
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

			System.out.println("converted num is:"+value+"\n");		
		}		
	}
	
	public static void dconversion()
	{
		boolean flag = true; 
		
		while(flag){ 
			try{		//try block 
				Scanner sc = new Scanner(System.in);
				int choice = 0;		//take the value from user then decide which statement execute  
				int number;
				System.out.println("Enter to do following. ");
				System.out.println("Enter 1 to Convert Decimal To Binary. ");
				System.out.println("Enter 2 to Convert Decimal To Octal. ");
				System.out.println("Enter 3 to Convert Decimal To HexaDecimal.");
				System.out.println("Enter 4 to Convert Decimal To Any Base. ");
				System.out.println("Enter 5 to Exit. ");
				System.out.print("Please Enter Choice :");
			
				choice = sc.nextInt();
				
				switch(choice){
					/* Decimal To Binary Conversion */
					case 1 :System.out.println(); 
							System.out.print("-----Enter The Decimal Number : ");
							//number = Integer.parseInt(sc.nextLine());
							number = sc.nextInt();
							System.out.println("Decimal : "+number+" in Binary :"+Integer.toBinaryString(number));
							System.out.println();
							break;
					
					/* Decimal To Octal Conversion */					
					case 2 :System.out.println(); 
							System.out.print("-----Enter The Decimal Number : ");
							//number = Integer.parseInt(sc.nextLine());
							number = sc.nextInt();
							System.out.println("Decimal : "+number+" in Octal :"+Integer.toOctalString(number));
							System.out.println();
							break; 
					
					/* Decimal To HexaDecimal Conversion */
					case 3 :System.out.println(); 
							System.out.print("-----Enter The Decimal Number : ");
							//number = Integer.parseInt(sc.nextLine());
							number = sc.nextInt();
							System.out.println("Decimal : "+number+" in HexaDecimal :"+Integer.toHexString(number).toUpperCase());
							System.out.println();
							break;
					
					/* Decimal To Any Base Conversion */
					case 4 : decimalToAny();
							 break;
					
					/* Exit */
					case 5 :flag=false;
							break;	  
							 			 
					default : System.out.println();
							  System.out.println("-----Invalid choice enter choice again-----");
							  System.out.println();
				}
			}
			catch(Exception e){
				System.out.println();
				System.out.println("-----Please Insert Only Number-----");
				System.out.println();
			}
		}
	}
	public static void main(String args[])
	{
		dconversion();
	}
}