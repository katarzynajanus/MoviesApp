package pl.kjanus.MoviesAppSQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateMovieTableCommand {
    private final Connection connection;

    public CreateMovieTableCommand(Connection connection) {
        this.connection = connection;
    }

    public Boolean execute() {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE Movies(Id INTEGER PRIMARY KEY AUTO_INCREMENT," +
                    "Title Varchar(100) NOT NULL, MovieType VARCHAR(20) NOT NULL )");
            System.out.println("Movie table created!");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
