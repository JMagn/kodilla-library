package com.additional.library.repository;

import com.additional.library.domain.Rent;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public interface RentRepository extends CrudRepository<Rent, Long> {

    Optional<Rent> findByReaderIdAndExemplarId(Long readerId, Long exemplarId);

    Rent save(Long exemplarId, Long readerId);
}
