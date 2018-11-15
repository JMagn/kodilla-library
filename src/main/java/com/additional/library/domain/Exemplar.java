package com.additional.library.domain;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "COPIES")
@EqualsAndHashCode
@NoArgsConstructor
@Setter
public class Exemplar {

    private int exemplarId;
    private ExemplarStatus status;
    private Book book;

    public Exemplar(ExemplarStatus status) {
        this.status = status;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "EXEMPLAR_ID", unique = true)
    public int getExemplarId() {
        return exemplarId;
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
