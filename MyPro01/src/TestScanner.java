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
	        System.out.println("来到地球的天数："+age*365);
	        System.out.println("离开地球的天数："+(72-age)*365);
	}

}
