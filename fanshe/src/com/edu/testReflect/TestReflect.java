package com.edu.testReflect;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.edu.pojo.Person;
import com.edu.pojo.Student;
/*反射学习
 	1、获取类对象
 		Class cla=Class.forName("类的全限定路径");
 	2、获取属性
 		cla.getFields(); //返回类的及其父类的所有公共字段Field数组       返回Field[]
 		cla.getDeclaredFields();//返回类声明的所有字段（不包括父类）  返回Field[]
 		cla.getField(String name);	//获取该类及其父类的指定公共字段     返回Field
 		cla.getDeclaredField(String name);获取该类的指定公共字段（不包括父类） 返回Field
 		------------
 			Field[] fds=cla.getFields();
 			for(Field f:fds){
		
			System.out.println("获取属性名---->"+f.getName());
			System.out.println("获取修饰符---->"+f.getModifiers());
			System.out.println("获取类型---->"+f.getType());
			
		    }
 	3、操作属性
 		操作静态属性
 * 			Field f=cla.getDeclaredField("字段名");
 * 			f.set(null,新的值);
 * 			f.get(null);
 * 		操作非静态属性
 * 			Field fd=cla.getDeclaredField("字段名");
 *          //fd.setAccessible(true);//暴力反射操作私有属性(操作private属性时用到，极度不安全)
 * 			Object obj=cla.newInstance();
			fd.set(obj, "字段值");
			System.out.println(fd.get(obj));//创建一个实例化对象并返回
			
 	4、操作方法
 		获取类属性
 		获取方法对象
 			getMethods();            					//（获取所有的公共方法包括父类）
 			getDeclaredMethods();						//（获取所有声明的方法不包括父类）
 			getMethod("pHi",int.class,String.class);	//获取指定的公共方法包括父类
 			getDeclaredMethod("sHello", null);			//获取指定的方法不包括父类
 		操作方法
 			静态方法
 			非静态方法
 
 */





public class TestReflect {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, 
	IllegalArgumentException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
		//反射操作类属性
		 //operFileld();
		
		//getCla();

		//反射操作类方法
			operMethod();
				
		
	}
	//操作方法
	private static void operMethod() throws ClassNotFoundException, 
	NoSuchMethodException, SecurityException, IllegalAccessException, 
	IllegalArgumentException, InvocationTargetException, InstantiationException {
		//获取类对象
		Class cla=Class.forName("com.edu.pojo.Student");
		//获取类方法对象
		  //（获取所有的公共方法包括父类）
			Method[] ms=cla.getMethods();
			for(Method m:ms){
				System.out.println("获取方法名---->"+m.getName());
			}
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
		  //（获取所有声明的方法不包括父类）
			Method[] ms2=cla.getDeclaredMethods();//（自己声明的所有方法）
			for(Method m:ms2){
				System.out.println("获取方法名---->"+m.getName());
			}
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
		  //获取指定的公共方法包括父类 cla.getMethod("sHi",Class类型);（Class有先后顺序）
			Method ms3=cla.getMethod("pHi",int.class,String.class);
			System.out.println(ms3.getReturnType());
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
		  //获取指定的方法不包括父类
			Method ms4=cla.getDeclaredMethod("sHello", null);
			System.out.println(ms4.getName());
		  //执行方法
				//静态
					Method ms5=cla.getDeclaredMethod("sHi", String.class);//返回静态方法
					ms5.invoke(null, "今天学了反射好开心哈哈哈哈哈哈哈");//传递参数
				//非静态
					Method ms6=cla.getDeclaredMethod("sHi", int.class,String.class);
					ms6.invoke(cla.newInstance(), 3,"反射功能好强大");
			
	}

	private static void  operFileld() throws ClassNotFoundException, 
	NoSuchFieldException, SecurityException, IllegalArgumentException, 
	IllegalAccessException, InstantiationException {
		// TODO Auto-generated method stub
		//获取类对象
		Class cla=Class.forName("com.edu.pojo.Student");
		//获取反射类属性
			//获取该类以及其父类的公共字段
		Field[] fds=cla.getFields();
		for(Field f:fds){
			System.out.println("获取类型---->"+f.getType());
			System.out.println("获取属性名---->"+f.getName());
			System.out.println("获取修饰符---->"+f.getModifiers());
			//返回int属性，如果是双重修饰符返回俩个修饰符的和（所有值不会重复）
			
			//public static int money=1000;  public(值1)和static(值8)就是修饰符
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			//获取类声明的所有字段
		Field[] fds2=cla.getDeclaredFields();
		for(Field f:fds2){
		
			System.out.println("获取属性名---->"+f.getName());
			System.out.println("获取修饰符---->"+f.getModifiers());
			System.out.println("获取类型---->"+f.getType());
			
		}
			//获取指定字段(只能获取公共字段)
		Field f=cla.getField("sname");
		System.out.println(f.getName());
		System.out.println(f.getType());
		
		//获取指定类的指定字段（该类的所有）
		Field f2=cla.getDeclaredField("sage");
		System.out.println(f2.getName());
		System.out.println(f2.getType());
		
		
		//获取父类的..
		Field f3=cla.getSuperclass().getDeclaredField("page");
		System.out.println(f3.getName());
		
		
		//操作字段值
			System.out.println("**************操作静态字段");
			Field fs=cla.getDeclaredField("money");
			//如果是静态变量填"null"（操作静态属性值）
			fs.set(null, 2000);//赋值（静态）
			System.out.println(fs.get(null));
			
			//如果是非静态变量
			System.out.println("**************操作非静态字段");
			Field fd=cla.getDeclaredField("sname");
			//（操作非静态属性值）
			//fd.setAccessible(true);//暴力反射操作私有属性(操作private属性时用到，极度不安全)
			Object obj=cla.newInstance();
			fd.set(obj, "李四");
			System.out.println(fd.get(obj));//创建一个实例化对象并返回
			
			
			
			Field fd1=cla.getDeclaredField("ssex");
			fd1.setAccessible(true);
			Object obj2=cla.newInstance();
			fd1.set(obj2, "女");
			System.out.println(fd1.get(obj2));
			
			
		
	} 	
	//反射获取类对象
	private static void getCla() throws ClassNotFoundException {
		// TODO Auto-generated method stub
	
		Class cla01=Class.forName("com.edu.pojo.Person");  //把Person对象存到cla里
		Class cla02=Person.class;
		Class cla03=new Person().getClass();
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		//常用方法
		System.out.println(cla01==cla02);
		System.out.println("获取类对象包名--->"+cla01.getPackage());
		System.out.println("获取类修饰符--->"+cla01.getModifiers());
		System.out.println("获取类名(全限定)--->"+cla01.getName());
		System.out.println("获取类名--->"+cla01.getSimpleName());
		System.out.println("获取类的父类的类对象--->"+cla01.getSuperclass());
	}
	
}











/*
//反射创建类对象(动态创建对象)
		//传统方式  Person p=new Person()
		
		
		第一种方式（必须会）  (创建类对象)
		 * Class.forName();//工具全限定路径获取（必须会）
		Class cla01=Class.forName("com.edu.pojo.Person");  //把Person对象存到cla里
		Object obj=cla01.newInstance(); //newInstance() 会返回Person的对象，Object类型，
		相当于 Person p=new Person()
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		

		第二种方式（调用底层使用反射封装的方法）（比较鸡肋）                 对象名.getClass();//工具对象获取
		常用于：当先用传统方式编码时，已经写了几百行了，突然发现有一个方法底层是有反射封装的，
		用起来很方便，这时候就把传统方式创建的对象丢进去就好了
		Class cla02=Person.class;
		
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
		//第三种方式 (最鸡肋)
		Class cla03=new Person().getClass();
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		*/
