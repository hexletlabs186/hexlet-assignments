package exercise.service;

import exercise.dto.*;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.AuthorMapper;
import exercise.mapper.AuthorMapper;
import exercise.repository.AuthorRepository;
import exercise.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    // BEGIN
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private AuthorMapper authorMapper;

    public List<AuthorDTO> getAll() {
        var authors = authorRepository.findAll();

        return authors.stream()
                .map(p -> authorMapper.map(p))
                .toList();
    }

    public AuthorDTO getById(long id) {
        var author =  authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author with id " + id + " not found"));

        return authorMapper.map(author);
    }


    public AuthorDTO create(AuthorCreateDTO authorData) {
        var author = authorMapper.create(authorData);
        return authorMapper.map(authorRepository.save(author));
    }

    public AuthorDTO update(long id, AuthorUpdateDTO authorData) {
        var author =  authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author with id " + id + " not found"));

        authorMapper.update(authorData, author);

        return authorMapper.map(authorRepository.save(author));
    }


    public void delete(long id) {
        var author =  authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author with id " + id + " not found"));
        authorRepository.deleteById(id);
    }    
    // END
}
