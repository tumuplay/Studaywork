package tumu;

import java.util.concurrent.TimeUnit;

/**
 * ʹ�÷���ģ��ʵ��������Ϸ�е����纰������
 * ������ , Ƶ��, ����, ��������, ������ʱ����
 * @author 
 * @���� ��ľ
 * @��ע
 */
public class SendMessageDemo {
	public static void main(String[] args){
		
		//SendMessage("������", "����Ƶ��", "����", 5, 1);
		SendMessage("������", "����Ƶ��");
	}
	
	/**
	 * ���صĺ�������
	 * @param nickName	�ǳ�
	 * @param channlName	Ƶ��
	 */
	public static void SendMessage(String nickName, String channelName){
		SendMessage(nickName, channelName, "С����С����", 4, 1);
	}
	/**
	 * ���صĺ�������,ֻ��Ҫ�û��ṩ�ǳƲ������ɽ���Ĭ�ϵĺ���
	 * @param nicName
	 */
	public static void SendMessage(String nicName){
		String[] contents = {
				"����С������",
				"�����������������Ѳ��,���˿ɷ�"
		};
		SendMessage(nicName, "Ĭ��Ƶ��", contents[(int)(Math.random() *2)], 10, 1);
	}
	/**
	 * ʵ����Ϸ�еĺ�������
	 * @param name 			�����ߵ��ǳ�
	 * @param channelName	������Ƶ������
	 * @param message		����������
	 * @param count			�����Ĵ���
	 * @param interval		������ʱ����	(��λ,��)
	 */
	public static void SendMessage(String name, String channelName, String message, int count, int interval){
		if(interval < 5) interval = 5;
		//�����߼�: ƴ���ַ����Ժ��ӡ����
		String value = String.format("��%s��%s:%s",
				channelName, name, message);
		for(int i = 0; i < count; i++){
			System.out.println(value);
			try{
				//TimeUnit.HOURS.sleep(interval);
				TimeUnit.SECONDS.sleep(interval);
				//Thread.sleep(interval * 1000);//���߶�����
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		//Ԫ��-10
		
	}
	
	
}
