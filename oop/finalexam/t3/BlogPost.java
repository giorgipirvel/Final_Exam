package oop.finalexam.t3;

public class BlogPost {
    private int id;
    private String title;
    private String content;
    private String author;

    public BlogPost() {}

    public BlogPost(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format("ID: %d\nTitle: %s\nAuthor: %s\nContent: %s\n",
                id, title, author, content);
    }
}
