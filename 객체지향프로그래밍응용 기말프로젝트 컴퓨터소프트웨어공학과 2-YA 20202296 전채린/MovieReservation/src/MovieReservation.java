/*
 * ��ü�������α׷������� �⸻ ������Ʈ ��ǻ�ͼ���Ʈ������а� 2-YA 20202296 ��ä��
 * ��ȭ ���� ������Ʈ
 * ȸ�� ������ �Է��ϰ� ��ȭ, ������, ���۽ð�, �¼��� �����ϸ� ���� �� ��ȭ�� ������ �� �ִ� �������α׷�
 * �Է�, ����, ����, ��ȸ, �˻� ��� ����
 * ȸ�� ������ ��ȭ ���� �����͸� �Է��ϸ� ȸ�� ������ ���� ������ �����ͺ��̽��� �Է�
 * ȸ�� ���̵�� ���� ���� ����
 * ȸ�� ���̵�� ȸ�� ������ �������� ����
 * ȸ��, ��ȭ, ���� ���̺� ��ȸ
 * ȸ�� ���̵�� ȸ�� ���� �˻�
 * ��ȭ �������� ��ȭ ���� �˻�
 * ȸ�� ���̵�� ���� ���� �˻�
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MovieReservation extends JFrame{
	private JPanel pnNorth, pnCenter, pnSouth, pnEast, pnWest; // ����, ����, ����, ���� �г�
	private JButton btnInsert, btnDelete, btnUpdate, btnSelect, btnSearch; // �Է�, ����, ����, ��ȸ, �˻� ��ư
	private JTextField tfMemberId, tfPwd, tfName, tfPhone,tfAddr, tfSearch; // ȸ�� ����, �˻� �ؽ�Ʈ �ʵ�
	private JRadioButton rbId, rbMovie, rbReservation; // ���̵�, ��ȭ, ���� ���� ��ư
	private JTextArea ta; // �ؽ�Ʈ����
	
	private JButton[] btnMovies = new JButton[5];
	private JButton[] btnBussinesses = new JButton[13];
	private JButton[] btnStartTime = new JButton[13];
	private JButton[][] btnSits = new JButton[5][5];
	
	private String[][] sitArr = { {"A1", "A2", "A3", "A4", "A5"},
						  {"B1", "B2", "B3", "B4", "B5"},
						  {"C1", "C2", "C3", "C4", "C5"},
						  {"D1", "D2", "D3", "D4", "D5"},
						  {"E1", "E2", "E3", "E4", "E5"} }; // �¼� �迭
	private String[] movieArr = { "������ 3", "ũ�翤��", "ĳ��Ʈ��", "�г��� ����", "����������" }; // ��ȭ �迭
	private String[] businessArr = { "����", "�̾�", "����", "����", "��", "��������ũ��", "�ұ�", "���з�", "��", "�սʸ�", "���ſ����Ա�", "����", "������" }; // ������ �迭
	private String[] startTimeArr = { "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00" }; // ���۽ð� �迭
	private String sit; // ���� �¼�
	
	private JComboBox<String> movieCombo = new JComboBox<String>(movieArr); // ��ȭ �޺��ڽ� ����
	private JComboBox<String> businessCombo = new JComboBox<String>(businessArr); // ������ �޺��ڽ� ����
	private JComboBox<String> startTimeCombo = new JComboBox<String>(startTimeArr); // ���۽ð� �޺��ڽ� ����
	
	private ImageIcon [] images = { // ��ȭ �̹��� ��ü �迭
			new ImageIcon("images/movie01.jpg"),
			new ImageIcon("images/movie02.jpg"),
			new ImageIcon("images/movie03.jpg"),
			new ImageIcon("images/movie04.jpg"),
			new ImageIcon("images/movie05.jpg"),
			new ImageIcon("images/movie06.jpg"),
			new ImageIcon("images/movie07.jpg") };
	private JLabel imgLabel = new JLabel(images[0]); // ��ȭ �̹��� ���̺� ������Ʈ
	
	Connection conn; // DB ����
	Statement stmt; // SQL ���� �����ϱ� ���ؼ��� Statement Ŭ������ �̿�
	ResultSet rs; // SQL �� ���� ����� ������ ���ؼ��� ResultSet Ŭ������ �̿�

	public MovieReservation() { // ������
		setTitle("��ȭ ���� ������Ʈ ��ǻ�ͼ���Ʈ������а� 2-YA 20202296 ��ä��"); // ������ Ÿ��Ʋ �ޱ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ������ �����츦 ������ ���α׷��� �����ϵ��� ����
		
		createGUI(); // GUI ���� �޼ҵ�
		
		btnInsert.addActionListener(new ActionListener() { // �Է� ��ư �׼� �̺�Ʈ ó��			
			@Override
			public void actionPerformed(ActionEvent e) { 
				dbInsert(); // ������ ���� �޼ҵ�
			}
		});
		btnDelete.addActionListener(new ActionListener() { // ���� ��ư �׼� �̺�Ʈ ó��				
			@Override
			public void actionPerformed(ActionEvent e) {
				dbDelete(); // ������ ���� �޼ҵ�
			}
		});
		btnUpdate.addActionListener(new ActionListener() { // ���� ��ư �׼� �̺�Ʈ ó��			
			@Override
			public void actionPerformed(ActionEvent e) {
				dbUpdate(); // ������ ���� �޼ҵ�				
			}
		});		
		btnSelect.addActionListener(new ActionListener() { // ��ȸ ��ư �׼� �̺�Ʈ ó��				
			@Override
			public void actionPerformed(ActionEvent e) {
				dbSelect();	// ������ ��ȸ �޼ҵ�			
			}
		});
		btnSearch.addActionListener(new ActionListener() { // �˻� ��ư �׼� �̺�Ʈ ó��			
			@Override
			public void actionPerformed(ActionEvent e) {
				dbSearch(); // ������ �˻� �޼ҵ�
			}
		});

		setSize(1000, 600); // ������ ũ�� 1000x600 ����
		setVisible(true); // ȭ�鿡 ������ ���
	}
	
	public void createGUI() { // GUI ���� �޼ҵ�
		Container c = getContentPane(); // �������� ����Ʈ��
		
		// West
		pnWest = new JPanel(); // ȸ������ �г� ����
		pnWest.setLayout(new GridLayout(0, 2)); // GridLayout ��ġ������ ����
		
		// ȸ������
		pnWest.add(new JLabel("ȸ�� ���̵�")); // ȸ�� ���̵� ���̺��� �гο� ����
		tfMemberId = new JTextField(20); // ȸ�� ���̵� �ؽ�Ʈ �ʵ� ����
		pnWest.add(tfMemberId); // ȸ�� ��й�ȣ �ؽ�Ʈ �ʵ带 �гο� ����
		
		pnWest.add(new JLabel("ȸ�� ��й�ȣ")); // ȸ�� ��й�ȣ ���̺��� �гο� ����
		tfPwd = new JTextField(20); // ȸ�� ��й�ȣ �ؽ�Ʈ �ʵ� ����
		pnWest.add(tfPwd); // ȸ�� ��й�ȣ �ؽ�Ʈ �ʵ带 �гο� ����
		
		pnWest.add(new JLabel("ȸ�� �̸�")); // ȸ�� �̸� ���̺��� �гο� ����
		tfName = new JTextField(20); // ȸ�� �̸� �ؽ�Ʈ �ʵ� ����
		pnWest.add(tfName); // ȸ�� �̸� �ؽ�Ʈ �ʵ带 �гο� ����
		
		pnWest.add(new JLabel("ȸ�� ��ȭ��ȣ")); // ȸ�� ��ȭ��ȣ ���̺��� �гο� ����
		tfPhone = new JTextField(20); // ȸ�� ��ȭ��ȣ �ؽ�Ʈ �ʵ� ����
		pnWest.add(tfPhone); // ȸ�� ��ȭ��ȣ �ؽ�Ʈ �ʵ带 �гο� ����
		
		pnWest.add(new JLabel("ȸ�� �ּ�")); // ȸ�� �ּ� ���̺��� �гο� ����
		tfAddr = new JTextField(20); // ȸ�� �ּ� �ؽ�Ʈ �ʵ� ����
		pnWest.add(tfAddr); // ȸ�� �ּ� �ؽ�Ʈ �ʵ带 �гο� ����
		
		c.add(pnWest, BorderLayout.WEST); // ����Ʈ�ҿ� pnWest �г� ����			
			
		// East
		pnEast = new JPanel(); // �¼� �г� ����	
		pnEast.setLayout(new GridLayout(0, 5)); // GridLayout ��ġ������ ����
				
		// �¼�
		for(int i=0; i<btnSits.length; i++) {
			for(int j=0; j<btnSits[i].length; j++) {
				btnSits[i][j] = new JButton(sitArr[i][j]); // �¼� ��ư ����
				pnEast.add(btnSits[i][j]); // �¼� ��ư�� �гο� ����
				btnSits[i][j].addActionListener(new ActionListener() { // �׼� �̺�Ʈ ���
					
					@Override
					public void actionPerformed(ActionEvent e) {
						JButton btn = (JButton)e.getSource();
						btn.setBackground(Color.GRAY);
						sit = btn.getText(); // �¼� ��ȣ ��������
					}
				});
			}
		}
		
		c.add(pnEast, BorderLayout.EAST); // ����Ʈ�ҿ� pnWest �г� ����
		
		// North
		pnNorth  = new JPanel(); // ���̺� �г� ����
		pnNorth.setLayout(new GridLayout(0, 4)); // GridLayout ��ġ������ ����
		
		
		pnNorth.add(new JLabel("ȸ������")); // ȸ������ ���̺��� pnNorth �гο� ����
		pnNorth.add(new JLabel("")); // ���̺��� pnNorth �гο� ����
		pnNorth.add(new JLabel("����")); // ���� ���̺��� pnNorth �гο� ����
		pnNorth.add(new JLabel("�¼� (SCREEN)")); // �¼� ���̺��� pnNorth �гο� ����
		
		c.add(pnNorth, BorderLayout.NORTH); // ����Ʈ�ҿ� pnNorth �г� ����

		// Center
		pnCenter = new JPanel(); // ��ȭ �г� ����
		pnCenter.setLayout(new GridLayout(0, 2)); // GridLayout ��ġ������ ����
				
		// ��ȭ 	
		JPanel pn1 = new JPanel(); // ��ȭ �г� ����
		
		pn1.add(new JLabel("��ȭ")); // ��ȭ ���̺��� pn1 �гο� ����
		pn1.add(movieCombo); // movieCombo �޺��ڽ��� pn1 �гο� ����
		
		pnCenter.add(imgLabel); // ��ȭ �̹��� ���̺��� pnCenter �гο� ����
		pnCenter.add(pn1); // pn1 �г��� pnCenter �гο� ����
		
		movieCombo.addActionListener(new ActionListener() { // �׼� �̺�Ʈ ���
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> cb = (JComboBox<String>)e.getSource(); // Action �̺�Ʈ�� �߻��� �޺��ڽ� �˾Ƴ���
				int index = cb.getSelectedIndex(); // �޺��ڽ��� ���õ� �������� �ε��� ��ȣ �˾Ƴ���
				imgLabel.setIcon(images[index]); // �ε����� �̹����� �̹��� ���̺� ������Ʈ�� ���
			}
		});
	
		// ������
		JPanel pn2 = new JPanel(); // ������ �г� ����
		
		pn2.add(new JLabel("������")); // ������ ���̺��� pn2 �гο� ����		
		pn2.add(businessCombo); // businessCombo �޺��ڽ��� pn2 �гο� ����
		
		pnCenter.add(pn2); // pn2 �г��� pnCenter �гο� ����
		
		// ���۽ð�
		JPanel pn3 = new JPanel(); // ���۽ð� �г� ����
		
		pn3.add(new JLabel("���۽ð�")); // ���۽ð� ���̺��� pn3 �гο� ����
		pn3.add(startTimeCombo); // startTimeCombo �޺��ڽ��� pn3 �гο� ����
		
		pnCenter.add(pn3); // pn5 �г��� pnCenter �гο� ����
						
		c.add(pnCenter, BorderLayout.CENTER); // ����Ʈ�ҿ� pnCenter ����
		
		// South
		pnSouth = new JPanel(); // �г� ����
		pnSouth.setLayout(new BorderLayout(0, 0)); // BorderLayout ��ġ������ ����
						
		JPanel pnBtn = new JPanel(); // ��ư �г� ���� 
		btnInsert = new JButton("�Է�"); // �Է� ��ư ����
		btnDelete = new JButton("����"); // ���� ��ư ����
		btnUpdate = new JButton("����"); // ���� ��ư ����
		btnSelect = new JButton("��ȸ"); // ��ȸ ��ư ����
		pnBtn.add(btnInsert); // �Է� ��ư�� �гο� ����		
		pnBtn.add(btnDelete); // ���� ��ư�� �гο� ����	
		pnBtn.add(btnUpdate); // ���� ��ư�� �гο� ����		
		pnBtn.add(btnSelect); // ��ȸ ��ư�� �гο� ����
		
		pnSouth.add(pnBtn, BorderLayout.NORTH); // pnBtn �г��� pnSouth �гο� ����
		
		// �˻�
		JPanel pnSearch = new JPanel(); // �˻� �г� ����
		pnSearch.setLayout(new BorderLayout(0, 0)); // BorderLayout ��ġ������ ����
		
		JPanel pn4 = new JPanel(); // �г� ����
		
		tfSearch = new JTextField(20); // �˻� �ؽ�Ʈ �ʵ� ����
		btnSearch = new JButton("�˻�"); // �˻� ��ư ����		
		pn4.add(tfSearch); // �˻� �ؽ�Ʈ �ʵ带 pn4 �гο� ����
		pn4.add(btnSearch); // �˻� ��ư�� pn4 �гο� ����
		
		JPanel pn5 = new JPanel(); // 3���� ������ư�� ������ �г� ����
		
		ButtonGroup group = new ButtonGroup(); // ��ư �׷� ��ü ����
		rbId = new JRadioButton("���̵�", true); // ���̵� ���� ��ư ����. �ʱ� ����
		rbMovie = new JRadioButton("��ȭ"); // ��ȭ ���� ��ư ����
		rbReservation = new JRadioButton("����"); // ���� ���� ��ư ����		
		group.add(rbId); // ���̵� ���� ��ư�� ��ư �׷쿡 ����
		group.add(rbMovie); // ��ȭ ���� ��ư�� ��ư �׷쿡 ����
		group.add(rbReservation); // ���� ���� ��ư�� ��ư �׷쿡 ����
		
		pn5.add(rbId); // ���̵� ���� ��ư�� pn5 �гο� ����
		pn5.add(rbMovie); // ��ȭ ���� ��ư�� pn5 �гο� ����
		pn5.add(rbReservation); // ���� ���� ��ư�� pn5 �гο� ����
		
		pnSearch.add(pn4, BorderLayout.NORTH); // pn4 �г��� pnSearch �гο� ����
		pnSearch.add(pn5, BorderLayout.CENTER); // pn5 �г��� pnSearch �гο� ����
		
		pnSouth.add(pnSearch, BorderLayout.CENTER); // pnSearch �г��� pnSouth �гο� ����
		
		// ���� ���
		ta = new JTextArea(10, 10); // �ؽ�Ʈ���� ����
		
		pnSouth.add(ta, BorderLayout.SOUTH); // �ؽ�Ʈ������ pnSouth �гο� ����
				
		c.add(pnSouth, BorderLayout.SOUTH); // ����Ʈ�ҿ� pnSouth �г� ����

	}
	
	public void dbInsert() { // ������ �Է� �޼ҵ�
		try { // ȸ������ ���� �Է� �� ���� ���� �Է�
			conn = DBConn.dbConnection(); // DB ����
			stmt = conn.createStatement();
			String id = tfMemberId.getText().toString(); // ȸ�� ���̵� �ؽ�Ʈ �ʵ忡 �Էµ� ������ ��������
			String pwd = tfPwd.getText().toString(); // ��ȭ �ؽ�Ʈ �ʵ忡 �Էµ� ������ ��������
			String name = tfName.getText().toString(); // ȸ�� �̸� �ؽ�Ʈ �ʵ忡 �Էµ� ������ ��������
			String phone = tfPhone.getText().toString(); // ȸ�� ��ȭ��ȣ �ؽ�Ʈ �ʵ忡 �Էµ� ������ ��������
			String addr = tfAddr.getText().toString(); // ȸ�� �ּ� �ؽ�Ʈ �ʵ忡 �Էµ� ������ ��������
			String title = movieCombo.getSelectedItem().toString(); // ��ȭ �޺��ڽ��� ���õ� ������ ��������
			String business = businessCombo.getSelectedItem().toString(); // ������ �޺��ڽ��� ���õ� ������ ��������			
			String startTime = startTimeCombo.getSelectedItem().toString(); // ���۽ð� �޺��ڽ��� ���õ� ������ ��������
			
			stmt.executeUpdate("insert into ȸ�� values('" + id + "', '" + pwd + "', '" + name + "', '" + phone + "', '" + addr + "');"); // insert ���� �̿��Ͽ� ������ ���� ���
			stmt.executeUpdate("insert into ���� values('" + id + "', '" + title + "', '" + business + "', '" + startTime + "', '" + sit + "');"); // insert ���� �̿��Ͽ� ������ ���� ���
			System.out.println(name + " ȸ������ �Ϸ�"); // �ֿܼ� ��� ���
			System.out.println(name + " ���� �Ϸ�"); // �ֿܼ� ��� ���
			tfMemberId.setText(""); // ȸ�� ���̵� �ؽ�Ʈ �ʵ� �������� ����
			tfPwd.setText(""); // ȸ�� ��й�ȣ �ؽ�Ʈ �ʵ� �������� ����
			tfName.setText(""); // ȸ�� �̸� �ؽ�Ʈ �ʵ� �������� ����
			tfPhone.setText(""); // ȸ�� ��ȭ��ȣ �ؽ�Ʈ �ʵ� �������� ����
			tfAddr.setText(""); // ȸ�� �ּ� �ؽ�Ʈ �ʵ� �������� ����
			stmt.close(); // stmt �ݱ�
			conn.close(); // conn �ݱ�
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void dbDelete() { // ������ ���� �޼ҵ�
		try { // ȸ�� ���̵�� ������ ����
			conn = DBConn.dbConnection(); // DB ����
			stmt = conn.createStatement();
			String inputid = tfMemberId.getText().toString(); // ȸ�� ���̵� �ؽ�Ʈ �ʵ忡 �Էµ� ������ ��������
			stmt.executeUpdate("delete from ���� where memberid = '" + inputid + "'"); // delete ���� �̿��Ͽ� ������ ���� ���
			System.out.println(inputid +" ���� ���"); // �ֿܼ� ��� ���
			tfMemberId.setText(""); // ȸ�� ���̵� �ؽ�Ʈ �ʵ� �������� ����
			stmt.close(); // stmt �ݱ�
			conn.close(); // conn �ݱ�
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dbSearch() { // �˻� �޼ҵ�
		try {
			conn = DBConn.dbConnection(); // DB ����
			stmt = conn.createStatement(); 
			String searchText = tfSearch.getText().toString(); // �˻� �ؽ�Ʈ �ʵ忡 �Էµ� ������ ��������
			String searchSql = "";
			String line = "";
			
			if(rbId.isSelected()) { // ���̵� ���� ��ư�� ���õǾ��� ���, �Էµ� ���̵��� ȸ�� ���� ���
				searchSql = "select * from ȸ�� where memberId = '" + searchText + "';"; // select ���� �̿��Ͽ� ������ ��ȸ ���
				rs = stmt.executeQuery(searchSql); // Statement�� excuteQuery()�� SQL ���� �����Ͽ� ���� ����� �Ѱ���. ��� ���� ��� ���� �о� ����� rs�� ����
				ta.setText("memberId  pwd  name  phone  addr\n");
				ta.append("--------------------------------------------------------------\n");
				while(rs.next()) { // ���� ���� ������ true
					String memberId = rs.getString("memberId");
					String pwd = rs.getString("pwd");
					String name = rs.getString("name");
					String phone = rs.getString("phone");
					String addr = rs.getString("addr");
					line = " | " + memberId + " | " + pwd + " | " + name + " | " + phone + " | " + addr + "\n";
					System.out.println("rs => " + line); // �ֿܼ� ��� ���
					ta.append(line); // update ���� �̿��Ͽ� ������ ���� ���
					tfSearch.setText(""); // �˻� �ؽ�Ʈ �ʵ� �������� ����
				}
			}
			
			else if(rbMovie.isSelected()) { // ��ȭ ���� ��ư�� ���õǾ��� ���, �Էµ� ��ȭ�� ���� ���
				searchSql = "select * from ��ȭ where title = '" + searchText + "';"; // select ���� �̿��Ͽ� ������ ��ȸ ���				
				rs = stmt.executeQuery(searchSql); // Statement�� excuteQuery()�� SQL ���� �����Ͽ� ���� ����� �Ѱ���. ��� ���� ��� ���� �о� ����� rs�� ����
				ta.setText("title  director  actor  phone  addr\n");
				ta.append("--------------------------------------------------------------\n");
				while(rs.next()) { // ���� ���� ������ true
					String title = rs.getString("title");
					String director = rs.getString("director");
					String actor = rs.getString("actor");
					String genre = rs.getString("genre");
					String time = rs.getString("time");
					String nation = rs.getString("nation");
					String openDate = rs.getString("openDate");
					line = " | " + title + " | " + director + " | " + actor + " | " + genre + " | " + time + " | " + nation + " | " + openDate + "\n";
					System.out.println("rs => " + line); // �ֿܼ� ��� ���
					ta.append(line); // update ���� �̿��Ͽ� ������ ���� ���
					tfSearch.setText(""); // �˻� �ؽ�Ʈ �ʵ� �������� ����
				}
			}
			
			else { // ���� ���� ��ư�� ���õǾ��� ���, �Էµ� ���̵��� �������� ���
				searchSql = "select * from ���� where memberId = '" + searchText + "';"; // select ���� �̿��Ͽ� ������ ��ȸ ���
				rs = stmt.executeQuery(searchSql); // Statement�� excuteQuery()�� SQL ���� �����Ͽ� ���� ����� �Ѱ���. ��� ���� ��� ���� �о� ����� rs�� ����
				ta.setText("memberId  title  businessName  startTime  sit\n");
				ta.append("--------------------------------------------------------------\n");
				while(rs.next()) { // ���� ���� ������ true
					String memberId = rs.getString("memberId");
					String title = rs.getString("title");
					String businessName = rs.getString("businessName");
					String startTime = rs.getString("startTime");
					String sit = rs.getString("sit");
					line = " | " + memberId + " | " + title + " | " + businessName + " | " + startTime + " | " + sit + "\n";
					System.out.println("rs => " + line); // �ֿܼ� ��� ���
					ta.append(line); // update ���� �̿��Ͽ� ������ ���� ���
					tfSearch.setText(""); // �˻� �ؽ�Ʈ �ʵ� �������� ����
				}
			}
		
			stmt.close(); // stmt �ݱ�
			conn.close(); // conn �ݱ�
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void dbSelect() { // ������ ��ȸ �޼ҵ�		
		try {
			conn = DBConn.dbConnection(); // DB ����
			stmt = conn.createStatement();
			
			// ȸ�� ���� ��ȸ
			rs = stmt.executeQuery("select * from ȸ��;"); // Statement�� excuteQuery()�� SQL ���� �����Ͽ� ���� ����� �Ѱ���. ��� ���� ��� ���� �о� ����� rs�� ����. select ���� �̿��Ͽ� ������ ��ȸ ���
			String line = "";
			System.out.println("memberId  pwd  name  phone  addr\n");
			System.out.println("--------------------------------------------------------------\n");
			while(rs.next()) { // ���� ���� ������ True
				String memberId = rs.getString("memberId");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String addr = rs.getString("addr");
				line = " | " + memberId + " | " + pwd + " | " + name + " | " + phone + " | " + addr + "\n";
				System.out.println("rs => " + line); // �ֿܼ� ��� ���
			}
			System.out.println("--------------------------------------------------------------\n");
			
			// ��ȭ ���� ��ȸ
			rs = stmt.executeQuery("select * from ��ȭ;"); // Statement�� excuteQuery()�� SQL ���� �����Ͽ� ���� ����� �Ѱ���. ��� ���� ��� ���� �о� ����� rs�� ����. select ���� �̿��Ͽ� ������ ��ȸ ���
			line = "";
			System.out.println("title  director  actor  phone  addr\n");
			System.out.println("--------------------------------------------------------------\n");
			while(rs.next()) { // ���� ���� ������ True
				String title = rs.getString("title");
				String director = rs.getString("director");
				String actor = rs.getString("actor");
				String genre = rs.getString("genre");
				String time = rs.getString("time");
				String nation = rs.getString("nation");
				String openDate = rs.getString("openDate");
				line = " | " + title + " | " + director + " | " + actor + " | " + genre + " | " + time + " | " + nation + " | " + openDate + "\n";
				System.out.println("rs => " + line); // �ֿܼ� ��� ���
			}
			System.out.println("--------------------------------------------------------------\n");
			
			// ���� ���� ��ȸ
			rs = stmt.executeQuery("select * from ����;"); // Statement�� excuteQuery()�� SQL ���� �����Ͽ� ���� ����� �Ѱ���. ��� ���� ��� ���� �о� ����� rs�� ����. select ���� �̿��Ͽ� ������ ��ȸ ���
			line = "";
			System.out.println("memberId  title  businessName  startTime  sit\n");
			System.out.println("--------------------------------------------------------------\n");
			while(rs.next()) { // ���� ���� ������ True
				String memberId = rs.getString("memberId");
				String title = rs.getString("title");
				String businessName = rs.getString("businessName");
				String startTime = rs.getString("startTime");
				String sit = rs.getString("sit");
				line = " | " + memberId + " | " + title + " | " + businessName + " | " + startTime + " | " + sit + "\n";
				System.out.println("rs => " + line); // �ֿܼ� ��� ���
			}
			
			stmt.close(); // stmt �ݱ�
			conn.close(); // conn �ݱ�
		} catch(Exception e) {
			e.printStackTrace();
		}			
	}

	public void dbUpdate() { // ������ ���� �޼ҵ�
		try { // ȸ�� ���̵�� ���� ���� ����
			conn = DBConn.dbConnection(); // DB ����
			stmt = conn.createStatement();
			String in_id = tfMemberId.getText().toString(); // ȸ�� ���̵� �ؽ�Ʈ �ʵ忡 �Էµ� ������ ��������
			String in_title = movieCombo.getSelectedItem().toString(); // ��ȭ �޺��ڽ��� ���õ� ������ ��������
			String in_business = businessCombo.getSelectedItem().toString(); // ������  �޺��ڽ��� ���õ� ������ ��������			
			String in_startTime = startTimeCombo.getSelectedItem().toString(); // ���۽ð�  �޺��ڽ��� ���õ� ������ ��������
			
			stmt.executeUpdate("update ���� set title = '" + in_title + "', businessName = '" + in_business + "', startTime = '" + in_startTime + "', sit = '" + sit + "' where memberId = '" + in_id + "';"); // update ���� �̿��Ͽ� ������ ���� ���
			System.out.println(in_id + " ���� �Ϸ�"); // �ֿܼ� ��� ���
			stmt.close(); // stmt �ݱ�
			conn.close(); // conn �ݱ�
		} catch(Exception e) {
			e.printStackTrace();
			System.err.println("���� ����");
		}	
	}

	public static void main(String[] args) {
		new MovieReservation(); // MovieReservation ��ü ����
	}
}
