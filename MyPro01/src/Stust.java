class Shu{
	String sname;
}

public class Stust {

	int age;
	String id,name;
	Shu shu;
	void study(){
		System.out.println("我是"+name+",我正在看"+shu.sname);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stust stu=new Stust();
		stu.name="cqc";
		stu.id="07";
		Shu shu=new Shu();
		shu.sname="平凡的世界";
		stu.shu=shu;
		stu.study();
	}

}
