package com.example.librarymanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

   
    public Book addBook(Book book) {
        return repository.save(book);
    }

    
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Book getBookById(int id) {
        return repository.findById(id).orElse(null);
    }

  
    public boolean deleteBook(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    
    public boolean updateAvailability(int id, boolean available) {
        Book book = getBookById(id);
        if (book != null) {
            book.setAvailable(available); 
            repository.save(book);
            return true;
        } else {
            return false;
        }
    }
}