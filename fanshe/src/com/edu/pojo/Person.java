package com.edu.pojo;

public class Person {

	public String pname;   //������
	protected int page;		//��ǰ������ǰ����Ч������
	String pfav;			//��ǰ������ǰ��
	private String psex;	//��ǰ��
	public String pHi() {
		return "Hi Reflect";
		// TODO Auto-generated method stub
		
	}
	public String pHi(int number,String str) {
		return str+number;
		// TODO Auto-generated method stub
		
	}
	
	protected void pHello(){
		System.out.println("Person.pHello(protected)");
	}
	private void pHello1(){
		System.out.println("Person.pHello1(private)");
	}
	void pHello2(){
		System.out.println("Person.pHello2(defult)");
	}
}
