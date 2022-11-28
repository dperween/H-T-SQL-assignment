import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Signin {

	
	static final String DB_url="jdbc:mysql://localhost:3306/cognidemo";
	static final String user="root";
	static final String pass="Perween123";
	static final String QuerySelect="select * from login";
	static final String QueryInsert="insert into login(fname,email,password) values(?,?,?)";
	static final String QueryUpdate="update login set fnamename=?,password=?, where email=?";
	static final String QueryDel="delete from customers where email=?";
	
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Select a option");
		System.out.println("Press 1 to Retrieve data");
		System.out.println("Press 2 to insert data");
		System.out.println("Press 3 to update data");
		System.out.println("Press 4 to delete data");
		
		int choice = sc.nextInt();

		if(choice==1)
		{
		try(Connection conn=DriverManager.getConnection(DB_url,user,pass);
				Statement st=conn.createStatement();
				ResultSet rs=st.executeQuery(QuerySelect);){
				while(rs.next()) {
					
					System.out.println("User name is "+ rs.getString("fname"));
					System.out.println("Email is "+ rs.getString("email"));
					System.out.println("password is "+ rs.getString("password"));
					
					
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
				
			}
		}
		
		if(choice==2)
		{
			try(Connection conn=DriverManager.getConnection(DB_url,user,pass);
					PreparedStatement ps=conn.prepareStatement(QueryInsert);){
				
				System.out.println("Enter the firstname");
				String firstname=sc.next();
				System.out.println("Enter email");
				String emailId=sc.next();
				System.out.println("Enter the password");
				String password=sc.next();
				
				
				ps.setString(1, firstname);
				ps.setString(2, emailId);
				ps.setString(3, password);
				
				
				ps.executeUpdate();
				System.out.println("Inserted successfully!!!");
				
				
			}
			catch(SQLException e) {
				e.printStackTrace();
				
			}
		}
		if(choice==3)
		{
			try(Connection conn=DriverManager.getConnection(DB_url,user,pass);
					PreparedStatement ps=conn.prepareStatement(QueryUpdate);){
				System.out.println("Enter the emailid");
				String email_id=sc.next();
				
				System.out.println("Enter the first name");
				String firstname=sc.next();
				System.out.println("Enter the password");
				String password=sc.next();
				System.out.println("Enter the city");
				String cust_city=sc.next();
				
				ps.setString(1, firstname);
				ps.setString(2, password);
				ps.setString(3, email_id);
				//ps.setInt(4, cust_id);
				ps.executeUpdate();
				System.out.println("updated successfully!!!!");
				
				
			}
			catch(SQLException e) {
				e.printStackTrace();
				
			}
		}
		if(choice==4) {
		try(Connection conn=DriverManager.getConnection(DB_url,user,pass);
				PreparedStatement ps=conn.prepareStatement(QueryDel);){
			
			System.out.println("Enter the emailid");
			int email_id=sc.nextInt();
			
			
			ps.setInt(1, email_id);
			ps.executeUpdate();
			
			System.out.println("deleted successfully");
		
		}
		catch(SQLException e) {
			e.printStackTrace();
			
		}
		// TODO Auto-generated method stub

	}

	}
}
