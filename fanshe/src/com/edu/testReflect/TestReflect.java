package com.edu.testReflect;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.edu.pojo.Person;
import com.edu.pojo.Student;
/*����ѧϰ
 	1����ȡ�����
 		Class cla=Class.forName("���ȫ�޶�·��");
 	2����ȡ����
 		cla.getFields(); //������ļ��丸������й����ֶ�Field����       ����Field[]
 		cla.getDeclaredFields();//�����������������ֶΣ����������ࣩ  ����Field[]
 		cla.getField(String name);	//��ȡ���༰�丸���ָ�������ֶ�     ����Field
 		cla.getDeclaredField(String name);��ȡ�����ָ�������ֶΣ����������ࣩ ����Field
 		------------
 			Field[] fds=cla.getFields();
 			for(Field f:fds){
		
			System.out.println("��ȡ������---->"+f.getName());
			System.out.println("��ȡ���η�---->"+f.getModifiers());
			System.out.println("��ȡ����---->"+f.getType());
			
		    }
 	3����������
 		������̬����
 * 			Field f=cla.getDeclaredField("�ֶ���");
 * 			f.set(null,�µ�ֵ);
 * 			f.get(null);
 * 		�����Ǿ�̬����
 * 			Field fd=cla.getDeclaredField("�ֶ���");
 *          //fd.setAccessible(true);//�����������˽������(����private����ʱ�õ������Ȳ���ȫ)
 * 			Object obj=cla.newInstance();
			fd.set(obj, "�ֶ�ֵ");
			System.out.println(fd.get(obj));//����һ��ʵ�������󲢷���
			
 	4����������
 		��ȡ������
 		��ȡ��������
 			getMethods();            					//����ȡ���еĹ��������������ࣩ
 			getDeclaredMethods();						//����ȡ���������ķ������������ࣩ
 			getMethod("pHi",int.class,String.class);	//��ȡָ���Ĺ���������������
 			getDeclaredMethod("sHello", null);			//��ȡָ���ķ�������������
 		��������
 			��̬����
 			�Ǿ�̬����
 
 */





public class TestReflect {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, 
	IllegalArgumentException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
		//�������������
		 //operFileld();
		
		//getCla();

		//��������෽��
			operMethod();
				
		
	}
	//��������
	private static void operMethod() throws ClassNotFoundException, 
	NoSuchMethodException, SecurityException, IllegalAccessException, 
	IllegalArgumentException, InvocationTargetException, InstantiationException {
		//��ȡ�����
		Class cla=Class.forName("com.edu.pojo.Student");
		//��ȡ�෽������
		  //����ȡ���еĹ��������������ࣩ
			Method[] ms=cla.getMethods();
			for(Method m:ms){
				System.out.println("��ȡ������---->"+m.getName());
			}
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
		  //����ȡ���������ķ������������ࣩ
			Method[] ms2=cla.getDeclaredMethods();//���Լ����������з�����
			for(Method m:ms2){
				System.out.println("��ȡ������---->"+m.getName());
			}
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
		  //��ȡָ���Ĺ��������������� cla.getMethod("sHi",Class����);��Class���Ⱥ�˳��
			Method ms3=cla.getMethod("pHi",int.class,String.class);
			System.out.println(ms3.getReturnType());
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
		  //��ȡָ���ķ�������������
			Method ms4=cla.getDeclaredMethod("sHello", null);
			System.out.println(ms4.getName());
		  //ִ�з���
				//��̬
					Method ms5=cla.getDeclaredMethod("sHi", String.class);//���ؾ�̬����
					ms5.invoke(null, "����ѧ�˷���ÿ��Ĺ�������������");//���ݲ���
				//�Ǿ�̬
					Method ms6=cla.getDeclaredMethod("sHi", int.class,String.class);
					ms6.invoke(cla.newInstance(), 3,"���书�ܺ�ǿ��");
			
	}

	private static void  operFileld() throws ClassNotFoundException, 
	NoSuchFieldException, SecurityException, IllegalArgumentException, 
	IllegalAccessException, InstantiationException {
		// TODO Auto-generated method stub
		//��ȡ�����
		Class cla=Class.forName("com.edu.pojo.Student");
		//��ȡ����������
			//��ȡ�����Լ��丸��Ĺ����ֶ�
		Field[] fds=cla.getFields();
		for(Field f:fds){
			System.out.println("��ȡ����---->"+f.getType());
			System.out.println("��ȡ������---->"+f.getName());
			System.out.println("��ȡ���η�---->"+f.getModifiers());
			//����int���ԣ������˫�����η������������η��ĺͣ�����ֵ�����ظ���
			
			//public static int money=1000;  public(ֵ1)��static(ֵ8)�������η�
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			//��ȡ�������������ֶ�
		Field[] fds2=cla.getDeclaredFields();
		for(Field f:fds2){
		
			System.out.println("��ȡ������---->"+f.getName());
			System.out.println("��ȡ���η�---->"+f.getModifiers());
			System.out.println("��ȡ����---->"+f.getType());
			
		}
			//��ȡָ���ֶ�(ֻ�ܻ�ȡ�����ֶ�)
		Field f=cla.getField("sname");
		System.out.println(f.getName());
		System.out.println(f.getType());
		
		//��ȡָ�����ָ���ֶΣ���������У�
		Field f2=cla.getDeclaredField("sage");
		System.out.println(f2.getName());
		System.out.println(f2.getType());
		
		
		//��ȡ�����..
		Field f3=cla.getSuperclass().getDeclaredField("page");
		System.out.println(f3.getName());
		
		
		//�����ֶ�ֵ
			System.out.println("**************������̬�ֶ�");
			Field fs=cla.getDeclaredField("money");
			//����Ǿ�̬������"null"��������̬����ֵ��
			fs.set(null, 2000);//��ֵ����̬��
			System.out.println(fs.get(null));
			
			//����ǷǾ�̬����
			System.out.println("**************�����Ǿ�̬�ֶ�");
			Field fd=cla.getDeclaredField("sname");
			//�������Ǿ�̬����ֵ��
			//fd.setAccessible(true);//�����������˽������(����private����ʱ�õ������Ȳ���ȫ)
			Object obj=cla.newInstance();
			fd.set(obj, "����");
			System.out.println(fd.get(obj));//����һ��ʵ�������󲢷���
			
			
			
			Field fd1=cla.getDeclaredField("ssex");
			fd1.setAccessible(true);
			Object obj2=cla.newInstance();
			fd1.set(obj2, "Ů");
			System.out.println(fd1.get(obj2));
			
			
		
	} 	
	//�����ȡ�����
	private static void getCla() throws ClassNotFoundException {
		// TODO Auto-generated method stub
	
		Class cla01=Class.forName("com.edu.pojo.Person");  //��Person����浽cla��
		Class cla02=Person.class;
		Class cla03=new Person().getClass();
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		//���÷���
		System.out.println(cla01==cla02);
		System.out.println("��ȡ��������--->"+cla01.getPackage());
		System.out.println("��ȡ�����η�--->"+cla01.getModifiers());
		System.out.println("��ȡ����(ȫ�޶�)--->"+cla01.getName());
		System.out.println("��ȡ����--->"+cla01.getSimpleName());
		System.out.println("��ȡ��ĸ���������--->"+cla01.getSuperclass());
	}
	
}











/*
//���䴴�������(��̬��������)
		//��ͳ��ʽ  Person p=new Person()
		
		
		��һ�ַ�ʽ������ᣩ  (���������)
		 * Class.forName();//����ȫ�޶�·����ȡ������ᣩ
		Class cla01=Class.forName("com.edu.pojo.Person");  //��Person����浽cla��
		Object obj=cla01.newInstance(); //newInstance() �᷵��Person�Ķ���Object���ͣ�
		�൱�� Person p=new Person()
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		

		�ڶ��ַ�ʽ�����õײ�ʹ�÷����װ�ķ��������Ƚϼ��ߣ�                 ������.getClass();//���߶����ȡ
		�����ڣ������ô�ͳ��ʽ����ʱ���Ѿ�д�˼������ˣ�ͻȻ������һ�������ײ����з����װ�ģ�
		�������ܷ��㣬��ʱ��ͰѴ�ͳ��ʽ�����Ķ��󶪽�ȥ�ͺ���
		Class cla02=Person.class;
		
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
		//�����ַ�ʽ (���)
		Class cla03=new Person().getClass();
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		*/
