package exercise.service;

import exercise.dto.BookCreateDTO;
import exercise.dto.BookDTO;
import exercise.dto.BookUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.BookMapper;
import exercise.repository.AuthorRepository;
import exercise.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    // BEGIN
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookMapper bookMapper;

    public List<BookDTO> getAll() {
        var books = bookRepository.findAll();

        return books.stream()
                .map(p -> bookMapper.map(p))
                .toList();
    }


    public BookDTO getById(long id) {
        var book =  bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book with id " + id + " not found"));

        return bookMapper.map(book);
    }


    public BookDTO create(BookCreateDTO bookData) {
        var book = bookMapper.create(bookData);
        return bookMapper.map(bookRepository.save(book));
    }

    public BookDTO update(long id, BookUpdateDTO bookData) {
        var book =  bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book with id " + id + " not found"));

        var newAuthorId =  bookData.getAuthorId().get();
        if (book.getAuthor().getId() != newAuthorId) {
            book.setAuthor(authorRepository.findById(newAuthorId)
                    .orElseThrow(() -> new ResourceNotFoundException("Author with id " + newAuthorId + " not found"))
            );
        }

        bookMapper.update(bookData, book);

        return bookMapper.map(bookRepository.save(book));
    }


    public void delete(long id) {
        var book =  bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book with id " + id + " not found"));
        bookRepository.deleteById(id);
    }
    
    // END
}
