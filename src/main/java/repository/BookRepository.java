package repository;

import helper.DBConnector;
import model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    public int deleteById(Integer id) {
        String sql = "DELETE FROM books WHERE BookId = ?";
        try (Connection connection = DBConnector.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate(); // Trả về số dòng bị xóa

        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public List<Book> getAll() { // Đổi void thành List<Book>
        List<Book> books = new ArrayList<>();

        try (Connection connection = DBConnector.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM books")) {

            while(rs.next()) {
                Integer id = rs.getInt("BookId");
                String title = rs.getString("Title");
                String author = rs.getString("Author");
                Integer yearPublished = rs.getInt("YearPublished");
                String genre = rs.getString("Genre");

                // Sử dụng constructor có sẵn
                Book book = new Book(id, title, author, yearPublished, genre);
                books.add(book);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }

        return books; // Trả về danh sách
    }
}
