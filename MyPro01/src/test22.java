import java.sql.Date;
import java.text.SimpleDateFormat;

public class test22 {
    public static void main(String[] args) {
        long d1 = System.currentTimeMillis();  
        System.out.printf("%d�׳˵Ľ��:%s%n", 10, factorial(10));
        long d2 = System.currentTimeMillis();
        System.out.printf("�ݹ��ʱ��%s%n", d2-d1);  //��ʱ��32ms
        
        long currentTime = System.currentTimeMillis();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy��-MM��dd��-HHʱmm��ss��");

        Date date = new Date(currentTime);
        System.out.println(date);
        System.out.println(formatter.format(date));
       // *= a * (a - 1);   ?? a
        
    }
    /** ��׳˵ķ���*/
    static long  factorial(int n){
        if(n==1){//�ݹ�ͷ
            return 1;
        }else{//�ݹ���
            return n*factorial(n-1);//n! = n * (n-1)!
        }
    }
}

