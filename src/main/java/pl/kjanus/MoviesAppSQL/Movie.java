package pl.kjanus.MoviesAppSQL;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class Movie {
    private int id;
    private String title;
    private String movieType;

    public Movie(String title, String movieType) {
        this.title = title;
        this.movieType = movieType;
    }

    public Movie(int id, String title, String movieType) {
        this.id = id;
        this.title = title;
        this.movieType = movieType;
    }

    @Override
    public String toString() {
        return "Movie:" +
                "id:" + id +
                ", title:'" + title + '\'' +
                ", movieType:'" + movieType;
    }
}


