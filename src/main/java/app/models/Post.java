package app.models;

import java.sql.Date;

public class Post {
    private int id;
    private String text;
    private String author;
    private Date date;

    public Post(String text, String author, Date date) {
        this.text = text;
        this.author = author;
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    public Post(int id, String text, String author, Date date) {
        this.id = id;
        this.text = text;
        this.author = author;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
}
