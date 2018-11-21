package com.additional.library.service;

import com.additional.library.domain.*;
import com.additional.library.domain.dto.BookDto;
import com.additional.library.domain.dto.ExemplarDto;
import com.additional.library.domain.dto.ReaderDto;
import com.additional.library.mapper.BookMapper;
import com.additional.library.mapper.ExemplarMapper;
import com.additional.library.mapper.ReaderMapper;
import com.additional.library.repository.BookRepository;
import com.additional.library.repository.ExemplarRepository;
import com.additional.library.repository.ReaderRepository;
import com.additional.library.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
public class LibraryService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    ExemplarRepository exemplarRepository;
    @Autowired
    ReaderRepository readerRepository;
    @Autowired
    RentRepository rentRepository;
    @Autowired
    BookMapper bookMapper;
    @Autowired
    ExemplarMapper exemplarMapper;
    @Autowired
    ReaderMapper readerMapper;

    public Long saveBook(final BookDto bookDto) {
        Book book = bookMapper.mapToBook(bookDto);
        if (book == null) {
            return null;
        }
        return bookRepository.save(book).getId();
    }

    public Long saveReader(final ReaderDto readerDto) {
        Reader reader = readerMapper.mapToReader(readerDto);
        if (reader == null) {
            return null;
        }
        return readerRepository.save(reader).getId();
    }

    public Long saveExemplar(final ExemplarDto exemplarDto) {
        Exemplar exemplar = exemplarMapper.mapToExemplar(exemplarDto);
        if (exemplar == null) {
            return null;
        }
        return exemplarRepository.save(exemplar).getId();
    }

    public boolean changeStatus(Long exemplarId, ExemplarStatus newStatus) {
        Exemplar exemplar = exemplarRepository.findById(exemplarId);
        if (exemplar == null) {
            return false;
        }
        exemplar.setStatus(newStatus);
        return true;
    }

    public int checkQtyByTitle(String title) {
        if(title == null) {
            return 0;
        }
        return exemplarRepository.countAvailableByBookTitle(title);
    }

    public boolean borrowBook(Long readerId, Long exemplarId) {
        Exemplar exemplar = exemplarRepository.findById(exemplarId);
        if (readerId == null || exemplar == null) {
            return false;
        } else if (exemplar.getStatus().equals(ExemplarStatus.AVAILABLE)) {
            rentRepository.save(new Rent(readerRepository.findById(readerId), exemplar));
            exemplar.setStatus(ExemplarStatus.BORROWED);
            return true;
        }
        return false;
    }

    public boolean returnBook(Long readerId, Long exemplarId) {
        Rent rent = rentRepository.findByReaderIdAndExemplarId(readerId, exemplarId);
        if (rent == null) {
            return false;
        }
        rent.getExemplar().setStatus(ExemplarStatus.AVAILABLE);
        rent.setReturnDate(LocalDate.now());
        return true;
    }
}
