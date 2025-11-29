package repository;

import helper.DBConnector;
import model.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    public int deleteById(Integer id) {
        try {
            Connection connection = DBConnector.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("DELETE FROM books WHERE BookId=" + id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public void getAll() {
       List<Book> books = new ArrayList<>();

       try {
           Connection connection = DBConnector.getConnection();
           Statement statement = connection.createStatement();
           ResultSet rs = statement.executeQuery("SELECT * FROM books");
           while(rs.next()) {
               Integer id = rs.getInt("BookId");
               String title = rs.getString("Title");
               String author = rs.getString("Author");
               Integer yearPublished = rs.getInt("YearPublished");
               String genre = rs.getString("Genre");

               Book book = new Book();
               book.setId(id);
               book.setTitle(title);
               book.setAuthor(author);
               book.setYearPublished(yearPublished);
               book.setGenre(genre);

               books.add(book);
           }
       } catch (Exception ex){
           ex.printStackTrace();
       }
    }



    public static void main(String[] args) throws Exception {
        Connection connection = DBConnector.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM books");
        while(rs.next()) {
            System.out.println(rs.getString("Title"));
        }
    }
}
