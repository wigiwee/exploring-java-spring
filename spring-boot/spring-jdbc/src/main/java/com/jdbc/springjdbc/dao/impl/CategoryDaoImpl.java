package com.jdbc.springjdbc.dao.impl;

import com.jdbc.springjdbc.dao.CategoryDao;
import com.jdbc.springjdbc.dao.Model.Category;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDaoImpl implements CategoryDao {

    private JdbcTemplate jdbcTemplate;

    public CategoryDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;


        String query = "CREATE TABLE IF NOT EXISTS categories(" +
                "id int primary key, " +
                "title varchar(255) not null, " +
                "description varchar(255) not null)";
        jdbcTemplate.update(query);
        System.out.println("Category table is created");
    }


    @Override
    public Category createCategory(Category category) {
        String query = "INSERT INTO categories (id, title, description) VALUES (?, ?, ?)";
        int result = jdbcTemplate.update(query, category.getId(), category.getName(), category.getDescription());
        System.out.println(result + " rows affected");

        return category;
    }
}
