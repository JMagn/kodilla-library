package com.additional.library.domain;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "EXEMPLARS")
@EqualsAndHashCode
@NoArgsConstructor
@Setter
public class Exemplar {

    private Long id;
    private ExemplarStatus status;
    private Book book;

    public Exemplar(ExemplarStatus status, Book book) {
        this.status = status;
        this.book = book;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }

    @Column(name = "STATUS")
    public ExemplarStatus getStatus() {
        return status;
    }

    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    public Book getBook() {
        return book;
    }
}
