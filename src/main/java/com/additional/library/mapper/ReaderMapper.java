package com.additional.library.mapper;

import com.additional.library.domain.Reader;
import com.additional.library.domain.dto.ReaderDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReaderMapper {

    public Reader mapToReader(final ReaderDto readerDto) {
        if (readerDto == null) {
            return null;
        }
        return new Reader(
                readerDto.getName(),
                readerDto.getLastName(),
                readerDto.getAccountCreationDate());
    }
}
