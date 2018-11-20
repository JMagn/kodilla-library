package com.additional.library.mapper;

import com.additional.library.domain.Book;
import com.additional.library.domain.dto.BookDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {

    public Book mapToBook(final BookDto bookDto) {
        if (bookDto == null) {
            return null;
        }
        return new Book(
                bookDto.getTitle(),
                bookDto.getAuthor(),
                bookDto.getPublicationYear());
    }
}
