import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibraryDao {
	private Connection connection;
	private static final String USERNAME = "root";
	private static final String PASSWORD = "mysql";
	private static final String URL = "jdbc:mysql://localhost:3306/bitcamp?autoReconnect=true&useSSL=false";
	private static LibraryDao instance;

	public static LibraryDao getInstance() {
		if (instance == null)
			instance = new LibraryDao();

		return instance;
	}

	public LibraryDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("클래스 적재 실패");
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("서버 연결 실패");
		}
	}

	public void insertLibrary(Library library) {
		String sql = "insert into employee values(?,?,?);";
		PreparedStatement pstmt = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, library.getId());
			pstmt.setString(2, library.getTitle());
			pstmt.setString(3, library.getAuthor());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null & !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void updateLibrary(Library library) {
		String sql = "update employee set title = ?, author = ? where id = ?";
		PreparedStatement pstmt = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(3, library.getId());
			pstmt.setString(1, library.getTitle());
			pstmt.setString(2, library.getAuthor());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null & !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void deleteLibrary(int id) {
		String sql = "delete from employee where id = ?";
		PreparedStatement pstmt = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null & !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public Library selectone(int id) {
		String sql = "select * from Library where id = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Library library = null;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeQuery();
			rs = pstmt.executeQuery();
			if (rs.next()) {
				library = new Library();
				library.setId(rs.getInt("id"));
				library.setTitle(rs.getString("title"));
				library.setAuthor(rs.getString("author"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null & !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return library;

	}

	public List<Library> selectAll() {
		String sql = "select * from library";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Library> libraryList = new ArrayList<Library>();

		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Library library = new Library();
				library.setId(rs.getInt("id"));
				library.setTitle(rs.getString("title"));
				library.setAuthor(rs.getString("author"));
				libraryList.add(library);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null & !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return libraryList;

	}

}
