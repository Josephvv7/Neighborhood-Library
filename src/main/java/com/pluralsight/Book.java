package com.pluralsight;

//Book class attributes
public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

//Constructor
    public Book(int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }
// Getter and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public boolean isCheckedOut() {
        return isCheckedOut;
    }
    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }
    public String getCheckedOutTo() {
        return checkedOutTo;
    }
    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }
    //Check out method
    public void checkOut(String name) {
        this.checkedOutTo = name;
        this.isCheckedOut = true;
    }
    //Check in method
    public void checkIn(){
        this.checkedOutTo = "";
        this.isCheckedOut = false;
    }
    //This Displays book information
    @Override
    public String toString() {
        String status = isCheckedOut() ? "Checked out to: " + getCheckedOutTo() : "Available";
        return "Book ID: " + id + " | ISBN: " + isbn + " | Title: " + title + " | Status: " + status;
    }
}
