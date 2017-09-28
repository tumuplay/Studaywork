package tumu;

import java.util.Scanner;

/**
 * ʹ�÷���ʵ�������Ĵ�ӡ
 * @author 
 * @���� ��ľ
 * @��ע
 */
public class PrintCalendarDemo {
	//�û���������
	public static int year = Integer.MIN_VALUE;
	//�û�������·�
	public static int month = Integer.MIN_VALUE;
	//��Ӧÿ���·ݵ�����
	private static int[] dayOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public static void main(String[] args) {	
		PrintCalendar();	
	}
	/**
	 * ��ӡ�����ĺ��·���
	 */
	public static void PrintCalendar(){
		//1.�û�������ݺ��·�
		InputYearAndMonth();
		//2.����1900-1-1���û���������·ݵ�������(year=2017, month = 7 2017-7-1)
		//	2-1��������������
		//	2-2������µ�����֮��
		int sum = getSumDayOfYears();
		sum += getSumDayOfMonth();
		sum++;
		System.out.println(sum % 7);
		//3.��ӡ��ݺ��·�(Ӣ��)
		PrintMonthTitle();
		//4.��ӡ�·ݵı���(����һ��������)
		//5.����ĳ��1�������ڼ�,��ӡ����������	
		PrintCalendarContent(sum % 7);
	}
	/**
	 * ���ݵ���1�����ܼ���ӡ��������
	 * @param dayOfWeek	����1�������ڼ�
	 */
	private static void PrintCalendarContent(int dayOfWeek){
		//ע�� dayOfWeek ȡֵ��Χ��0-6
		int sepCount = 0;  //\t������	
		if(dayOfWeek == 0){
			sepCount = 6;
		}else{
			sepCount = dayOfWeek - 1;
		}
		for (int i = 0; i < sepCount; i++) {
			System.out.print("\t");
		}
		for (int i = 0; i < dayOfMonth[month - 1]; i++) {
			System.out.print(i + 1);
			if((dayOfWeek + i) % 7 == 0 ){
				//����һ������
				System.out.println();
			}else{
				System.out.print("\t");
			}
		}
	}
	
	private static void PrintMonthTitle(){
		String[] monthNames = {"January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		System.out.println("\t\t" + year + "\t" + monthNames[month - 1]);
		String[] weekdays = {"��ҫ��", "������", "ˮ����", "ľ����", "������", "������", "������"};
		for (int i = 0; i < weekdays.length; i++) {
			System.out.print(weekdays[i] + "\t");
		}	
		System.out.println();
	
	}
	
	/**
	 * ���1900��year���������
	 * @param year
	 * @return
	 */
	private static int getSumDayOfYears(){ //ȫ�ֱ������Դ�����������ν
		//��Ҫ�ж��û��Ƿ���ȷ���������
		if(year == Integer.MIN_VALUE){
			System.out.println("��ݴ���,������������ݺ��·�");
			InputYearAndMonth();
		}
		int sum = 0;
		for (int i = 1900; i < year; i++) {
			sum += 365; 	//ÿһ���ۼ�365��
			
			if(isLeapYear(i)){
				sum++; //������һ��
			}
		}
		return sum;
	}
	/**
	 * �õ�year��1��1�õ�year��month-1�����һ���������
	 * @return
	 */
	private static int getSumDayOfMonth(){
		int sum = 0; 
		
		for(int i = 0; i < month - 1; i++){
			sum += dayOfMonth[i];
			}
		//���year��ʼ���겢��month>=3
		if(isLeapYear(year) && month >= 3){
			sum++;
		}
		return sum;
	}
	
	
	
	/**
	 * �����жϴ����year�����ǲ�������
	 * @param year 	Ҫ�жϵ����
	 * @return ������ͷ���ture
	 */
	private static boolean isLeapYear(int year){
		return year % 400 == 0 || year % 4 == 0 && year % 100 != 0;
	}
	//�����û��������ݺ��·�
	private static void InputYearAndMonth(){
		
		Scanner input = new Scanner (System.in);
		System.out.println("���������:");
		year = input.nextInt();
		System.out.println("�������·�:");
		month = input.nextInt();
		input.close();
		input = null;
	}
	
	
	
	
	
	
	
	
}
