package tumu;


import javax.swing.ImageIcon;
/*java的选项面板*/
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
/**
 * 对话框示例
 * @author 
 * @作者 土木
 * @备注
 */
public class DialogDemo {
	public static void main(String[] args){
		//参数1: 对话框的父窗体对象
		JOptionPane.showMessageDialog(null, "提示信息");
		//参数2:对话框中的提示信息
		//参数3:对话框的标题信息
		//参数4:对话框的消息类型
		//JOptionPane.showMessageDialog(null,"今天你吃了吗?","嘘寒问暖",JOptionPane.WARNING_MESSAGE);
		//参数5:对话框中显示的图片对象
		//JOptionPane.showMessageDialog(null,"今天你吃了吗?","嘘寒问暖",JOptionPane.WARNING_MESSAGE, new ImageIcon("images/timg.jpg"));
		JOptionPane.showInputDialog(null, "吃了吗", "标题", 0, new ImageIcon("images/timg.jpg"), null, "默认值");
	}
}
