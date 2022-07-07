package pl.kjanus.MoviesAppSQL;

import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class SelectAllMoviesCommand implements SqlCommand<List<Movie>>{

    private final Connection connection;


    @Override
    public List<Movie> execute() {
        List<Movie> movies = new ArrayList<>();
        try(Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT  * FROM Moviesovies");
            int id = resultSet.getInt("Id");
            String title = resultSet.getString("Title");
            String movieType = resultSet.getString("MovieType");
            movies.add(new Movie(id, title, movieType));
        }catch (SQLException e){
            e.printStackTrace();
        }
        return movies;
    }
}
