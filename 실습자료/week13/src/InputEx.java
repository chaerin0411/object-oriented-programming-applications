import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class InputEx extends JFrame {
	JButton btnInsert, btnDelete; //J��ư �Է�, ����
	JTextField tfId, tfName, tfDept; //�Է¶� id, name, dept
	Connection conn; //DB
	Statement stmt; //SQL��
	
	public InputEx() { //������
		this.setTitle("�л� �Է� �� ����� ����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createGUI(); //JButton, JTF ����
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbInsert();
			}
		}); //�Է¹�ư�� �׼Ǹ����� ����
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbDelete();
			}
		}); //������ư�� �׼Ǹ����� ����
		this.setSize(300,150); //300 x 150 ������
		this.setVisible(true); //���� ���̰�
	} /*end-InputEx()*/
	
	public void createGUI() {
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout()); //FlowLayout - �帣���� ��ġ
		
		c.add(new JLabel("�й�")); //�й� �Է�ĭ ����
		tfId = new JTextField(20);
		c.add(tfId);
		
		c.add(new JLabel("�̸�")); //�̸� �Է�ĭ ����
		tfName = new JTextField(20);
		c.add(tfName);
		
		c.add(new JLabel("�а�")); //�а� �Է�ĭ ����
		tfDept = new JTextField(20);
		c.add(tfDept);
		
		btnInsert = new JButton("�Է�"); //�Է¹�ư ����
		c.add(btnInsert);
		btnDelete = new JButton("����"); //������ư ����
		c.add(btnDelete);
	} /*end-createGUI()*/
	
	public void dbInsert() { //�Է¹�ư ������ ��
		try { //DB����
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC", "root", "admin");
			System.out.println("DB ���� �Ϸ�");
			
			stmt = conn.createStatement(); //SQL�� �Է�
			String id   = tfId.getText().toString();
			String name = tfName.getText().toString();
			String dept = tfDept.getText().toString();
			
			//������ �Է� name-tfName | dept-tfDept | id-tfId
			stmt.executeUpdate("insert into testtable values('"+name+"', '"+dept+"', '"+id+"');");
			System.out.println(name + "�Է� �Ϸ�");
			
			//JTF �ʱ�ȭ
			tfId.setText("");
			tfName.setText("");
			tfDept.setText("");
			//DB, SQL����
			stmt.close();
			conn.close();
			
		} catch (Exception e) { e.printStackTrace(); }
	} /*end-dbInsert*/
	
	public void dbDelete() { //������ư ������ ��
		try { //DB����
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC", "root", "admin");
			System.out.println("DB ���� �Ϸ�");
			stmt = conn.createStatement(); //SQL�� �Է�
			
			//������ ���� id=inputid�� ���ڵ� ����
			String inputid = tfId.getText().toString();
			stmt.executeUpdate("delete from testtable where id = '"+inputid+"'");
			System.out.println(inputid+"���� �Ϸ�");
			
			//JTF �ʱ�ȭ
			tfId.setText("");
			tfName.setText("");
			tfDept.setText("");
			//DB, SQL����
			stmt.close();
			conn.close();
			
		} catch (Exception e) { /*����ó��*/; }
	} /*end-dbDelete*/
	
	public static void main(String[] args) {
		new InputEx(); //������ ����
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 12���� �л��������α׷� ����");
	}
}
