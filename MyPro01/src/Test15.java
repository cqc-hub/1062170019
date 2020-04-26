
public class Test15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 outer: for (int i = 101; i < 150; i++) {
	            for (int j = 2; j < i / 2; j++) {
	                if (i % j == 0){
	                    continue outer;
	                }
	            }
	            System.out.print(i + "  ");
	        }
	    }
}
