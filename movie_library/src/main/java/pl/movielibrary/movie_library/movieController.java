package pl.movielibrary.movie_library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class movieController {
    @Autowired
    MovieRepository movieRepository;

    @GetMapping("/test")
    public int test(){
        return 1;
    }
    @GetMapping("")
    public List<Movie> getAll(){
        return movieRepository.getAll();
    }
    @GetMapping("/{id}")
    public Movie getById(@PathVariable("id") int id){
        return movieRepository.getById(id);
    }

    @PostMapping("")
    public int addMovie(@RequestBody  List<Movie> movies){
        return movieRepository.save(movies);
    }

    @PutMapping("/{id}")
    public int updateMovie(@PathVariable("id") int id, @RequestBody Movie updatedMovie){
        Movie movie = movieRepository.getById(id);
        if(movie != null){
            movie.setMovie_title(updatedMovie.getMovie_title());
            movie.setRating(updatedMovie.getRating());
            movieRepository.update(movie);
            return 1;
        }else {
            return -1;
        }
    }

}
