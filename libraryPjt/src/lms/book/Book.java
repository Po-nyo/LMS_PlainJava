package lms.book;

public class Book {
	
	private String name;
	private String publisher;
	private String location;
	private boolean available;
	
	
	public Book(String name, String publisher, String location) {
		this.name = name;
		this.publisher = publisher;
		this.location = location;
		this.available = true;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	
	

}

