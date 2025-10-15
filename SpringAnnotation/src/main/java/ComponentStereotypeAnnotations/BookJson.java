package ComponentStereotypeAnnotations;

public class BookJson {
	public BookJson() {
		super();
	}
	private int bookid;
	private String bookname;
	private String bookdesc;
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getBookdesc() {
		return bookdesc;
	}
	public void setBookdesc(String bookdesc) {
		this.bookdesc = bookdesc;
	}
	public BookJson(int bookid, String bookname, String bookdesc) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.bookdesc = bookdesc;
	}
}
