package com.additional.library.domain.dto;

import com.additional.library.domain.ExemplarStatus;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ExemplarDto {

    private Long id;
    private ExemplarStatus status;
    private Long bookId;
}
