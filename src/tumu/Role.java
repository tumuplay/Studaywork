package tumu;
/**
 * ��Ϸ�Ľ�ɫ��
 * @author 
 * @���� ��ľ
 * @��ע
 */
public class Role {
		//����
	//�ȼ�
	//ְҵ
	//����
	/** ��Ϸ��ɫ����������*/
	public String name;
	/** �ȼ�*/
	public int level;
	/** ְҵ */
	public String job;
	
	public void show(){
		System.out.println(name + "\t" + level + "\t" + job);
	}
	/** ����*/
	public void doSkill(){
		if(name.equals("����")){
			System.out.println("һ�ѽ���,һ�ѽа�");
		}else if(name.equals("�����")){
			System.out.println("�԰�����һ��!");
		}else{
			System.out.println(name + "С����֮ȭ!!!!");
		}
	}
}
