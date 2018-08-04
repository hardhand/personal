package service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import commons.Constant;
import dao.IMemberDao;

@Service
public class MemberService {
	
	@Autowired
	private IMemberDao mDao;
	public String getData() {
		return "I am a human";
	}
	
	public List<HashMap<String, Object>> getMemberList() {
		return mDao.selectAll();
	}
	
	public void joinMember(HashMap<String, Object> params) {
		if (params.get("pwd").equals(params.get("pwd_CHECK"))) {
			mDao.selectAll();
		}
	}

	public boolean login(String id, String pwd) {
		HashMap<String, Object> result = mDao.selectOne(id);
		
		if(result == null)
			return false;
		
		else {
			String oPwd = (String) result.get(Constant.Member.PWD);
			
			if(oPwd == null)
				return false;
			
			else {
				if(oPwd.equals(pwd))
					return true;
				else
					return false;
			}
			
		}
		
	}
	
	public HashMap<String, Object> getMemberinfo(String id) {
		return mDao.selectOne(id);
	}
	
	public void memberUpdate(HashMap<String, Object> params) {
		if(params.get("pwd").equals(params.get("pwd_CHECK"))) {
			mDao.updateMember(params);
		}
	}
}








