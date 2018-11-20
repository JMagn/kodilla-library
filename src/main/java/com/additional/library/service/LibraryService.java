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

    @Transactional
    public Long saveBook(final BookDto bookDto) {
        return bookRepository.save(bookMapper.mapToBook(bookDto)).getId();
    }

    @Transactional
    public Long saveReader(final ReaderDto readerDto) {
        return readerRepository.save(readerMapper.mapToReader(readerDto)).getId();
    }

    @Transactional
    public Long saveExemplar(final ExemplarDto exemplarDto) {
        return exemplarRepository.save(exemplarMapper.mapToExemplar(exemplarDto)).getId();
    }

    @Transactional
    public boolean changeStatus(Long exemplarId, ExemplarStatus newStatus) {
        Exemplar exemplar = exemplarRepository.findById(exemplarId);
        if (exemplar == null) {
            return false;
        }
        exemplar.setStatus(newStatus);
        return true;
    }

    @Transactional
    public int checkQtyByTitle(String title) {
        if(title == null) {
            return 0;
        }
        return exemplarRepository.countAvailableByBookTitle(title);
    }

    @Transactional
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

    @Transactional
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
