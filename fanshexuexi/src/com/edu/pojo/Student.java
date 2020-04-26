package com.edu.pojo;

public class Student extends Person{
	public String sname;
	public String ssex;	
	public String sfav;
	public int sage;
	public Student() {
		// TODO Auto-generated constructor stub
		super();
	}
	public int Shi(int n,String str){
		System.out.println("void Shi");
		return n;
		
	}
	public static void Shi(String str,int n){
		System.out.println("static Shi");
		
		
	}
}
