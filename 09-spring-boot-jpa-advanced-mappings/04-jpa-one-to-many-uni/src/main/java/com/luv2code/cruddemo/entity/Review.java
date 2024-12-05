package com.luv2code.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="review")
public class Review {

    // define fields

    // define constructors

    // define getters/setters

    // define toString()

    // annotate the fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="comment")
    private String commnet;

    public Review()
    {

    }

     public Review(String commnet)
     {
         this.commnet = commnet;
     }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommnet() {
        return commnet;
    }

    public void setCommnet(String commnet) {
        this.commnet = commnet;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", commnet='" + commnet + '\'' +
                '}';
    }
}
