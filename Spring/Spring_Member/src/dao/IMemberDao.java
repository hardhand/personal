package dao;

import java.util.HashMap;
import java.util.List;

public interface IMemberDao {
	
	public int insertMember(HashMap<String, Object> params);

	public void updateMember(HashMap<String, Object> params);

	public void deleteMember(String userid);

	public HashMap<String, Object> selectOne(String userid);

	public List<HashMap<String, Object>> selectAll();
}
