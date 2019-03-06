package app.database;

import app.models.Post;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class PostDao {
    private final Connection connection;

    public PostDao(String url, String username, String password) {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("cannot connect to db: check url usename password!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("cannot find postgresql driver");
        }
    }

    private Function<ResultSet, Post> mapper = (resultSet) -> {
        try {
            return new Post(
                    resultSet.getInt("id"),
                    resultSet.getString("text"),
                    resultSet.getString("author"),
                    resultSet.getDate("date")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    };

    // language=SQL
    private String SQL_GET_ALL_QUERY = "SELECT * FROM posts order by date asc";

    //language=SQL
    private String SQL_CREATE_QUERY = "insert into posts(text, author) values (?, ?)";

    public List<Post> getAllPosts() {
        List<Post> posts = new LinkedList<>();
        try {
            ResultSet resultSet = connection.prepareStatement(SQL_GET_ALL_QUERY).executeQuery();
            while (resultSet.next()) {
                Post post = mapper.apply(resultSet);
                posts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

    public void createPost(String text, String author) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_CREATE_QUERY);
            statement.setString(1, text);
            statement.setString(2, author);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
