package pl.movielibrary.movie_library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> addMovie(@RequestBody  List<Movie> movies){
        movieRepository.save(movies);
        return new ResponseEntity<>("Movie added successfully", HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public  ResponseEntity<String> updateMovie(@PathVariable("id") int id, @RequestBody Movie updatedMovie){
        Movie movie = movieRepository.getById(id);
        if(movie != null){
            movie.setMovie_title(updatedMovie.getMovie_title());
            movie.setRating(updatedMovie.getRating());
            movieRepository.update(movie);
            return new ResponseEntity<>("Movie updated successfully", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Movie not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable("id") int id){
            movieRepository.delete(id);
            return new ResponseEntity<>("Movie deleted successfully", HttpStatus.OK);

    }

}
