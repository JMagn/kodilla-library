package com.additional.library.repository;

import com.additional.library.domain.Exemplar;
import com.additional.library.domain.ExemplarStatus;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ExemplarRepository extends CrudRepository<Exemplar, Long> {

    Exemplar findById(Long id);

    @Override
    Exemplar save(Exemplar exemplar);

    int countByBookTitleAndStatus(String title, ExemplarStatus status);
}