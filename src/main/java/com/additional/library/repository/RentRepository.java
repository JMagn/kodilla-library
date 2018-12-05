package com.additional.library.repository;

import com.additional.library.domain.Rent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface RentRepository extends CrudRepository<Rent, Long> {

    Rent findByReaderIdAndExemplarId(Long readerId, Long exemplarId);

    @Override
    Rent save(Rent rent);
}
