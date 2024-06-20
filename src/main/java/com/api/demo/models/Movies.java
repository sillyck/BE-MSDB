package com.api.demo.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "movies")
public class Movies {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Getter
    private String title;

    @Getter
    private String director;

    @Getter
    private String genre;

    @Getter
    private Date release_date;

    @Getter
    private int duration;

    @Getter
    private String synopsis;

    @Getter
    private float valoration;
}
