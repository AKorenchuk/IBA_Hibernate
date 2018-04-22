package com.javacodegeeks.snippets.enterprise.hibernate.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "card", schema = "ibatestdb", catalog = "")
public class Card {
    @Id
    @Column(name = "id")
    private int id;


    @Column(name = "date")
    private Date date;

    @Column(name = "book_id", nullable = false, insertable = true, updatable = true)
    private Integer bookId;

    @Column(name = "client_id", nullable = false, insertable = true, updatable = true)
    private Integer clientId;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


    public Client getClient() {
        return client;
    }

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;


    public Book getBook() {
        return book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card that = (Card) o;

        if (id != that.id) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "Card: " + this.id + ", " + this.bookId + ", " + this.clientId + ", " + this.date ;
    }


    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }


}
