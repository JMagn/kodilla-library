package com.additional.library.domain;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "BOOKS")
@EqualsAndHashCode
@NoArgsConstructor
@Setter
public class Book {

    private Long id;
    private String title;
    private String author;
    private int publicationYear;
    private List<Exemplar> exemplars;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }

    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    @Column(name = "AUTHOR")
    public String getAuthor() {
        return author;
    }

    @Column(name = "PUBLICATION_YEAR")
    public int getPublicationYear() {
        return publicationYear;
    }

    @OneToMany(
            targetEntity = Exemplar.class,
            mappedBy = "book",
            fetch = FetchType.LAZY
    )
    public List<Exemplar> getExemplars() {
        return exemplars;
    }
}
