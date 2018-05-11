package it16139404;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement ;

public class MemberDAO {
	static Connection conn = null;
    static ResultSet rs = null;  
	
    
    public List<MemberBean> getAllMembers() throws SQLException{
		
		
		ArrayList<MemberBean> members =null;
		Connection conn = DBConnect.getConnection();
		String query = "select * from members";
	
		Statement stmt ;
		try {
			
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			//members=(ArrayList<MemberBean>)resultsetToArrayList(rs);
			
			conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return members;
		
		
	}
    
    public static void addMemberDetails(MemberBean member){
		
    	String type = "U";
    	try {
		Connection conn = DBConnect.getConnection();
		
		String query = "insert into user("
    			+ "name,"
    			+ "username,"
    			+ "type,"
    			+ "dob,"
    			+ "email,"
    			+ "phonenumber,"
    			+ "address,"
    			+ "password,"
    			+ "interests"
    			+ ") values(?,?,?,?,?,?,?,?,?);";
	
		PreparedStatement stmt ;
		
		System.out.println(member.getName());
		System.out.println(member.getUserName());
		System.out.println(member.getDOB());
		System.out.println(member.getEmail());
		System.out.println(member.getPhoneNumber());
		System.out.println(member.getAddress());
		System.out.println(member.getPassword());
		System.out.println(member.getInterest());

		
	    		stmt = conn.prepareStatement(query);
	    		stmt.setString(1, member.getName());
	    		stmt.setString(2, member.getUserName());
	    		stmt.setString(3, type );
	    		stmt.setString(4, member.getDOB());
	    		stmt.setString(5, member.getEmail());
	    		stmt.setString(6, member.getPhoneNumber());
	    		stmt.setString(7, member.getAddress());
	    		stmt.setString(8, Encryption.encrypt(member.getPassword())); //Password encrypted
	    		stmt.setString(9, member.getInterest());
	    		
	    		stmt.executeUpdate();
	    		
	    		System.out.println("Inserted successfully");
	    		 conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
    
 public static void updateMemberDetails(MemberBean member){
		
    	String type = "U";
    	try {
		Connection conn = DBConnect.getConnection();
		System.out.println("QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ"+  member.getUName());
		String query = "update user set name=?,username=?,type=?,dob=?,email=?,phonenumber=?,address=?,password=?,interests=? where name='"+member.getUName()+"';";
	
		PreparedStatement stmt ;
		
		System.out.println(member.getName());
		System.out.println(member.getUserName());
		System.out.println(member.getDOB());
		System.out.println(member.getEmail());
		System.out.println(member.getPhoneNumber());
		System.out.println(member.getAddress());
		System.out.println(member.getPassword());
		System.out.println(member.getInterest());
		System.out.println(member.getUName());


	    		stmt = conn.prepareStatement(query);
	    		stmt.setString(1, member.getName());
	    		stmt.setString(2, member.getUserName());
	    		stmt.setString(3, type );
	    		stmt.setString(4, member.getDOB());
	    		stmt.setString(5, member.getEmail());
	    		stmt.setString(6, member.getPhoneNumber());
	    		stmt.setString(7, member.getAddress());
	    		stmt.setString(8, Encryption.encrypt(member.getPassword())); //Password encrypted
	    		stmt.setString(9, member.getInterest());
	    		//stmt.setString(10, member.getUName());
	    		
	    		stmt.executeUpdate();
	    		
	    		System.out.println("Updated successfully");
	    		 conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
    
}
