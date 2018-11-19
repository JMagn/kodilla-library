package com.additional.library.repository;

import com.additional.library.domain.Reader;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ReaderRepository extends CrudRepository<Reader, Long> {

    @Override
    Reader save(Reader reader);
}