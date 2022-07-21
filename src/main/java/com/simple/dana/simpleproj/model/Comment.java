package com.simple.dana.simpleproj.model;

import javax.persistence.*;

@Entity
@Table(name="comments")//genereaza automat tabel
public class Comment {
    @Id
    ///SEQUENCE  -de vazut ce pot face aici pt ca incearca sa imi suprascrie la save id-ul
    //secventa cu initialvalue nu e o solutie
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "author")
    private String author;
    @Column(name = "comm_text")
    private String text;

//am renuntat la constructor

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
