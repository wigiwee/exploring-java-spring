package com.jdbc.springjdbc.dao.impl;

import com.jdbc.springjdbc.dao.Model.Product;
import com.jdbc.springjdbc.dao.Model.ProductWithCategory;
import com.jdbc.springjdbc.dao.ProductDao;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    private JdbcTemplate jdbcTemplate;

    //by default constructor injection will be used
    public ProductDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

        String query = "CREATE TABLE IF NOT EXISTS products(" +
                "id int primary key, " +
                "title varchar(255) not null, " +
                "description varchar(500) not null, " +
                "price int not null, " +
                "cat_id int, "+
                "foreign key (cat_id) references categories(id)) ";
        jdbcTemplate.update(query);
    }

    @Override
    public List<Product> getAll() {
        String query = "SELECT * FROM products";
        //implicitly passes RowMapper class
//        List<Product> products = jdbcTemplate.queryForList(query, Product.class);
//        return products;

        //using anonymous class
        //explicitly defining RowMapper class
//        List<Product> products = jdbcTemplate.query(query, new RowMapper<Product>() {
//            @Override
//            public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Product product = new Product();
//                product.setId( rs.getInt("id") );
//                product.setTitle(rs.getString("title"));
//                product.setDescription(rs.getString("description"));
//                product.setPrice(rs.getInt("price"));
//                return product;
//
//            }
//        });

        List<Product> products = jdbcTemplate.query(query, (rs, rowNum) ->{
            Product product = new Product();
            product.setId( rs.getInt("id") );
            product.setTitle(rs.getString("title"));
            product.setDescription(rs.getString("description"));
            product.setPrice(rs.getInt("price"));
            return product;
        });

        return products;
    }

    @Override
    public Product getById(int id) {
        String query = "SELECT * FROM products WHERE id = ?";
        return jdbcTemplate.queryForObject(query, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setTitle(rs.getString("title"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getInt("price"));
                return product;
            }
        }, id);
    }

    @Override
    public Product create(Product product) {
        String query = "insert into products(id, title, description, price, cat_id) values(?,?,?,?,?)";
        int result =jdbcTemplate.update(
                query,
                product.getId(),
                product.getTitle(),
                product.getDescription(),
                product.getPrice(),
                product.getCat_id()
        );
        System.out.println(result + "rows affected");
        return product;
    }

    @Override
    public Product update(int productId, Product product) {
        String query = "update products set title = ?, description = ?, price = ? where id = ?";
        int result =jdbcTemplate.update(query, product.getTitle(), product.getDescription(), product.getPrice(), productId);
        System.out.println(result + "rows affected");
        product.setId(productId);
        return product;
    }

    @Override
    public Product delete(int id) {
        String query = "delete from products where id = ?";
        int result =jdbcTemplate.update(query, id);
        System.out.println(result + "rows affected");
        return null;
    }

    @Override
    public List<Product> search(String keyword) {
        return List.of();
    }

    @Override
    public List<ProductWithCategory> getAllProductWithCategory() {
        String query = "select p.id as id, " +
                "p.title as title, " +
                "p.description as description, " +
                "p.price as price, " +
                "c.title as catTitle " +
                "from products as p inner join categories c on p.cat_id = c.id";
        return jdbcTemplate.query(query, new RowMapper<ProductWithCategory>() {

            @Override
            public ProductWithCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
                ProductWithCategory productWithCategory = new ProductWithCategory();
                productWithCategory.setId(rs.getInt("id"));
                productWithCategory.setTitle(rs.getString("title"));
                productWithCategory.setDescription(rs.getString("description"));
                productWithCategory.setPrice(rs.getInt("price"));
                productWithCategory.setCatTitle(rs.getString("catTitle"));
                return productWithCategory;
            }
        });
    }
}
