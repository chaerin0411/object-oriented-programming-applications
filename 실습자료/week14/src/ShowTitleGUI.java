import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

public class ShowTitleGUI extends JFrame {
	/** SerialVersionUID **/
	private static final long serialVersionUID = 1L;

	JButton btnBack, btnSearch, btnDelete, btnInsert;
	JTable table;
	String title, day, time;
	String[][] contents;
	int selectedIndex;
	Connection conn; //DB
	Statement stmt; //SQL��
	ResultSet rs;
	
	public ShowTitleGUI(String txt) {
		super("���̾");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		dbShowTitle(txt);
		
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setPreferredSize(new Dimension(350,125));
		c.add(scrollpane);
		
		btnBack = new JButton("���ư���");
		btnSearch = new JButton("�˻�");
		btnDelete = new JButton("��ü����");
		btnInsert = new JButton("�۾���");
		
		c.add(btnBack);
		c.add(btnSearch);
		c.add(btnDelete);
		c.add(btnInsert);
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Diary(); setVisible(false);
			}
		}); //���ư��� ��ư
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchGUI(); setVisible(false);
			}
		}); //�˻� ��ư
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, 
						"�����͸� ��� �����Ͻðڽ��ϱ�?", "Ȯ��", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					dbDelete(); new ShowGUI(); setVisible(false);
				} else if (result == JOptionPane.NO_OPTION) {;} else {;}
			}
		}); //��ü���� ��ư
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InputGUI(); setVisible(false);
			}
		}); //�۾��� ��ư
		
		setSize(400,500);
		setVisible(true);
	} /*end-showGUI()*/
	
	public void dbShowTitle(String selectedTitle) { //������ ��ȸ - ���� �˻�
		try { //DB����
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DBConn.dbConnection();
			System.out.println("DB ���� �Ϸ�");
			stmt = conn.createStatement(); //SQL�� �Է�
			
			int len = 0;
			rs = stmt.executeQuery("select count(*) from recordtable where title like '%"+selectedTitle+"%';");
			while (rs.next()) { //������ �о���̱�
				len = Integer.parseInt(rs.getString("count(*)"));
			}
			
			rs = stmt.executeQuery("select * from recordtable where title like '%"+selectedTitle+"%';");
			String[] header = {"�۹�ȣ","��¥","�ð�","����"};
			contents = new String[len][4];
			
			int cnt = 0;
			while (rs.next()) { //������ �о���̱�
				day   = rs.getString("day");
				time  = rs.getString("time");
				title = rs.getString("title");
				
				contents[cnt][0] = Integer.toString(cnt+1);
				contents[cnt][1] = day;
				contents[cnt][2] = time;
				contents[cnt][3] = title;
				cnt++;
			}
			DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
			celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
			
			table = new JTable(contents, header);
			table.getColumn("�۹�ȣ").setCellRenderer(celAlignCenter);
			table.getColumn("�۹�ȣ").setPreferredWidth(30);
			table.getColumn("��¥").setCellRenderer(celAlignCenter);
			table.getColumn("��¥").setPreferredWidth(40);
			table.getColumn("�ð�").setCellRenderer(celAlignCenter);
			table.getColumn("�ð�").setPreferredWidth(40);
			table.getColumn("����").setPreferredWidth(200);
			
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
			System.err.println("��ȸ ����");
		}

		table.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				JTable jt = (JTable)e.getSource();
				selectedIndex = jt.getSelectedRow();
				System.out.println(contents[selectedIndex][1]+" "+contents[selectedIndex][2]);
				new SelectGUI(contents[selectedIndex][1],contents[selectedIndex][2]);
				setVisible(false);
			}
			public void mousePressed(MouseEvent e) {;}
			public void mouseReleased(MouseEvent e) {;}
			public void mouseEntered(MouseEvent e) {;}
			public void mouseExited(MouseEvent e) {;}
		}); //�ϱ���ȸ
	} /*end-dbShowTitle()*/
	
	public void dbDelete() { //��ü����
		try { //DB����
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DBConn.dbConnection();
			System.out.println("DB ���� �Ϸ�");
			stmt = conn.createStatement(); //SQL�� �Է�
			
			//������ ���� title-tfTt | day-tfDay
			stmt.executeUpdate("delete from recordtable;");
			System.out.println("������ ��ü���� �Ϸ�");
			
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