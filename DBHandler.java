
import java.sql.*;

public class DBHandler {

		public static  Connection getConnection() throws ClassNotFoundException, SQLException{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","mysql@123");
			return connection;
			
		}
		public static int insertQuery(int idStudent, String firstName, String lastName, String dateOfBirth , String branch, int admissionYear, long mobileNumber,String email, String city ) throws SQLException, ClassNotFoundException {
			Connection con = getConnection();
		
			PreparedStatement prestmt = con.prepareStatement("insert into student values(?,?,?,?,?,?,?,?,?)");
			prestmt.setInt(1, idStudent);
			prestmt.setString(2,firstName);
			prestmt.setString(3, lastName);
			prestmt.setString(4, dateOfBirth);
			prestmt.setString(5,branch);
			prestmt.setInt(6,admissionYear);
			prestmt.setLong(7,mobileNumber);
			prestmt.setString(8,email);
			prestmt.setString(9,city);
			int result = prestmt.executeUpdate();
			
			return result;
		}
		


		
		public static int deleteQuery(int deleteId) throws ClassNotFoundException, SQLException
		{
			Connection con = getConnection();
			PreparedStatement prepstmt = con.prepareStatement("delete from student where idstudent = ?");
			prepstmt.setInt(1, deleteId);
			int result = prepstmt.executeUpdate();
			return result;
		}
		
		public static ResultSet listTableQuery() throws ClassNotFoundException, SQLException
		{
			
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			
			ResultSet result=stmt.executeQuery("select * from student");
			   
			      
						
			return result;
		}
		public static ResultSet findStudent(int idStudent) throws ClassNotFoundException, SQLException
		{
			Connection con = getConnection();
			Statement st = con.createStatement();
			ResultSet rs =  st.executeQuery("select * from student where idstudent = '"+ idStudent + "'");
		
			return rs;	
		}
		
}
