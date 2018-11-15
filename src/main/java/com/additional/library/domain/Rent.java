package com.additional.library.domain;

import lombok.EqualsAndHashCode;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "RENTS")
@EqualsAndHashCode
@Setter
public class Rent {

    private int rentId;
    private LocalDate rentDate;
    private LocalDate returnDate;
    private Reader reader;
    private Exemplar exemplar;

    public Rent() {
        this.rentDate = LocalDate.now();
        this.returnDate = rentDate.plusDays(28);
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "RENT_ID", unique = true)
    public int getRentId() {
        return rentId;
    }

    @Column(name = "RENT_DATE")
    public LocalDate getRentDate() {
        return rentDate;
    }

    @Column(name = "RETURN_DATE")
    public LocalDate getReturnDate() {
        return returnDate;
    }

    @ManyToOne
    @JoinColumn(name = "READER_ID")
    public Reader getReader() {
        return reader;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EXEMPLAR_ID")
    public Exemplar getExemplar() {
        return exemplar;
    }
}
