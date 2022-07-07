package pl.kjanus.MoviesAppSQL;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Movie {
    private int id;
    private String title;
    private String movieType;

    @Override
    public String toString() {
        return "Movie:" +
                "id:" + id +
                ", title:'" + title + '\'' +
                ", movieType:'" + movieType;
    }
}


