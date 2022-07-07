package pl.kjanus.MoviesAppSQL;

import org.apache.catalina.Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        try {
            //uruchomienie serwera baz danych H2
            Server server = Server.createWebServer();
            server.start();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //połączenie z bazą danych
        try (Connection connection = connect()) {
            System.out.println("Connection established!");
            new CreateMovieTableCommand(connection).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection connect() throws SQLException {
        return DriverManager.getConnection("",
                "kjanus", "");
    }
}

