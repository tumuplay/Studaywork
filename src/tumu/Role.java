package tumu;
/**
 * 游戏的角色类
 * @author 
 * @作者 土木
 * @备注
 */
public class Role {
		//名称
	//等级
	//职业
	//技能
	/** 游戏角色的名称属性*/
	public String name;
	/** 等级*/
	public int level;
	/** 职业 */
	public String job;
	
	public void show(){
		System.out.println(name + "\t" + level + "\t" + job);
	}
	/** 技能*/
	public void doSkill(){
		if(name.equals("劳拉")){
			System.out.println("一把叫射,一把叫啊");
		}else if(name.equals("孙悟空")){
			System.out.println("吃俺老孙一棒!");
		}else{
			System.out.println(name + "小辣鸡之拳!!!!");
		}
	}
}
