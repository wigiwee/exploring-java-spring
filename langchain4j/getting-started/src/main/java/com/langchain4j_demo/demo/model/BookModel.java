package com.langchain4j_demo.demo.model;

import java.time.LocalDate;

import dev.langchain4j.model.output.structured.Description;
import lombok.Data;

@Data
public class BookModel {

    private Integer id;

    private String title;

    private String author;

    @Description("Should be less than 20 words")
    private String description;

    private String genre;

    private LocalDate dateOfPublication;
}
