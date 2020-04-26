package com.edu.pojo;

public class Person {

	public String pname;   //公共的
	protected int page;		//当前包、当前类有效、子类
	String pfav;			//当前包、当前类
	private String psex;	//当前类
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
