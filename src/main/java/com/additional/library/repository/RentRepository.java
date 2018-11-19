package com.additional.library.repository;

import com.additional.library.domain.Rent;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface RentRepository extends CrudRepository<Rent, Long> {

    Rent findByReaderIdAndExemplarId(Long readerId, Long exemplarId);

    Rent save (Long exemplarId, Long readerId);
}
