package com.additional.library.domain;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "RENTS")
@EqualsAndHashCode
@NoArgsConstructor
@Setter
public class Rent {

    private Long id;
    private LocalDate rentDate;
    private LocalDate returnDate;
    private Reader reader;
    private Exemplar exemplar;

    public Rent(Reader reader, Exemplar exemplar) {
        this.rentDate = LocalDate.now();
        this.reader = reader;
        this.exemplar = exemplar;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
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

    @ManyToOne
    @JoinColumn(name = "EXEMPLAR_ID")
    public Exemplar getExemplar() {
        return exemplar;
    }
}
