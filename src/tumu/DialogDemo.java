package tumu;


import javax.swing.ImageIcon;
/*java��ѡ�����*/
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
/**
 * �Ի���ʾ��
 * @author 
 * @���� ��ľ
 * @��ע
 */
public class DialogDemo {
	public static void main(String[] args){
		//����1: �Ի���ĸ��������
		JOptionPane.showMessageDialog(null, "��ʾ��Ϣ");
		//����2:�Ի����е���ʾ��Ϣ
		//����3:�Ի���ı�����Ϣ
		//����4:�Ի������Ϣ����
		//JOptionPane.showMessageDialog(null,"�����������?","�꺮��ů",JOptionPane.WARNING_MESSAGE);
		//����5:�Ի�������ʾ��ͼƬ����
		//JOptionPane.showMessageDialog(null,"�����������?","�꺮��ů",JOptionPane.WARNING_MESSAGE, new ImageIcon("images/timg.jpg"));
		JOptionPane.showInputDialog(null, "������", "����", 0, new ImageIcon("images/timg.jpg"), null, "Ĭ��ֵ");
	}
}
