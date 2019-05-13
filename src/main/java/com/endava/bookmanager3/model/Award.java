package com.endava.bookmanager3.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Clob;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "awards")
@Data
public class Award {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Column(length = 4000)
    private String description;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "awards")
    private Set<Book> books = new HashSet<>();
}
