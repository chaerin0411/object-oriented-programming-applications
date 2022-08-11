import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.*;

public class Ex16_00ManageStudent extends JFrame {
   /**SerialVersionUID**/
   private static final long serialVersionUID = 1L;
   
   JButton btnInsert, btnUpdate, btnDelete, btnSelect, btnSearch; //J버튼 입력, 수정, 삭제, 조회, 검색
   JTextField tfId, tfName, tfDept, tfSearch; //데이터입력란, 조회할 데이터 입력란
   JTextArea ta; //검색결과 출력
   JRadioButton rbId, rbName, rbDept; //검색할 데이터 고르는 라디오버튼
   Connection conn; //DB
   Statement stmt; //SQL문
   ResultSet rs; //검색된 데이터
   
   public Ex16_00ManageStudent() { //생성자
      this.setTitle("학생 입력 폼 만들기 예제");
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      createGUI(); //JButton, JTF 생성
      
      btnInsert.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            dbInsert();
         }
      }); //입력버튼에 액션리스너 설정
      btnUpdate.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            dbUpdate();
         }
      }); //수정버튼에 액션리스너 설정
      btnDelete.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            dbDelete();
         }
      }); //삭제버튼에 액션리스너 설정
      btnSelect.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            dbSelect();
         }
      }); //조회버튼에 액션리스너 설정
      btnSearch.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            dbSearch();
         }
      }); //검색버튼에 액션리스너 설정
      
      this.setSize(280,538); //280 x 538 사이즈
      this.setVisible(true); //눈에 보이게
   } /*end-Ex16_00ManageStudent()*/
   
   public void createGUI() {
      Container c = this.getContentPane();
      c.setLayout(new FlowLayout()); //FlowLayout - 흐르듯이 배치
      
      c.add(new JLabel("학번")); //학번 입력칸 생성
      tfId = new JTextField(22);
      c.add(tfId);
      
      c.add(new JLabel("이름")); //이름 입력칸 생성
      tfName = new JTextField(22);
      c.add(tfName);
      
      c.add(new JLabel("학과")); //학과 입력칸 생성
      tfDept = new JTextField(22);
      c.add(tfDept);
      
      btnInsert = new JButton("입력"); c.add(btnInsert); //입력버튼 생성
      btnUpdate = new JButton("수정"); c.add(btnUpdate); //수정버튼 생성
      btnDelete = new JButton("삭제"); c.add(btnDelete); //삭제버튼 생성
      btnSelect= new JButton("조회"); c.add(btnSelect); //조회버튼 생성
      
      //검색부분
      tfSearch = new JTextField(18);
      rbId = new JRadioButton("학번", true); //기본으로 체크돼있음
      rbName = new JRadioButton("이름");
      rbDept = new JRadioButton("학과");
      ButtonGroup group = new ButtonGroup();
      group.add(rbId); group.add(rbName); group.add(rbDept);
      
      btnSearch = new JButton("검색");
      JPanel pn1 = new JPanel();
      pn1.add(new JLabel(" "));
      pn1.add(tfSearch); pn1.add(btnSearch);
      
      JPanel pn2 = new JPanel(); //라디오버튼
      pn2.add(rbId); pn2.add(rbName); pn2.add(rbDept);
      
      JPanel pMiddle = new JPanel(new BorderLayout(0,0)); //middle 판넬
      pMiddle.add(BorderLayout.NORTH, pn1);
      pMiddle.add(BorderLayout.CENTER, pn2);
      
      TitledBorder tb = new TitledBorder("검색");
      pMiddle.setBorder(tb);
      c.add(pMiddle); //middle 판넬 추가
      //
      ta = new JTextArea(15, 20); //검색결과 표시 부분
      c.add(ta);
      
   } /*end-createGUI()*/
   
   public void dbInsert() { //입력버튼 눌렀을 떄
      try { //DB연결
         conn = DBConn.dbConnection();
         stmt = conn.createStatement(); //SQL문 입력
         
         String id   = tfId.getText().toString();
         String name = tfName.getText().toString();
         String dept = tfDept.getText().toString();
         
         //데이터 입력 name-tfName | dept-tfDept | id-tfId
         stmt.executeUpdate("insert into testtable values('"+id+"', '"+name+"', '"+dept+"');");
         System.out.println(name+"입력 완료");
         
         //JTF 초기화
         tfId.setText("");
         tfName.setText("");
         tfDept.setText("");
         //DB, SQL종료
         stmt.close();
         conn.close();
      
      //예외처리
      } catch (SQLIntegrityConstraintViolationException e) {
         System.out.println("Constraint 제약 조건 에러");
      } catch (SQLException e) {
         System.out.println("SQL 실행 에러");
      } catch (Exception e) { e.printStackTrace(); }
   } /*end-dbInsert*/
   
   public void dbUpdate() { //수정버튼 눌렀을 떄
      try { //DB연결
         conn = DBConn.dbConnection();
         stmt = conn.createStatement(); //SQL문 입력
         
         //데이터 수정 id=inid인 레코드의 name과 dept를 inname과 indept로 수정
         String inid   = tfId.getText().toString();
         String inname = tfName.getText().toString();
         String indept = tfDept.getText().toString();
         
         //데이터 수정 name-tfName | dept-tfDept | id-tfId
         stmt.executeUpdate("update testtable set name='"+inname+"', dept='"+indept+"' where id='"+inid+"';");
         System.out.println(inname+"수정 완료");
         
         //JTF 초기화
         tfId.setText("");
         tfName.setText("");
         tfDept.setText("");
         //DB, SQL종료
         stmt.close();
         conn.close();
         
      //예외처리
      } catch (SQLIntegrityConstraintViolationException e) {
         System.out.println("Constraint 제약 조건 에러");
      } catch (SQLException e) {
         System.out.println("SQL 실행 에러");
      } catch (Exception e) {
         e.printStackTrace();
         System.err.println("수정 에러");
      }
   } /*end-dbUpdate*/
   
   public void dbDelete() { //삭제버튼 눌렀을 때
      try { //DB연결
         conn = DBConn.dbConnection();
         stmt = conn.createStatement(); //SQL문 입력
         
         //데이터 삭제 id=inputid인 레코드 삭제
         String inputid = tfId.getText().toString();
         stmt.executeUpdate("delete from testtable where id = '"+inputid+"';");
         System.out.println(inputid+"삭제 완료");
         
         //JTF 초기화
         tfId.setText("");
         tfName.setText("");
         tfDept.setText("");
         //DB, SQL종료
         stmt.close();
         conn.close();
         
      //예외처리
      } catch (SQLIntegrityConstraintViolationException e) {
         System.out.println("Constraint 제약 조건 에러");
      } catch (SQLException e) {
         System.out.println("SQL 실행 에러");
      } catch (Exception e) { e.printStackTrace(); }
   } /*end-dbDelete*/
   
   public void dbSelect() { //조회버튼 눌렀을 떄
      try { //DB연결
         conn = DBConn.dbConnection();
         stmt = conn.createStatement(); //SQL문 입력
         rs = stmt.executeQuery("select * from testtable;");
         
         var line = "";
         ta.setText("         id         name          dept\n");
         ta.append("+------------+---------+-----------------+\n");
         
         while (rs.next()) { //끝까지 읽어들이기
            var id   = rs.getString("id");
            var name = rs.getString("name");
            var dept = rs.getString("dept");
            line = " | "+id+" | "+name+" | "+dept+" | \n";
            System.out.println("rs => "+line);
            ta.append(line);
         }
         //DB, SQL종료
         stmt.close();
         conn.close();
         
      //예외처리
      } catch (SQLIntegrityConstraintViolationException e) {
         System.out.println("Constraint 제약 조건 에러");
      } catch (SQLException e) {
         System.out.println("SQL 실행 에러");
      } catch (Exception e) { e.printStackTrace(); }
   } /*end-dbSelect*/
   
   public void dbSearch() { //검색버튼 눌렀을 떄
      try { //DB연결
         conn = DBConn.dbConnection();
         stmt = conn.createStatement(); //SQL문 입력
         var searchText = tfSearch.getText().toString();
         var searchSql = "";
         
         //데이터 조회 검색조건=searchText인 레코드 모든 필드 검색
         if (rbId.isSelected()) {
            searchSql = "select * from testtable where id = '"+searchText+"';";
         } else if (rbName.isSelected()) {
            searchSql = "select * from testtable where name = '"+searchText+"';";
         } else {
            searchSql = "select * from testtable where dept = '"+searchText+"';";
         }
         rs = stmt.executeQuery(searchSql); //searchSql 실행
         
         var line = "";
         ta.setText("         id         name          dept\n");
         ta.append("+------------+---------+-----------------+\n");
         
         while (rs.next()) { //끝까지 읽어들이기
             var id   = rs.getString("id");
             var name = rs.getString("name");
             var dept = rs.getString("dept");
             line = " | "+id+" | "+name+" | "+dept+" | \n";
             System.out.println("rs => "+line);
             ta.append(line);
          }
          //DB, SQL종료
          stmt.close();
          conn.close();
         
      //예외처리
      } catch (SQLIntegrityConstraintViolationException e) {
         System.out.println("Constraint 제약 조건 에러");
      } catch (SQLException e) {
         System.out.println("SQL 실행 에러");
      } catch (Exception e) {
         e.printStackTrace();
         System.err.println("검색 에러");
      }
   } /*end-dbSearch*/
   
   public static void main(String[] args) {
      new Ex16_00ManageStudent(); //생성자 실행
      System.out.println("YA 20202865 엄지희");
      System.out.println("객체지향프로그래밍 응용 12주차 학생관리프로그램 예제");
   }
}
