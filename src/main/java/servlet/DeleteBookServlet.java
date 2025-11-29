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

@WebServlet(value = {"/book", "/book/view"})
public class DeleteBookServlet extends HttpServlet {
    private final BookRepository repository = new BookRepository();

    @Override
    protected void doGet(HttpServletRequest req; HttpServletResponse resp) throws ServletException, IOException{
        String idStr = req.getParameter("id");
        Integer id = Integer.valueOf(idStr);
        repository.deleteById(id);
        resp.sendRedirect(req.getContextPath() + "/book");
    }
}
