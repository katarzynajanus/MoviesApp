package pl.kjanus.MoviesAppSQL;

import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@AllArgsConstructor
public class RemoveMovieByIdCommand implements SqlCommand<Boolean>{

    private final Connection connection;
    private final int id;

    @Override
    public Boolean execute() {
        try(Statement statement= connection.createStatement()){
            statement.execute(String.format("DELETE FROM Movies WHERE id=%d", id));
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
