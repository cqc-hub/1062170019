class Shu{
	String sname;
}

public class Stust {

	int age;
	String id,name;
	Shu shu;
	void study(){
		System.out.println("����"+name+",�����ڿ�"+shu.sname);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stust stu=new Stust();
		stu.name="cqc";
		stu.id="07";
		Shu shu=new Shu();
		shu.sname="ƽ��������";
		stu.shu=shu;
		stu.study();
	}

}
