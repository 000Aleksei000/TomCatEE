package com.tomEE.IventExample;

import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;

public class ServiceBook {
    @Inject
            @Add
    Event<Book> event;
    @Inject
            @Remove
    Event<Book> removeEvent;

    public void addBook(Book book) {
        System.out.println(book.getName() + " book was added!");
        event.fire(book);
    }

    public void removeBook(Book book) {
        System.out.println(book.getName() + " book was deleted!");
        removeEvent.fire(book);
    }
}
