package pl.kjanus.MoviesAppSQL;

import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@AllArgsConstructor
public class RemoveMovieByTitleCommand implements SqlCommand<Boolean> {
    private final Connection connection;
    private final String title;

    @Override
    public Boolean execute() {
        try (Statement statement = connection.createStatement()) {
            statement.execute(String.format("DELETE FROM Movies WHERE Title='%s'", title));
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
