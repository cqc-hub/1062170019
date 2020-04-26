import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
// in ∂¡ ; out –¥
public class TextIO2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		byte[]b=new byte[1024];
		StringBuffer sb=new StringBuffer();
		int temp;
		try {
			FileInputStream fis=new FileInputStream("d:/a.txt");
			while((temp=fis.read(b))!=-1){
				sb.append(new String(b));	
			}
			System.out.println(sb);
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
	/*	byte[] b=new byte[1024];
		
		StringBuffer str=new StringBuffer();
		int temp;
		
		try {
			FileInputStream fis=new FileInputStream("d:/a.txt");
			while((temp=fis.read(b))!=-1){
				str.append(new String(b));
			}System.out.println(str);
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
			
		
		
		
		
		
		
//		byte[] b = new byte[1024];
//		StringBuffer str = new StringBuffer();
//		int len ;
//		// —≠ª∑∂¡»°
//		try {
//			FileInputStream fis = new FileInputStream("d:/a.txt");
//			while ((len = fis.read(b)) != -1) {
//				str.append(new String(b, 0, len));
//			}
//			System.out.println(str.toString());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		/*String str;
		StringBuilder sb=new StringBuilder();
		int temp;
	    try {
			FileInputStream fis=new FileInputStream("d:/a.txt");

			try {
				while((temp=fis.read())!=-1){

					sb.append((char)temp);
				}
				System.out.print(sb);
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 */

	}
}








