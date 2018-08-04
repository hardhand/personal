package service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import commons.Constant;
import dao.IMemberDao;

@Service
public class MemberService {

	@Autowired
	private IMemberDao mDao;
//	public String getData() {
//		
//		return "I am a human";
//	}
	public List<HashMap<String, Object>> getMemberList(){
		return mDao.selectAll();
	}
	
	public void joinMember(HashMap<String, Object> params) {
		if(params.get("pwd").equals(params.get("pwd_CHECK"))) {
			mDao.insertMember(params);
		}
	}
	
	public boolean login(String userid, String pwd) {
		HashMap<String, Object> result = mDao.selectOne(userid);
		if(result==null) 
			return false;
		else {
			String pw = (String) result.get(Constant.Member.PWD);
			if (pw == null)
				return false;
			else {
				if (pw.equals(pwd))
					return true;
				else
					return false;
			}
			
//			String oPwd = (String) result.get(Constant.Member.PWD);
//			if(oPwd.equals(pwd))
//				return true;
//			else
//				return false;
		}
	}
	
	public HashMap<String, Object> getMemberInfo(String id){
		return mDao.selectOne(id);
	}
	
	public void memberUpdate(HashMap<String, Object> params) {
		if(params.get("pwd").equals(params.get("pwd_CHECK"))) {
			mDao.updateMember(params);
		}
	}
}
