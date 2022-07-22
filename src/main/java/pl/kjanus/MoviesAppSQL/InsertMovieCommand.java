package pl.kjanus.MoviesAppSQL;

import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@AllArgsConstructor
public class InsertMovieCommand implements SqlCommand<Boolean> {
    private final Connection connection;
    private final Movie movie;


    public Boolean execute() {
        String query = "INSERT INTO Movies(Title,MovieType)VALUES(?,?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, movie.getTitle());
            statement.setString(2, movie.getMovieType());
            statement.execute();
            System.out.println("Movie added!");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
