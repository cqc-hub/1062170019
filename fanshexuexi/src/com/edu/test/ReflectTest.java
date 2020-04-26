package com.edu.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {
	
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		xuexi();
	}

	private static void xuexi() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		// TODO Auto-generated method stub
	
		Class cla=Class.forName("com.edu.pojo.Student");
		Method m=cla.getDeclaredMethod("Shi", int.class,String.class);
		int s=(int) m.invoke(cla.newInstance(), 3,"fds");
		
		
		Method ms=cla.getDeclaredMethod("Shi", String.class,int.class);
		
		ms.invoke(null, "fds",3);
		
		
	}
	
	
	
}
