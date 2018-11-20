package com.additional.library.controller;

import com.additional.library.domain.ExemplarStatus;
import com.additional.library.domain.dto.BookDto;
import com.additional.library.domain.dto.ExemplarDto;
import com.additional.library.domain.dto.ReaderDto;
import com.additional.library.domain.dto.RentDto;
import com.additional.library.mapper.BookMapper;
import com.additional.library.mapper.ExemplarMapper;
import com.additional.library.mapper.ReaderMapper;
import com.additional.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/library")
public class LibraryController {

    @Autowired
    LibraryService libraryService;
    @Autowired
    BookMapper bookMapper;
    @Autowired
    ExemplarMapper exemplarMapper;
    @Autowired
    ReaderMapper readerMapper;

    @RequestMapping(method = RequestMethod.POST, value = "/readers", consumes = APPLICATION_JSON_VALUE)
    public Long addReader(@RequestBody ReaderDto readerDto) {
        return libraryService.saveReader(readerMapper.mapToReader(readerDto));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/books", consumes = APPLICATION_JSON_VALUE)
    public Long addBook(@RequestBody BookDto bookDto) {
        return libraryService.saveBook(bookMapper.mapToBook(bookDto));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/exemplars", consumes = APPLICATION_JSON_VALUE)
    public Long addExemplar(@RequestBody ExemplarDto exemplarDto) {
        return libraryService.saveExemplar(exemplarMapper.mapToExemplar(exemplarDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/exemplars", consumes = APPLICATION_JSON_VALUE)
    public boolean changeExemplarStatus(@RequestParam Long exemplarId, @RequestParam ExemplarStatus newStatus) {
        return libraryService.changeStatus(exemplarId, newStatus);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/exemplars")
    public int checkAvailableExemplarsQty(@RequestParam String title) {
        return libraryService.checkQtyByTitle(title);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/rents")
    public boolean borrowBook(@RequestParam Long readerId, @RequestParam Long exemplarId) {
        return libraryService.borrowBook(readerId, exemplarId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/rents")
    public boolean returnBook(@RequestParam Long readerId, @RequestParam Long exemplarId) {
        return libraryService.returnBook(readerId, exemplarId);
    }
}