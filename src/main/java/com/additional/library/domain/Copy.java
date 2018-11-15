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
public class Copy {

    private int copyId;
    private CopyStatus status;
    private Book book;

    public Copy(CopyStatus status) {
        this.status = status;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "COPY_ID", unique = true)
    public int getCopyId() {
        return copyId;
    }

    @Column(name = "STATUS")
    public CopyStatus getStatus() {
        return status;
    }

    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    public Book getBook() {
        return book;
    }
}
