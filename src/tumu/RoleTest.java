package tumu;

public class RoleTest {

	public static void main(String[] args) {
		//ʵ����
		Role role1 = new Role(); //��main������ջ�ռ�������һ������role1 ������Role  ; �ڶѿռ��д����˷�����һ��ռ�,�����ռ��ַ������role1;
		role1.name = "����";
		role1.level = 25;
		role1.job = "����Уξ";
		role1.doSkill();
		role1.show();
		
		
		Role role2 = null; //������Role���͵ı���,role2
		role2 = new Role();
		role2.name ="�����";
		role2.job = "����";
		role2.level = 99;
		role2.doSkill();
		role2.show();
		
		Role role3 = new Role();
		role3.name = "С��Ů";
		role3.doSkill();
		role3.show();
	}

}
