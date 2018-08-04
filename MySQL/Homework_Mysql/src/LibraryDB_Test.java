
public class LibraryDB_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Library lb = new Library();
		LibraryDao dao = LibraryDao.getInstance();
		
		lb.setId(6);
		lb.setTitle("곱게 자란 자식");
		lb.setAuthor("이무기");
		dao.insertLibrary(lb);
		
		dao.deleteLibrary(6);
		
		for(Library l : dao.selectAll())
			System.out.println(l);	
	}

}
