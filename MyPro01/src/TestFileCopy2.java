import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileCopy2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		fileCopy("d:/a.txt","d:/b.txt");
	}

	private static void fileCopy(String src, String dec) {
		// TODO Auto-generated method stub
		int temp;
		byte[]b=new byte[1024];
		
		try {
			FileInputStream fis=new FileInputStream(src);
			FileOutputStream fos=new FileOutputStream(dec);
			try {
				while((temp=fis.read(b))!=-1){
					fos.write(b);
				}
				fis.close();
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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*private static void fileCopy(String src, String dec) {
		// TODO Auto-generated method stub
		byte[] b=new byte[1024];
		int temp;
		
		try {
			FileInputStream fis=new FileInputStream(src);
			FileOutputStream fos=new FileOutputStream(dec);
			while((temp=fis.read(b))!=-1){
				fos.write(b);
			}
			fis.close();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}*/



}
