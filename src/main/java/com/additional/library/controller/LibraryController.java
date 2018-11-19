package com.additional.library.controller;

import com.additional.library.domain.ExemplarStatus;
import com.additional.library.domain.dto.BookDto;
import com.additional.library.domain.dto.ExemplarDto;
import com.additional.library.domain.dto.ReaderDto;
import com.additional.library.domain.dto.RentDto;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/library")
public class LibraryController {

    @RequestMapping(method = RequestMethod.POST, value = "/readers", consumes = APPLICATION_JSON_VALUE)
    public Long addReader(@RequestBody ReaderDto readerDto) {
        return new ReaderDto().getId();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/books", consumes = APPLICATION_JSON_VALUE)
    public Long addBook(@RequestBody BookDto bookDto) {
        return new BookDto().getId();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/exemplars", consumes = APPLICATION_JSON_VALUE)
    public Long addExemplar(@RequestBody ExemplarDto exemplarDto) {
        return new ExemplarDto().getId();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/exemplars", consumes = APPLICATION_JSON_VALUE)
    public boolean changeExemplarStatus(@RequestParam Long exemplarId, ExemplarStatus status) {
        return true;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/exemplars")
    public int checkAvailableExemplarsQty(@RequestParam String title) {
        return 0;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/rents")
    public boolean borrowBook(@RequestParam Long exemplarId, @RequestParam Long readerId) {
        return true;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/rents")
    public boolean returnBook(@RequestParam Long exemplarId, @RequestParam Long readerId) {
        return true;
    }
}