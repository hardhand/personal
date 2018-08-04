package service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import dao.BoardDao;
import model.Board;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao bDao;

	@Override //글쓰기
	public int writeBoard(Board board, MultipartFile file) {
		// TODO Auto-generated method stub
		
		String path = "C:/BitCamp/image/"; //업로드한 파일 저장될 장소
		File dir = new File(path);
		if(!dir.exists())
			dir.mkdirs(); // 저 경로에 폴더 없으면 폴더 하나 만들어라. make directory
		String fileName = file.getOriginalFilename();
		File attachFile = new File(path + fileName);
		
		try {
			file.transferTo(attachFile);
			board.setFile(fileName);
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		bDao.insertBoard(board);
		return board.getNum();
	}

	@Override//게시물 수정
	public int modifyBoard(Board board) {
		// TODO Auto-generated method stub
		Board originBoard = bDao.selectOne(board.getNum());
		if (originBoard.getPass().equals(board.getPass()))
			return bDao.updateBoard(board);
		else
		return 0;
	}

	@Override //게시물 삭제
	public int deleteBoard(int num, String pass) {
		// TODO Auto-generated method stub
		return bDao.deleteBoard(num);
	}

	@Override
	public Board readBoard(int num) {
		// TODO Auto-generated method stub
		//게시물 정보를 조회, 조회수 +1 추가
		Board b = bDao.selectOne(num);
		b.setReadCount(b.getReadCount()+1);
		bDao.updateBoard(b);
		if(b.getContent()==null || b.getContent().equals(""))
			b.setContent("내용없음");
		if(b.getTitle()==null || b.getTitle().equals(""))
			b.setTitle("제목없음");
		return b;
	}
	

	@Override
	public HashMap<String, Object> getBoardListPage(HashMap<String, Object> params, int page)
	{
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("current", page);
		result.put("start", getStartPage(page));
		
		if(getEndPage(page)<=getLastPage(params)) {
			result.put("end", getEndPage(page));
		}else {
			int nextSkip = (page-1)/10 * 10;//앞에 몇개 있었는지
			result.put("end", getLastPage(params));
		}
		result.put("last", getLastPage(params));
		
		params.put("skip", getSkip(page));
		params.put("qty", 10);
		result.put("boardList", bDao.selectBoardPage(params));
		return result;
	}
	
	@Override
	public int getStartPage(int num) {
		// TODO Auto-generated method stub
		return (num - 1) / 10 * 10 + 1;
	}

	@Override
	public int getEndPage(int num) {
		// TODO Auto-generated method stub
		return (num / 10 + 1) * 10;
	}

	@Override
	public int getLastPage(HashMap<String, Object> params) {
		// TODO Auto-generated method stub
		return (bDao.getCount(params)- 1) / 10 + 1;
	}

	@Override
	public int getSkip(int page) {
		// TODO Auto-generated method stub
		return (page - 1) * 10;
	}

	@Override
	public Board getBoard(int num) {
		// TODO Auto-generated method stub
		return bDao.selectOne(num);
	}

	@Override
	public File getAttachFile(int num) {
		// TODO Auto-generated method stub
		Board b = bDao.selectOne(num);
		String fileName = b.getFile();
		String path = "C:/BitCamp/image/";
		return new File(path + fileName);
	}
	
	

}
