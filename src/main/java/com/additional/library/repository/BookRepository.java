package com.additional.library.repository;

import com.additional.library.domain.Book;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public interface BookRepository extends CrudRepository<Book, Long> {

    Optional<Book> findById(Long id);

    @Override
    Book save(Book book);
}
