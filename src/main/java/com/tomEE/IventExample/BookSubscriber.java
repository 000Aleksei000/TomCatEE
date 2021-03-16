package com.tomEE.IventExample;

import jakarta.enterprise.event.Observes;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class BookSubscriber {
    public List<Book> list = new ArrayList<>();

    public void add(@Observes @Add Book book) {
        System.out.println(book.getName() + " added to list.");
        list.add(book);
    }

    public void delete(@Observes @Remove Book book){
        System.out.println(book.getName() + " delete from list");
        list.remove(book);
    }
}
