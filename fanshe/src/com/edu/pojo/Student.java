package com.edu.pojo;

public class Student extends Person {
	//����ʵ���������
	public String sname="zhangsan";
	protected int sage;
	String sfav;
	private String ssex="��";

	public static int money=1000;
	
	//�޲ι�����
	public Student() {
		// TODO Auto-generated constructor stub
		super();
	}
	public int sHi() {
		return 2;
		// TODO Auto-generated method stub
		
	}
	public String sHi(int number,String str) {
		System.out.println(number+str);
		return str+number;
		// TODO Auto-generated method stub
		
	}
	public static String sHi(String str) {
		System.out.println(str);
		return str;
		// TODO Auto-generated method stub
		
	}
	protected void sHello(){
		System.out.println("Student.sHello(protected)");
	}
	private void sHello1(){
		System.out.println("Student.sHello1(private)");
	}
	void sHello2(){
		System.out.println("Student.sHello2(defult)");
	}
	
}
