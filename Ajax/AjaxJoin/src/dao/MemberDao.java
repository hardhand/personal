package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Member;

public class MemberDao {
	private static MemberDao instance;
	
	private Connection connection;
	
	private static String URL = "jdbc:mysql://localhost/bitcamp";
	private static String USERNAME = "root";
	private static String PASSWORD = "mysql";
	
	private MemberDao(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static MemberDao getInstance(){
		if(instance == null)
			instance = new MemberDao();
		return instance;
	}
	public boolean insertMember(Member member)
	{
		PreparedStatement pstmt = null;
		String sql = "insert into member values ( ?, ?, ? )";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			
			int result = pstmt.executeUpdate();
			if(result > 0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean updateMember(Member member)
	{

		PreparedStatement pstmt = null;
		String sql = "update member set pwd = ?, name = ? where id = ? ";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(3, member.getId());
			pstmt.setString(1, member.getPwd());
			pstmt.setString(2, member.getName());
			
			int result = pstmt.executeUpdate();
			if(result > 0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	
	}
	public boolean deleteMember(String id)
	{
		PreparedStatement pstmt = null;
		String sql = "delete from member where id = ?";
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, id);
			int result = pstmt.executeUpdate();
			if(result > 0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	
	public Member selectOne(String id){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		String sql = "select * from member where id = '" +id + "'";
//		System.out.println(sql);
		try {
			pstmt = connection.prepareStatement(sql);
//			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if( rs.next() )
			{
				member = new Member();
				member.setId( rs.getString(1) );
				member.setPwd( rs.getString(2) );
				member.setName( rs.getString(3) );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(pstmt != null && !pstmt.isClosed())
					pstmt.close();
				if(rs != null && !rs.isClosed())
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return member;
	}
	
	public Member selectOneName(String name){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		String sql = "select * from member where name = '" +name + "'";
		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if( rs.next() )
			{
				member = new Member();
				member.setId( rs.getString(1) );
				member.setPwd( rs.getString(2) );
				member.setName( rs.getString(3) );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(pstmt != null && !pstmt.isClosed())
					pstmt.close();
				if(rs != null && !rs.isClosed())
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return member;
	}
	public List<Member> selectAll(){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Member> list = new ArrayList<Member>();
		String sql = "select * from member";
		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while( rs.next() )
			{
				Member member = new Member();
				member.setId( rs.getString(1) );
				member.setPwd( rs.getString(2) );
				member.setName( rs.getString(3) );
				list.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(pstmt != null && !pstmt.isClosed())
					pstmt.close();
				if(rs != null && !rs.isClosed())
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	
	}
}















