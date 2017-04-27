package beans;
import java.sql.Date;
public class Book {


	private int number;
	private String name;
	private String author;
	private String group;
	private Date date;
	private int lendstatus;

	public Book(){}
	
	public Book(int number, String name, String author,String group,Date date,int lendstatus) {
		this.number = number;
		this.name = name;
		this.author = author;
		this.group = group;
		this.date = date;
		this.lendstatus = lendstatus;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getLendstatus() {
		return lendstatus;
	}
	public void setLendstatus(int lendstatus) {
		this.lendstatus = lendstatus;
	}



}
