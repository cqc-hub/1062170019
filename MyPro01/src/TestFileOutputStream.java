import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileOutputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str="   12345,Ê°Èþ";
		try {
			FileOutputStream fos=new FileOutputStream("d:/a.txt",true);
			
			try {
				fos.write(str.getBytes());
				
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
