package com.blog.blog.models;

import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {
    @Id @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT")
    private String message;
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;




    public Post() {
    }

    public Post(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public Post(long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.message = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String description) {
        message = description;
    }
}
