package com.additional.library.domain;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "READERS")
@EqualsAndHashCode
@NoArgsConstructor
@Setter
public class Reader {

    private Long id;
    private String name;
    private String lastName;
    private LocalDate accountCreationDate;
    private List<Rent> rents;

    public Reader(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        this.accountCreationDate = LocalDate.now();
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    @Column(name = "ACCOUNT_CREATION_DATE")
    public LocalDate getAccountCreationDate() {
        return accountCreationDate;
    }

    @OneToMany(
            targetEntity = Rent.class,
            mappedBy = "reader",
            fetch = FetchType.LAZY
    )
    public List<Rent> getRents() {
        return rents;
    }
}
