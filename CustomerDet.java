import java.sql.*;
import java.util.Scanner;
public class CustomerDet {
	
	static final String DB_url="jdbc:mysql://localhost:3306/cognidemo";
	static final String user="root";
	static final String pass="Perween123";
	static final String QuerySelect="select * from customers";
	static final String QueryInsert="insert into customers(cust_id,cust_name,cust_age,cust_address,cust_income) values(?,?,?,?,?)";
	static final String QueryUpdate="update customers set cust_name=?,cust_age=?,cust_address=? where cust_id=?";
	static final String QueryDel="delete from customers where cust_id=?";

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
					System.out.println("Customer id is "+ rs.getInt("cust_id"));
					System.out.println("Customer name is "+ rs.getString("cust_name"));
					System.out.println("Customer age is "+ rs.getString("cust_age"));
					System.out.println("Customer address is "+ rs.getString("cust_address"));
					System.out.println("Customer income is "+ rs.getString("cust_income"));
					
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
				System.out.println("Enter the id");
				int cust_id=sc.nextInt();
				System.out.println("Enter the name");
				String cust_name=sc.next();
				System.out.println("Enter the age");
				int cust_age=sc.nextInt();
				System.out.println("Enter the city");
				String cust_city=sc.next();
				System.out.println("Enter the income");
				int cust_income=sc.nextInt();
				
				ps.setInt(1, cust_id);
				ps.setString(2, cust_name);
				ps.setInt(3, cust_age);
				ps.setString(4, cust_city);
				ps.setInt(5, cust_income);
				
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
				System.out.println("Enter the id");
				int cust_id=sc.nextInt();
				
				System.out.println("Enter the name");
				String cust_name=sc.next();
				System.out.println("Enter the age");
				int cust_age=sc.nextInt();
				System.out.println("Enter the city");
				String cust_city=sc.next();
				
				ps.setString(1, cust_name);
				ps.setInt(2, cust_age);
				ps.setString(3, cust_city);
				ps.setInt(4, cust_id);
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
			
			System.out.println("Enter the id");
			int cust_id=sc.nextInt();
			
			
			ps.setInt(1, cust_id);
			ps.executeUpdate();
			
			System.out.println("deleted successfully");
		
		}
		catch(SQLException e) {
			e.printStackTrace();
			
		}
		}
		
		
		

	}

}
