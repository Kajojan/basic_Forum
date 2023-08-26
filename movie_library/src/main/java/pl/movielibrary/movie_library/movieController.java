package pl.movielibrary.movie_library;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class movieController {
    @GetMapping("/test")
    public int test(){
        return 1;
    }
}
