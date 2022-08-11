import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.*;

public class Ex16_00ManageStudent extends JFrame {
	/** SerialVersionUID **/
	private static final long serialVersionUID = 1L;
	
	JButton btnInsert, btnUpdate, btnDelete, btnSelect, btnSearch; //J��ư �Է�, ����, ����, ��ȸ, �˻�
	JTextField tfId, tfName, tfDept, tfSearch; //�������Է¶�, ��ȸ�� ������ �Է¶�
	JTextArea ta; //�˻���� ���
	JRadioButton rbId, rbName, rbDept; //�˻��� ������ ���� ������ư
	Connection conn; //DB
	Statement stmt; //SQL��
	ResultSet rs; //�˻��� ������
	
	public Ex16_00ManageStudent() { //������
		this.setTitle("�л� �Է� �� ����� ����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createGUI(); //JButton, JTF ����
		
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbInsert();
			}
		}); //�Է¹�ư�� �׼Ǹ����� ����
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbUpdate();
			}
		}); //������ư�� �׼Ǹ����� ����
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbDelete();
			}
		}); //������ư�� �׼Ǹ����� ����
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbSelect();
			}
		}); //��ȸ��ư�� �׼Ǹ����� ����
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbSearch();
			}
		}); //�˻���ư�� �׼Ǹ����� ����
		
		this.setSize(300,550); //300 x 150 ������
		this.setVisible(true); //���� ���̰�
	} /*end-Ex16_00ManageStudent()*/
	
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
		
		
		btnInsert = new JButton("�Է�"); c.add(btnInsert); //�Է¹�ư ����
		btnUpdate = new JButton("����"); c.add(btnUpdate); //������ư ����
		btnDelete = new JButton("����"); c.add(btnDelete); //������ư ����
		btnSelect= new JButton("��ȸ"); c.add(btnSelect); //��ȸ��ư ����
		
		//�˻��κ�
		tfSearch = new JTextField(18);
		btnSearch = new JButton("�˻�");
		JPanel pn1 = new JPanel();
		pn1.add(new JLabel(" "));
		pn1.add(tfSearch); pn1.add(btnSearch);
		
		ButtonGroup group = new ButtonGroup();
		rbId = new JRadioButton("�й�", true); //�⺻���� üũ������
		rbName = new JRadioButton("�̸�");
		rbDept = new JRadioButton("�а�");
		group.add(rbId); group.add(rbName); group.add(rbDept);
		btnSearch = new JButton("�˻�");
		
		JPanel pn2 = new JPanel(); //������ư
		pn2.add(rbId); pn2.add(rbName);	pn2.add(rbDept);
		
		JPanel pMiddle = new JPanel(new BorderLayout(0,0)); //middle �ǳ�
		pMiddle.add(BorderLayout.NORTH, pn1);
		pMiddle.add(BorderLayout.CENTER, pn2);
		
		TitledBorder tb = new TitledBorder("�˻�");
		pMiddle.setBorder(tb);
		c.add(pMiddle); //middle �ǳ� �߰�
		//
		ta = new JTextArea(15, 20); //�˻���� ǥ�� �κ�
		c.add(ta);
		
	} /*end-createGUI()*/
	
	public void dbInsert() { //�Է¹�ư ������ ��
		try { //DB����
			conn = DBConn.dbConnection();
			stmt = conn.createStatement(); //SQL�� �Է�
			
			String id   = tfId.getText().toString();
			String name = tfName.getText().toString();
			String dept = tfDept.getText().toString();
			
			//������ �Է� name-tfName | dept-tfDept | id-tfId
			stmt.executeUpdate("insert into testtable values('"+name+"', '"+dept+"', '"+id+"');");
			System.out.println(name+"�Է� �Ϸ�");
			
			//JTF �ʱ�ȭ
			tfId.setText("");
			tfName.setText("");
			tfDept.setText("");
			//DB, SQL����
			stmt.close();
			conn.close();
		
		//����ó��
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("Constraint ���� ���� ����");
		} catch (SQLException e) {
			System.out.println("SQL ���� ����");
		} catch (Exception e) { e.printStackTrace(); }
	} /*end-dbInsert*/
	
	public void dbUpdate() { //������ư ������ ��
		try { //DB����
			conn = DBConn.dbConnection();
			stmt = conn.createStatement(); //SQL�� �Է�
			
			//������ ���� id=inid�� ���ڵ��� name�� dept�� inname�� indept�� ����
			String inid   = tfId.getText().toString();
			String inname = tfName.getText().toString();
			String indept = tfDept.getText().toString();
			
			//������ ���� name-tfName | dept-tfDept | id-tfId
			stmt.executeUpdate("update set name='"+inname+"', dept='"+indept+"' where id='"+inid+"';");
			System.out.println(inname+"���� �Ϸ�");
			
			//JTF �ʱ�ȭ
			tfId.setText("");
			tfName.setText("");
			tfDept.setText("");
			//DB, SQL����
			stmt.close();
			conn.close();
			
		//����ó��
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("Constraint ���� ���� ����");
		} catch (SQLException e) {
			System.out.println("SQL ���� ����");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("���� ����");
		}
	} /*end-dbUpdate*/
	
	public void dbDelete() { //������ư ������ ��
		try { //DB����
			conn = DBConn.dbConnection();
			stmt = conn.createStatement(); //SQL�� �Է�
			
			//������ ���� id=inputid�� ���ڵ� ����
			String inputid = tfId.getText().toString();
			stmt.executeUpdate("delete from testtable where id = '"+inputid+"';");
			System.out.println(inputid+"���� �Ϸ�");
			
			//JTF �ʱ�ȭ
			tfId.setText("");
			tfName.setText("");
			tfDept.setText("");
			//DB, SQL����
			stmt.close();
			conn.close();
			
		//����ó��
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("Constraint ���� ���� ����");
		} catch (SQLException e) {
			System.out.println("SQL ���� ����");
		} catch (Exception e) { e.printStackTrace(); }
	} /*end-dbDelete*/
	
	public void dbSelect() { //��ȸ��ư ������ ��
		try { //DB����
			conn = DBConn.dbConnection();
			stmt = conn.createStatement(); //SQL�� �Է�
			rs = stmt.executeQuery("select * from student;");
			
			var line = "";
			ta.setText("   id                name                   dept \n");
			ta.append("-------------------------------------------------------\n");
			
			while (rs.next()) { //������ �о���̱�
				var name = rs.getString("name");
				var dept = rs.getString("dept");
				var id   = rs.getString("id");
				line = " | "+id+" | "+name+" | "+dept+"\n";
				System.out.println("rs => "+line);
				ta.append(line);
			}
			//DB, SQL����
			stmt.close();
			conn.close();
			
		//����ó��
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("Constraint ���� ���� ����");
		} catch (SQLException e) {
			System.out.println("SQL ���� ����");
		} catch (Exception e) { e.printStackTrace(); }
	} /*end-dbSelect*/
	
	public void dbSearch() { //�˻���ư ������ ��
		try { //DB����
			conn = DBConn.dbConnection();
			stmt = conn.createStatement(); //SQL�� �Է�
			var searchText = tfSearch.getText().toString();
			var searchSql = "";
			
			//������ ��ȸ �˻�����=searchText�� ���ڵ� ��� �ʵ� �˻�
			if (rbId.isSelected()) {
				searchSql = "select * from testdb where id = '"+searchText+"';";
			} else if (rbName.isSelected()) {
				searchSql = "select * from testdb where name = '"+searchText+"';";
			} else {
				searchSql = "select * from testdb where dept = '"+searchText+"';";
			}
			rs = stmt.executeQuery(searchSql); //searchSql ����
			
			var line = "";
			ta.setText("   id                name                   dept \n");
			ta.append("-------------------------------------------------------\n");
			
			while (rs.next()) { //������ �о���̱�
				var name = rs.getString("name");
				var dept = rs.getString("dept");
				var id   = rs.getString("id");
				line = " | "+id+" | "+name+" | "+dept+"\n";
				System.out.println("rs => "+line);
				ta.append(line);
			}
			//DB, SQL����
			stmt.close();
			conn.close();
			
		//����ó��
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("Constraint ���� ���� ����");
		} catch (SQLException e) {
			System.out.println("SQL ���� ����");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("�˻� ����");
		}
	} /*end-dbSearch*/
	
	public static void main(String[] args) {
		new Ex16_00ManageStudent(); //������ ����
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 12���� �л��������α׷� ����");
	}
}
