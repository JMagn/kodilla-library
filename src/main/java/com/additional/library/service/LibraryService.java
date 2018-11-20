package com.additional.library.service;

import com.additional.library.domain.*;
import com.additional.library.repository.BookRepository;
import com.additional.library.repository.ExemplarRepository;
import com.additional.library.repository.ReaderRepository;
import com.additional.library.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Long saveBook(final Book book) {
        return bookRepository.save(book).getId();
    }

    public Long saveReader(final Reader reader) {
        return readerRepository.save(reader).getId();
    }

    public Long saveExemplar(final Exemplar exemplar) {
        return exemplarRepository.save(exemplar).getId();
    }

    public boolean changeStatus(Long exemplarId, ExemplarStatus newStatus) {
        Exemplar exemplar = exemplarRepository.findById(exemplarId);
        if (exemplar == null) {
            return false;
        }
        exemplar.setStatus(newStatus);
        return false;
    }

    public int checkQtyByTitle(String title) {
        if(title == null) {
            return 0;
        }
        return exemplarRepository.countByBookTitleAndStatus(title, ExemplarStatus.AVAILABLE);
    }

    public boolean borrowBook(Long readerId, Long exemplarId) {
        Exemplar exemplar = exemplarRepository.findById(exemplarId);
        if (readerId == null || exemplar == null) {
            return false;
        } else if (exemplar.getStatus().equals(ExemplarStatus.AVAILABLE)) {
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
        return true;
    }
}
