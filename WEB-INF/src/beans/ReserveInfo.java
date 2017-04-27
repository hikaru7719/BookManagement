package beans;


public class ReserveInfo {
	private int number;
	private int book_number;
	private String user_id;
	private int reserve_status;
	public ReserveInfo(){}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getBook_number() {
		return book_number;
	}
	public void setBook_number(int book_number) {
		this.book_number = book_number;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getReserve_status() {
		return reserve_status;
	}
	public void setReserve_status(int reserve_status) {
		this.reserve_status = reserve_status;
	}

}
