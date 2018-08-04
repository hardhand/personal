package dao;

import java.util.HashMap;
import java.util.List;

public interface IMemberDao {
	
	public int insertMember(HashMap<String, Object> params);

	public int updateMember(HashMap<String, Object> params);

	public void deleteMember(String userid);

	public HashMap<String, Object> selectOne(String id);

	public List<HashMap<String, Object>> selectAll();
	
	public String selectPw(String id);
	

}
