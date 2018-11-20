package com.additional.library.repository;

import com.additional.library.domain.Exemplar;
import com.additional.library.domain.ExemplarStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public interface ExemplarRepository extends CrudRepository<Exemplar, Long> {

    Optional<Exemplar> findById(Long id);

    @Override
    Exemplar save(Exemplar exemplar);

    int countByBookTitleAndStatus(String title, ExemplarStatus status);
}