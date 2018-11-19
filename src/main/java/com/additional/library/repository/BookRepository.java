package com.additional.library.repository;

import com.additional.library.domain.Book;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    Book findById(Long id);

    @Override
    Book save(Book book);
}
