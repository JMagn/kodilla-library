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
public class ReaderDto {

    private Long id;
    private String name;
    private String lastName;
    private LocalDate accountCreationDate;
}
