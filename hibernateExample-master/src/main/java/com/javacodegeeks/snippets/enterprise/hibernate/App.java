package com.javacodegeeks.snippets.enterprise.hibernate;

import com.javacodegeeks.snippets.enterprise.hibernate.model.Book;
import com.javacodegeeks.snippets.enterprise.hibernate.model.Client;
import com.javacodegeeks.snippets.enterprise.hibernate.service.BookService;
import com.javacodegeeks.snippets.enterprise.hibernate.service.CardService;
import com.javacodegeeks.snippets.enterprise.hibernate.service.ClientService;

import java.util.List;

public class App {

	public static void main(String[] args) {
		ClientService clientService = new ClientService();
		CardService cardService = new CardService();
		Client cl = new Client(" Elon Musk",46);
		//clientService.persist(cl);
		//System.out.println("Client by id - 1  :" + clientService.findById("1"));
		//clientService.delete("17");

		List<Client> clients = clientService.findAll();
		System.out.println("Clients Persisted are :");
		for (Client b : clients) {
			System.out.println("-" + b.toString());
		}


//		List<Card> cards = cardService.findAll();
//		System.out.println("Cards Persisted are :");
//		for (Card b : cards) {
//			System.out.println("-" + b.toString());
//		}


		List<Book> overdueBooks = cardService.choiseOverdueBook();
		System.out.println("Overdue books :");
		for (Book b : overdueBooks) {
			System.out.println("-" + b.toString());
		}



		BookService bookService = new BookService();
		Book book = new Book(3, "The Brothers", "Fyodor");
		// bookService.persist(book1);
		List<Book> books = bookService.findAll();
		System.out.println("Books Persisted are :");
		for (Book b : books) {
			System.out.println("-" + b.toString());
		}
		System.exit(0);
	}
}
