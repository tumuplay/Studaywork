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
		//输入玩家姓名
		
		Scanner input = new Scanner(System.in);
		//野生美女的姓名数组
		String[] newNameArray = {"褒姒", "甄嬛", "郭德纲", "钟无艳", "小仙女"};
		int newNameCount = newNameArray.length;//待选野生美女总数
		//后宫娘娘姓名数组
		String[] nnNameArray = {"西施", "貂蝉", "王昭君", "杨玉环", "赵飞燕", "", "", "", "", ""};
		//后宫级别数组
		String[] levelNames = {"贵人", "嫔妃", "贵妃", "皇贵妃", "皇后"};
		//对应每个娘娘的级别
		int[] level = new int[10];
		//每个娘娘度对应的好感度
		int[] loves = new int[10];
		//娘娘初始数量为5
		int nnCount = 5;
		// 游戏默认运行十天
		int gamedays = 1; 
		//皇帝体力值
		int heart = 100;
		//设定默认好感度为100
		for (int i = 0; i < nnCount; i++) {
			loves[i] = 100;
		}
		//游戏主界面
		JOptionPane.showMessageDialog(null, "陛下您来了呀", "欢迎来到后宫选妃", 0, new ImageIcon("images/title.jpg"));
			
		while(gamedays <= 10){
//			System.out.println("游戏进行到第" + gamedays + "天!");
//			System.out.println("1.皇帝下旨选妃\t\t(增加)");
//			System.out.println("2.翻牌宠幸\t\t(修改状态)");
//			System.out.println("3.打入冷宫\t\t(删除)");
//			System.out.println("4.风花雪月,与爱妃共赏\t\t(查找 修改状态)");
//			System.out.print("陛下请选择:");
//			int choice = input.nextInt();
			String strMenu = "1.皇帝下旨选妃\n";
			strMenu += "2.翻牌宠幸\n";
			strMenu += "3.打入冷宫\n";
			strMenu += "4.风花雪月\n";
			strMenu += "陛下请选择今天要做的事情\n";
			Object objResult = JOptionPane.showInputDialog(null, strMenu, "游戏进行到第" + gamedays + "天", 0, new ImageIcon("images/宝座.jpg"), 
							new String[]{"1", "2", "3", "4"}, 1);
					
			//判断用户选择取消的情况- 目前省略
			//把用户的选择(1 - 4之间的字符串) 转换成整型 
			//int choice = Integer.parseInt(objResult.toString());
			switch(objResult.toString()){
			case "1":
				if(nnCount == nnNameArray.length){
					System.out.println("后宫已经人满为患,陛下保重龙体呀!");
				}
//				System.out.print("请输入娘娘的名讳:");
//				String newName = input.next();
				
				objResult = (String)JOptionPane.showInputDialog(null, "请选择秀女", 
						"选妃", 0, new ImageIcon("images/timg.jpg"),
						newNameArray, null);
				if(objResult == null){
					//用户选择了取消
					continue;// 测试break和continue的区别
				}
				JOptionPane.showMessageDialog(null, objResult.toString(), "选中的嫔妃",
						0, new ImageIcon("images/" + objResult.toString() + ".jpg"));
				//增加: 姓名数组  好感度数组 级别数组
				nnNameArray[nnCount] = objResult.toString();
				loves[nnCount++] = 100; 
				break;
			case "2"://2.翻牌宠幸     +20 其他-10
//				System.out.println("今天宠幸哪位娘娘:");
//				String name = input.next();
				objResult = JOptionPane.showInputDialog(null, "陛下请选择", "翻牌", 
						0, new ImageIcon("images/选妃翻牌.jpg"), nnNameArray, null);
				if(objResult == null){
					continue;
				}	
				String name = objResult.toString();
				//查找
				int searchIndex = -1; //要查找字符串的下标
				for (int i = 0; i < nnCount; i++) {
					if(name.compareTo(nnNameArray[i]) == 0){//姓名相等的情况
						searchIndex = i;
						break;
					}
						
					
				}
				if(searchIndex == Integer.MIN_VALUE){
					System.out.println("陛下,没有此人啊");
					break;
				}
				//找到的情况, 当前好感度加20并升一级,其他人-10;
				loves[searchIndex] += 30;
				for (int i = 0; i < loves.length; i++) {
					loves[i] -= 10;
				}
				if(level[searchIndex] == levelNames.length - 1){
					System.out.println(nnNameArray[searchIndex] + "娘娘已经母仪天下了");
					//break;
					
				}else{
				level[searchIndex]++;//等级加1
				}
				//System.out.println("宠幸" + nnNameArray[searchIndex] + ",好感+20,升级为" + levelNames[level[searchIndex]] + "其余娘娘好感度-10");
				JOptionPane.showMessageDialog(null, "宠幸" + nnNameArray[searchIndex] +
						",好感+20,升级为" + levelNames[level[searchIndex]] + "其余娘娘好感度-10", 
						"翻牌的结果", 0, new ImageIcon("images/" + nnNameArray[searchIndex] + ".jpg"));
				break;
				
			case "3"://3.打入冷宫\t\t(删除)
				
				break;
			case "4":
				break;
			default:
				System.out.println("必须输入1-4之间的数字");
				break;
			
		
			
			}
//			System.out.println("姓名\t级别\t好感度");
//			for (int i = 0; i < nnCount; i++) {
//				System.out.println(nnNameArray[i] + "\t" + levelNames[level[i]] + "\t" + loves[i]);
//			}
			//如果有3个以上的妃子好感度都低于60,那么发生暴乱,游戏强制退出
			int count = 0;
			for (int i = 0; i < nnCount; i++) {
				if(loves[i] < 60){
					count++;
				}
			}
			if(count >= 3) {
				JOptionPane.showMessageDialog(null, "后宫不稳,皇亲国戚举兵造反让您退位让贤.", "发生暴乱", 0, new ImageIcon("images/皇上被害.jpg"));
				System.exit(0);
			}
			//每日结算
			String value = "没羞没臊的生活又过去了一天,后宫情况如下\n";
			for (int i = 0; i < nnCount; i++) {
				//System.out.println(nnNameArray[i] + "\t" + levelNames[level[i]] + "\t" + loves[i]);
				value += String.format("%s   %s   %d\n", nnNameArray[i], levelNames[level[i]], loves[i]);
			}
			JOptionPane.showMessageDialog(null, value, "每日结算", 0, new ImageIcon("images/嬉戏.jpg"));
			gamedays++;
		}

		}
		
		
	}

