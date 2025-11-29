package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Book;
import repository.BookRepository;

import java.io.IOException;
import java.util.List;

@WebServlet(value = {"/book", "/book/view"}) // Giữ nguyên
public class ViewBookServlet extends HttpServlet {
    private final BookRepository repository = new BookRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = repository.getAll();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/WEB-INF/views/view-books.jsp").forward(req, resp);
    }
}
