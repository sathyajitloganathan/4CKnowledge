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
		
    	try {
		Connection conn = DBConnect.getConnection();
		
		String query = "insert into member("
    			+ "name,"
    			+ "dob,"
    			+ "email,"
    			+ "phonenumber,"
    			+ "address,"
    			+ "password,"
    			+ "interests"
    			+ ") values(?,?,?,?,?,?,?);";
	
		PreparedStatement stmt ;
		
	    		
	    		stmt = conn.prepareStatement(query);
	    		stmt.setString(1, member.getUserName());
	    		stmt.setString(2, member.getDOB());
	    		stmt.setString(3, member.getEmail());
	    		stmt.setString(4, member.getPhoneNumber());
	    		stmt.setString(5, member.getAddress());
	    		stmt.setString(6, member.getPassword());
	    		stmt.setString(7, member.getInterest());
	    		
	    		stmt.executeUpdate();
	    		
	    		
	    		 conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
    
}
