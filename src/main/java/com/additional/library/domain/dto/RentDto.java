package com.additional.library.domain.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class RentDto {

    private int id;
    private LocalDate rentDate;
    private LocalDate returnDate;
    private int readerId;
    private int exemplarId;
}
