package tumu;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class AppMain {
	public static void main(String[] args) {
		//�����������
		
		Scanner input = new Scanner(System.in);
		//Ұ����Ů����������
		String[] newNameArray = {"���", "���", "���¸�", "������", "С��Ů"};
		int newNameCount = newNameArray.length;//��ѡҰ����Ů����
		//��������������
		String[] nnNameArray = {"��ʩ", "����", "���Ѿ�", "����", "�Է���", "", "", "", "", ""};
		//�󹬼�������
		String[] levelNames = {"����", "����", "����", "�ʹ���", "�ʺ�"};
		//��Ӧÿ������ļ���
		int[] level = new int[10];
		//ÿ������ȶ�Ӧ�ĺøж�
		int[] loves = new int[10];
		//�����ʼ����Ϊ5
		int nnCount = 5;
		// ��ϷĬ������ʮ��
		int gamedays = 1; 
		//�ʵ�����ֵ
		int heart = 100;
		//�趨Ĭ�Ϻøж�Ϊ100
		for (int i = 0; i < nnCount; i++) {
			loves[i] = 100;
		}
		//��Ϸ������
		JOptionPane.showMessageDialog(null, "����������ѽ", "��ӭ������ѡ��", 0, new ImageIcon("images/title.jpg"));
			
		while(gamedays <= 10){
//			System.out.println("��Ϸ���е���" + gamedays + "��!");
//			System.out.println("1.�ʵ���ּѡ��\t\t(����)");
//			System.out.println("2.���Ƴ���\t\t(�޸�״̬)");
//			System.out.println("3.�����乬\t\t(ɾ��)");
//			System.out.println("4.�绨ѩ��,�밮������\t\t(���� �޸�״̬)");
//			System.out.print("������ѡ��:");
//			int choice = input.nextInt();
			String strMenu = "1.�ʵ���ּѡ��\n";
			strMenu += "2.���Ƴ���\n";
			strMenu += "3.�����乬\n";
			strMenu += "4.�绨ѩ��\n";
			strMenu += "������ѡ�����Ҫ��������\n";
			Object objResult = JOptionPane.showInputDialog(null, strMenu, "��Ϸ���е���" + gamedays + "��", 0, new ImageIcon("images/����.jpg"), 
							new String[]{"1", "2", "3", "4"}, 1);
					
			//�ж��û�ѡ��ȡ�������- Ŀǰʡ��
			//���û���ѡ��(1 - 4֮����ַ���) ת�������� 
			//int choice = Integer.parseInt(objResult.toString());
			switch(objResult.toString()){
			case "1":
				if(nnCount == nnNameArray.length){
					System.out.println("���Ѿ�����Ϊ��,���±�������ѽ!");
				}
//				System.out.print("���������������:");
//				String newName = input.next();
				
				objResult = (String)JOptionPane.showInputDialog(null, "��ѡ����Ů", 
						"ѡ��", 0, new ImageIcon("images/timg.jpg"),
						newNameArray, null);
				if(objResult == null){
					//�û�ѡ����ȡ��
					continue;// ����break��continue������
				}
				JOptionPane.showMessageDialog(null, objResult.toString(), "ѡ�е�����",
						0, new ImageIcon("images/" + objResult.toString() + ".jpg"));
				//����: ��������  �øж����� ��������
				nnNameArray[nnCount] = objResult.toString();
				loves[nnCount++] = 100; 
				break;
			case "2"://2.���Ƴ���     +20 ����-10
//				System.out.println("���������λ����:");
//				String name = input.next();
				objResult = JOptionPane.showInputDialog(null, "������ѡ��", "����", 
						0, new ImageIcon("images/ѡ������.jpg"), nnNameArray, null);
				if(objResult == null){
					continue;
				}	
				String name = objResult.toString();
				//����
				int searchIndex = -1; //Ҫ�����ַ������±�
				for (int i = 0; i < nnCount; i++) {
					if(name.compareTo(nnNameArray[i]) == 0){//������ȵ����
						searchIndex = i;
						break;
					}
						
					
				}
				if(searchIndex == Integer.MIN_VALUE){
					System.out.println("����,û�д��˰�");
					break;
				}
				//�ҵ������, ��ǰ�øжȼ�20����һ��,������-10;
				loves[searchIndex] += 30;
				for (int i = 0; i < loves.length; i++) {
					loves[i] -= 10;
				}
				if(level[searchIndex] == levelNames.length - 1){
					System.out.println(nnNameArray[searchIndex] + "�����Ѿ�ĸ��������");
					//break;
					
				}else{
				level[searchIndex]++;//�ȼ���1
				}
				//System.out.println("����" + nnNameArray[searchIndex] + ",�ø�+20,����Ϊ" + levelNames[level[searchIndex]] + "��������øж�-10");
				JOptionPane.showMessageDialog(null, "����" + nnNameArray[searchIndex] +
						",�ø�+20,����Ϊ" + levelNames[level[searchIndex]] + "��������øж�-10", 
						"���ƵĽ��", 0, new ImageIcon("images/" + nnNameArray[searchIndex] + ".jpg"));
				break;
				
			case "3"://3.�����乬\t\t(ɾ��)
				
				break;
			case "4":
				break;
			default:
				System.out.println("��������1-4֮�������");
				break;
			
		
			
			}
//			System.out.println("����\t����\t�øж�");
//			for (int i = 0; i < nnCount; i++) {
//				System.out.println(nnNameArray[i] + "\t" + levelNames[level[i]] + "\t" + loves[i]);
//			}
			//�����3�����ϵ����Ӻøжȶ�����60,��ô��������,��Ϸǿ���˳�
			int count = 0;
			for (int i = 0; i < nnCount; i++) {
				if(loves[i] < 60){
					count++;
				}
			}
			if(count >= 3) {
				JOptionPane.showMessageDialog(null, "�󹬲���,���׹��ݾٱ��췴������λ����.", "��������", 0, new ImageIcon("images/���ϱ���.jpg"));
				System.exit(0);
			}
			//ÿ�ս���
			String value = "û��û���������ֹ�ȥ��һ��,���������\n";
			for (int i = 0; i < nnCount; i++) {
				//System.out.println(nnNameArray[i] + "\t" + levelNames[level[i]] + "\t" + loves[i]);
				value += String.format("%s   %s   %d\n", nnNameArray[i], levelNames[level[i]], loves[i]);
			}
			JOptionPane.showMessageDialog(null, value, "ÿ�ս���", 0, new ImageIcon("images/��Ϸ.jpg"));
			gamedays++;
		}

		}
		
		
	}

