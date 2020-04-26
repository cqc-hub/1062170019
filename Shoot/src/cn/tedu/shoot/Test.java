package cn.tedu.shoot;
//补充
public class Test {
	public static void main(String[] args) {
		/*
		//面试题一:
		short s = 5;
		s += 10; //扩展赋值运算，需要时会自动强制类型转换
		//s = s+10; //编译错误，必须强转
		*/
		
		//面试题二:
		/*
		int a = 0;
		for(int i=1;i<=100;i++){
			a=a++;
		}
		System.out.println(a); //0
		*/
		/*
		 *     a=0
		 * i=1 a=0
		 * i=2 a=0
		 * i=3 a=0
		 * ...
		 * i=100 a=0
		 */
		
		/*
		int a = 1;
		//1)记录a++的值1
		//2)a自增1变为2
		//3)将a++的值1赋值给a
		a=a++;
		System.out.println(a); //1
		*/
		
		//面试题三:
		//问:父类的构造方法可以被子类继承吗?
		//答:不可以，是在子类构造去调用父类的构造
		//Boo o1 = new Boo(5); //编译错误，子类不能继承父类的构造方法
		
		//面试题四:
		//问:如何不借助于第三数来交换两个整数
		//提示:加减减
		int a=5,b=8;
		a = a+b; //a=13
		b = a-b; //b=5
		a = a-b; //a=8
		
	}
}

class Aoo{
	Aoo(){
	}
	Aoo(int a){
	}
}
class Boo extends Aoo{
	Boo(){
	}
}


















