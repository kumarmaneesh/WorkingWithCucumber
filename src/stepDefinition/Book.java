package stepDefinition;

import java.util.Date;

public class Book {

	private final String title;
	private final String author;
	private final Date published;
	
	public Book(String title, String author, Date published) {
		this.title = title;
		this.author = author;
		this.published = published;
		// TODO Auto-generated constructor stub
	}
	
	public Date getPublished() {
		// TODO Auto-generated method stub
		return published;
	}
	public String getTitle() {
		// TODO Auto-generated method stub
		return title;
	}

	public String getAuthor() {
		return author;
	}
 
	// constructors, getter, setter ommitted
}