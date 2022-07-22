package pl.kjanus.MoviesAppSQL;

import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@AllArgsConstructor
public class UpdateMovieCommand implements SqlCommand<Boolean> {

    private final Connection connection;
    private final Movie movie;

    @Override
    public Boolean execute() {
        String query = "UPDATE Movies SET Title=?, MovieType=? WHERE Id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setString(2, movie.getMovieType());
            preparedStatement.setInt(3, movie.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
