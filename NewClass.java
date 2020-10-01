import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NewClass {

    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows:");
        int noOfRows = sc.nextInt();
        while(noOfRows%2==0){
           System.out.println("Only an odd number can be inserted. Enter number of rows:");
           noOfRows = sc.nextInt(); 
        }
        String str = concatFibSeries(noOfRows*3);
        List<String> list = chopp(str,noOfRows);
        printDimondPattern(list);
    }
    // Formula for the n-th Fibonacci number
    static int nthFib(int n){
        return (int)( ( 1/Math.sqrt(5) )* ( (Math.pow( ( ( 1+Math.sqrt(5) )/2),n ) ) - (Math.pow( ( ( 1-Math.sqrt(5) )/2),n ) ) ) );    
    }
    // returns a string of all Fibonacci numbers upto the nth Fibonacci number concatenated with "+"
    static String concatFibSeries(int n){
        StringBuilder sb = new StringBuilder();
        for(int i= 1; i<=n; i++){
            sb.append(nthFib(i)).append("+");
        }
        return sb.toString();
    }
    // cuts the string returned by the method concatFibSeries(int n) into small chunks
    // returns a list of strings with list.size equal to given rows
    // the length of the strings beginns by one and increases by two on each step till the middle row is reached
    // and decreases by two till the end of rows is reached
    static List<String> chopp(String concatenatedString,int rows){
        List<String> list = new ArrayList<>();
        for(int i = 1, j = 1; i <= rows; i++, j=(i<= Math.ceil(rows/2.))? j+2 : j-2){
           list.add(concatenatedString.substring(0,j));
           concatenatedString = concatenatedString.substring(j);
           if (concatenatedString.startsWith("+")){
               concatenatedString = concatenatedString.substring(1);
           }
        }
        return list;    
    }
    // adds the required space before and after each string and prints the string
    static void printDimondPattern(List<String> list){
        for(int i = 0; i< list.size();i++){
            String str ="";
            for (int j = 0; j<(Math.abs(list.size()-Math.ceil(list.size()/2.)-i));j++){
                str +=" ";
            }
            System.out.println(str+list.get(i)+str);
        }
    }        
}