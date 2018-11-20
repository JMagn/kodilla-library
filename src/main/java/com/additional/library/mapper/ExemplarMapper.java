package com.additional.library.mapper;

import com.additional.library.domain.Book;
import com.additional.library.domain.Exemplar;
import com.additional.library.domain.dto.ExemplarDto;
import com.additional.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ExemplarMapper {

    @Autowired
    BookRepository bookRepository;

    public Exemplar mapToExemplar(final ExemplarDto exemplarDto) {
        if (exemplarDto == null) {
            return null;
        }
        return new Exemplar(exemplarDto.getStatus(), bookRepository.findById(exemplarDto.getBookId()));
    }
}
