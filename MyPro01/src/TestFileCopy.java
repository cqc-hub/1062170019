import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		copyFile("d:/a.txt","d:/b.txt");

	}

	private static void copyFile(String src, String dec) {
		// TODO Auto-generated method stub
		byte[] b=new byte[1024];
		int temp;
		
		try {
			FileInputStream fis=new FileInputStream(src);
			FileOutputStream fos=new FileOutputStream(dec);
			
			try {
				while((temp=fis.read( b))!=-1){
					fos.write(b);
				}
				if(fis!=null){
					fis.close();
				}
				if(fos!=null){
					fos.close();
				}
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
	
	
/*	private static void copyFile(String src, String dec) {
		// TODO Auto-generated method stub
		
		byte[] b=new byte[1024];
		int temp;
		
		try {
			FileInputStream fis=new FileInputStream(src);
			FileOutputStream fos=new FileOutputStream(dec);
			
			try {
				while((temp=fis.read(b))!=-1)
				{
					fos.write(b);
				}
				if(fis!=null){
					fis.close();
				}
				if(fos!=null){
					fos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


*/

/**
 * @author cqc
 *
 */