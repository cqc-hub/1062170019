import java.util.Scanner;

/**
 * @author cqc
 *
 */
public class TestScanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		
		System.out.printf("name:");
		String name=scanner.nextLine();
		System.out.printf("favor:");
		String favor=scanner.nextLine();
		System.out.printf("age:");
		int age=scanner.nextInt();
		
		 System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	        System.out.println(name);
	        System.out.println(favor);
	        System.out.println("���������������"+age*365);
	        System.out.println("�뿪�����������"+(72-age)*365);
	}

}
