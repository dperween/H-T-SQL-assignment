import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Signup {

	
	static final String DB_url="jdbc:mysql://localhost:3306/cognidemo";
	static final String user="root";
	static final String pass="Perween123";
	static final String Query="insert into login(first_name,email,password) values(?,?,?)";
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(Connection conn=DriverManager.getConnection(DB_url,user,pass);
				PreparedStatement ps=conn.prepareStatement(Query);){
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the first name");
			String fname=sc.next();
			System.out.println("Enter the email");
			String email=sc.next();
			System.out.println("Enter the password");
			String password=sc.next();
			
			//ps.setInt(1, eid);
			//ps.setString(2, ename);
			ps.setString(1, fname);
			ps.setString(2, email);
			ps.setString(3, password);
			
			ps.executeUpdate();
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			
		}

	}

}
