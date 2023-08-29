package pl.movielibrary.movie_library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Movie> getAll(){

        List<Movie> query = jdbcTemplate.query("SELECT id,movie_title,rating FROM movies",
                BeanPropertyRowMapper.newInstance(Movie.class));

        return query;

    }

    public Movie getById(int id){
        return jdbcTemplate.queryForObject("SELECT id,movie_title,rating from movies WHERE " + "id = ?" , BeanPropertyRowMapper.newInstance(Movie.class), id);
    }
}
