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

    private int id;
    private ExemplarStatus status;
    private Book book;

    public Exemplar(ExemplarStatus status) {
        this.status = status;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getExemplarId() {
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
