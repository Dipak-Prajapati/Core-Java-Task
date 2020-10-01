import java.io.DataInputStream;  
import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.InputStream;    

public class TryWithRes{
	public static void main(String args[]){
		/*try (PrintWriter writer = new PrintWriter(new File("test.txt"))) {
			writer.println("Hello World");
		}*/
	    try(FileInputStream input = new FileInputStream("D:\\INEXTURE\\corejava\\test.txt")) {
			int data = input.read();
			while(data != -1){
				System.out.print((char) data);
				data = input.read();
			}
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}
}