package com.additional.library.repository;

import com.additional.library.domain.Reader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface ReaderRepository extends CrudRepository<Reader, Long> {

    Reader findById(Long id);

    @Override
    Reader save(Reader reader);
}