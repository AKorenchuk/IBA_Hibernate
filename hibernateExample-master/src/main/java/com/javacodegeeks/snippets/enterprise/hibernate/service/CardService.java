package com.javacodegeeks.snippets.enterprise.hibernate.service;


import com.javacodegeeks.snippets.enterprise.hibernate.model.Book;
import com.javacodegeeks.snippets.enterprise.hibernate.model.Card;
import com.javacodegeeks.snippets.enterprise.hibernate.model.Client;
import com.javacodegeeks.snippets.enterprise.hibernate.service.helper.GenericService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CardService extends  GenericService<Card>{

    public CardService() {
        super("from Card",Card.class);
    }

    public List<Book> choiseOverdueBook() {
        List<Book> books = new ArrayList<Book>();
        BookService bookService = new BookService();
        Date currentDate = new Date();

        List<Card> cards = this.findAll();
        for (Card b : cards) {
            if( b.getDate() != null && currentDate.before(b.getDate())){
                books.add(bookService.findById(b.getBookId().toString()));
            }
        }
        return books;
    }

    public List<Book> choiseActiveBookByClientName(String clientName) {
        ClientService clientService = new ClientService();
        int clientId=-1;
        for (Client b : clientService.findAll()) {
            if(b.getName().equals(clientName)){
                clientId = b.getId();
                break;
            }
        }
        List<Book> books = new ArrayList<Book>();
        List<Card> cards = this.findAll();
        for (Card b : cards) {
            if( b.getClientId() == clientId){
                books.add(b.getBook());
            }
        }
        return books;
    }

}
