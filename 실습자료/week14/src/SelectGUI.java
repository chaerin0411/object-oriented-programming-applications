import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class SelectGUI extends JFrame {
	/** SerialVersionUID **/
	private static final long serialVersionUID = 1L;

	GridBagLayout gBag;
	JTextField tfTt, tfDay, tfTime, tfWth;
	JTextArea taCnt;
	JButton btnBack, btnDel, btnUpd;
	String title, day, time, weather, content;
	Connection conn; //DB
	Statement stmt; //SQL��
	ResultSet rs;
	
	public SelectGUI(String selectedDate, String selectedTime) {
		super("���̾");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		gBag = new GridBagLayout();
		c.setLayout(gBag);
		
		gbinsert(new JLabel("���� "),0,0,1,1); //���� �Է�ĭ ����
		tfTt = new JTextField(20);
		gbinsert(tfTt,1,0,5,1);
		gbinsert(new JLabel(" "),0,1,4,1);
		
		gbinsert(new JLabel(" "),0,2,1,1);
		gbinsert(new JLabel(" "),1,2,1,1);
		gbinsert(new JLabel(" "),2,2,1,1);
		gbinsert(new JLabel("��¥(Ex.06/16) ",JLabel.RIGHT),4,2,1,1); //��¥ �Է�ĭ ����
		tfDay = new JTextField(3);
		gbinsert(tfDay,5,2,1,1);

		gbinsert(new JLabel(" "),0,3,1,1);
		gbinsert(new JLabel(" "),1,3,1,1);
		gbinsert(new JLabel(" "),2,3,1,1);
		gbinsert(new JLabel("�ð�(Ex.18:30) ",JLabel.RIGHT),4,3,1,1); //�ð� �Է�ĭ ����
		tfTime = new JTextField(3);
		gbinsert(tfTime,5,3,1,1);

		gbinsert(new JLabel(" "),0,4,5,1);
		gbinsert(new JLabel("���� "),0,5,1,1); //���� �Է�ĭ ����
		tfWth = new JTextField(20);
		gbinsert(tfWth,1,5,5,1);
		
		gbinsert(new JLabel("���� "),0,6,1,1); //���� �Է�ĭ ����
		taCnt = new JTextArea(7,20);
		taCnt.setLineWrap(true);
		gbinsert(taCnt,1,6,5,4);

		gbinsert(new JLabel(" "),0,10,5,1);
		btnBack = new JButton("���ư���");
		gbinsert(btnBack,0,11,3,1);
		btnDel = new JButton("�ϱ����");
		gbinsert(btnDel,3,11,1,1);
		btnUpd = new JButton("����");
		gbinsert(btnUpd,4,11,2,1);
		
		dbShow(selectedDate, selectedTime);
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ShowGUI(); setVisible(false);
			}
		}); //���ư��� ��ư
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbDelete(selectedDate, selectedTime);
			}
		}); //���� ��ư
		btnUpd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbUpdate(selectedDate, selectedTime);
			}
		}); //���� ��ư
				
		setSize(400,500);
		setVisible(true);
	} /*end-SelectGUI()*/
	
	public void gbinsert(Component c, int x, int y, int w, int h) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gBag.setConstraints(c,gbc);
		this.add(c);
	} /*end-gbinsert()*/
	
	public void dbShow(String selectedDate, String selectedTime) { //������ ���̱�
		try { //DB����
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DBConn.dbConnection();
			System.out.println("DB ���� �Ϸ�");
			stmt = conn.createStatement(); //SQL�� �Է�			
			rs = stmt.executeQuery("select * from recordtable where day='"+selectedDate+"' and time='"+selectedTime+"';");
			while (rs.next()) { //������ �о���̱�
				title = rs.getString("title");
				day   = rs.getString("day");
				time  = rs.getString("time");
				weather = rs.getString("weather");
				content = rs.getString("content");
				//JTF setText
				tfTt.setText(title);
				tfDay.setText(day);
				tfTime.setText(time);
				tfWth.setText(weather);
				taCnt.setText(content);
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
	} /*end-dbShow()*/
	
	public void dbUpdate(String selectedDate, String selectedTime) { //���� ��ư ������ ��
		try { //DB����
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DBConn.dbConnection();
			System.out.println("DB ���� �Ϸ�");
			stmt = conn.createStatement(); //SQL�� �Է�

			title = tfTt.getText().toString();
			day   = tfDay.getText().toString();
			time  = tfTime.getText().toString();
			weather = tfWth.getText().toString();
			content = taCnt.getText().toString();
			
			//������ ���� title-tfTt | day-tfDay | time-tfTime | weather-tfWth | content-taCnt
			stmt.executeUpdate("update recordtable set day='"+day+"', time='"+time+"', weather='"+weather+"', title='"+title+"', content='"+content+"' where day='"+selectedDate+"' and time='"+selectedTime+"';");
			System.out.println(day+" "+time+" ���� �Ϸ�");
			
			//DB, SQL����
			stmt.close();
			conn.close();
		
		//����ó��
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("Constraint ���� ���� ����");
		} catch (SQLException e) {
			System.out.println("SQL ���� ����");
		} catch (Exception e) { e.printStackTrace(); }
	} /*end-dbUpdate()*/
	
	public void dbDelete(String selectedDate, String selectedTime) { //�ϱ���� ��ư ������ ��
		try { //DB����
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DBConn.dbConnection();
			System.out.println("DB ���� �Ϸ�");
			stmt = conn.createStatement(); //SQL�� �Է�
			
			//������ ���� title-tfTt | day-tfDay
			stmt.executeUpdate("delete from recordtable where day='"+selectedDate+"' and time='"+selectedTime+"';");
			System.out.println(day+" "+time+" ���� �Ϸ�");
			
			//DB, SQL����
			stmt.close();
			conn.close();
		
		//����ó��
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("Constraint ���� ���� ����");
		} catch (SQLException e) {
			System.out.println("SQL ���� ����");
		} catch (Exception e) { e.printStackTrace(); }
	} /*end-dbDelete()*/
}