package jdbctest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcTemplate {

    public void executeUpdate(User user, String sql, PreparedStatementSetter pstmt) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionManager.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            pstmt.setter(preparedStatement);
            preparedStatement.executeUpdate();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (connection != null) {
                connection.close();
            }
        }
    }
}
