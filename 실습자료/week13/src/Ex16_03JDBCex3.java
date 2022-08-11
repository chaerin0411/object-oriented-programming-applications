import java.io.*;
import java.sql.*;

public class Ex16_03JDBCex3 {
	public static void main(String[] args) {
		Connection conn;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC", "root", "admin");
			System.out.println("DB ���� �Ϸ�");
			
			stmt = conn.createStatement();
			stmt.executeUpdate("insert into testtable (name, id, dept) values('�ƹ���', '0893012', '��ǻ�Ͱ���');");
			printTable(stmt);
			System.out.println();
			
			stmt.executeUpdate( "update testtable set id='0189011' where name='�ƹ���'");
			printTable(stmt);
			System.out.println();
			
			stmt.executeUpdate("delete from testtable where name='�ƹ���'");
			printTable(stmt);
			System.out.println();
			
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC ����̹� �ε� ����");
		} catch (SQLException e) {
			System.out.println("SQL ���� ����");
		}
		
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 13���� ���� 16-3");
	}
	
	private static void printTable(Statement stmt) throws SQLException {
		ResultSet srs = stmt.executeQuery("select * from testtable");
		while (srs.next()) {
		System.out.print(srs.getString("name"));
		System.out.print("\t|\t" + srs.getString("id"));
		System.out.println("\t|\t" + srs.getString("dept"));
		}
	}
}
