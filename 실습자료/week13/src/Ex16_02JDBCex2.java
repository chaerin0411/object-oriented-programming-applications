import java.io.*;
import java.sql.*;

public class Ex16_02JDBCex2 {
	public static void main(String[] args) {
		Connection conn;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC", "root", "admin");
			System.out.println("DB ���� �Ϸ�");
			stmt = conn.createStatement();
			
			ResultSet srs = stmt.executeQuery("select * from testtable");
			printData(srs, "name", "id", "dept");
			srs = stmt.executeQuery("select name, id, dept from testtable where name='�̱���'"); 
			printData(srs, "name", "id", "dept");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC ����̹� �ε� ����");
		} catch (SQLException e) {
			System.out.println("SQL ���� ����");
		}
		
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 13���� ���� 16-2");
	}
	
	private static void printData(ResultSet srs, String col1, String col2, String col3)
			throws SQLException {
		while (srs.next()) { //���ٿ� �����ϸ� false ��ȯ
			if (!col1.equals(""))
				System.out.print(srs.getString("name"));
			if (!col2.equals(""))
				System.out.print("\t|\t" + srs.getString("id"));
			if (!col3.equals(""))
				System.out.println("\t|\t" + srs.getString("dept"));
			else 
				System.out.println();
		}
	}
}
