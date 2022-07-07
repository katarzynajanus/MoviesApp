package pl.kjanus.MoviesAppSQL;

import lombok.AllArgsConstructor;

import java.awt.print.Book;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor

public class SelectMovieByTitleCommand implements SqlCommand<List<Movie>> {
    private final Connection connection;
    private final String title;

    @Override
    public List<Movie> execute() {
        List<Movie> movies = new ArrayList<>();
        String query = "SELECT * FROM Movies WHERE Title LIKE ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, title);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String title = resultSet.getString("Title");
                String movieType = resultSet.getString("MovieType");
                movies.add(new Movie(id, title, movieType));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }
}
