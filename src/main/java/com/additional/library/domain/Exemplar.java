package com.additional.library.domain;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "EXEMPLARS")
@EqualsAndHashCode
@NoArgsConstructor
@Setter
public class Exemplar {

    private Long id;
    private ExemplarStatus status;
    private Book book;
    private List<Rent> rents;

    public Exemplar(Book book) {
        this.status = ExemplarStatus.AVAILABLE;
        this.book = book;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
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

    @OneToMany(
            targetEntity = Rent.class,
            mappedBy = "exemplar",
            fetch = FetchType.LAZY
    )
    public List<Rent> getRents() {
        return rents;
    }
}
