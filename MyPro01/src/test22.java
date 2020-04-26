import java.sql.Date;
import java.text.SimpleDateFormat;

public class test22 {
    public static void main(String[] args) {
        long d1 = System.currentTimeMillis();  
        System.out.printf("%d阶乘的结果:%s%n", 10, factorial(10));
        long d2 = System.currentTimeMillis();
        System.out.printf("递归费时：%s%n", d2-d1);  //耗时：32ms
        
        long currentTime = System.currentTimeMillis();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年-MM月dd日-HH时mm分ss秒");

        Date date = new Date(currentTime);
        System.out.println(date);
        System.out.println(formatter.format(date));
       // *= a * (a - 1);   ?? a
        
    }
    /** 求阶乘的方法*/
    static long  factorial(int n){
        if(n==1){//递归头
            return 1;
        }else{//递归体
            return n*factorial(n-1);//n! = n * (n-1)!
        }
    }
}

