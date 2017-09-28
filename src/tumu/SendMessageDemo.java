package tumu;

import java.util.concurrent.TimeUnit;

/**
 * 使用方法模拟实现网络游戏中的世界喊话功能
 * 喊话者 , 频道, 内容, 喊话次数, 喊话的时间间隔
 * @author 
 * @作者 土木
 * @备注
 */
public class SendMessageDemo {
	public static void main(String[] args){
		
		//SendMessage("王二狗", "世界频道", "辣鸡", 5, 1);
		SendMessage("王二狗", "世界频道");
	}
	
	/**
	 * 重载的喊话方法
	 * @param nickName	昵称
	 * @param channlName	频道
	 */
	public static void SendMessage(String nickName, String channelName){
		SendMessage(nickName, channelName, "小辣鸡小辣鸡", 4, 1);
	}
	/**
	 * 重载的喊话方法,只需要用户提供昵称参数即可进行默认的喊话
	 * @param nicName
	 */
	public static void SendMessage(String nicName){
		String[] contents = {
				"你是小辣鸡吗",
				"炫舞世界有武神大人巡守,无人可犯"
		};
		SendMessage(nicName, "默认频道", contents[(int)(Math.random() *2)], 10, 1);
	}
	/**
	 * 实现游戏中的喊话功能
	 * @param name 			喊话者的昵称
	 * @param channelName	喊话的频道名称
	 * @param message		喊话的内容
	 * @param count			喊话的次数
	 * @param interval		喊话的时间间隔	(单位,秒)
	 */
	public static void SendMessage(String name, String channelName, String message, int count, int interval){
		if(interval < 5) interval = 5;
		//总体逻辑: 拼接字符串以后打印出来
		String value = String.format("【%s】%s:%s",
				channelName, name, message);
		for(int i = 0; i < count; i++){
			System.out.println(value);
			try{
				//TimeUnit.HOURS.sleep(interval);
				TimeUnit.SECONDS.sleep(interval);
				//Thread.sleep(interval * 1000);//休眠多少秒
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		//元宝-10
		
	}
	
	
}
