package pl.kjanus.MoviesAppSQL;

import org.apache.catalina.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class MoviesAppSqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesAppSqlApplication.class, args);
		/*try {
			//uruchomienie serwera baz danych H2
			Server server = Server.createWebServer();
			server.start();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		//połączenie z bazą danych
		try (Connection connection = connect()) {
			System.out.println("Connection established!");
			new CreateMovieTableCommand(connection).execute();
			new InsertMovieCommand(connection, new Movie("Harry Potter", "Fantasy")).execute();
			new InsertMovieCommand(connection, new Movie("Batman", "Comics")).execute();
			new InsertMovieCommand(connection, new Movie("Batman2", "Comics")).execute();
			new RemoveMovieByIdCommand(connection, 2).execute();
			new RemoveMovieByTitleCommand(connection, "Batman2").execute();
			new InsertMovieCommand(connection, new Movie("Władca Pierścieni", "Fantasy")).execute();
			new UpdateMovieCommand(connection, new Movie(4, "Lord of the Rings", "Fantasy")).execute();
			//List<Movie> books = new SelectAllMoviesCommand(connection).execute();
			//List<Movie> booksByTitle = new SelectMovieByTitleCommand(connection, "Harry Potter").execute();
			//System.out.println("Movies: "+ books);
			//System.out.println("Movies by title: " + booksByTitle);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static Connection connect() throws SQLException {
		return DriverManager.getConnection("jdbc:h2:mem:testdb",
				"kjanus", "");
	}

}
