
class Computer {
    String brand;  //品牌
}
public class SxtStu {
    // field
    int id;
    String sname;
    int age;
    Computer comp;
    void study() {
        System.out.println("我正在学习！使用我们的电脑，"+comp.brand);
    }
    public static void main(String[] args) {
        SxtStu stu1 = new SxtStu();
        stu1.sname = "张三";
        Computer comp1 = new Computer();
         comp1.brand = "联想";
        stu1.comp = comp1;
        stu1.study();
    }
}
