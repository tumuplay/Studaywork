package tumu;

public class RoleTest {

	public static void main(String[] args) {
		//实例化
		Role role1 = new Role(); //在main方法的栈空间声明了一个变量role1 类型是Role  ; 在堆空间中创造了分配了一块空间,并将空间地址赋给了role1;
		role1.name = "劳拉";
		role1.level = 25;
		role1.job = "摸金校尉";
		role1.doSkill();
		role1.show();
		
		
		Role role2 = null; //声明了Role类型的变量,role2
		role2 = new Role();
		role2.name ="孙悟空";
		role2.job = "神仙";
		role2.level = 99;
		role2.doSkill();
		role2.show();
		
		Role role3 = new Role();
		role3.name = "小仙女";
		role3.doSkill();
		role3.show();
	}

}
